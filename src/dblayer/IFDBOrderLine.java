package dblayer;
import modellayer.*;


public interface IFDBOrderLine
{

	public int insertOrderLine(OrderLine ol) throws Exception;

	public OrderLine findOrderLine(int salesOrderId);

	public int updateOrderLine(OrderLine ol);
	
	public int deleteCustomer(int productId);

}