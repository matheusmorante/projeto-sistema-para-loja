/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.system.view;

import br.com.system.dao.EmployeeDAO;
import br.com.system.model.Employee;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Moveis Morante
 */
public class EmployeesTableLoader implements Runnable{
    JTable employeesTable;
    EmployeeDAO employeeDAO = new EmployeeDAO();
    
    public EmployeesTableLoader (JTable employeesTable) {
        this.employeesTable = employeesTable;
    }
    
    @Override
    public void run() {
        DefaultTableModel employeesTableModel = (DefaultTableModel) employeesTable.getModel();
        employeesTableModel.setRowCount(0);
        List<Employee> employees = employeeDAO.findAll();
        
        if (employees != null){
            for (Employee employee : employees) {
                int id = employee.getId();
                String name = employee.getName();
                String cpf = employee.getCpf();

                employeesTableModel.addRow(new Object[] {
                    id,
                    name,
                    cpf
                });
            }   
        }
    }
}
