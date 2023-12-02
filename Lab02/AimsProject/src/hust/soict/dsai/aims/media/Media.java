package hust.soict.dsai.aims.media;

//import java.util.Collection;
//import java.util.Collection.sort(, Media.COMPARE_BY_TITLE_COST);
import java.util.Comparator;
//import java.util.Collection.sort(collection,Media.COMPARE_BY_TITLE_COST);

public abstract class Media {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost(); 
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	protected int id; 
	protected String title; 
	protected String category;
	protected float cost;
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
//

//
}
