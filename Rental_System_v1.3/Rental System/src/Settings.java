import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame implements ActionListener {
	
	//Sets up the screen for the Settings Screen
	Container settingscreen = new JPanel();
	
	JLabel SetTitle = new JLabel("Settings");
	
	JButton SetUsers = new JButton("Add User");
	JButton SetFont = new JButton("Font");
	JButton SetAudio = new JButton("Audio");
	JButton Return = new JButton("Return");
	
	public Settings(String settings)
	{
		super(settings);
		setSize(600,600);
		setContentPane(SettingScreen());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setJMenuBar(createMenu());
		setVisible(false);
		setResizable(false);
	}
	
	public Container SettingScreen()
	{
		
		JPanel Button1 = new JPanel();
	    
		settingscreen.setLayout(new BorderLayout());
		Button1.setLayout(new GridLayout(4,1));
		
		Button1.add(SetUsers);
		Button1.add(SetFont);
		Button1.add(SetAudio);
		Button1.add(Return);
		
		SetUsers.setToolTipText("Add New Users");
		SetFont.setToolTipText("Set Font Size");
		SetAudio.setToolTipText("Set Audio options");
		Return.setToolTipText("Return to Main Menu");
		
		SetUsers.addActionListener(this);
		SetFont.addActionListener(this);
		SetAudio.addActionListener(this);
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
			
			setVisible(false);
		//	new GUI("Menu Screen");
		  //System.exit(1);
			
		}
		if(Event == SetFont)//Action Listener to change the font size
		{
			//JOptionPane.showMessageDialog(null,"Not Implemented Yet!");
			settingscreen.setVisible(false);
			setContentPane(new FontC("s").setF);
		}
		if(Event == SetAudio)//Action Listener that enables audio read out of certain words
		{
			JOptionPane.showMessageDialog(null,"Not Implemented yet!");
		}
		if(Event == SetUsers)//Action Listener that allows to add and set the users of the system
		{
			JOptionPane.showMessageDialog(null, "Not implemented yet!");
		}
		
	}

}
