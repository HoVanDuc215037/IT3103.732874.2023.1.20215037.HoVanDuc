package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;

public abstract class Media {
	protected int id; 
	protected String title; 
	protected String category;
	protected float cost;
/*
	ArrayList<Media> mediae = new ArrayList<Media>();
//sample cd, dvd, book
	Book book = new Book(1, "Book of moon", "imaginary", 10.01f);
	CompactDisc cd = new CompactDisc("Celion Dion");
	DigitalVideoDisc dvd = new DigitalVideoDisc("Title: Venom.Let's be the carnage!");
	mediae.add(book);
	mediae.add(cd);
	mediae.add(dvd);
*/
//
//getter&setter
	public Media() {
		// TODO Auto-generated constructor stub
	}

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
//end getter&setter
//override equals() methhod
	public boolean equals(Object o) {
		Object obj = this.title + this.category + this.cost;
		if (obj != o) return false;
		return true;
	}
}
