package dblayer;
import modellayer.*;

import java.sql.*;


public class DBOrderLine implements IFDBOrderLine
{
	private Connection con;

	public DBOrderLine()
	{
		con = DBConnection.getInstance().getDBcon();
	}

	public int insertOrderLine(OrderLine ol) throws Exception
	{
		int nextID = GetMax.GetMaxID("Select max(id) from orderline");
		nextID += 1;
		System.out.println("next id = " + nextID);

		int rc = -1;
		String query = "INSERT INTO orderline "
				+ "VALUES('" + nextID + "','" + ol.getQuantity() + "','" + ol.getUnitPrice()+ "')";

		System.out.println("insert : " + query);

		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(SQLException ex){
			System.out.println("Orderline ikke oprettet");
			throw new Exception ("Orderline is not inserted correct");
		}
		return(rc);

	}

	public OrderLine findOrderLine(int salesOrderId)
	{
		String wClause = " salesOrderId = '" + salesOrderId + "'";
		return singleWhere(wClause);
	}

	public int updateOrderLine(OrderLine ol)
	{
		OrderLine olObj = ol;
		int rc = -1;

		String query = " UPDATE orderline SET " + 
				"quantity = '" + olObj.getQuantity() +"', "+
				"unitprice = '" + olObj.getUnitPrice() +"', "+
				" WHERE salesorderid = '" + olObj.getSalesOrderId() + "'";

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
			System.out.println("Update exception in orderline db: " + e);
		}
		return(rc);
	}
	
	//Delete a customer
	public int deleteCustomer(int productId)
	{
		int rc = -1;
		String query = "DELETE FROM orderline WHERE productId = '" + productId + "'";
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
			System.out.println("Delete exception in orderline db: " + e);
		}
		return rc;
	}


	private OrderLine singleWhere(String wClause)
	{
		ResultSet results;
		OrderLine olObj = new OrderLine();
		String query = buildQuery(wClause);

		System.out.println(query);

		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			if(results.next())
			{
				olObj = buildOrderLine(results);
				stmt.close();
			}
			else
			{
				olObj = null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return olObj;
	}

	private String buildQuery(String wClause)
	{
		String query = " SELECT quantity, unitPrice, salesOrderID, productID FROM orderline";
		if(wClause.length()>0)
		{
			query = query  +" WHERE " + wClause;			
		}
		return query;
	}

	private OrderLine buildOrderLine(ResultSet results)
	{
		OrderLine olObj = new OrderLine();
		try
		{
			olObj.setQuantity(results.getInt("quantity"));
			olObj.setUnitPrice(results.getDouble("unitprice"));
		}
		catch(Exception e)
		{
			System.out.println("Error in building the orderline object.");
		}
		return olObj;
	}





















}
