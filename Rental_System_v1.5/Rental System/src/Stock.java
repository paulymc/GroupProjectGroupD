import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Stock extends JFrame implements ActionListener{
	Container Screen = new JPanel();
	JLabel name = new JLabel("Name:");
	JLabel Director = new JLabel("Director:");
	JLabel QTY = new JLabel("Quantity:");
	JLabel Genre = new JLabel("Rent:");
	JLabel ID = new JLabel("Year:");
	JLabel Search1 = new JLabel("Id Search:");
	
	JTextField Name1 = new JTextField();
	JTextField Director1 = new JTextField();
	JTextField Quantity1 = new JTextField();
	JTextField rent = new JTextField();
	JTextField Year = new JTextField();
	
	JButton Return = new JButton("Return");
	JButton searcgx = new JButton("Search");
	JButton Edit = new JButton("Edit");
	JButton Remove = new JButton("Remove");
	
	//Return.setToolTipText("Return to menu screen");
	JTextField Search = new JTextField();
	

	//To hold the username and password for the database
	String username,password;

	int id;
	
	public Stock(String Stock,String user,String pass)
	{
		
		super(Stock);
		setSize(800,600);
		setLocationRelativeTo(null);
		setContentPane(StockScreen());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setJMenuBar(createMenu());
		setVisible(true);
		setResizable(false);							//resizing not allowed 
		
		username = user;
		password = pass;
		
	}
	
	public Container StockScreen()
	{
		
		//Container Screen = new JPanel();
		Screen.setLayout(new BorderLayout());
		Font Font2 = new Font("Aerial",Font.BOLD,32);
		
		
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(17,2));
		JLabel StockTitle = new JLabel("   Stock");
		
		StockTitle.setFont(Font2);
		
		//Adding components to the info panel / screen 
		info.add(Search1);
		info.add(Search);
		info.add(searcgx);
		info.add(Director);
		info.add(Director1);
		info.add(ID);
		info.add(Year);
		info.add(QTY);
		info.add(Quantity1);
		info.add(Genre);
		info.add(rent);
		info.add(name);
		info.add(Name1);
		info.add(Edit);

		info.add(Remove);
		info.add(Return);
		
		//Action Listeners set here 
		Return.addActionListener(this);
		searcgx.addActionListener(this);
		Remove.addActionListener(this);
		Edit.addActionListener(this);
			
		//Layout of the screen set here 
		Screen.add(StockTitle,BorderLayout.NORTH);
		Screen.add(info,BorderLayout.CENTER);
		Return.setToolTipText("Return to menu screen");		
		Remove.setToolTipText("Remove DVD from Stock");
		Edit.setToolTipText("Edit Details of DVD in Stock");
		return Screen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object Event = e.getSource();
		
		if(Event == Return)
		{
			this.setVisible(false);
		}		
		if(Event == searcgx)
		{
			//Code for Searching the Stock , i.e SELECT STATEMENT 
			
			//Code for Searching the Stock , i.e SELECT STATEMENT 
			Model St_search = new Model(username,password);
			//needs work
			ResultSet cursor = St_search.getMovie(Integer.parseInt(Search.getText()));
			
			
			System.out.println("displaying cursor");
			try {
				while(cursor.next())
				{
					
					String name,director;
						 id = cursor.getInt("stockId");
						name = cursor.getString("dvdTitle");
						int year = cursor.getInt("dvdYear"); 
						director = cursor.getString("dvdDirector");
						int quant = cursor.getInt("dvdQuant");
						int rentfee = cursor.getInt("dvdRentFee");
						System.out.println("Id : "+id+"	Name: "+name+"	year:"+year+" 	director:"+director+"		quantity:"+quant+"		rentfee:"+rentfee);
						
						
						//Films.
						
						Name1.setText(name);
						Director1.setText(director);
						Quantity1.setText(""+quant);
						rent.setText(""+rentfee);
						Year.setText(""+year);
						
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			System.out.println("closing stock cursor");
			St_search.closeResultSet();
			try {
				cursor.close();
	
				System.out.println("successfully closed");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			St_search.closeStm();//closes the statement
			
			St_search.closeDB();// closes the database when finished
			
			
		}
		if(Event == Edit)
		{
			Model upStock = new Model(username, password);
			
			upStock.UpStockDe(id, Name1.getText(),Integer.parseInt(Year.getText()) , Director1.getText(),Integer.parseInt( rent.getText()), Integer.parseInt(Quantity1.getText()));
			//Code for Editing the stock implemented here, i.e UPDATE STOCK
		}
		if(Event== Remove)
		{
			Model delstock = new Model(username, password);
			
			delstock.DelStock(id);
			
			
		}
		
		
	}
}
