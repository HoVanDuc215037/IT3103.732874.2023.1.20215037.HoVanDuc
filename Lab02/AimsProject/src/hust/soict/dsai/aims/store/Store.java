package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private static final int MAX_NUMBER_ITEMS = 100000;
	private static int qty = 0;
	private DigitalVideoDisc [] itemsInStore = new DigitalVideoDisc[MAX_NUMBER_ITEMS]; 
//getter & setter

	public void setItemsInStore(DigitalVideoDisc disc, int a) {
		this.itemsInStore[a] = disc;
	}

	public DigitalVideoDisc getItemsInStore(int i) {
		return itemsInStore[i];
	}
//method addDVD(dvd)
	public void addDVD(DigitalVideoDisc disc) {
		for (int i = 0; i<=qty; i++) {
			if (getItemsInStore(i) == null) {
				setItemsInStore(disc, i);
				if ( i == qty) qty += 1;
				System.out.println("Store. Add DVDs success.");
				break;
			}
		}
	}
//method removeDVD(dvd)
	public void removeDVD(DigitalVideoDisc disc) {
		int i;
		for (i = 0; i < qty; i++) {
			if (getItemsInStore(i) == disc) {
				setItemsInStore(null, i);
				System.out.println("Store. Remove DVD success.");
				break;
			}
		}
		if (i == qty - 1) System.out.println("Fail. Unable remove. Your removing item is not in store");
	}
//method print() to print list of Items
	public void print() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < qty ; i ++) {
			if (getItemsInStore(i) != null) {
				System.out.println("Id: "+getItemsInStore(i).getId()+"- ["+getItemsInStore(i).getTitle()+"] - ["+getItemsInStore(i).getCategory()+"] - ["+getItemsInStore(i).getDirector()
						+"] - ["+getItemsInStore(i).getLength()+ ": " + getItemsInStore(i).getCost()+"$");
			}
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
}

