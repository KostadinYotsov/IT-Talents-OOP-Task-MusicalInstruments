package musicalInstrument;

public class Baraban extends MusicalInstrument {

	public Baraban(double price, int quantity) {
		super("Baraban", price, "Udarni",quantity);
		
	}

	@Override
	public Baraban createCloning() {
		return new Baraban(price, quantity);
	}
}
