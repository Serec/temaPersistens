package ctrlayer;
import dblayer.*;
import modellayer.*;

public class SalesOrderCtr {

	public SalesOrderCtr()
	{
		
	}
	
	public void createNewSalesOrder(String date, double price, String deliveryStatus, String deliveryDate) throws Exception
	{
		SalesOrder soObj = new SalesOrder();
		soObj.setDate(date);
		soObj.setPrice(price);
		soObj.setDeliveryDate(deliveryDate);
		soObj.setDeliveryStatus(deliveryStatus);
		try
		{
			DBConnection.startTransaction();
			IFDBSalesOrder dbSo = new DBSalesOrder();
			dbSo.insertSalesOrder(soObj);
			DBConnection.commitTransaction();			
		}
		catch(Exception e)
		{
			DBConnection.rollbackTransaction();
			throw new Exception("SalesOrder not created");
		}
	}
	
	public SalesOrder findSalesOrder(int id)
	{
		IFDBSalesOrder dbSo = new DBSalesOrder();
		return dbSo.findSalesOrder(id);
	}
	
	public int updateSalesOrder(String deliveryDate, String deliveryStatus, double price)
	{
		IFDBSalesOrder dbSo = new DBSalesOrder();
		SalesOrder so = new SalesOrder();
		
		so.setDeliveryDate(deliveryDate);
		so.setDeliveryStatus(deliveryStatus);
		so.setPrice(price);
		return dbSo.updateSalesOrder(so);
	}
	
	public int deleteSalesOrder(SalesOrder so)
	{
		IFDBSalesOrder dbSo = new DBSalesOrder();
		return dbSo.deleteSalesOrder(so);
	}
	
	
	
	
	
}
