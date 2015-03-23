package modellayer;

public class OrderLine {

	private int salesOrderId;
	private int productId;
	private int quantity;
	private double  unitPrice;
	private Product product;
	
	
	public OrderLine()
	{
		
	}


	public OrderLine(int quantity, double unitPrice, Product product) {
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.product = product;
	}

	
	public int getSalesOrderId() {
		return salesOrderId;
	}


	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductOrderId(int productId) {
		this.productId = productId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
