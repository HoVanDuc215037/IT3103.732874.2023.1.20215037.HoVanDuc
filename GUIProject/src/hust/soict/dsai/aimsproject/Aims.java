package hust.soict.dsai.aimsproject;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.exception.PlayerException;

public class Aims{
	static Store store = new Store();
	static Cart cart = new Cart();
	
	static boolean checkInput(int input, int options) {
		if (input < 0 || input > options) return false;
		return true;
	}
	public static void showMenu() throws PlayerException {
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
	public static void main(String[] args) throws PlayerException {
		showMenu();
	}
}

