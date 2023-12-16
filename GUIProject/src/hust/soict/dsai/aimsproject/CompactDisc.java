package hust.soict.dsai.aimsproject;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String artist, ArrayList<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(String artist) {
		super();
		this.artist = artist;
	}
//method add & remove track
	public void addTrack(Track t) {
		if (tracks.contains(t)) {
			System.out.println("CompactDisc. Add failed. ["+t+"] had already in your Track.");
		}else {
			tracks.add(t);
			System.out.println("CompactDisc. Add success.");
			
		}
	}
	public void removeTrack(Track t) {
		if (tracks.contains(t)) {
			tracks.remove(t);
			System.out.println("CompactDisc. Remove success.");
		}else {
			System.out.println("CompactDisc. Remove failed. ["+t+"] does not exist in your Track.");			
		}
	}
//method getLength
	public int getLength() {
		int sumLength = 0;
		for (Track i : tracks) {
			sumLength += i.getLength();
		}
		return sumLength;
	}
//implements Playable interface
	public void play() {
		for (Track i: tracks) {
			System.out.println("Track "+i+": title  ["+i.getTitle()+"], length ["+ i.getLength()+"]");
		}
	}
//toString() method
	public String toString() {
		String outputString;
		outputString = "CD| "+ this.id+". [" + this.title+"] [" + this.category+"]" + " ["
							+ this.artist+"]. Track: "+this.tracks+ " "+this.cost+"$";
		return outputString;
	}
}

