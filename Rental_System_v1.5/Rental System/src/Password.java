
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Password extends JFrame implements ActionListener
{

	String Username,Pass;

	JPasswordField password;
	
	JTextField username;
	Container pane = new JPanel();
	JButton Login = new JButton("Login");
	
	public Password (String myTitle) 
	{
		super ("Login");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setContentPane(createPane());
		setVisible(true);
	
	}
	
	private Container createPane() 
    {
		
		JPanel w1 = new JPanel();
		JPanel w3 = new JPanel();
		JPanel w2 = new JPanel();
		w2.setLayout(new GridLayout(7,1));
		pane.setLayout(new BorderLayout());
		
		JLabel usernamelabel = new JLabel("Username:");
		JLabel passwordlabel = new JLabel("password:");
		username = new JTextField(10);
		//username.setPreferredSize(new Dimension(5,5));
	    password = new JPasswordField(10);
		//password.setPreferredSize(new Dimension(10,10));
		JLabel Title = new JLabel("Uber-Vision");
		Font fancyFont = new Font ("Serif",Font.BOLD,72);
		Title.setFont(fancyFont);
		
		JPanel buttonpanel = new JPanel();
		
		buttonpanel.add(Login);
		
		w1.add(usernamelabel);
		w1.add(username);
		w3.add(passwordlabel);
		w3.add(password);
		
		w2.add(w1);
		w2.add(w3);
		w2.add(buttonpanel);
		pane.add(Title, BorderLayout.NORTH);
		pane.add(w2, BorderLayout.CENTER);
		
		
		Login.addActionListener(this);
		
		return pane;
    }
	
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e) {
		
		Object boom = e.getSource();
		
		if(boom == Login)
		{
			Username = username.getText();
			Pass = password.getText();
			System.out.println("Username:"+Username+"	Password:"+Pass);
		//	new GUI("Menu Screen");
			//new AccDetails("DVD Rentel");
			//new createAcc("customer");
			setVisible(false);
		}
}
}