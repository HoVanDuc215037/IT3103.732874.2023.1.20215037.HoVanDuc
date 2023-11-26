package hust.soict.dsai.aims.cart;

//import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Media> items0rdered = new ArrayList<Media>();
//addMedia() & removeMedia()
	public void addMedia(Media A) {
		if (items0rdered.contains(A)) {
			System.out.println("Cart. Add media failed. This media had already existed in your Cart.");
		}else {
			items0rdered.add(A);
			System.out.println("Cart. Add media success.");		}
	}
	public void removeMedia(Media A) {
		if (items0rdered.contains(A)) {
			items0rdered.remove(A);
			System.out.println("Cart. Remove media success.");
		}else {
			System.out.println("Cart. Remove media failed. This media does not in your Cart.");
		}		
	}
//.
// Method overloading addMedia()
	public void addMedia(Media [] mediaList) {
		for (Media i : mediaList) {
			addMedia(i);
		}
	}
	public void addMedia(Media media1, Media media2) {
		addMedia(media1);
		addMedia(media2);
	}

//.
//update totalCost()
	public float totalCost() {
		float total;
		total = 0;
		for (Media i  : items0rdered) {
				total += i.getCost();				
		}
		return total;
	}
//.
//update print()
	public void print() {
		System.out.println("***********************CART***********************");
		for(Media i : items0rdered) {
					System.out.println(i.toString()); //System.out.println(getItems0rdered(i).getId() + ".DVD - ["+getItems0rdered(i).getTitle()+"] - ["+getItems0rdered(i).getCategory()+"] - ["+getItems0rdered(i).getDirector()+"] - ["
					//+getItems0rdered(i).getLength()+"]: "+getItems0rdered(i).getCost()+"$");
		}
		System.out.println("Total cost: " + totalCost()+"$");
		System.out.println("***************************************************");
	}
//.
//-----------------------------------------------------------------------------------------------
/*	public static final int MAX_NUMBERS_ORDER = 20;	
	private DigitalVideoDisc [] items0rdered  =	new DigitalVideoDisc [MAX_NUMBERS_ORDER];//item 
	private int qtyOrdered;//qty item
//getter & setter
	public DigitalVideoDisc getItems0rdered(int i) {
		return items0rdered[i];
	}
	public void setItems0rdered(DigitalVideoDisc items0rdered, int i) {
		this.items0rdered[i] = items0rdered;
	}
//add & remove.
	public void addDigitalVideoDisc(DigitalVideoDisc discA) {
		if (qtyOrdered == MAX_NUMBERS_ORDER) {
			System.out.println("Items current max. Unable get new order.");
		}else {
			for (int i = 0; i< MAX_NUMBERS_ORDER; i++) {
				if (getItems0rdered(i) == null) {
					setItems0rdered(discA, i);
					qtyOrdered += 1;
					System.out.println("Cart.Add success.");
					break;
				}
			}
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc discB) {
		short count = 0;
		for (int i = 0; i< MAX_NUMBERS_ORDER; i++) {
			if (items0rdered[i] == discB) {
				setItems0rdered(null, i);
				System.out.println("Cart.Remove success.");
				qtyOrdered -= 1;
                break;
			}else count += 1;
		}
		if (count == MAX_NUMBERS_ORDER) 	System.out.println("remove. Can't find " + discB.getTitle());
	}

//total
	public float totalCost() {
		float total;
		total = 0;
		for (int i = 0; i< qtyOrdered; i++) {
			if (getItems0rdered(i) != null) {
				total += items0rdered[i].getCost();				}
		}
		return total;
	}

//lab03, method-overloading addDigitalVideoDisc(DigitalVideoDisc [] dvdList)

	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (int i = 0; i< dvdList.length; i ++) {
			addDigitalVideoDisc(dvdList[i]);
		}
	}
//lab03, method-overloading addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}

//lab03, method print()
	public void print() {
		System.out.println("***********************CART***********************");
		for(int i = 0; i<qtyOrdered; i++) {
			if (getItems0rdered(i) != null)				System.out.println(getItems0rdered(i).toString()); //System.out.println(getItems0rdered(i).getId() + ".DVD - ["+getItems0rdered(i).getTitle()+"] - ["+getItems0rdered(i).getCategory()+"] - ["+getItems0rdered(i).getDirector()+"] - ["
					//+getItems0rdered(i).getLength()+"]: "+getItems0rdered(i).getCost()+"$");
		}
		System.out.println("Total cost: " + totalCost()+"$");
		System.out.println("***************************************************");
	}

//lab03, method print() is done.
//lab03, method searchbyID(id).
	public void searchbyID(int id) {
		short count = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (getItems0rdered(i).getId() == id) {
//				System.out.println("Id: "+id+ ". DVD -["+getItems0rdered(i).getTitle()+"] - ["+getItems0rdered(i).getCategory()+"] - ["+getItems0rdered(i).getDirector()+"] - ["
//						+getItems0rdered(i).getLength()+"]: "+getItems0rdered(i).getCost()+"$| Searching by ID~~");
				System.out.println(getItems0rdered(i).toString());
				return;
			}else count++;
		}
		if (count == qtyOrdered) System.out.println("No match result for id: "+ id);		

	}
//lab03, method searchbyTitle(title).
	public void searchbyTitle(String title) {
		short count = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (getItems0rdered(i).getTitle().toUpperCase().equals(title.toUpperCase())) {
//				System.out.println("Id: "+getItems0rdered(i).getId()+". DVD -["+getItems0rdered(i).getTitle()+"] - ["+getItems0rdered(i).getCategory()+"] - ["+getItems0rdered(i).getDirector()+"] - ["
	//					+getItems0rdered(i).getLength()+"]: "+getItems0rdered(i).getCost()+"$| Searching by Title~~");
				System.out.println(getItems0rdered(i).toString());
				return;
			}else count++;
		}
		if (count == qtyOrdered) System.out.println("No match result for title: "+ title);		
	}
*/	
}