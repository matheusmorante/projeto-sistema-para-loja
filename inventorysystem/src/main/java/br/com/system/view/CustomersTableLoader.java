package br.com.system.view;

import br.com.system.dao.CustomerDAO;
import br.com.system.model.Address;
import br.com.system.model.Customer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CustomersTableLoader implements Runnable {
    private final JTable customersTable;
    private final CustomerDAO customerDAO = new CustomerDAO();

    public CustomersTableLoader(JTable customersTable) {
        this.customersTable = customersTable;
    }

    @Override
    public void run() {
        DefaultTableModel customersTableModel = (DefaultTableModel) customersTable.getModel();
        customersTableModel.setRowCount(0);
        List<Customer> customers = customerDAO.findAll();
        if (customers != null){
            for (Customer customer : customers) {
                Address address = customer.getAddress();
                customersTableModel.addRow(new Object[]{
                    customer.getId(),
                    customer.getName(),
                    customer.getCpf(),
                    customer.getCellphone(),
                    customer.getTellphone(),
                    address.toString()
                });
            }
        }
    }
}