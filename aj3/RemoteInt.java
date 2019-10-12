/*import java.rmi.Remote; 
import java.rmi.RemoteException;*/ 
import java.util.*;
import java.rmi.*;

// Creating Remote interface for our application 
interface RemoteInt extends Remote {  
   public List<Car> getCars(String car_name) throws RemoteException;  
}