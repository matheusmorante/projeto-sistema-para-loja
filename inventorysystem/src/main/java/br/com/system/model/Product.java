package br.com.system.model;

public class Product {
    private int id;
    private String description;
    private Double cost;
    private Double price;
    private int quantity;
    
    public Product(String description, Double cost, Double price, int quantity) {
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id, String description, Double cost, Double price, int quantity) {
    	this.id = id;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.quantity = quantity;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public boolean decreaseQuantity(int quantity) {
    	if (quantity > this.quantity) {
    		return false;
    	} else {
    		this.quantity -= quantity;
    		return true;
    	}
    }
    
    public void increaseQuantity(int quantity) {
    		this.quantity += quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", cost=" + cost +
                ", price=" + price +
                '}';
    }
}