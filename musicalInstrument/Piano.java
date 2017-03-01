package musicalInstrument;

public class Piano extends MusicalInstrument {

	public Piano(double price, int quantity) {
		super("Piano", price, "Klavishni",quantity);
		
	}

	@Override
	public Piano createCloning() {
		return new Piano(price, quantity);
	}
}
