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
	 Container Frames = new JPanel();
	//menus declared
	//JMenu menu = new JMenu("Files");
	JMenu menu2 = new JMenu("Help");
	
	JMenuItem About = new JMenuItem("About");
	JMenuItem Instruction = new JMenuItem("Instruction");
		JPanel Frame = new JPanel();
	static int size = 32;
	Font Font1 = new Font("Aerial",Font.BOLD,size);	//font for the title
		
	public GUI(String gui)
	{
		
		super(gui);
		setSize(800,600);
		setLocationRelativeTo(null);
		setContentPane(createContentFrame());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(createMenu());
		setVisible(true);
		setResizable(false);							//resizing not allowed 
		
	}

	public Container createContentFrame() 
	{		
		
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
		 	
		Frames.add(Frame);
	  	return Frames; 
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
			new Settings("Settings");
		}
		if(Event == Account)
		{	
			new AccDetails("Account Details");
		}
		if(Event == Stock)
		{				
			new StockSearch("Stock Screen");
		}
		if(Event == Reservations)
		{	
			new Reservations("Reservations");
		}
		if(Event == LogOut)
		{	//displays message and exits when clicked
			JOptionPane.showMessageDialog(null,"You Have Logged out");
			this.setVisible(false);
			new login("Login");
		}
		if(Event == About)
		{
			//show information about program
			JOptionPane.showMessageDialog(null,"Dvd Rental Management System \nVersion 1.0 \nCopyright 2013 The CodeFathers");
		}
	}//end of actionPerformed
}//end of class
