package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		return o1.title.compareTo(o2.title);
	}

}
