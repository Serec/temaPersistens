package modellayer;

public class Customer {

	private String name;
	private String address;
	private String zipCode;
	private String phoneNo;
	
	public Customer()
	{
		
	}
	
	public Customer(String name, String phoneNo)
	{
		this.name = name;
		this.phoneNo = phoneNo;
	}
	
	
	public Customer(String name, String address, String zipCode, String phoneNo)
	{
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
	
}
