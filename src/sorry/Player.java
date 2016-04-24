public class Player {
	
	private String name;
	private int numberOfAttempts;
   int color;
   int p1;
   int p2;
	int p3;
   int p4;
   
	public Player(String name){
		this.name = name;
		numberOfAttempts = 0;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void increaseNumberOfAttempts() {
		numberOfAttempts++;
	}
	

}