package musicalInstrument;

public class Cigulka extends MusicalInstrument {

	public Cigulka( double price,int quantity) {
		super("Cigulka", price, "Strunni",quantity);
		
	}
	
	@Override
	public Cigulka createCloning() {
		return new Cigulka(price, quantity);
	}

}
