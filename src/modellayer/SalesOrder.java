package modellayer;

import java.util.ArrayList;

public class SalesOrder {
	
	private String date;
	private double price;
	private String deliveryStatus;
	private String deliveryDate;
	private ArrayList<OrderLine> orderlines;
	private int id;
	
	public SalesOrder()
	{
		
	}
	
	public SalesOrder(String date, double price, String deliveryStatus,	String deliveryDate) {
		this.date = date;
		this.price = price;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public ArrayList<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void addOrderLine(OrderLine ol)
	{
		orderlines.add(ol);
	}
	
	public void removeOrderLine(OrderLine ol)
	{
		if(orderlines.contains(ol))
		{
			orderlines.remove(ol);
		}
	}
}
