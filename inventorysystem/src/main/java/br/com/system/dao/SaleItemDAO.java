package br.com.system.dao;

import br.com.system.model.SaleItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moveis Morante
 */
public class SaleItemDAO implements GenericDAO<SaleItem, Integer>{
  ProductDAO productDAO = new ProductDAO();
  @Override
    public void save(SaleItem saleItem) {        
        String sql = "INSERT INTO sale_items (sale_id, product_id, unit_price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, saleItem.getSaleId());
            stmt.setDouble(2, saleItem.getProduct().getId());
            stmt.setDouble(3, saleItem.getUnitPrice());
            stmt.setInt(4, saleItem.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        }
    }

    public void update(SaleItem saleItem) {
        String sql = "UPDATE sale_items SET product_id = ?, unit_price = ?, quantity = ? WHERE id = ? and sale_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
     
            stmt.setDouble(1, saleItem.getProduct().getId());
            stmt.setDouble(2, saleItem.getUnitPrice());
            stmt.setInt(3, saleItem.getQuantity());
            stmt.setInt(4, saleItem.getId());
            stmt.setInt(5, saleItem.getSaleId());
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar item: " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM sale_items WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar item: " + e.getMessage());
        }
    }

    public SaleItem findById(Integer id) {
        String sql = "SELECT * FROM sale_items WHERE id = ?";
        SaleItem saleItem = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                saleItem = new SaleItem(
                    rs.getInt("id"),
                    rs.getInt("sale_id"),
                    productDAO.findById(rs.getInt("product_id")),
                    rs.getDouble("unit_price"),
                    rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar item: " + e.getMessage());
        }
        return saleItem;
    }

    public List<SaleItem> findAllBySaleId(int saleId) {
        String sql = "SELECT * FROM sale_items where sale_id = ?";
        List<SaleItem> saleItems = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ) {
            stmt.setInt(1, saleId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SaleItem saleItem = new SaleItem(
                    rs.getInt("id"),
                    rs.getInt("sale_id"),
                    productDAO.findById(rs.getInt("product_id")),
                    rs.getDouble("unit_price"),
                    rs.getInt("quantity")
                );
            saleItems.add(saleItem);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os itens: " + e.getMessage());
        }
        return saleItems;
    }
}        
