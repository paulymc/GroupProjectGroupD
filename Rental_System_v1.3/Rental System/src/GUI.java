import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Frame;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

	//Buttons declared
	JButton Settings = new JButton("Settings");
	JButton Account  = new JButton("Account");
	JButton Stock    = new JButton("Stock");
	JButton Reservations = new JButton("Reservations");
	JButton LogOut   = new JButton("Log Out");
	static Container Frame = new JPanel();
	//menus declared
	//JMenu menu = new JMenu("Files");
	JMenu menu2 = new JMenu("Help");
	String password,username;
	
	JMenuItem About = new JMenuItem("About");
	JMenuItem Instruction = new JMenuItem("Instruction");
	
	static int size = 32;
	Font Font1 = new Font("Aerial",Font.BOLD,size);	//font for the title
		
	public GUI(String gui,String user,String pass)
	{
		
		super(gui);
		setSize(800,600);
		setLocationRelativeTo(null);
		setContentPane(createContentFrame());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(createMenu());
		setVisible(true);
		setResizable(false);							//resizing not allowed 
		password= pass;
		username = user;
	}
	
	public Container createContentFrame() 
	{
		//Container Frame = new JPanel();
		
		
	//	Font Font1 = new Font("Aerial",Font.BOLD,32);	//font for the title
		
		Frame.setLayout(new BorderLayout());			//layout for the main frame
		ImageIcon Logo = new ImageIcon("images.JPG");   //Image declared
		
		JLabel Title = new JLabel("    DVD Rental Management System");
		JLabel Copyright = new JLabel("Copyright 2013, The CodeFathers");	//copyright message
		JLabel LogoLabel = new JLabel(Logo);
		
		Title.setFont(Font1);
		
		JPanel ButtonPanel = new JPanel();
		JPanel EmptyPanel = new JPanel();
		ButtonPanel.setLayout(new GridLayout(5,2));
		
		ButtonPanel.add(Settings);
		ButtonPanel.add(Account);
		ButtonPanel.add(Stock);
		ButtonPanel.add(Reservations);
		ButtonPanel.add(LogOut);
				
		Settings.setToolTipText("Set Access Levels");
		Account.setToolTipText("Check and Manage Accounts");
		Stock.setToolTipText("Check and Manage Stock");
		Reservations.setToolTipText("Manage Resevations");
		LogOut.setToolTipText("Exit System");
			
		Settings.addActionListener(this);
		Account.addActionListener(this);
		Stock.addActionListener(this);
		Reservations.addActionListener(this);
		LogOut.addActionListener(this);
		
		Frame.add(ButtonPanel,BorderLayout.CENTER);
		Frame.add(Title,BorderLayout.NORTH);
		Frame.add(Copyright,BorderLayout.SOUTH);
		Frame.add(LogoLabel,BorderLayout.EAST);
		Frame.add(EmptyPanel,BorderLayout.WEST);
		 	
	  	return Frame; 
	}
	
	public JMenuBar createMenu()
	{
		
		JMenuBar menubar = new JMenuBar();
		//JMenu menu = new JMenu("Files");
		JMenu menu2 = new JMenu("Help");
		
		menu2.add(About);
		menu2.add(Instruction);
		
		About.addActionListener(this);
		Instruction.addActionListener(this);
	
		//menubar.add(menu);
		menubar.add(menu2);
				
		return menubar;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object Event = e.getSource();
		
		if(Event == Settings)
		{ 
	
			Frame.setVisible(false);
			setContentPane(new Settings("s").settingscreen);
		}
		if(Event == Account)
		{	//ActionListener that goes to the account screen.
			//AccDetails acc = null;
			//JOptionPane.showMessageDialog(null, "Account not implemented Yet!");
			Frame.setVisible(false);
			setContentPane(new AccDetails("Account").pane);
		}
		if(Event == Stock)
		{	//ActionListener that goes to stock screen.  
			//JOptionPane.showMessageDialog(null,"Stock not implemented Yet!");
			
			Stock stock1 = null;
			Frame.setVisible(false);
			setContentPane(new StockSearch("s").StockSScreen);
			//new Stock("s").setVisible(true);
			
		}
		if(Event == Reservations)
		{	//ActionListener that goes to the Reservations screen
			JOptionPane.showMessageDialog(null, "Reservations not implemented Yet!");
		}
		if(Event == LogOut)
		{	//displays message and exits when clicked
			//might go to login screen afterwards
			JOptionPane.showMessageDialog(null,"You Have Logged out");
			//Password pass = null;
			Frame.setVisible(false);
			setContentPane(new login("Login").pane);
			
			//System.exit(1);
		}
		if(Event == About)
		{
			//show information about program
			JOptionPane.showMessageDialog(null,"Dvd Rental Management System \nVersion 1.0 \nCopyright 2013 The CodeFathers");
		}
		
		
		
	}//end of actionPerformed
	
	

}//end of class
