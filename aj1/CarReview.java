import java.util.Scanner;
import java.sql.*;
import java.io.Console;
class CarReview
{
	public static void main(String [] args){
			Scanner sc = new Scanner(System.in);
			Console cnsl = System.console(); 

			System.out.println("*****************************************");
	        System.out.println("1. Login as Admin");
	        System.out.println("2. Login as User");
	        System.out.println("3. Exit");
			System.out.println("*****************************************");
			int choice = sc.nextInt();

			Login lg = new Login();
			String usr = new String();
			String pass = new String();
			char[] ps = new char [20];

			Search srch = new Search();

			Create crt = new Create();

			Update upd = new Update();

			Delete dlt = new Delete();

			Rate rt = new Rate();

			while(true)
			{
				switch(choice)
				{
					
					case 1:
						System.out.println("Enter Username");
						usr = sc.next();
						System.out.println("Enter password");
						ps = cnsl.readPassword();
						pass = String.valueOf(ps);
						if(lg.ifLogin(usr,pass,true))
						{
							while(true)
							{
								System.out.println("*****************************************");
			        			System.out.println("1. Create Car Record");
			        			System.out.println("2. Search Car Record");
			        			System.out.println("3. Update Car Record");
			        			System.out.println("4. Delete Car Record");
			        			System.out.println("5. Exit");
			        			System.out.println("*****************************************");
								int ch = sc.nextInt();
								switch(ch)
								{
									case 1:
										System.out.println("Enter car_id");
										int car_id = sc.nextInt();
										System.out.println("Enter car_name");
										String car_name = sc.next();
										System.out.println("Enter company_name");
										String company_name = sc.next();
										System.out.println("Enter launch_year");
										int launch_year = sc.nextInt();
										System.out.println("Enter price");
										int price = sc.nextInt();
										crt.createRecord(car_id,car_name,company_name,launch_year,price);
										break;
									case 2:
										System.out.println("Enter Car name to be searched");
										car_name = sc.next();
										srch.searchCar(car_name);
										break;
									case 3:
										System.out.println("Enter Car name to be searched for editing");
										car_name = sc.next();
										srch.searchCar(car_name);
										System.out.println("Enter the car_id for updating");
										car_id = sc.nextInt();
										System.out.println("Enter car_name");
										car_name = sc.next();
										System.out.println("Enter company_name");
										company_name = sc.next();
										System.out.println("Enter launch_year");
										launch_year = sc.nextInt();
										System.out.println("Enter price");
										price = sc.nextInt();
										upd.updateRecord(car_id,car_name,company_name,launch_year,price);
										break;
									case 4:
										System.out.println("Enter Car name for which you want to delete data:");
		            					car_name = sc.next();
		            					srch.searchCar(car_name);
		            					System.out.println("Enter the car_id for deleting");
		            					car_id = sc.nextInt();
		            					dlt.deleteRecord(car_id);
										break;
									case 5:
										System.exit(0);
										break;
									default:
										System.out.println("Invlaid Input");
										break;
								}
							}
								
						}
						else
						{
							System.out.println("Invalid login credentials");
						}
						break;
					case 2:
						System.out.println("Enter Username");
						usr = sc.next();
						System.out.println("Enter password");
						ps = cnsl.readPassword();
						pass = String.valueOf(ps);
						if(lg.ifLogin(usr,pass,false))
						{
							while(true)
							{
								System.out.println("*****************************************");
			        			System.out.println("1. Search Car Record");
			        			System.out.println("2. Rate a Car");
			        			System.out.println("3. Exit");
			        			System.out.println("*****************************************\n");
			        			int ch = sc.nextInt();
			        			switch(ch)
			        			{
			        				case 1:
			        					System.out.println("Enter Car name to be searched");
										String car_name = sc.next();
										srch.searchCar(car_name);
										break;
			        				case 2:
			        					System.out.println("Enter Car name to be rated");
										car_name = sc.next();
										srch.searchCar(car_name);
										System.out.println("Enter the car id for rating");
										int car_id = sc.nextInt();
										System.out.println("Enter the rating you want to give out of 10");
										float rate = sc.nextFloat();
										rt.rateCar(car_id,rate);
			        					break;
			        				case 3:
			        					System.exit(0);
			        				default:
			        					System.out.println("Invalid input");
			        					break;
			        			}
							}
						}
						else
						{
							System.out.println("Invalid login credentials");
						}
						break;
					case 3:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input");
				}
			}
	}
}