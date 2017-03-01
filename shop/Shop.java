package shop;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import musicalInstrument.ComparatorByName;
import musicalInstrument.ComparatorByPrice;
import musicalInstrument.MusicalInstrument;

public class Shop {

	private double cash;
	private HashMap<String, HashSet<MusicalInstrument>> kat;
	private HashMap<String, HashSet<MusicalInstrument>> sell;
	private String name;
	private static int uniqueId=1;
	
	public Shop(double cash) {
		this.cash = cash;
		this.kat =new HashMap<>();
		this.sell=new HashMap<>();
		this.name="Musical Shop " + uniqueId++;
	}
	
	public void addInstrument (MusicalInstrument mi) {
		if (!kat.containsKey(mi.getType())) {
			kat.put(mi.getType(), new HashSet<MusicalInstrument>());
		}
		kat.get(mi.getType()).add(mi);
	}
	
	public void sellInstrument (String name, int quantity) {
		for (Iterator <HashSet<MusicalInstrument>>  iterator = kat.values().iterator(); iterator.hasNext();) {
			HashSet<MusicalInstrument> set = iterator.next();
			for (Iterator<MusicalInstrument> iterator2 = set.iterator(); iterator2.hasNext();) {
				MusicalInstrument musicalInstrument =  iterator2.next();
				if (musicalInstrument.getName().equals(name)) {
					if (musicalInstrument.getQuantity()<quantity) {
						System.out.println("Nqma takava broika nalichni instrumenti.");
						System.out.println("V magazina ima ostani oshte " + musicalInstrument.getQuantity() + " broq");
						return;
					}
					else {
						musicalInstrument.setQuantity(musicalInstrument.getQuantity()-quantity);
						cash+=quantity*musicalInstrument.getPrice();
						this.addInstrumentSells(musicalInstrument, quantity);
						if (musicalInstrument.getQuantity()==0) {
							set.remove(musicalInstrument);
						}
					}
				}
			}
		}
	}
	
	private void addInstrumentSells(MusicalInstrument mi, int quantity) {
		if (mi!=null && !sell.containsKey(mi.getType())) {
			sell.put(mi.getType(), new HashSet ());
		}
		MusicalInstrument mi2 = mi.createCloning();
		mi2.setQuantity(quantity);
		sell.get(mi.getType()).add(mi2);
	}
	
	public void printInfo() {
		System.out.println("V kasata na magazina ima " + this.cash);
		System.out.println("V magazina ima v nalichnost slednite tipove muzikalni instrumenti:");
		for (Entry <String, HashSet<MusicalInstrument>> e : kat.entrySet()) {
			System.out.println(e.getKey() + " : ");
			for (MusicalInstrument mi: e.getValue()) {
				System.out.println(mi);
			}
			System.out.println();
		}
	}
	
	public void printInfoSells () {
		System.out.println("Ot magazina sa prodadeni slednite tipove muzikalni instrumenti:");
		for (Entry <String , HashSet<MusicalInstrument>> e : sell.entrySet()) {
			System.out.println(e.getKey()+ " ");
			for (MusicalInstrument mi : e.getValue()) {
				System.out.println(mi);
			}
		}
	}
	
	public void printByType() {
		System.out.println("============= Sorted by type =============");
		for (Iterator<Entry<String,HashSet<MusicalInstrument>>> it =kat.entrySet().iterator(); it.hasNext();) {
			Entry<String,HashSet<MusicalInstrument>> e=it.next();
			String type = e.getKey();
			System.out.println("============= " + type + " =============");
			HashSet<MusicalInstrument> set=e.getValue();
			for (Iterator<MusicalInstrument> it1=set.iterator(); it1.hasNext();) {
				MusicalInstrument mi=it1.next();
				System.out.println(mi);
			}
		}
		System.out.println();
	}
	
	public void printByName () {
		TreeSet<MusicalInstrument> treeSet=new TreeSet<>(new ComparatorByName());
		for (HashSet<MusicalInstrument> hashSet : kat.values()) {
			for (MusicalInstrument mi : hashSet ) {
				treeSet.add(mi);
			}
		}
		System.out.println("============= Sorted by name =============");
		for (MusicalInstrument mi : treeSet ) {
			System.out.println(mi);
		}
	}
	
	public void printByPrice () {
		TreeSet<MusicalInstrument> treeSet=new TreeSet<>(new ComparatorByPrice());
		for (Iterator <HashSet<MusicalInstrument>> it=kat.values().iterator(); it.hasNext();) {
			HashSet <MusicalInstrument> set=it.next();
			for (Iterator <MusicalInstrument> it1=set.iterator(); it1.hasNext();) {
				MusicalInstrument mi=it1.next();
				treeSet.add(mi);
			}
		}
		System.out.println("============= Sorted by price =============");
		for (Iterator<MusicalInstrument> it=treeSet.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}




