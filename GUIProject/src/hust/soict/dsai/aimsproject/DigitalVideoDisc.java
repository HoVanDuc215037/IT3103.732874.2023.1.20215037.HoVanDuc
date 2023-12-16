package hust.soict.dsai.aimsproject;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{

	private static int nbDigitalVideoDiscs = 0;


	public DigitalVideoDisc() {
	
	}	
	public static int getNbDigitalVideoDiscs() {//Lab03 classify member & instance member
		return nbDigitalVideoDiscs;
	}
	//constructor	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;//Lab03 classify member & instance member
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs += 1;//Lab03 classify member & instance member
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;//Lab03 classify member & instance member
	}
	public String toString() {
		String outputString;
		outputString = "DVD| "+ this.id+". [" + this.title+"] [" + this.category+"] [" 
					+ this.director+"] [" + this.length+"]: " + this.cost+"$";
		return outputString;
	}
//implement Playable interface
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: DVD's length is non-postitive!");
		}

	}

}
