//import java.rmi.registry.LocateRegistry; 
//import java.rmi.registry.Registry; 
import java.util.*;
import java.rmi.*;  

public class Client {  
   //private Client() {}  
   public static void main(String[] args)throws Exception {  
      

         Scanner sc = new Scanner(System.in);
         System.out.println("Enter car name to be searched:");
         String car_name = sc.next();
         // Getting the registry 
         
    
         // Looking up the registry for the remote object 
         RemoteInt r = (RemoteInt)Naming.lookup("rmi://localhost:7856/aj3"); 
    
         // Calling the remote method using the obtained object 
         List<Car> list = r.getCars(car_name); 
         for (Car c:list) { 
            
            // System.out.println("bc "+s.getBranch()); 
            System.out.print(c.getId()+"  "); 
            System.out.print(c.getName()+"  "); 
            System.out.print(c.getCompName()+"  "); 
            System.out.print(c.getYear()+"  "); 
            System.out.print(c.getPrice()+"  ");
            System.out.print(c.getRating()+"  ");
            System.out.print(c.getNum()+"  ");
            System.out.println(); 
         }  
      // System.out.println(list); 
       
       
   } 
}