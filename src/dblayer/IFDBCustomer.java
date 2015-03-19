package dblayer;
import modellayer.*;
/**
 * Interface to DBCustomers
 * @author Søren
 * @version 19.03.2015
 */


public interface IFDBCustomer 
{
	//insert a new customer
	public int insertCustomer(Customer cus) throws Exception;
	//find a customer with phoneNo
	public Customer findCustomer(String phoneNo);
	//update information about customer
	public int updateCustomer(Customer cus);

}
