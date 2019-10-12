import java.io.*;
import java.net.*;
import java.lang.*;
class client
{
	public static void main(String[] args) {
		
		try
		{
			String car;

			Socket client_socket = new Socket("localhost",7456);
			
			BufferedReader input_user = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream out_server = new DataOutputStream(client_socket.getOutputStream());
			BufferedReader in_server = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));

			System.out.println("Enter car to search ");
			car=input_user.readLine();
			
			out_server.writeBytes(car+"\n");

			String result = in_server.readLine();

			String[] temp;
			temp=result.split("#");
			int i=0;
			for(i=0;i<temp.length;i++)
			{
				System.out.println(temp[i]);
			}

			client_socket.close();
		}catch(Exception e){
			System.out.println(e);
		}	
	}
}