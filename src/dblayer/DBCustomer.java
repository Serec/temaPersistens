package dblayer;
import modellayer.*;

import java.sql.*;
/**
 * 
 * @author Søren
 * @version 19.03.2015
 *
 */


public class DBCustomer implements IFDBCustomer
{
	private Connection con;

	public DBCustomer()
	{
		con = DBConnection.getInstance().getDBcon();
	}

	//insert a customer
	public int insertCustomer(Customer cus) throws Exception
	{
		//call to get next id
		int nextID = GetMax.GetMaxID("Select max(id) from customer");
		nextID += 1;
		System.out.println("next id = " + nextID);

		int rc = -1;
		String query = "INSERT INTO customer "
				+ "VALUES('" + nextID + "','" + cus.getName() + "','" + cus.getAddress()  + "','" + cus.getZipCode()
				+ "','" + cus.getPhoneNo() +"')";

		System.out.println("insert : " + query);

		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(SQLException ex){
			System.out.println("Customer ikke oprettet");
			throw new Exception ("Customer is not inserted correct");
		}
		return(rc);

	}

	//Find a customer	
	public Customer findCustomer(String phoneNo)
	{
		String wClause = " phoneNo = '" + phoneNo + "'";
		return singleWhere(wClause);
	}

	//update a customer
	public int updateCustomer(Customer cus)
	{
		int rc = -1;

		String query = " UPDATE customer SET " + 
				"name ='" + cus.getName() +"', "+
				"address ='" + cus.getAddress() +"', "+
				"zipCode ='" + cus.getZipCode() +"', "+
				"phoneNo = '" + cus.getPhoneNo() + "'";

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
			System.out.println("Update exception in customer db: " + e);
		}
		return(rc);
	}
	
	//Delete a customer
	public int deleteCustomer(String phoneNo)
	{
		int rc = -1;
		String query = "DELETE FROM customer WHERE phoneNo = '" + phoneNo + "'";
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
			System.out.println("Delete exception in customer db: " + e);
		}
		return rc;
	}


	private Customer singleWhere(String wClause)
	{
		ResultSet results;
		Customer cusObj = new Customer();
		String query = buildQuery(wClause);

		System.out.println(query);

		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			if(results.next())
			{
				cusObj = buildCustomer(results);
				stmt.close();	
			}
			else
			{
				cusObj = null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return cusObj;
	}

	private String buildQuery(String wClause)
	{
		String query = " SELECT id, name, address, zipCode, phoneNo FROM customer";
		if(wClause.length()>0)
		{
			query = query  +" WHERE " + wClause;			
		}
		return query;
	}

	private Customer buildCustomer(ResultSet results)
	{
		Customer cusObj = new Customer();
		try
		{
			cusObj.setName(results.getString("name"));
			cusObj.setAddress(results.getString("address"));
			cusObj.setZipCode(results.getString("zipCode"));
			cusObj.setPhoneNo(results.getString("phoneNo"));
		}
		catch(Exception e)
		{
			System.out.println("Error in building the customer object.");
		}
		return cusObj;
	}





















}
