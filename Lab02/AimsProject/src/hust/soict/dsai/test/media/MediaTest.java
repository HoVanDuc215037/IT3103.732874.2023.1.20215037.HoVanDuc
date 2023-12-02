package hust.soict.dsai.test.media;
import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.*;

public class MediaTest {

	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc("Celion Dion");
		DigitalVideoDisc dvd = new DigitalVideoDisc("Aladin 2");
		Book book = new Book("The dorve tree");
		// create some media here
		// for example: cd, dvd, book
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		for (Media m: mediae) {
		System.out.println(m.toString());
		}
	}

}
