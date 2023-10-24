package ThreadMatcher;

public class Thread {

	private String manufacturer;
	private String name;
	private int code;
	private double color;

	public Thread(String manufacturer, String name, int code, double color) {
		this.manufacturer = manufacturer;
		this.name = name;
		this.code = code;
		this.color = color;
	}

	public double difference(Thread other) {
		return Math.abs(color - other.color);
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

	public double getColor() {
		return color;
	}

	public void setColor(double color) {
		this.color = color;
	}

}
