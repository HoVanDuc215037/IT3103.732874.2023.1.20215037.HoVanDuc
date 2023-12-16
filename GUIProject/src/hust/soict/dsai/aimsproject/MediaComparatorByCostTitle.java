package hust.soict.dsai.aimsproject;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		return (int) (o1.cost - o2.cost);
	}

}
