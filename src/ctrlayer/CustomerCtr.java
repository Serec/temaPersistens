package ctrlayer;
import modellayer.*;
import dblayer.*;

public class CustomerCtr 
{
	public CustomerCtr()
	{

	}

	//insert customer
	public void insertNewCustomer(String name, String address, String zipCode, String phoneNo) throws Exception
	{
		Customer cusObj = new Customer();
		cusObj.setName(name);
		cusObj.setAddress(address);
		cusObj.setZipCode(zipCode);
		cusObj.setPhoneNo(phoneNo);
		try
		{
			DBConnection.startTransaction();
			IFDBCustomer dbCus = new DBCustomer();
			dbCus.insertCustomer(cusObj);
			DBConnection.commitTransaction();			
		}
		catch(Exception e)
		{
			DBConnection.rollbackTransaction();
			throw new Exception("Customer not inserted");
		}

	}

	//find customer
	public Customer findByPhoneNo(String phoneNo)
	{
		IFDBCustomer dbCus = new DBCustomer();
		return dbCus.findCustomer(phoneNo);
	}

	//update customer
	public int updateCustomer(String name, String address, String zipCode, String city, String phoneNo)
	{
		IFDBCustomer dbCus = new DBCustomer();
		Customer cus = new Customer();
		
		cus.setName(name);
		cus.setAddress(address);
		cus.setZipCode(zipCode);
		cus.setPhoneNo(phoneNo);
		return dbCus.updateCustomer(cus);
	}
	
	//delete customer
	public int deleteCustomer(String phoneNo)
	{
		IFDBCustomer dbCus = new DBCustomer();
		return dbCus.deleteCustomer(phoneNo);
	}





















}
