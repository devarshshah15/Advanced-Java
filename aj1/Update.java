import java.sql.*;
class Update
{
	void updateRecord(int car_id, String car_name, String company_name, int launch_year, int price)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/car-review","root","password");
			Statement st = con.createStatement();
			st.executeUpdate("update cars set car_name='"+car_name+"', company_name='"+company_name+"', launch_year="+launch_year+", price="+price+" where car_id="+car_id+";");  
			System.out.println("1 Row updated");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}