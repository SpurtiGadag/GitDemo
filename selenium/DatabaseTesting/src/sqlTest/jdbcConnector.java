
package sqlTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class jdbcConnector {
 



public static void main(String[] args) throws SQLException, Throwable, IllegalAccessException, ClassNotFoundException

{
	//String URL="jdbc:mysql://localhost:3306/qadbt?autoReconnect=true&useSSL=false";
	String Username = "root";
	String password = "root";
	//String port="3306";
	//Connection con = null;
   	//Class.forName("com.jdbc.Driver").newInstance();
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt?" + "autoReconnect=true&useSSL=false", Username, password);
      
Statement  s=con.createStatement();
String sql="insert into employeeinfo" + "(name,id,location,age)" +" values('Acdf',543,'ASM',23)";
//insert into DB
s.executeUpdate(sql);
ResultSet rs=s.executeQuery("select * from Employeeinfo");
while (rs.next())
{
	System.out.println(rs.getString("name"));
	System.out.println(rs.getString("id"));
	System.out.println(rs.getString("location"));
	System.out.println(rs.getString("age"));
	
	
	
	
}
 
 
 
 
 
 }
}
