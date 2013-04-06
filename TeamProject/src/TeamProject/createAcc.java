package TeamProject;

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

public class createAcc extends JFrame implements ActionListener
{
	JButton Confirm = new JButton("Confirm Details");
	JButton Cancel = new JButton ("Cancel");
	
	public createAcc (String myTitle) 
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
	//pane.setBackground(Color.GRAY);
	
	JPanel Accinfo = new JPanel();
	Accinfo.setLayout(new GridLayout(10,2));
	Accinfo.setBorder(BorderFactory.createLineBorder(Color.RED,10));
	
	JPanel newAcc = new JPanel();
	newAcc.setBackground(Color.RED);
	JLabel NewAcc = new JLabel ("  Account Details");
	Font fancyFont = new Font ("Serif",Font.BOLD,24);
	NewAcc.setFont(fancyFont);
	
	JLabel AccId = new JLabel ("  Account ID:");
	JTextField AccIdField = new JTextField (10);
	
	JLabel Name = new JLabel ("  Name:");
	JTextField NameField = new JTextField (10);
	
	JLabel PhNum = new JLabel ("  Phone Number:");
	JTextField PhField = new JTextField (10);
	
	JLabel Email = new JLabel ("  Email:");
	JTextField EmailField = new JTextField (10);
	
	JLabel AddLine1 = new JLabel ("  Address Line 1:");
	JTextField Add1Field = new JTextField (10);
	
	JLabel AddLine2 = new JLabel ("  Address Line 2:");
	JTextField Add2Field = new JTextField (10);
	
	JLabel County = new JLabel ("  County:");
	JTextField CountyField = new JTextField (10);
	
	JLabel DateJoin = new JLabel ("  Date Joined:");
	JTextField DateField = new JTextField (10);
	
	JLabel Branch = new JLabel ("  Branch:");
	JTextField BranchField = new JTextField (10);

	Accinfo.add(AccId);
	Accinfo.add(AccIdField);
	
	Accinfo.add(Name);
	Accinfo.add(NameField);
	
	Accinfo.add(PhNum);
	Accinfo.add(PhField);
	
	Accinfo.add(Email);
	Accinfo.add(EmailField);
	
	Accinfo.add(AddLine1);
	Accinfo.add(Add1Field);

	Accinfo.add(AddLine2);
	Accinfo.add(Add2Field);
	
	Accinfo.add(County);
	Accinfo.add(CountyField);
	
	Accinfo.add(DateJoin);
	Accinfo.add(DateField);
	
	Accinfo.add(Branch);
	Accinfo.add(BranchField);
	
	JPanel buttonpanel = new JPanel();
	buttonpanel.setLayout(new BorderLayout());
	buttonpanel.add(Confirm, BorderLayout.WEST);
	buttonpanel.add(Cancel, BorderLayout.EAST);
	newAcc.add(NewAcc);
	Accinfo.add(buttonpanel);
	pane.add(newAcc,BorderLayout.NORTH);
	pane.add(Accinfo);
	
	Confirm.addActionListener(this);
	Cancel.addActionListener(this);
	return pane;
    }

public void actionPerformed(ActionEvent e) {
		
		Object fire = e.getSource();
		
		if(fire == Confirm)
		{
			new Password("DVD Rentel");
			setVisible(false);
		}
		
		if(fire == Cancel)
		{
			new AccDetails("DVD Rentel");
			setVisible(false);
		}
}

}
