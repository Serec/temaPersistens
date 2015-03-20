package modellayer;

public class Invoice {
	
	private int invoiceNo;
	private String paymentDate;
	private double price;
	
	public Invoice()
	{
		
	}

	public Invoice(int invoiceNo, String paymentDate, double price) {
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.price = price;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
