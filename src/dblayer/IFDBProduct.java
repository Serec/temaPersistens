package dblayer;
import modellayer.*;

public interface IFDBProduct {
	//Get all employees
	public int insertProduct(Product product) throws Exception;
	public Product findProduct(String name, boolean retriveAssociation);
	public int updateProduct(Product product);
	public int deleteProduct(Product product);
}
