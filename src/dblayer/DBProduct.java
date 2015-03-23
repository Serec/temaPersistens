package dblayer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import modellayer.Product;

public class DBProduct implements IFDBProduct  {
	private Connection con;

	public DBProduct()
	{
		con = DBConnection.getInstance().getDBcon();
	}
	
	
	
	@Override
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
				throw new Exception ("Customer is not inserted correct");
			}
			return(returnCode);
	}



	@Override
	public Product findProduct(String name, boolean retriveAssociation) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int deleteProduct(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
