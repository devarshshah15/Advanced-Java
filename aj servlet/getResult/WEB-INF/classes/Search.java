import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
//import java.lang.*;

public class Search extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String car=request.getParameter("car");
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car-review","root","password");
			
			PreparedStatement ps=con.prepareStatement("select * from cars where car_name=?");
			ps.setString(1,car);
			
			out.print("<table width=50% border=1>");
			out.print("<caption>Result:</caption>");
			ResultSet rs=ps.executeQuery();
			
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int total=rsmd.getColumnCount();
			out.print("<tr>");
			for(int i=1;i<=total;i++)
			{
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");
				
			}
			out.print("</tr>");
			
			/* Printing result */
			while(rs.next())
			{
				out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getInt(5)+"</td><td>"+rs.getFloat(6)+"</td><td>"+rs.getInt(7)+"</td></tr>");
				
			}
			out.print("</table>");
			
		}catch (Exception e2) {e2.printStackTrace();}
		
		finally{out.close();}
	}

}
