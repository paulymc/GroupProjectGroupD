package TeamProject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Password extends JFrame
{
	public Password (String myTitle) 
	{
		super (myTitle);
		setSize(800,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		setContentPane(createPane());
		setVisible(true);
	}
	
	private Container createPane() 
    {
		Container pane = new JPanel();
		JPanel w1 = new JPanel();
		JPanel w3 = new JPanel();
		JPanel w2 = new JPanel();
		w2.setLayout(new GridLayout(7,1));
		pane.setLayout(new BorderLayout());
		
		JLabel usernamelabel = new JLabel("Username:");
		JLabel passwordlabel = new JLabel("password:");
		JTextField username = new JTextField(10);
		//username.setPreferredSize(new Dimension(5,5));
		JPasswordField password = new JPasswordField(10);
		//password.setPreferredSize(new Dimension(10,10));
		JLabel Title = new JLabel("Uber-Vision");
		Font fancyFont = new Font ("Serif",Font.BOLD,72);
		Title.setFont(fancyFont);
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new BorderLayout());
		JButton Login = new JButton("Login");
		buttonpanel.add(Login, BorderLayout.WEST);
		
		w1.add(usernamelabel);
		w1.add(username);
		w3.add(passwordlabel);
		w3.add(password);
		
		w2.add(w1);
		w2.add(w3);
		w2.add(buttonpanel);
		pane.add(Title, BorderLayout.NORTH);
		pane.add(w2, BorderLayout.WEST);
		
		return pane;
    }
}
