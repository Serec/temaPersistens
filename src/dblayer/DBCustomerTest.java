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

}
