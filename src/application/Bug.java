package application;

public class Bug  implements Thing {
	
	
	private double x;
	private double y;
	private String species;
	private String imagePath;
	private int energy;
	private int hungerlevel;
	private int randomDirection;
	private static int bugCount = 0;
	private int uniqueID = bugCount++;
	


	public Bug(double x, double y, String imagePath, int energy, int hungerlevel ) {
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
		this.energy = energy;
		this.hungerlevel = hungerlevel;
		this.randomDirection = (int) (Math.random()*7)+1;
	}



	public Bug(double x, double y, String imagePath) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
		this.randomDirection = (int) (Math.random()*7)+1;
	}

	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public int getEnergy() {
		return energy;
	}


	public void setEnergy(int energy) {
		this.energy = energy;
	}


	public int getHungerlevel() {
		return hungerlevel;
	}


	public void setHungerlevel(int hungerlevel) {
		this.hungerlevel = hungerlevel;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public int getRandomDirection() {
		return randomDirection;
	}


	public void setRandomDirection(int randomDirection) {
		this.randomDirection = randomDirection;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public static int getBugCount() {
		return bugCount;
	}


	public static void setBugCount(int bugCount) {
		Bug.bugCount = bugCount;
	}


	public int getUniqueID() {
		return uniqueID;
	}


	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

}
	

		