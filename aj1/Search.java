import java.sql.*;
class Search
{
	void searchCar(String car_name)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/car-review","root","password");
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select * from cars where car_name='"+car_name+"';");  
						while(rs.next()){  
							System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "
								+rs.getFloat(6)+" "+rs.getInt(7));
						}
		}catch(Exception e){
			System.out.println(e);
		}	
	}
}