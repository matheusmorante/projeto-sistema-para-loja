package br.com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.system.model.Employee;

public class EmployeeDAO implements GenericDAO<Employee, Integer> {
    
    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employees (name, cpf) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar funcionário: " + e.getMessage());
        }
    }
    
    public void update(Employee employee) {
        String sql = "UPDATE employees SET name = ?, cpf = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getCpf());
            stmt.setInt(3, employee.getId());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }
    
    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionário: " + e.getMessage());
        }
    }
    
    public Employee findById(Integer id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        Employee employee = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                employee = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionário por ID: " + e.getMessage());
        }
        return employee;
    }
    
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Employee employee = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("cpf")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os funcionários: " + e.getMessage());
        }
        return employees;
    }
}
