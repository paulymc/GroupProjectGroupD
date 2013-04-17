import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockSearch extends JFrame implements ActionListener {
	    Container StockSScreen = new JPanel();
		JButton Searched = new JButton("Search");
		JButton cancel = new JButton("Cancel");
		JButton goBack = new JButton("Main menu");
		JButton details = new JButton("Film Details");
		
		JButton Add = new JButton("Add Film to Stock");
		JList Films = new JList();
		
		
	public StockSearch(String s)
	{
		super("StockSearch");
		setSize(800,600);
		setLocationRelativeTo(null);
		setContentPane(StockSearchScreen());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setJMenuBar(createMenu());
		setVisible(true);
		setResizable(false);							//resizing not allowed 
		
	}
	
	public Container StockSearchScreen()
	{						
		StockSScreen.setLayout(new GridLayout(4,0));
		
		//Font for the title
		Font newFont = new Font("Aerial",Font.BOLD,32);
		
		//Panels for the different parts of the screen.
		JPanel SearchP = new JPanel();
		JPanel buttonP = new JPanel();
		JPanel ResultP = new JPanel();
	//	ResultP.setLayout(new GridLayout(2,0));
		SearchP.setLayout(new GridLayout(5,0));
		
		//Search text area
		JTextField Searching = new JTextField("Input Search");
		JLabel title = new JLabel("Stock Search");
	
		title.setFont(newFont);
	
		details.setPreferredSize(new Dimension(20,30));
		//Results are put into textarea
		JTextArea results = new JTextArea("Results Displayed here");
		results.setEditable(false);
		results.setSize(50,2500);
		JLabel resultsa = new JLabel();
		Films.setLayoutOrientation(JList.VERTICAL);
		JScrollPane scroll = new JScrollPane(Films);
		
		scroll.setPreferredSize(new Dimension(450,150));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		results.add(resultsa);
		
		SearchP.add(Searching);
		SearchP.add(Searched);
		//SearchP.add(scroll);
		//SearchP.add(details);
		ResultP.add(scroll);
		ResultP.add(details);
		buttonP.add(Add);
		buttonP.add(cancel);
		buttonP.add(goBack);
		
		
		//Set the action listeners for the buttons
		Searched.addActionListener(this);
		cancel.addActionListener(this);
		goBack.addActionListener(this);
		details.addActionListener(this);
		Add.addActionListener(this);
		
		
		StockSScreen.add(title);//,BorderLayout.NORTH);
		StockSScreen.add(SearchP);//,BorderLayout.CENTER);
		StockSScreen.add(ResultP);//,BorderLayout.CENTER);
		StockSScreen.add(buttonP);//,BorderLayout.SOUTH);

		
		return StockSScreen;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object Event = e.getSource();
		
		if(Event == Searched)
		{
			//Code for Searching the Stock , i.e SELECT STATEMENT 
			Model St_search = new Model("Emp", "pass");
			//needs work
			ResultSet cursor = St_search.DisplayStock();
			
			
			System.out.println("displaying cursor");
			try {
				while(cursor.next())
				{
					
					String name,director;
						int id = cursor.getInt("stockId");
						name = cursor.getString("dvdTitle");
						int year = cursor.getInt("dvdYear"); 
						director = cursor.getString("dvdDirector");
						int quant = cursor.getInt("dvdQuant");
						int rentfee = cursor.getInt("dvdRentFee");
						System.out.println("Id : "+id+"	Name: "+name+"	year:"+year+" 	director:"+director+"		quantity:"+quant+"		rentfee:"+rentfee);
						
						Films.se
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
		if(Event == cancel)
		{
			this.setVisible(false);
		}
		if(Event == goBack)
		{
			this.setVisible(false);
		}
		if(Event == details)
		{	
			new Stock("Stock Details");
		}
		
	}
	
	

}
