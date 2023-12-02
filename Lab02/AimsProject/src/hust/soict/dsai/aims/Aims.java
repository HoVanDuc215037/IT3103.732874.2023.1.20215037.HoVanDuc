package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public class Aims{
	static Store store = new Store();
	static Cart cart = new Cart();
	
	static boolean checkInput(int input, int options) {
		if (input < 0 || input > options) return false;
		return true;
	}
	public static void showMenu() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		int cmd = keyboard.nextInt();
		if (checkInput(cmd, 3) == false) showMenu();
		switch (cmd) {
			case 1:{
					Store.print();
					Store.storeMenu();
				}
			case 2: {
					Store.updateStore();
				}
			case 3: {
				Cart.print();
				Cart.cartMenu();
				break;
				}
			case 0 : {
				System.out.println("Thank for visit my Store.");
				break;
				}
			default : break;
		}		
		keyboard.close();
	}
//
	public static void main(String[] args) {
		showMenu();
	}
}





























/*
		//lab01, lab02
			//Create a new cart
			Cart anOrder = new Cart();
			//Create new dvd objects and add them to the cart 
			DigitalVideoDisc dvd1 = new DigitalVideoDisc (
					"The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
			anOrder.addDigitalVideoDisc (dvd1);
			DigitalVideoDisc dvd2 = new DigitalVideoDisc(
					"Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
			anOrder.addDigitalVideoDisc (dvd2);
			DigitalVideoDisc dvd3= new DigitalVideoDisc (
					"Aladin", "Animation", 18.99f);
			anOrder.addDigitalVideoDisc (dvd3);
			//print total cost of the items in the cart 			
			System.out.print("Total Cost is: "); 
			System.out.println(anOrder.totalCost());
			anOrder.removeDigitalVideoDisc (dvd3);
			System.out.print("Total Cost is: "); 
			System.out.println(anOrder.totalCost()+ "$");
			//to commit
//lab03 test add to Cart a list of dvd
			DigitalVideoDisc [] listDVD = new DigitalVideoDisc[3];
			DigitalVideoDisc dvd4  = new DigitalVideoDisc("Aladin - 2", "Animation",20.00f);
			listDVD[0] = dvd4;
			DigitalVideoDisc dvd5  = new DigitalVideoDisc("Aladin - 3", "Animation", 21.00f);
			listDVD[1] =	dvd5; 
			DigitalVideoDisc dvd6  = new DigitalVideoDisc("Aladin - 4", "Animation", 22.00f);
			listDVD[2] =	dvd6;
			anOrder.addDigitalVideoDisc (listDVD);
			anOrder.print();
//lab03 test add to Cart a list of dvd
			DigitalVideoDisc dvd7  = new DigitalVideoDisc("The Lion King 2", "Animation", "Roger Allers", 88, 16.95f); 
			DigitalVideoDisc dvd8  = new DigitalVideoDisc("The Lion King 3", "Animation", "Roger Allers", 90, 20.23f);
			anOrder.addDigitalVideoDisc (dvd7, dvd8);
			anOrder.print();
//lab03 teat add to Cart 2 dvd
*/			
// commit to merge release/apply-release-flow to release/lab03

