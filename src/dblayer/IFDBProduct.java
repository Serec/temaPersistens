package dblayer;

import modellayer.*;

public interface IFDBProduct {
	int insertProduct(Product product) throws Exception;
	Product findProduct(String name, boolean retriveAssociation);
	int updateProduct(Product product);
	int deleteProduct(String name);
}
