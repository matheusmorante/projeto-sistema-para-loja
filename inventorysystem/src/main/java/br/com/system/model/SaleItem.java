package br.com.system.model;

public class SaleItem {
    private int id;
    private int saleId;
    private Product product;
    private double unitPrice;
    private int quantity;
    
    public SaleItem(int id, int saleId, Product product, double unitPrice, int quantity) {
        this.id = id;
    	this.saleId = saleId;
    	this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    
    public SaleItem(Product product, double unitPrice, int quantity) {
    	this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getTotalValue() {
        return unitPrice * quantity;
    }
}