package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;
import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cart {
	private static ArrayList<Media> items0rdered = new ArrayList<Media>();
//addMedia() & removeMedia()
	public static void addMedia(Media A) {
		if (items0rdered.contains(A)) {
			System.out.println("Cart. Add media failed. This media had already existed in your Cart.");
		}else {
			if (A != null) {
				items0rdered.add(A);
				System.out.println("Cart. Add media success.");		
			}
		}
	}
	public static void removeMedia(Media A) {//
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
	public static float totalCost() {
		float total;
		total = 0;
		for (Media i  : items0rdered) {
				total += i.getCost();				
		}
		return total;
	}
	static boolean checkInput(int input, int options) {
		if (input < 0 || input > options) return false;
		return true;
	}
//.
//update print()
	public static void print() {
		System.out.println("***********************CART***********************");
		for(Media i : items0rdered) {
					System.out.println(i.toString());
		}
		System.out.println("Total cost: " + totalCost()+"$");
		System.out.println("***************************************************");
	}
//filter
	public static void filterbyid(int id) {
		String contain_id = String.valueOf(id);
		
		for (Media m : items0rdered) {
			if (String.valueOf(m.getId()).contains(contain_id)){
				System.out.println(m.toString());
			}
		}
	}
	public static void filterbytitle(String title) {
		for (Media m : items0rdered) {
			if (m.getTitle().toUpperCase().contains(title.toUpperCase())) {
				System.out.println(m.toString());
			}
		}
	}
//sort
	public static void sortbycost(){
		Collections.sort(items0rdered, new MediaComparatorByCostTitle());
		print();
	}
	public static void sortbytitle() {
		Collections.sort(items0rdered, new 	MediaComparatorByTitleCost());
		print();
	}
//remove media m by title
	public static void removeMedia(String title) {
		for(Media m : items0rdered){
			if (m.getTitle().toUpperCase() == title.toUpperCase()) removeMedia(m);
		}
	}
//find Media by title
	public static Media findMedia(String title) {
		for(Media m : items0rdered){
			if (m.getTitle().toUpperCase() == title.toUpperCase()) return m;
		}
		System.out.println("No media for title ["+title+"]");
		return null;
	}
	//cart
		public static void cartMenu() {
			Scanner keyboard = new Scanner(System.in);
			int cmd;
		
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");
			cmd = keyboard.nextInt();
			if (checkInput(cmd, 4) == false) cartMenu();
			switch (cmd) {
				case 1:{
					int filter_id;
					String filter_title;
					System.out.println("1. Filter by id.");
					System.out.println("2. Filter by title.");
					int cmd11 = keyboard.nextInt();
					if (cmd11 == 1) {
						System.out.print("Enter ID : ");
						filter_id = keyboard.nextInt();
						filterbyid(filter_id);
					}else if(cmd11 == 2){
						System.out.println("Enter title :");
						filter_title = keyboard.next();
						filterbytitle(filter_title);
					}else {
						System.out.println("Input is not valid");
					}
					cartMenu();
				}
				case 2 :{
					short cmd12 = 0;
					System.out.println("1. Sort by cost.");
					System.out.println("2. Sort by title.");
					if (cmd12 == 1) {
						sortbycost();
					}else if(cmd12 == 2) {
						sortbytitle();
					}
					cartMenu();
				}
				case 3 : {
					System.out.println("Enter the title of media that you want to remove: ");
					String title = keyboard.next();
					removeMedia(title);
					cartMenu();
				}
				case 4 : {
					System.out.println("Enter a title of DVD or CD to play:");
					String title = keyboard.next();
					Media m = Cart.findMedia(title);
					if (m.getClass() == DigitalVideoDisc.class) {
						DigitalVideoDisc dvd = (DigitalVideoDisc) m;
						dvd.play();
					}else if (m.getClass() == CompactDisc.class) {
						CompactDisc cd = (CompactDisc) m;
						cd.play();
					}
				}
				case 0 : Aims.showMenu();
				default : cartMenu();
				}
			cartMenu();
		}
}