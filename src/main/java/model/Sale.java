package model;

import java.util.List;

public class Sale {

	private String saleId;
	private List<Item> items;
	private String salesmanName;

	public Sale(String saleId, List<Item> items, String salesmanName) {
		super();
		this.saleId = saleId;
		this.items = items;
		this.salesmanName = salesmanName;
	}

	public double getTotalPrice() {
		return items.stream().mapToDouble(Item::getTotalPrice).sum();
	}

	public String getSaleId() {
		return saleId;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (saleId == null) {
			if (other.saleId != null)
				return false;
		} else if (!saleId.equals(other.saleId))
			return false;
		if (salesmanName == null) {
			if (other.salesmanName != null)
				return false;
		} else if (!salesmanName.equals(other.salesmanName))
			return false;
		return true;
	}

}
