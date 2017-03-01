package musicalInstrument;

import java.util.Comparator;

public class ComparatorByPrice implements Comparator<MusicalInstrument> {

	@Override
	public int compare(MusicalInstrument o1, MusicalInstrument o2) {
		if (o1.getPrice()>o2.getPrice()) {
			return 1;
		}
		if (o1.getPrice()<o2.getPrice()) {
			return -1;
		}
		return 0;
	}

}
