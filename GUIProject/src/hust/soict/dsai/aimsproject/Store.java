package hust.soict.dsai.aimsproject;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.exception.PlayerException;

public class Store {
	public static boolean checkInput(int input, int options) {
		if (input < 0 || input > options) return false;
		return true;
	}
//getter&setter
//
	
	private static ArrayList<Media> itemsInStore = new ArrayList<Media>();
//addMedia() & removeMedia()	
	public static void addMedia(Media A) {
		if (itemsInStore.contains(A)) {
			System.out.println("Store. Add media failed. This media had already existed.");
		}else {
			if (A != null) {
			itemsInStore.add(A);
			System.out.println("Store. Add media success.");		
			}
		}
	}
	public static void removeMedia(Media A) {
		if (itemsInStore.contains(A)) {
			itemsInStore.remove(Integer.valueOf(A.getTitle()));
			System.out.println("Store. Remove media success.");
		}else {
			System.out.println("Store. Remove media failed. This media does not exist.");
		}		
	}	
//.

// print()
	public static void print() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~STORE~~~~~~~~~~~~~~~~~~~~~~~~");
		for (Media i : itemsInStore) {
			System.out.println(i.toString());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	public static ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	//return an existing Media or null with an input title
	public static Media findMedia(String title) {
		for(Media m : itemsInStore){
			if (m.getTitle().toUpperCase().equals(title.toUpperCase())) return m;
		}
		//System.out.println("No media for title ["+title+"]");
		return null;
	}

	public static void showMedia(String title) {
		for (Media m : itemsInStore) {
			if (m.getTitle().toUpperCase().contains(title.toUpperCase())) System.out.println(m.toString());
		}
	}
//*update store
	public static  void updateStore() throws PlayerException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Options");
		System.out.println("1. Add media.");
		System.out.println("2. Remove media.");
		System.out.println("0. Exit");
		int cmd = keyboard.nextInt();
		if (checkInput(cmd, 2) == false) {
			keyboard.close();
			Aims.showMenu();
		}
		switch (cmd) {
		case 2: {
			System.out.println("Enter media title to remove: ");
			String title = keyboard.nextLine();
			removeMedia(findMedia(title));
	//		Aims.showMenu();
		}
		case 1 : {
			System.out.println("Select type of media: 1)Book  2)DVD  3)CD");
			int type = keyboard.nextInt();
			if (type == 1) {
				Book book = new Book();
				System.out.print("Enter media id: "); //set id
				int id = keyboard.nextInt();
				book.setId(id);
				
				System.out.print("\nEnter book 's title: ");  //set title
				String title = keyboard.next();
				book.setTitle(title);

				System.out.print("Enter book 's category: \n");
				String category = keyboard.next();
				book.setCategory(category);
				
				System.out.println("Enter book's Cost: ");
				Float cost = keyboard.nextFloat();
				book.setCost(cost);
				addMedia(book);
			}else if (type==2) {
				DigitalVideoDisc dvd = new DigitalVideoDisc();
				System.out.print("Enter media id: "); //set id
				int id = keyboard.nextInt();
				dvd.setId(id);
				
				System.out.print("Enter title: \n");  //set title
				String title = keyboard.next();
				dvd.setTitle(title);

				System.out.print("Enter category: \n");
				String category = keyboard.next();
				dvd.setCategory(category);
			
				System.out.println("Enter Cost: ");
				Float cost = keyboard.nextFloat();
				dvd.setCost(cost);
				addMedia(dvd);
			}else if (type == 3) {
				CompactDisc cd = new CompactDisc();
				System.out.print("Enter id: "); //set id
				int id = keyboard.nextInt();
				cd.setId(id);
				
				System.out.print("Enter title: \n");  //set title
				String title = keyboard.next();
				cd.setTitle(title);

				System.out.print("Enter category: \n");
				String category = keyboard.next();
				cd.setCategory(category);
				
				System.out.println("Enter Cost: ");
				Float cost = keyboard.nextFloat();
				cd.setCost(cost);	
				addMedia(cd);
			}
		}
	}
		Aims.showMenu();
}
//option

	public static void storeMenu() throws PlayerException{
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
			
		Scanner keyboard = new Scanner(System.in);
		int cmd = keyboard .nextShort();
		if (checkInput(cmd, 4) == false) storeMenu();
		switch (cmd) {
		case 1 :{
			//store.print();
			System.out.println("Enter media's title: ");
			String title = keyboard.next();
			showMedia(title);
			mediaDetailsMenu();
			storeMenu();
		}
		case 2 :{
			System.out.println("Enter media's title: ");
			String title = keyboard.next();
			Cart.addMedia(findMedia(title));
			storeMenu();
		}
		case 3 :{
			System.out.println("Enter a title of DVD or CD to play:");
			String title = keyboard.next();
			Media m = findMedia(title);
			if (m.getClass() == DigitalVideoDisc.class) {
				DigitalVideoDisc dvd = (DigitalVideoDisc) m;
				dvd.play();
			}else if (m.getClass() == CompactDisc.class) {
				CompactDisc cd = (CompactDisc) m;
				cd.play();
			}
			storeMenu();
		}
		case 4 :{
			Cart.print();
			Cart.cartMenu();
		}
		case 0:{
			Aims.showMenu();
		}
		default : Aims.showMenu();
		}
		keyboard.close();
	}
			
			
//see media detail
	public static void mediaDetailsMenu() throws PlayerException {
		java.util.Scanner keyboard = new Scanner(System.in);
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		int cmd = keyboard.nextInt();
		if (checkInput(cmd, 2) == false) {
			System.out.println("Input's not valid.");
			mediaDetailsMenu();
		}
		switch(cmd) {
		case 1 :{
			System.out.println("Enter a media's title to adding:");
			String title = keyboard.next();
			Cart.addMedia(findMedia(title));
			mediaDetailsMenu();
		}
		case 2: {
			System.out.println("Enter a title of DVD or CD to play:");
			String title = keyboard.next();
			Media m = findMedia(title);
			if (m.getClass() == DigitalVideoDisc.class) {
				DigitalVideoDisc dvd = (DigitalVideoDisc) m;
				dvd.play();
			}else if (m.getClass() == CompactDisc.class) {
				CompactDisc cd = (CompactDisc) m;
				cd.play();
			}
			mediaDetailsMenu();
		}
		case 0:{
			storeMenu();
		}
		default: break;
		}
		keyboard.close();
	}
}
