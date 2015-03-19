package dblayer;
import modellayer.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class DBCustomerTest {

	@Test
	public void testInsertCustomer() throws Exception
	{
		DBCustomer dbCus = new DBCustomer();
		Customer cus = new Customer("Hans","Sofiendalsvej 60", "9000", "12345678");
		if(dbCus.insertCustomer(cus) > 0)
		{
			System.out.println("Customer has been inserted");
		}
		else
		{
			fail("Customer not inserted");
		}
	}

	@Test
	public void testFindCustomer() 
	{
		DBCustomer dbCus = new DBCustomer();
		Customer cus = dbCus.findCustomer("12345678");
		if(cus != null)
		{
			System.out.println("Customer found");
		}
		else
		{
			fail("Customer not found");
		}
	}

	//	@Test
	//	public void testUpdateCustomer() 
	//	{
	//		DBCustomer dbCus = new DBCustomer();
	//		
	//		fail("Not yet implemented");
	//	}

	@Test
	public void testDeleteCustomer()
	{
		DBCustomer dbCus = new DBCustomer();
		if(dbCus.deleteCustomer("12345678") > 0)
		{
			System.out.println("Customer deleted");
		}
		else
		{
			fail("Customer not deleted");
		}
	}




}


