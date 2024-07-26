package br.com.system.model;

public class Address {
	private int id;
	private int customerId;
	private String logradouro;
	private String addressNumber;
	private String complement;
	private String bairro;
	private String city;
	private String uf;
	
	
	public Address(int id, int customerId, String logradouro, String addressNumber, String complement, String bairro, String city, String uf) {
		this.id = id;
		this.customerId = customerId;
		this.logradouro = logradouro;
		this.addressNumber = addressNumber;
		this.complement = complement;
		this.bairro = bairro;
		this.city = city;
		this.uf = uf;
	}
	
	public Address(String logradouro, String addressNumber, String complement, String bairro, String city, String uf) {
		this.logradouro = logradouro;
		this.addressNumber = addressNumber;
		this.complement = complement;
		this.bairro = bairro;
		this.city = city;
		this.uf = uf;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return logradouro +", " + addressNumber +", " + complement +", " + bairro +", " + city + "-" + uf;
    }
}