package br.com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.system.model.Address;
import br.com.system.model.Customer;

public class CustomerDAO implements GenericDAO<Customer, Integer> {
	AddressDAO addressDAO = new AddressDAO();
	
    @Override
    public void save(Customer customer) {
        String sql = "INSERT INTO customers (name, cpf, cellphone, tellphone) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getCpf());
            stmt.setString(3, customer.getCellphone());
            stmt.setString(4, customer.getTellphone());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Falha ao adicionar cliente, nenhuma linha afetada.");
            }
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
            	int customerId = generatedKeys.getInt(1);
            	Address address = customer.getAddress();
            	address.setCustomerId(customerId);
                addressDAO.save(address);
            } 
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());    
        }
    }
    

    public void update(Customer customer) {
        String sql = "UPDATE customers SET name = ?, cpf = ?, cellphone = ?, tellphone = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getCpf());
            stmt.setString(3, customer.getCellphone());
            stmt.setString(4, customer.getTellphone());
            stmt.setInt(5, customer.getId());
            stmt.executeUpdate();
            
            Address address = customer.getAddress();
            addressDAO.update(address);
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }
    
    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        }
    }
    
  
    public Customer findById(Integer id) {
        String sqlCustomer = "SELECT * FROM customers WHERE id = ?";
        Customer customer = null;
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlCustomer)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();  
            
            if(rs.next()) {
            	int customerId = rs.getInt("id");
                customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("cpf"),
                        rs.getString("cellphone"),
                        rs.getString("tellphone"),
                        addressDAO.findById(customerId)
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente por id: " + e.getMessage());
        }
                
         return customer;
    }
    
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	Integer customerId = rs.getInt("id");    
                Customer customer = new Customer(
                        customerId,
                        rs.getString("name"),
                        rs.getString("cpf"),
                        rs.getString("cellphone"),
                        rs.getString("tellphone"),
                        addressDAO.findById(customerId)
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os clientes: " + e.getMessage());    
        }
        return customers;
    }
}