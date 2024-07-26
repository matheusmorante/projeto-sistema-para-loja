package br.com.system.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private int id;
    String date;
    private List<SaleItem> saleItems;
    private Customer customer;
    private Employee saller;
    private double discount;
    private List<Payment> payments;

    public Sale(List<SaleItem> saleItems, Customer customer, Employee saller, double discount, List<Payment> payments) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedNow = now.format(formatter);
        
        this.date = formattedNow;
        this.saleItems = saleItems;
        this.customer = customer;
        this.saller = saller;
        this.discount = discount;
        this.payments = payments;
    }
    
    public Sale(int id, String date, List<SaleItem> saleItems, Customer customer, Employee saller, double discount, List<Payment> payments) {
        this.id = id;
        this.date = date;
        this.saleItems = saleItems;
        this.customer = customer;
        this.saller = saller;
        this.discount = discount;
        this.payments = payments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDate() {
        return date;
    }

    public void addSaleItem(SaleItem saleItem) {
        saleItems.add(saleItem);
    }
    
    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }
    
    public String saleItemsToString() {
        String text = "";
        for (SaleItem saleItem : saleItems) {
            Product product = saleItem.getProduct();
            String quantity = String.valueOf(saleItem.getQuantity());
            text += product.getDescription() + "(" + quantity + " un), ";
        }
        if (text.length() > 2) {    
             text = text.substring(0, text.length() - 2);
        }
        return text;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getSaller() {
        return saller;
    }

    public void setSaller(Employee saller) {
        this.saller = saller;
    }
    
    public double getGrossValue() {
        double value = 0;
        for (SaleItem saleItem : saleItems) {
            value += saleItem.getTotalValue();
        }
        return value;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public double getNetValue() {
        Double value;
        Double grossValue = this.getGrossValue();
        
        value = grossValue - discount;
        return value;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
    
    public String paymentsToString() {
        StringBuilder text = new StringBuilder();
        for (Payment payment : payments) {
            String amountStr = String.valueOf(payment.getAmount());
            text.append(amountStr)
                .append(" - ")
                .append(payment.getPaymentMethod())
                .append(", ");
        }
        // Remove a última vírgula e espaço, se houver
        if (text.length() > 0) {
            text.setLength(text.length() - 2);
        }
        return text.toString();
    }
}