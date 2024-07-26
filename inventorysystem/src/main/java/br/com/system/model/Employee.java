package br.com.system.model;

public class Employee extends Person {
    public int id;

    public Employee(int id, String name, String cpf) {
        super(name, cpf);
        this.id = id;
    }
    public Employee(String name, String cpf) {
        super(name, cpf);
    }
    
    public int getId() {
	return id;
    }
	
    public void setId(int id) {
	this.id = id;
    }
}

