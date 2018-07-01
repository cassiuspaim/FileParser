package model;

public class Item {

	private String id;
	private long quantity;
	private double price;

	public Item(String id, long quantity, double price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	public double getTotalPrice() {
		return price * quantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

}
