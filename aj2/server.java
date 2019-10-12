import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;
class server
{
	public static void main(String[] args) {
		
		try
		{
			String result_string="";

			ServerSocket server_socket = new ServerSocket(7456);
			
			Socket s1 = server_socket.accept();
			//BufferedReader input_user = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream out_client = new DataOutputStream(s1.getOutputStream());
			BufferedReader in_client = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			
			String car_name = in_client.readLine();
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/car-review","root","password");
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select * from cars where car_name='"+car_name+"';");  
			while(rs.next()){  
				result_string = result_string+ rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "
							+rs.getFloat(6)+" "+rs.getInt(7)+"#";
			}
			

			out_client.writeBytes(result_string+"\n");
			
			server_socket.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}