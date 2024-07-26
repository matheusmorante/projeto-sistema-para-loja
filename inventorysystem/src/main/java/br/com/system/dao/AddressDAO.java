package br.com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.system.model.Address;

public class AddressDAO implements GenericDAO<Address, Integer> {
        @Override
	public void save(Address address) {
		String sql = "INSERT INTO adresses (customer_id, logradouro, address_number, complement, bairro, city, uf) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, address.getCustomerId());
			stmt.setString(2, address.getLogradouro());
			stmt.setString(3, address.getAddressNumber());
			stmt.setString(4, address.getComplement());
			stmt.setString(5, address.getBairro());
			stmt.setString(6, address.getCity());
			stmt.setString(7, address.getUf());
			stmt.executeUpdate();	
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar endereço: " + e.getMessage());
		}
	}
	
        
	public void update(Address address) {
		String sql = "UPDATE adresses SET logradouro = ?, address_number = ?, complement = ?, bairro = ?, city = ?, uf = ? WHERE id = ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, address.getLogradouro());
			stmt.setString(2, address.getAddressNumber());
			stmt.setString(3, address.getComplement());
			stmt.setString(4, address.getBairro());
			stmt.setString(5, address.getCity());
			stmt.setString(6, address.getUf());
			stmt.setInt(7, address.getId());
			stmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Erro ao atualizar endereço :"+ e.getMessage());
		}
	}
	
        @Override
	public void delete(Integer id) {
		String sql = "DELETE FROM adresses WHERE id = ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Erro ao deletar endereço :"+ e.getMessage());
		}
	}
	
	public Address findById(Integer customerId) {
		String sql = "SELECT * FROM adresses WHERE customer_id = ?";
		Address address = null;
		
		try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			
			 if (rs.next()) {  // Chame rs.next() antes de acessar os dados
	                address = new Address(
	                    rs.getInt("id"),
	                    rs.getInt("customer_id"),
	                    rs.getString("logradouro"),
	                    rs.getString("address_number"),
	                    rs.getString("complement"),
	                    rs.getString("bairro"),
	                    rs.getString("city"),
	                    rs.getString("uf")
	                );
	          }
		} catch(SQLException e) {
			System.out.println("Erro ao buscar endereço: "+ e.getMessage());
		}
		return address;
	}
	
	 public List<Address> findAll() {
	        String sql = "SELECT * FROM addresses";
	        List<Address> adresses = new ArrayList<>();
	        
	        try(Connection conn = DatabaseConnection.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery()) {
	            
	            while (rs.next()) {
	                Address address = new Address(
	                    rs.getInt("id"),
	                    rs.getInt("customer_id"),
	                    rs.getString("logradouro"),
	                    rs.getString("address_number"),
	                    rs.getString("complement"),
	                    rs.getString("bairro"),
	                    rs.getString("city"),
	                    rs.getString("uf")
	                );
	                adresses.add(address);
	            }
	        } catch(SQLException e) {
	            System.out.println("Erro ao buscar endereços: " + e.getMessage());
	        }
	        return adresses;
	    }
}
