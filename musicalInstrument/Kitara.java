package musicalInstrument;

public class Kitara extends MusicalInstrument {

	public Kitara( double price, int quantity) {
		super("Kitara", price, "Strunni",quantity);
		
	}
	
	@Override
	public Kitara createCloning() {
		return new Kitara(price, quantity);
	}
}
