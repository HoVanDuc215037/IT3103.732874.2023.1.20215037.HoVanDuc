package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
//	private int id; 
//	private String title; 
//	private String category;
//	private float cost;
	private List<String> authors = new ArrayList<String>();
	

	public Book(int id, String title, String category, float cost, List<String> authors) {
		super();//c
		// TODO Auto-generated constructor stub
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.authors = authors;
	}
	public Book(int id, String title, String category, float cost) {
		super();
		// TODO Auto-generated constructor stub
		this.id = id;
		this.title = title;
		this.category = category;//ccv
		this.cost = cost;
	}
	public Book() {
	}
//getter&setter
/*	public int getId() {
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
*/
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
//end getter & setter
//method add& remove Authors
	public void addAuthors(String authorsName) {
		if (authors.contains(authorsName)) {
			System.out.println("Book. Add failed!. Author'name had already existed!");
		}else {
			authors.add(authorsName);
			System.out.println("Book. Add authors success.");
		}
	}
	
	public void removeAuthors(String authorsName) {
		if (authors.contains(authorsName)) {
			authors.remove(authorsName);
			System.out.println("Book. Remove authors success.");
		}else {
			System.out.println("Book. Remove failed!. Author'name had not existed!");
		}
	}
//toString() method
	public String toString() {
		String outputString;
		outputString = "Book| "+this.id+". [" + this.title+"] [" + this.category+"] " +"["+this.authors+"] "+ this.cost+"$";
		return outputString;//,,
	}
}
