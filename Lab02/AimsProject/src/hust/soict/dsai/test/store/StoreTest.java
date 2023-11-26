package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String args[]) {
		Store duc_store = new Store();
		//Create new dvd objects and add them to the cart 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc (
				"The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
		duc_store.addDVD(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				"Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
		duc_store.addDVD(dvd2);
		DigitalVideoDisc dvd3= new DigitalVideoDisc (
				"Aladin", "Animation", 18.99f);
		duc_store.addDVD(dvd3);
		duc_store.print();
		duc_store.removeDVD(dvd2);
		duc_store.print();
	}//commit to merge
}
