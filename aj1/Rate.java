import java.sql.*;
class Rate
{
	void rateCar(int car_id, float rate)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/car-review","root","password");
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select * from cars where car_id="+car_id+";"); 
			rs.next(); 
			int new_num = rs.getInt(7)+1; 
			float new_rating = ((rs.getFloat(6)*rs.getInt(7))+rate)/new_num;

			st.executeUpdate("update cars set rating="+new_rating+", num_of_ratings="+new_num+" where car_id="+car_id+";");  
			System.out.println("Rating Submitted");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}