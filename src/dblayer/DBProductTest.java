package dblayer;
import modellayer.Product;
import dblayer.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class DBProductTest {

	@Test
	public void testInsertProduct() throws Exception {
		Product product = new Product("Sko", 50, 100, 70, "Denmark", 5, 1);
		IFDBProduct dbProduct = new DBProduct();
		dbProduct.insertProduct(product);
		
		
	}

}
