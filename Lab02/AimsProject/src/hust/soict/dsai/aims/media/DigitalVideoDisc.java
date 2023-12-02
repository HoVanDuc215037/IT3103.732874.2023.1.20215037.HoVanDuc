package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
//	private String title;
//	private String category;
//	private String director;
//	private int length;
//	private float cost;
//Lab03 classify member & instance member
	private static int nbDigitalVideoDiscs = 0;
///	private int id = nbDigitalVideoDiscs;
//getter & setter
/*
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	*/

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
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());

	}
}
