package musicalInstrument;

public class Tupan extends MusicalInstrument {

	public Tupan(double price, int quantity) {
		super("Tupan", price, "Udarni",quantity);
		
	}

	@Override
	public Tupan createCloning() {
		return new Tupan(price, quantity);
	}
}
