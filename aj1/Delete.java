import java.sql.*;
class Delete
{
	void deleteRecord(int car_id)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/car-review","root","password");
			Statement st = con.createStatement();
			st.executeUpdate("delete from cars where car_id="+car_id+";");  
			System.out.println("1 Row deleted");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}