package modellayer;

public class OrderLine {

	private int salesOrderId;
	private int productId;
	private int quantity;
	private double  unitPrice;
	private Product product;
	private SalesOrder salesOrder;
	
	
	public OrderLine()
	{
		
	}


	public OrderLine(int quantity, double unitPrice, Product product, SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.product = product;
	}

	
	public int getSalesOrderId() {
		return salesOrderId;
	}


	public SalesOrder getSalesOrder() {
		return salesOrder;
	}


	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}


	public void setProductId(int productId) {
		this.productId = productId;
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
