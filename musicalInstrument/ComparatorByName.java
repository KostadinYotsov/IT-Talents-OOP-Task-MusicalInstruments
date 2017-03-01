package musicalInstrument;

import java.util.Comparator;

public class ComparatorByName implements Comparator<MusicalInstrument> {

	@Override
	public int compare(MusicalInstrument o1, MusicalInstrument o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
