import java.sql.*;
class Login
{
	boolean ifLogin(String usr1, String pass1,boolean ifadmin)
	{
	try
	{	
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/car-review","root","password");
		Statement st = con.createStatement();
		if(ifadmin)
		{
			ResultSet rs=st.executeQuery("select * from admin where username ='"+usr1+"' and password='"+pass1+"';");
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			ResultSet rs=st.executeQuery("select * from users where username ='"+usr1+"' and password='"+pass1+"';");
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}	
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
		return true;
	}
}