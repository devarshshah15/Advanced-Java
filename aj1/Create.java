import java.sql.*;
class Create 
{
	void createRecord(int car_id,String car_name,String company_name,int launch_year,int price)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/car-review","root","password");
			Statement st = con.createStatement();
			st.executeUpdate("insert into cars (car_id,car_name,company_name,launch_year,price) values ("+car_id+",'"+car_name+"','"+company_name+"',"+launch_year+","+price+");");  
			System.out.println("1 Row inserted");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
					
	}
}