package dblayer;
import java.sql.*;

/**
 * 
 * @author Søren
 * @version 19.03.2015
 */

public class GetMax {

	public GetMax()
	{
		
	}
	
	public static int GetMaxID(String query)
	{
		ResultSet results;
		int id = -1;
		try
		{
			Statement stmt = DBConnection.getInstance().getDBcon().createStatement();
			results = stmt.executeQuery(query);
			if(results.next())
			{
				id = results.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Query exception: Error in reading maxid" + e);
		}
		return id;
	}
}
