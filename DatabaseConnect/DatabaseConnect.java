import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DatabaseConnect {

	public static void main(String[] args) throws Exception {
		//Sets up connection
		Class.forName("org.postgresql.Driver");
		Connection connect = DriverManager.getConnection
				("jdbc:postgresql://georgiasouthern.chqyded5qfex.us-east-1.rds.amazonaws.com:5432/harrisgs?currentSchema=public",
						"as12660", "OODProject");
		Statement st = connect.createStatement();
		
		//Query
		ResultSet resultSet = st.executeQuery("SELECT * FROM oodquiz1");

		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		
		//print column names
		System.out.println(rsmd.getColumnName(1) + "\t\t    " + rsmd.getColumnName(2) + "\t\t\t    " + rsmd.getColumnName(3));
		while (resultSet.next()) {
			//Print one row          
			for(int i = 1 ; i <= columnsNumber; i++){

			      System.out.print(resultSet.getString(i) + " "); //Print one element of a row
			}
			  System.out.println();//Move to the next line to print the next row.           

		}
	}

}
