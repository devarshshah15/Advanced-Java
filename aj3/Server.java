/*import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;*/ 
import java.rmi.*;
//import java.rmi.registry.*;
public class Server{ 
    public static void main(String args[])throws Exception { 
         ImplClass s = new ImplClass();  
         Naming.rebind("rmi://localhost:7856/aj3",s); 
         System.out.println("Server ready");     
   } 
}