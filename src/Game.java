
import jade.util.leap.Serializable;

public class Game implements Serializable{

	String title;
	int pegi;
	int releaseDate;
	
	public Game(String title, int pegi, int releaseDate) {
		this.title = title;
		this.pegi = pegi;
		this.releaseDate = releaseDate;
	}
	
	public void Print(){
		System.out.println("Title: "+this.title);
		System.out.println("PEGI: "+this.pegi);
		System.out.println("Released: "+this.releaseDate);
		System.out.println("\n");
	}

}
