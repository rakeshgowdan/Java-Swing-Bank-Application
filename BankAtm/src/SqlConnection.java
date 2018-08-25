import java.sql.*;
import javax.swing.*;
public class SqlConnection {
	
	Connection conn=null;
	public static Connection dbConnector()
	{
	    try {
	    	
	    	String url = "jdbc:mysql://localhost/bank";
	    	Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	    	Connection conn = DriverManager.getConnection (url, "root", "root");
	    	/*Class.forName("org.mysql.JDBC");
	    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost//3306", "root", "root");*/
	    	JOptionPane.showMessageDialog(null, "connection succesfull");
	    	return conn;
	    }
	    catch(Exception e)
	    {
	    	JOptionPane.showMessageDialog(null, e);
	    	return null; 
	    	
	    }
		
		
		
	}

}
