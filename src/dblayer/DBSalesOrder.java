package dblayer;
import java.sql.*;

import modellayer.*;

public class DBSalesOrder implements IFDBSalesOrder
{
	private Connection con;
	
	public DBSalesOrder()
	{
		con = DBConnection.getInstance().getDBcon();
	}
	
	public int insertSalesOrder(SalesOrder so) throws Exception
	{
		int nextID = GetMax.GetMaxID("Select max(id) from salesorder");
		nextID += 1;
		System.out.println("next id = " + nextID);
		
		int rc = -1;
		String query = "INSERT INTO salesorder "
				+ "VALUES(" + nextID + ",'" + so.getDate() + "','" + so.getPrice()
				+ "','" + so.getDeliveryStatus() + "','" + so.getDeliveryDate() + "','" + 3 + "')";
		
		System.out.println("insert : " + query);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(SQLException ex){
			System.out.print("Salesorder ikke oprettet");
			throw new Exception ("Salesorder is not inserted correct");
		}
		return (rc);
		
	}
	
	public SalesOrder findSalesOrder(int id)
	{
		String wClause = " id  = '" + id + "'";
		return singleWhere(wClause);
	}
	
	public int updateSalesOrder(SalesOrder so)
	{
		SalesOrder soObj = so;
		int rc = -1;
		
		String query = " UPDATE salesorder SET " +
		"deliverydate = '" + soObj.getDeliveryDate() +"', "+
		"deliverystatus = '" + soObj.getDeliveryStatus() +"', "+
		"price = '" + soObj.getPrice() +"', "+
		" WHERE id = '" + soObj.getId() + "'";
		
		System.out.println("Update query: " + query);
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Updtae exception in salesorder db: " + e);
		}
		return(rc);
	}
	
	public int deleteSalesOrder(SalesOrder so)
	{
		int rc = -1;
		String query = "DELETE FROM salesorder WHERE id = '" + so.getId() + "'";
		System.out.println(query);
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Delete exception in salesorder db: " + e);
		}
		return rc;
	}
	
	private SalesOrder singleWhere(String wClause)
	{
		ResultSet results;
		SalesOrder soObj = new SalesOrder();
		String query = buildQuery(wClause);
		
		System.out.println(query);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			if(results.next())
			{
				soObj = buildSalesOrder(results);
				stmt.close();
			}
			else
			{
				soObj = null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return soObj;
	}
	
	private String buildQuery(String wClause)
	{
		String query = " SELECT id, date, deliverydate, deliverystatus, price FROM salesorder";
		if(wClause.length()>0)
		{
			query = query +" WHERE " + wClause;
		}
		return query;
	}
	
	private SalesOrder buildSalesOrder(ResultSet results)
	{
		SalesOrder soObj = new SalesOrder();
		try
		{
			soObj.setDate(results.getString("date"));
			soObj.setDeliveryDate(results.getString("deliverydate"));
			soObj.setDeliveryStatus(results.getString("deliverystatus"));
			soObj.setPrice(results.getDouble("price"));
		}
		catch(Exception e)
		{
			System.out.println("Error in building the salesorder object.");
		}
		return soObj;
	}
	
}
