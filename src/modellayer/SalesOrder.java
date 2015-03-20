package modellayer;

public class SalesOrder {
	
	private String date;
	private double price;
	private String deliveryStatus;
	private String deliveryDate;
	
	public SalesOrder()
	{
		
	}
	
	public SalesOrder(String date, double price, String deliveryStatus,	String deliveryDate) {
		this.date = date;
		this.price = price;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
