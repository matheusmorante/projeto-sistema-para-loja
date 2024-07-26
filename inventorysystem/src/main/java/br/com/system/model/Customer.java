package br.com.system.model;

public class Customer extends Person{
	private int id;
	private String cellphone;
	private String tellphone;
	private Address address;
	
	public Customer(int id, String name, String cpf, String cellphone, String tellphone, Address address) {
		super(name, cpf);
		this.id = id;
		this.cellphone = cellphone;
		this.tellphone = tellphone;
		this.address = address;
	}
	
	public Customer(String name, String cpf, String cellphone, String tellphone, Address address) {
		super(name, cpf);
		this.cellphone = cellphone;
		this.tellphone = tellphone;
		this.address = address;
	}
	
	public int getId() {
            return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String getTellphone() {
		return tellphone;
	}
	
	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
}
