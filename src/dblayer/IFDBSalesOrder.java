package dblayer;
import modellayer.*;

public interface IFDBSalesOrder
{
	public int insertSalesOrder(SalesOrder so) throws Exception;
	
	public SalesOrder findSalesOrder(int id);
	
	public int updateSalesOrder(SalesOrder so);
	
	public int deleteSalesOrder(SalesOrder id);
}
