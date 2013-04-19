package rentalsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Reservations extends JFrame implements ActionListener
{
	JButton Confirm = new JButton("Confirm Details");
	JButton Cancel = new JButton("Cancel");
	
	JTextField NameField,PhField, ResTilField, ResNumField;

	public Reservations (String myTitle) 
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
	pane.setLayout(new BorderLayout());
	
	JPanel Resinfo = new JPanel();
	Resinfo.setLayout(new GridLayout (4,2));
	Resinfo.setBorder(BorderFactory.createLineBorder(Color.RED,5));
	
	JPanel ResDetails = new JPanel();
	ResDetails.setLayout(new GridLayout(10,5));
	ResDetails.setBorder(BorderFactory.createLineBorder(Color.RED,5));
	
	JPanel resAcc = new JPanel();
	resAcc.setBackground(Color.RED);
	JLabel RewAcc = new JLabel ("Reservation Details");
	Font fancyFont = new Font ("Serif",Font.BOLD,24);
	resAcc.setFont(fancyFont);
	
	JLabel Name = new JLabel ("  Name:", JLabel.CENTER);
	NameField = new JTextField (5);
	
	JLabel PhNum = new JLabel ("  Phone Number:", JLabel.CENTER);
	PhField = new JTextField (5);
			
	JLabel ResTil = new JLabel ("Reserved Until:", JLabel.CENTER);
	ResTilField = new JTextField ();
	ResTilField.setEditable(false);
	
	JLabel ResNum = new JLabel ("Reservation Number:", JLabel.CENTER);
	ResNumField = new JTextField ();
	ResNumField.setEditable(false);
	
	Resinfo.add(Name);
	Resinfo.add(NameField);
	
	Resinfo.add(PhNum);
	Resinfo.add(PhField);
	
	ResDetails.add(ResTil);
	ResDetails.add(ResTilField);
	
	ResDetails.add(ResNum);
	ResDetails.add(ResNumField);
			
	JPanel buttonpanel = new JPanel();
	buttonpanel.setLayout(new GridLayout(1,1));
	buttonpanel.add(Confirm);
	buttonpanel.add(Cancel);
	
	resAcc.add(RewAcc);
	Resinfo.add(buttonpanel);
	pane.add(Resinfo,BorderLayout.NORTH);
	pane.add(ResDetails,BorderLayout.CENTER);
	//pane.add(Resinfo);
	
	Confirm.addActionListener(this);
	Cancel.addActionListener(this);
	return pane;
    }
	
public void actionPerformed(ActionEvent e) {
		
		Object fire = e.getSource();
		
		if(fire == Confirm)
		{
			String name,Ph_number,email,address,County,date_joined,Branch;
			
			name = NameField.getText();
			Ph_number = PhField.getText();
			
			
			System.out.println("Name:" +name);
			System.out.println("Phone number:" +Ph_number);
			
			/*
				Put the model class call here
			*/
			
			//new Password("DVD Rentel");
			//setVisible(false);
		}
		
		if(fire == Cancel)
		{
			NameField.setText("");
			PhField.setText("");
		
			
			//new AccDetails("DVD Rentel");
			//setVisible(false);
		}
}
}
