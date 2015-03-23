package ctrlayer;
import modellayer.*;
import dblayer.*;

public class ProductCtr
{
	public ProductCtr()
	{
	
	}
	
	public void insertNewProduct(String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin,int minStock, int supplierID) throws Exception
			{
				Product prodObj = new Product();
				prodObj.setName(name);
				prodObj.setPurchasePrice(purchasePrice);
				prodObj.setSalesPrice(salesPrice);
				prodObj.setRentPrice(rentPrice);
				prodObj.setCountryOfOrigin(countryOfOrigin);
				prodObj.setMinStock(minStock);
				prodObj.setSupplierID(supplierID);
				try
				{
					DBConnection.startTransaction();
					IFDBProduct dbProd = new DBProduct();
					dbProd.insertProduct(prodObj);
					DBConnection.commitTransaction();		
				}
				catch(Exception e)
				{
					DBConnection.rollbackTransaction();
					throw new Exception("Product not inserted");
				}
			}
	
	public Product findByName(String name)
	{
		IFDBProduct dbProd = new DBProduct();
		return dbProd.findProduct(name, false);
	}
	
	public int updateProduct(String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin,int minStock, int supplierID)
	{
		IFDBProduct dbProd = new DBProduct();
		Product prod = new Product();
		
		prod.setName(name);
		prod.setPurchasePrice(purchasePrice);
		prod.setSalesPrice(salesPrice);
		prod.setRentPrice(rentPrice);
		prod.setCountryOfOrigin(countryOfOrigin);
		prod.setMinStock(minStock);
		prod.setSupplierID(supplierID);
		
		return dbProd.updateProduct(prod);		
		
	}
	
	public int deleteProduct(String name)
	{
		IFDBProduct dbProd = new DBProduct();
		return dbProd.deleteProduct(name);
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
