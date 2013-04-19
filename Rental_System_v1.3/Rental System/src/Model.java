/*
 * Note this is only the alpha version of the model and can only connect to a database so far
 * While the other methods are only the bare skeleton of the class and do not contain any functioning code 
 * so far
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.lang.ClassNotFoundException;


public class Model 
{

	// This is the global user name and password.
 private String username,password;
 
//These are the connection and sql statements classes and instances.
	
		Connection DBconnection = null;
		Statement DBstatement = null;
	
	/*constructor: this will run when it is model created and will assign 
	the username and password to the private variables upon creation of the class*/
	
	public Model(String uname, String pass)
	{
		username  = uname;
		password  = pass;
	}

	/*
	 * The purpose of Pass_check is for the login screen 
	 * If the Username and password are correct then
	 * the connection to the database will be successful 
	 * and true will be returned
	 * However if a username password is incorrect the database 
	 * will not be connected to and an error will be thrown.
	 * This is when the catch statement will return false.
	 * 
	 */
	
	public Boolean Pass_check()
	{
		 try
			{
				System.out.println("Connecting to Driver.....");
				Class.forName("com.mysql.jdbc.Driver"); // this is connecting the java project to the driver Note very important
				System.out.println("Connection Successful");
				
				System.out.println("Connecting to Database: teamp \n password:" + password);
				
				DBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teamp" , username,password);
				System.out.println("Connection Successful");
				
			}
			catch(ClassNotFoundException error)
			{
				System.out.println("Error : " +  error.getMessage());
				//System.out.println("Username or password is incorrect");
			}
		  catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
				System.out.println("Username or password is incorrect");
				return false;
			}
		return true;
	}

	private void connectDb()
	{
	  
	  try
		{
			System.out.println("Connecting to Driver.....");
			Class.forName("com.mysql.jdbc.Driver"); // this is connecting the java project to the driver Note very important
			System.out.println("Connection Successful");
			
			System.out.println("Connecting to Database: teamp");
			DBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teamp" , username,password);
			System.out.println("Connection Successful");
			
		/*	System.out.println("Create dvd table");
			DBstatement = DBconnection.createStatement();
			DBstatement.execute("CREATE TABLE teseter(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, title VARCHAR(25)) ");
			System.out.println("completed");
		*/	
			
			
		}
		catch(ClassNotFoundException error)
		{
			System.out.println("Error : " +  error.getMessage());
		}
		
	  	catch(SQLException error)
		{
			System.out.println("Error : " +  error.getMessage());
		}
	/*	finally // 
		{
			
		}*/	
	}
	
	private void closeDB()
	{
		if(DBconnection != null)												//and this closes the DBconnection after it has been used
		{
			System.out.println("Closing connection.....");
	
			try{	DBconnection.close();}
				catch(SQLException ignore)
				{
					System.out.println("Error : " +  ignore.getMessage());
				}
	
			System.out.println("Connection closed");
		}
	}
	
	private void closeStm()
	{
		//this handles the closing of the connections to the database when finished
		
		
		if(DBstatement != null)     											//this block closes the DBstatement connection if it has been used
		{
			System.out.println("Closing statement.....");
			
			try{	DBstatement.close();  }
				catch(SQLException ignore)
				{
					System.out.println("Error : " +  ignore.getMessage());
				}
			System.out.println("Statement closed");
		}
	}
	
	//Create a new employee 
		public void NewEmp(String Un,String Pw)
		{
			connectDb(); //connect to the database
			try{
			System.out.println("Create new user");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute("CREATE USER " + Un + " IDENTIFIED BY  '" + Pw + "'" ); //Creates the user
					System.out.println("User " + Un + " has been created");
					DBstatement.execute("GRANT SELECT, INSERT,UPDATE,DELETE,CREATE,DROP,ALTER ON codetest.* TO " + Un + " IDENTIFIED BY '" + Pw + "'"); //Grants employee privileges to the user  NOTE: need exact privileges for the DVDManagement system.
					System.out.println("User " + Un + " has Employee level privileges granted");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
		}
	
		//Remove employee 
		public void RemoveEmp(String Un)
{
			connectDb(); //connect to the database
			try{
			System.out.println("Drop user");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" REVOKE ALL PRIVILEGES ON  `codetest` . * FROM  " + Un + " " ); //Revokes the privileges from the user 
					System.out.println("User " + Un + " has been revokes of privileges");
					//DBstatement.execute("");
					System.out.println("User " + Un + " has  been deleted");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
		}

	
	
		//Customer table
		
		//Create new customer  //due for testing
		public void NewCust( String custName, String custAddr, String cusPhone, String cusEmail)
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("Creating a new Customer account");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute("INSERT INTO Customer(custAddr, custName, custPhone, custEmail) VALUES('" + custAddr + "', '" + custName + "', '" + cusPhone + "', '" + cusEmail + "')"); 
					System.out.println("Customer has been successfully created");
					
				//the program should querie the database to get the customer id and print it back to the user
				
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
	
		//update an existing customer
		public void UpdateCust()
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//Delete a customer   // needs to be tested and tided up
		public void DeleteCust(int custID)
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute("DELETE FROM Customer WHERE custId = "+ custID +"" ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//View customer details
		public void getCust(int custID) //view customer by id
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		public void getCust(String CustName)// view customer by name
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		public void getCust()//View all customers 
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
	
		
		
		//Employee table
		
		//View employee privileges
		public void getEmp(int custID) //view employee  by id
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		
		public void getEmp(String CustName)// view employee  by name
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		public void getEmp()//View all employee 
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//update Employee privileges
		public void UpdateEmp()
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
			
		//DVD table
		
		//View DVD table details
		public void getDVD()
		{
		
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//this updates the state of the DVD
		public void UpdateDVD(char state)
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
					
		}
		
		//delete DVD
		public void DeleteDVD(int stockID)
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//returns the number of The dvd that are available to rent in stock
		public int AvDVDs(int stockID)
		{
			int aval = (Integer) null; //  null
			
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
			
			return aval;
		}

		//Stock table
		
		//View DvD movie details
		
		public void getMovie(int stockID) // searchs by id number
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute("SELECT * FROM Stock WHERE stockId = " + stockID); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		public void getMovie(String name)// searches by Movie name
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//Add to stock
		
		public void NewStock()
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//Update Stock details
		public void UpStockDe()
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		public void UpQuant(int StockId)//update the quantity of the DVD in stock
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//delete stock
		public void DelStock()
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}

		//Rented table
		
		//New rent
		public void RentNew()
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//Detailed rents
		public void RentHist() // displays all the rental history
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		public void RentHist(int rentID) // displays the rental history of a single id
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//Returned dvd
		public void Returned(int rentID)
		{				
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}
		
		//list all the DVD's that are overdue
		public void Overdue()
		{
			connectDb(); //connect to the database
			
			try
			{
					System.out.println("");
					DBstatement = DBconnection.createStatement();
					DBstatement.execute(" " ); 
					System.out.println("");
					//DBstatement.execute("");
					System.out.println("");
			}
			
			catch(SQLException error)
			{
				System.out.println("Error : " +  error.getMessage());
			}
			
			closeStm();//closes the statement
			
			closeDB();// closes the database when finished
			
		}

}
