package application;

public class Plant implements Thing {

	private double x;
	private double y;
	
	private String imagePath;

	public Plant(double x, double y, String imagePath) {
		super();
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
}
