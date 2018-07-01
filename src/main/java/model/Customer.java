package model;

public class Customer {

	private String cnpj;
	private String name;
	private String businessArea;

	public Customer(String cnpj, String name, String businessArea) {
		super();
		this.cnpj = cnpj;
		this.name = name;
		this.businessArea = businessArea;
	}

	@Override
	public boolean equals(Object obj) {
		Customer otherCustomer = (Customer) obj;
		return cnpj.equals(otherCustomer.getCnpj())
				&& name.equals(otherCustomer.getName())
				&& businessArea.equals(otherCustomer.getBusinessArea());
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getName() {
		return name;
	}

	public String getBusinessArea() {
		return businessArea;
	}

}
