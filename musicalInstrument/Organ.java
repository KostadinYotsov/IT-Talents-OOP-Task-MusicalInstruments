package musicalInstrument;

public class Organ extends MusicalInstrument {

	public Organ( double price, int quantity) {
		super("Organ", price, "Klavishni",quantity);
		
	}

	@Override
	public Organ createCloning() {
		return new Organ(price, quantity);
	}
}
