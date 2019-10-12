import java.sql.*; 
import java.util.*;  
import java.rmi.*;
import java.rmi.server.*;

// Implementing the remote interface 
public class ImplClass extends UnicastRemoteObject implements RemoteInt {  
   ImplClass()throws RemoteException{  
 
}  
   // Implementing the interface method 
   public List<Car> getCars(String car_name) {  
      List<Car> list = new ArrayList<Car>();   
    try{
      Class.forName("com.mysql.jdbc.Driver");  
         Connection con=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/car-review","root","password");
         Statement st = con.createStatement();
      
        
      
        
      
      //Open a connection
      
      System.out.println("Connected database successfully...");  
      
      //Execute a query 
      System.out.println("Creating statement..."); 
      
      ResultSet rs=st.executeQuery("select * from cars where car_name='"+car_name+"';");  
      
      //Extract data from result set 
      while(rs.next()) { 
         // Retrieve by column name 
         int id  = rs.getInt("car_id"); 
         
         String name = rs.getString("car_name"); 
         String comp_name = rs.getString("company_name"); 
         int price = rs.getInt("price");
         int year = rs.getInt("launch_year"); 
         int num = rs.getInt("num_of_ratings");  
         float rating = rs.getFloat("rating");
         // Setting the values 
         Car car = new Car(); 
         car.setID(id); 
         car.setName(name); 
         car.setCompName(comp_name); 
         car.setYear(year); 
         car.setPrice(price);
         car.setNum(num);
         car.setRating(rating);

         list.add(car); 
      } 
      rs.close();
      }catch(Exception e ){System.out.println(e);} 
      return list;     
   }  
}