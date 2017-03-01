package shop;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import musicalInstrument.Baraban;
import musicalInstrument.Cigulka;
import musicalInstrument.Kitara;
import musicalInstrument.MusicalInstrument;
import musicalInstrument.Organ;
import musicalInstrument.Piano;
import musicalInstrument.Tupan;

public class Demo {

	public static void main(String[] args) {
		
		Cigulka cigu =new Cigulka(100.5, 5);
		Kitara kit =new Kitara(150.99, 6);
		Organ org=new Organ(300, 8);
		Piano pia=new Piano(599.99, 11);
		Baraban bara= new Baraban (999.99, 3);
		Tupan tup=new Tupan(670, 13);
		Piano pi=new Piano(1000.99, 12);
		Cigulka cig =new Cigulka(255.89, 7);

		Shop shop=new Shop(1000);
		Shop shop1=new Shop(2000);
		Shop shop2=new Shop(3000);
		Shop shop3=new Shop(4000);
		Shop shop4=new Shop(5000);
		shop.addInstrument(cigu);
		shop.addInstrument(kit);
		//shop.addInstrument(pia);
		//shop.addInstrument(bara);
		shop.printInfo();
		//shop.sellInstrument("Baraban",2);
		//shop.printInfoSells();
		//shop.printInfo();
		//shop.printByType();
		//shop.printByName();
		//shop.printByPrice();
		
		//Za uprajnenie
		//Nomer na ulica s magazini na vsqka ulica, kato vuv vseki magazin ima muzikalni instrumenti
		//kato vsichki muzikalni instrumenti sa sortirani po broiki
		LinkedHashMap<Integer, HashMap <Shop,TreeMap<MusicalInstrument, String >>> grandeMap=new LinkedHashMap<>();
		grandeMap.put(1, new HashMap<>());
		grandeMap.get(1).put(shop1, new TreeMap<>());
		grandeMap.get(1).get(shop1).put(cigu, cigu.getType());
		grandeMap.get(1).get(shop1).put(kit, kit.getType());
		
	
		grandeMap.get(1).put(shop3, new TreeMap<>());
		grandeMap.get(1).get(shop3).put(org, org.getType());
		grandeMap.get(1).get(shop3).put(pia, pia.getType());
		
		grandeMap.put(2, new HashMap<>());
		grandeMap.get(2).put(shop2, new TreeMap<>());
		grandeMap.get(2).get(shop2).put(bara, bara.getType());
		grandeMap.get(2).get(shop2).put(tup, tup.getType());
		
		
		grandeMap.get(2).put(shop4, new TreeMap<>());
		grandeMap.get(2).get(shop4).put(pi, pi.getType());
		grandeMap.get(2).get(shop4).put(cig, cig.getType());
		
		//1. Pokazvam ulicite i tehnite nomera.
		for (Integer num : grandeMap.keySet()) {
			System.out.println("Ulica N: " + num);
		}
		System.out.println("===========================");

		
		//2.pokazvam ulicite s tehnite nomera i magazinite koite se namirat na tezi ulici
		for (Entry<Integer, HashMap <Shop,TreeMap<MusicalInstrument, String >>> e : grandeMap.entrySet()) {
			System.out.println("Ulica N: " + e.getKey());
			HashMap <Shop,TreeMap<MusicalInstrument, String >> map=e.getValue();
				for (Shop shopche : map.keySet()) {
					System.out.println("Magazin na ime " + shop);
				}
				System.out.println("===========================");
		}
		
		//2.pokazvam ulicite s tehnite nomera i magazinite koite se namirat na tezi ulici s vsichki vidove instrumenti koito ima v tqh
		for (Entry<Integer, HashMap <Shop,TreeMap<MusicalInstrument, String >>> e : grandeMap.entrySet()) {
			System.out.println("Ulica N: " + e.getKey());
			HashMap<Shop,TreeMap<MusicalInstrument, String >> map=e.getValue();
				for (Entry<Shop,TreeMap<MusicalInstrument, String >> e1 : map.entrySet()) {
					System.out.println("Magazin na ime " + e1.getKey());
					TreeMap<MusicalInstrument, String > mapche=e1.getValue();
					for (Entry<MusicalInstrument, String > e2: mapche.entrySet()) {
						System.out.println(e2.getValue() + " ---- " + e2.getKey());
					}
				}
				System.out.println("===========================");
		}
		
		
	}
	
}
