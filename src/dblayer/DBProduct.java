package dblayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modellayer.Product;

public class DBProduct implements IFDBProduct  {
	private Connection con;

	public DBProduct()
	{
		con = DBConnection.getInstance().getDBcon();
	}
	
	
	
	public int insertProduct(Product product) throws Exception {
		int nextID = GetMax.GetMaxID("SELECT max(id) FROM product");
		nextID += 1;
		System.out.println("next id = " + nextID);
		int returnCode = -1;
		   String query="INSERT INTO product(id, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, supplierID)  VALUES('"+
				   	nextID + "','" +
			  		product.getName()  + "','"  +
				    product.getPurchasePrice()  + "','"  +
		            product.getSalesPrice() + "','" +
		            product.getRentPrice() + "','" +
		            product.getCountryOfOrigin() + "','" +
		            product.getMinStock() + "','" +
		            product.getSupplierID()
		            		+ "')";
		   
		   System.out.println("insert : " + query);
		   
			try
			{
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				returnCode = stmt.executeUpdate(query);
				stmt.close();
			}
			catch(SQLException ex){
				System.out.println(ex.getMessage());
				throw new Exception ("Product is not inserted correct");
			}
			return(returnCode);
	}



	//Find a product	
	public Product findProduct(String name)
	{
		String wClause = " name = '" + name + "'";
		return singleWhere(wClause);
	}

	//update a product
	public int updateProduct(Product product)
	{
		Product prodObj = product;
		int rc = -1;

		String query = " UPDATE product SET " + 
				"purchasePrice = '" + prodObj.getPurchasePrice() +"', "+
				"salesPrice = '" + prodObj.getSalesPrice() +"'" +
				"rentPrice = '" + prodObj.getRentPrice() + "'" +
				"countryOfOrigin = '" + prodObj.getCountryOfOrigin() + "'" +
				"minStock = '" + prodObj.getMinStock() + "'" +
				"supplierID = '" + prodObj.getSupplierID() + "'" +
				" WHERE name = '" + prodObj.getName() + "'";

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
			System.out.println("Update exception in product db: " + e);
		}
		return(rc);
	}
	
	//Delete a product
	public int deleteProduct(String name)
	{
		int rc = -1;
		String query = "DELETE FROM product WHERE name = '" + name + "'";
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
			System.out.println("Delete exception in product db: " + e);
		}
		return rc;
	}


	private Product singleWhere(String wClause)
	{
		ResultSet results;
		Product prodObj = new Product();
		String query = buildQuery(wClause);

		System.out.println(query);

		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			if(results.next())
			{
				prodObj = buildProduct(results);
				stmt.close();	
			}
			else
			{
				prodObj = null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return prodObj;
	}

	private String buildQuery(String wClause)
	{
		String query = " SELECT id, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, supplierID FROM product";
		if(wClause.length()>0)
		{
			query = query  +" WHERE " + wClause;			
		}
		return query;
	}

	private Product buildProduct(ResultSet results)
	{
		Product prodObj = new Product();
		try
		{
			prodObj.setName(results.getString("name"));
			prodObj.setPurchasePrice(results.getDouble("purchasePrice"));
			prodObj.setSalesPrice(results.getDouble("salesPrice"));
			prodObj.setRentPrice(results.getDouble("rentPrice"));
			prodObj.setCountryOfOrigin(results.getString("countryOfOrigin"));
			prodObj.setMinStock(results.getInt("minStock"));
			prodObj.setSupplierID(results.getInt("supplierID"));
		}
		catch(Exception e)
		{
			System.out.println("Error in building the product object.");
		}
		return prodObj;
	}
	
	
}
