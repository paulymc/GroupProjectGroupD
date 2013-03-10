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


public class Model {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		Connection DBconnection = null;
		Statement DBstatement = null;
		
		
		
		
		try
		{
			System.out.println("Connecting to Driver.....");
			Class.forName("com.mysql.jdbc.Driver"); // this is connecting the java project to the driver Note very important
			System.out.println("Connection Successful");
			
			System.out.println("Connecting to Database: CodeTest");
			DBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codetest" , "root" ,"");
			System.out.println("Connection Successful");
			
			System.out.println("Create dvd table");
			DBstatement = DBconnection.createStatement();
			DBstatement.execute("CREATE TABLE teseter(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, title VARCHAR(25)) ");
			System.out.println("completed");
			
			
			
		}
		catch(ClassNotFoundException error)
		{
			System.out.println("Error : " +  error.getMessage());
		}
		catch(SQLException error)
		{
			System.out.println("Error : " +  error.getMessage());
		}
		finally // this handles the closing of the connections to the database when finished
		{
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
	}

	
	
	public Model()//constructor: this will run when it is model created and will connect to the database 
	{
		Connection DBconnection = null;
		
		try
		{
			System.out.println("Connecting to Driver.....");
			Class.forName("com.mysql.jdbc.Driver"); // this is connecting the java project to the driver Note very important
			System.out.println("Connection Successful");
			
			System.out.println("Connecting to Database: CodeTest");
			DBconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codetest" , "root" ,"");
			System.out.println("Connection Successful");
			
			
			
		}
		catch(ClassNotFoundException error)
		{
			System.out.println("Error : " +  error.getMessage());
		}
		catch(SQLException error)
		{
			System.out.println("Error : " +  error.getMessage());
		}
	}
	

	//Customer table
	
	//Create new customer
	public void NewCust( String custName, String custAddr, String cusPhone, String cusEmail)
	{
		
	}
	
	//update an existing customer
	public void UpdateCust()
	{
		
	}
	
	//Delete a customer
	public void DeleteCust()
	{
		
	}
	
	//View customer details
	public void getCust(int custID) //view customer by id
	{
		
	}
	
	public void getCust(string CustName)// view customer by name
	{
		
	}
	
	public void getCust()//View all customers 
	{
		
	}
	
	
	
	//Employee table
	
	//View employee details
	public void getEmp(int custID) //view employee  by id
	{
		
	}
	
	public void getEmp(string CustName)// view employee  by name
	{
		
	}
	
	public void getEmp()//View all employee 
	
	
	//Create a new employee 
	public void NewEmp()
	{
		
	}
	
	//update Employee details
	public void UpdateEmp()
	{
		
	}
	
	//delete employee 
	public void DeleteEmp()
	{
		
	}
	
	
	
	//DVD table
	
	//View DVD table details
	public void getDVD()
	{
		
	}
	
	//this updates the state of the dvd
	public void UpdateDVD(char state)
	{
				
	}
	
	//delete dvd
	public void DeleteDVD(int stockID)
	{
		
	}
	
	//returns the number of The dvd that are available to rent in stock
	public int AvDVDs(int stockID)
	{
		int aval;
		return aval;
	}
	
	
	//Stock table
	
	//View DvD movie details
	
	public void getMovie(int stockID) // searchs by id number
	{
		
	}
	
	public void getMovie(string name)// searches by Movie name
	{
		
	}
	
	//Add to stock
	
	public void NewStock()
	{
		
	}
	
	//Update Stock details
	public void UpStockDe()/
	{
		
	}
	
	public void UpQuant(int StockId)//update the quantity of the dvd in stock
	{
		
	}
	
	//delete stock
	public void DelStock()
	{
		
	}
	
	
	//Rented table
	
	//New rent
	public void RentNew()
	{
		
	}
	
	//Detailed rents
	public void RentHist() // displays all the rental history
	{
		
	}
	
	public void RentHist(int rentID) // displays the rental history of a single id
	{
		
	}
	
	//Returned dvd
	public void Returned(int rentID)
	{
		
	}
	
	//list all the Dvds that are overdue
	public void Overdue()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
