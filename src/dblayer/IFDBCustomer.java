package dblayer;
import modellayer.*;

public interface IFDBCustomer 
{
	//insert a new customer
	public int insertCustomer(Customer cus) throws Exception;
	//find a customer with phoneNo
	public Customer findCustomer(String phoneNo);
	//update information about customer
	public int updateCustomer(Customer cus);

}
