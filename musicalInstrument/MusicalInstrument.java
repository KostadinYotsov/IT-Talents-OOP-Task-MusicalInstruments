package musicalInstrument;

public abstract class MusicalInstrument implements Comparable<MusicalInstrument>{
	
	private String name;
	protected double price;
	private String type;
	protected int quantity;
	
	public MusicalInstrument(String name, double price, String type, int quantity) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.quantity=quantity;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int i) {
		this.quantity=i;
	}

	@Override
	public String toString() {
		return "MusicalInstrument [name=" + name + ", price=" + price + ", type=" + type + ", quantity=" + quantity	+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicalInstrument other = (MusicalInstrument) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public abstract MusicalInstrument createCloning();
	
	@Override
	public int compareTo(MusicalInstrument o) {
		return this.quantity-o.quantity;
	}
}
