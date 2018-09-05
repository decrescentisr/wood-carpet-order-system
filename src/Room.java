import helpers.OutputHelpers;
import helpers.StringHelpers;

public class Room {
	
	private String customerName = "";
	private String customerAddress = "";
	private String flooringType = "";
	private double floorArea = 0;
	private double floorCost = 0;
	private double length = 0;
	private double width = 0;
	
	
	public Room() {
		this("", "", "", 0, 0);
	}
	public Room(String address, String type, double area, double cost) {
		setCustomerAddress(address);
		setFlooringType(type);
		setFloorArea(area);
		setFloorCost(cost);
	}
	public Room(String name, String type, String address, double area, double cost) {
		setCustomerName(name);
		setCustomerAddress(address);
		setFlooringType(type);
		setFloorArea(area);
		setFloorCost(cost);
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public String getFlooringType() {
		return flooringType;
	}
	public double getFloorArea() {
		return getLength() * getWidth();
	}
	public double getFloorCost() {
		return floorCost;
	}
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	public void setLength(double length) {
		if (length >= 5 && length <= 100)
			this.length = length;
		else if (length < 5)
			this.length = 5;
		else
			this.length = 5;
		
		this.length = length;
	}
	public void setWidth(double width) {
		if (width >= 5 && width <= 100)
			this.width = width;
		else if (width < 5)
			this.width = 5;
		else
			this.width = 100;
		
		this.width = width;
	}
	public void setCustomerAddress(String customerAddress) {
		if (!StringHelpers.IsNullOrEmpty(customerAddress))
			this.customerAddress = customerAddress;
		else
			this.customerAddress = "Not provided";
		
		this.customerAddress = customerAddress;
	}
	public void setFlooringType(String flooringType) {
		if (!StringHelpers.IsNullOrEmpty(flooringType))
			this.flooringType = flooringType;
		else
			this.flooringType = "Not provided";
		
		this.flooringType = flooringType;
		
	}
	public void setFloorArea(double area) {
		this.floorArea = area;
	}
	public void setFloorCost(double cost) {
		this.floorCost = cost;
	}
	public void setCustomerName(String name) {
		if (!StringHelpers.IsNullOrEmpty(name))
			customerName = name;
		else
			//customerName = "Not provided";
		OutputHelpers.showStandardDialog("Please complete the form in order to save the client information.","Customer Information");
		
	}

	public String getCustomerName() {
		
		return customerName;
	}
	
	
	public boolean Save() {
		boolean success = false;
		success = RoomData.saveRoomData(this);
		
		return success;
	}
	
}
