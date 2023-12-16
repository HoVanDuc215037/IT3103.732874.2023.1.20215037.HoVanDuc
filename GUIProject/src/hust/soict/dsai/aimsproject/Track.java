package hust.soict.dsai.aimsproject;

public class Track implements Playable{
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

//implements Playable interface
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
//override equals() method
	public boolean equals(Object o) {
		Object obj = this.title + this.length;
		if (obj != o) return false;
		return true;
	}
}//c

