package au.com.ssfs.services;

import java.sql.*;

public class mysqldoa {
	
public static java.sql.Connection connection = null;
protected static PreparedStatement statement;
protected static ResultSet results;

	 public static void connect() throws SQLException {

             try
             {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
                     System.out.println("connected");
                     
             }
             catch (Exception e)
             {
                     e.printStackTrace();
                  //   return null;
             }
     }
	 protected static void disconnect(){
			try {
				if(connection != null)	connection.close();
				if(statement != null) statement.close();
				if(results != null) results.close();
				
			} catch(SQLException sqle) {
				System.out.println("Error disconnecting: " + sqle);
			}
		}

};


