/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.system.view;

import br.com.system.dao.SaleDAO;
import br.com.system.model.Address;
import br.com.system.model.Customer;
import br.com.system.model.Employee;
import br.com.system.model.Sale;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Moveis Morante
 */
public class SalesTableLoader implements Runnable{
    JTable salesTable;
    SaleDAO saleDAO = new SaleDAO();
 
    
    public SalesTableLoader(JTable salesTable) {
        this.salesTable = salesTable;
    }
    
    @Override
    public void run() {
        // Atualizar a tabela na EDT
        SwingUtilities.invokeLater(() -> {
            DefaultTableModel salesTableModel = (DefaultTableModel) salesTable.getModel();
            List<Sale> sales = saleDAO.findAll();
            
            salesTableModel.setRowCount(0);
            if (sales != null){
                for (Sale sale : sales) {
                    Customer customer = sale.getCustomer();
                    Employee employee = sale.getSaller();
                    Address address = customer.getAddress();

                    salesTableModel.addRow(new Object[]{
                            sale.getId(),
                            customer.getName(),
                            address.toString(),
                            employee.getName(),
                            sale.saleItemsToString(),
                            sale.getGrossValue(),
                            sale.getDiscount(),
                            sale.getNetValue(),
                            sale.paymentsToString()
                    });
                }
            }
        });
    }
}
