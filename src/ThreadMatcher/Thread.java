package ThreadMatcher;

public class Thread {

	private String manufacturer;
	private String name;
	private int code;
	private double[] color;

	public Thread(String manufacturer, String name, int code, double[] color) {
		this.manufacturer = manufacturer;
		this.name = name;
		this.code = code;
		this.color = color;
	}

	public double difference(Thread other) {
	    double sumDifference = 0;
	    // absolute differences for each RGB value
	    for (int i = 0; i < 3; i++) {
	        sumDifference += Math.abs(color[i] - other.color[i]);
	    }    
	    // Compute the average of the absolute differences
	    double averageDifference = sumDifference / 3;
	    
	    return averageDifference;
	}
	

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double[] getColor() {
		return color;
	}

	public void setColor(double[] color) {
		this.color = color;
	}

}
