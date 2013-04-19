package rentalSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame implements ActionListener {
	
	//Sets up the screen for the Settings Screen
	Container settingscreen = new JPanel();
	
	JLabel SetTitle = new JLabel("Settings");
	
	JButton SetUsers = new JButton("Add User");
	//JButton SetFont = new JButton("Font");
	//JButton SetAudio = new JButton("Audio");
	JButton Return = new JButton("Return");
	
	//To hold the username and password for the database
		String username,password;
	
	public Settings(String settings,String user,String pass)
	{
		super(settings);
		setSize(800,600);
		setLocationRelativeTo(null);
		setContentPane(SettingScreen());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setJMenuBar(createMenu());
		setVisible(true);
		setResizable(false);
		username = user;
		password = pass;		
	}
	
	public Container SettingScreen()
	{
		
		JPanel Button1 = new JPanel();
	    
		settingscreen.setLayout(new BorderLayout());
		Button1.setLayout(new GridLayout(6,1));
		
		Button1.add(SetUsers);
	//	Button1.add(SetFont);
	//	Button1.add(SetAudio);
		Button1.add(Return);
		
		SetUsers.setToolTipText("Add New Users");
	//	SetFont.setToolTipText("Set Font Size");
	//	SetAudio.setToolTipText("Set Audio options");
		Return.setToolTipText("Return to Main Menu");
		
		SetUsers.addActionListener(this);
	//	SetFont.addActionListener(this);
	//	SetAudio.addActionListener(this);
		Return.addActionListener(this);
		
		settingscreen.add(SetTitle, BorderLayout.NORTH);
		settingscreen.add(Button1, BorderLayout.CENTER);
		
		return settingscreen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
		Object Event = e.getSource();
		
		if(Event == Return)
		{
			this.setVisible(false);	
		}
	/*	if(Event == SetFont)//Action Listener to change the font size
		{
			
		}
		if(Event == SetAudio)//Action Listener that enables audio read out of certain words
		{
			JOptionPane.showMessageDialog(null,"Not Implemented yet!");
		}*/
		
		if(Event == SetUsers)//Action Listener that allows to add and set the users of the system
		{
			new SetUser("Set User",username,password);
		}
		
	}

}
