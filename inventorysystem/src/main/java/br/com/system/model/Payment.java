package br.com.system.model;

public class Payment {
    private int id;
    private int saleId;
    private double amount;
    private String paymentMethod;
    
    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public Payment(int id, int saleId, double amount, String paymentMethod) {
        this.id = id;
        this.saleId = saleId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    
    public int getSaleId() {
        return saleId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}