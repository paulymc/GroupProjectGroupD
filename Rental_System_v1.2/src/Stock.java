import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Stock extends JFrame implements ActionListener{
	Container Screen = new JPanel();
	JLabel name = new JLabel("Name:");
	JLabel Director = new JLabel("Director:");
	JLabel QTY = new JLabel("Quantity:");
	JLabel Genre = new JLabel("Genre:");
	JLabel ID = new JLabel("ID:");
	JLabel Search1 = new JLabel("Search:");
	
	JTextField Name1 = new JTextField();
	JTextField Director1 = new JTextField();
	JTextField Quantity1 = new JTextField();
	JTextField Genre1 = new JTextField();
	JTextField ID1 = new JTextField();
	
	JButton Return = new JButton("Return");
	JButton searcgx = new JButton("Search");
	JButton Edit = new JButton("Edit");
	JButton Add = new JButton("Add");
	JButton Remove = new JButton("Remove");
	
	//Return.setToolTipText("Return to menu screen");
	JTextField Search = new JTextField();
	
	public Stock(String Stock)
	{
		
		super(Stock);
		setSize(600,600);
		setContentPane(StockScreen());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setJMenuBar(createMenu());
		setVisible(false);
		setResizable(false);							//resizing not allowed 
		
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
		info.add(ID1);
		info.add(QTY);
		info.add(Quantity1);
		info.add(Genre);
		info.add(Genre1);
		info.add(name);
		info.add(Name1);
		info.add(Edit);
		info.add(Add);
		info.add(Remove);
		info.add(Return);
		
		//Action Listeners set here 
		Return.addActionListener(this);
		searcgx.addActionListener(this);
		Add.addActionListener(this);
		Remove.addActionListener(this);
		Edit.addActionListener(this);
			
		//Layout of the screen set here 
		Screen.add(StockTitle,BorderLayout.NORTH);
		Screen.add(info,BorderLayout.CENTER);
		Return.setToolTipText("Return to menu screen");		
		Add.setToolTipText("Add new DVD to Stock");
		Remove.setToolTipText("Remove DVD from Stock");
		Edit.setToolTipText("Edit Details of DVD in Stock");
		return Screen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object Event = e.getSource();
		
		if(Event == Return)
		{
			//GUI gui1 = null;
			
			//gui1.Frame.setVisible(true);
			//setContentPane(gui1.Frame);
			
			
			System.exit(1);
			new GUI("Menu");
		}
		if(Event == searcgx)
		{
			//Code for Searching the Stock , i.e SELECT STATEMENT 
		}
		if(Event == Edit)
		{
			
			//Code for Editing the stock implemented here, i.e UPDATE STOCK
		}
		if(Event== Remove)
		{
			int stock_id = Integer.parseInt(ID1.getText());
			
			//Code for Removing a stock item implemented here, i.e DELETE STOCK
			Model Re_stock = new Model("Emp", "pass");
			
			Re_stock.DelStock(stock_id);
		}
		if(Event == Add)
		{
			//Code for Adding an item to a stock implemented here, i.e INSERT STOCK
			String A_Name,A_Director,A_Gen;
			int A_Quant;
			
			A_Name = Name1.getText();
			A_Director = Director1.getText();
			A_Quant=Integer.parseInt(Quantity1.getText());//converts whats in the string text to an integer
			A_Gen=Genre1.getText();
			
			
			//Note their is no genra in the DVD database.
			//also there is no DVD year or dvd rent fee in the gui's either.
			//Also there needs to be a employee login and a place to pass in the username and passwords in the gui.
			//Also Id is autoincremented so it isnt needed for this.
			//Also there needs to be a textfield to add in the rental fee.
			
			Model Stock_add = new Model("Emp", "pass");
			
			Stock_add.NewStock(A_Name, 2012, A_Director, 5,A_Quant);
			
			//Stock_add.NewStock(A_Name, "2012", A_Director, 5,A_Quant);//this passes the data to the model to pass to the database
			
			
			
		}
		
	}
}
