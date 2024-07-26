/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.system.view;

import br.com.system.dao.ProductDAO;
import br.com.system.model.Product;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Moveis Morante
 */
public class ProductsTableLoader implements Runnable{
    JTable productsTable;
    ProductDAO productDAO = new ProductDAO();
    
    public ProductsTableLoader (JTable productsTable) {
        this.productsTable = productsTable;
    }
    
    @Override
    public void run() {
        DefaultTableModel productsTableModel = (DefaultTableModel) productsTable.getModel();
        productsTableModel.setRowCount(0);
        List<Product> products = productDAO.findAll();
        
        if (products != null){
            for (Product product : products) {
                int id = product.getId();
                String description = product.getDescription();
                Double cost = product.getCost();
                Double price = product.getPrice();
                int quantity = product.getQuantity();

                productsTableModel.addRow(new Object[] {id, description, cost, price, quantity});
            }   
        }
    }
}
