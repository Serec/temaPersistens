package modellayer;

public class Customer {

	private String name;
	private String address;
	private String zipCode;
	private String city;
	private String phoneNo;
	
	public Customer()
	{
		
	}
	
	public Customer(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	
	
	public Customer(String name, String address, String zipCode, String city, String phoneNo)
	{
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
	
}
