package br.com.system.dao;

import br.com.system.model.Address;
import br.com.system.model.Customer;
import br.com.system.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.system.model.Payment;
import br.com.system.model.Sale;
import br.com.system.model.SaleItem;

public class SaleDAO implements GenericDAO<Sale, Integer> {
    SaleItemDAO saleItemDAO = new SaleItemDAO();
    PaymentDAO paymentDAO = new PaymentDAO();
    
    @Override
    public void save(Sale sale) {
       String saleSql = "INSERT INTO sales (date, customer_name, customer_cpf, customer_logradouro, customer_address_number, customer_complement,"
        + " customer_bairro, customer_city, customer_uf, saller_name, saller_cpf, discount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       Customer customer = sale.getCustomer();
       Address address = customer.getAddress();
       Employee saller = sale.getSaller();
       
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(saleSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
             
            stmt.setString(1, sale.getDate());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getCpf());
            stmt.setString(4, address.getLogradouro());
            stmt.setString(5, address.getAddressNumber());
            stmt.setString(6, address.getComplement());
            stmt.setString(7, address.getBairro());
            stmt.setString(8, address.getCity());
            stmt.setString(9, address.getUf());
            stmt.setString(10, saller.getName());
            stmt.setString(11, saller.getCpf());
            stmt.setDouble(12, sale.getDiscount());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int saleId = generatedKeys.getInt(1);

                for (SaleItem saleItem : sale.getSaleItems()) {
                   saleItem.setSaleId(saleId);
                   saleItemDAO.save(saleItem);     
                }

                for (Payment payment : sale.getPayments()) {
                    payment.setSaleId(saleId);
                    paymentDAO.save(payment);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar venda: " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM sales WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar venda: " + e.getMessage());
        }
    }

    public List<Sale> findAll() {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT * FROM sales";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int saleId = rs.getInt("id");
                String date = rs.getString("date");
                String customerName = rs.getString("customer_name");
                String customerCpf = rs.getString("customer_cpf");
                String customerCellphone = rs.getString("customer_cellphone");
                String customerTellphone = rs.getString("customer_tellphone");
                String customerLogradouro = rs.getString("customer_logradouro");
                String customerAddressNumber = rs.getString("customer_address_number");
                String customerComplement = rs.getString("customer_complement");
                String customerBairro = rs.getString("customer_bairro");
                String customerCity = rs.getString("customer_city");
                String customerUf = rs.getString("customer_uf");
                String sallerName = rs.getString("saller_name");
                String sallerCpf = rs.getString("saller_cpf");
                double discount = rs.getDouble("discount");

                Address address = new Address(customerLogradouro, customerAddressNumber, customerComplement, customerBairro, customerCity, customerUf);
                Customer customer = new Customer(customerName, customerCpf, customerCellphone, customerTellphone, address);
                Employee saller = new Employee(sallerName, sallerCpf);                
                List<SaleItem> saleItems = saleItemDAO.findAllBySaleId(saleId);
                List<Payment> payments = paymentDAO.findAllBySaleId(saleId);

                Sale sale = new Sale(saleId, date, saleItems, customer, saller, discount, payments);

                sales.add(sale);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar vendas: " + e.getMessage());
        }

        return sales;
    }
}
