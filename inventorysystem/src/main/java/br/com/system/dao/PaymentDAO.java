package br.com.system.dao;

import br.com.system.model.Payment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO implements GenericDAO<Payment, Integer> {
    private final Connection connection = DatabaseConnection.getConnection();

    @Override
    public void save(Payment payment) {
        String sql = "INSERT INTO payments (sale_id, amount, payment_method) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getSaleId());
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setString(3, payment.getPaymentMethod());
            pstmt.executeUpdate();
        } catch (SQLException e) {
             System.out.println("Erro ao adicionar pagamento: " + e.getMessage());
        }
    }

    public void update(Payment payment) {
        String sql = "UPDATE payments SET sale_id = ?, amount = ?, payment_method = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getSaleId());
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setString(3, payment.getPaymentMethod());
            pstmt.setInt(4, payment.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pagamento: " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM payments WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar pagamento: " + e.getMessage());
        }
    }
    
    public Payment getById(Integer id) {
        String sql = "SELECT * FROM payments WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Payment(
                    rs.getInt("id"),
                    rs.getInt("sale_id"),
                    rs.getDouble("amount"),
                    rs.getString("payment_method")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pagamento: " + e.getMessage());
        }
        return null;
    }
    
    public List<Payment> findAllBySaleId(int saleId) {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments WHERE sale_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, saleId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment(
                    rs.getInt("id"),
                    rs.getInt("sale_id"),
                    rs.getDouble("amount"),
                    rs.getString("payment_method")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os pagamentos da venda: " + e.getMessage());
        }
        return payments;
    }
}