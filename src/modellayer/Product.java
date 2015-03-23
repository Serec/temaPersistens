package modellayer;

public class Product 
{
	private String name;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private int supplierID;
	
	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	
	public Product(){
		
	}

	public Product(String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, int minStock, int supplierID)
	{
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.supplierID = supplierID;
	}

	public String getName() {
		return name;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
}
