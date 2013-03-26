// this is a GUI for adding a new customer.


import java.awt.*;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class AccDetails extends JFrame
{
	Container pane = new JPanel();
// Constructor for frame 

	public AccDetails (String myTitle) 
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
		JPanel q1 = new JPanel();
		pane.setLayout(new BorderLayout());
		q1.setLayout(new GridLayout(10,2));
		JPanel q2 = new JPanel();
		q2.setLayout(new GridLayout(1,4));
		JPanel q3 = new JPanel();
		JPanel q4 = new JPanel();
		q4.setLayout(new GridLayout(6,0));
		JPanel q5 = new JPanel();
		JPanel q6 = new JPanel();
		JPanel q7 = new JPanel();
		
		JLabel AccDetails = new JLabel ("Account Details");
		Font fancyFont = new Font ("Serif",Font.BOLD,24);
		AccDetails.setFont(fancyFont);
		
		JLabel AccId = new JLabel ("Account ID:");
		JTextField AccIdField = new JTextField (10);
		
		JLabel Name = new JLabel ("Name:");
		JTextField NameField = new JTextField (10);
		
		JLabel PhNum = new JLabel ("Phone Number:");
		JTextField PhField = new JTextField (10);
		
		JLabel Email = new JLabel ("Email:");
		JTextField EmailField = new JTextField (10);
		
		JLabel AddLine1 = new JLabel ("Address Line 1:");
		JTextField Add1Field = new JTextField (10);
		
		JLabel AddLine2 = new JLabel ("Address Line 2:");
		JTextField Add2Field = new JTextField (10);
		
		JLabel County = new JLabel ("County:");
		JTextField CountyField = new JTextField (10);
		
		JLabel DateJoin = new JLabel ("Date Joined:");
		JTextField DateField = new JTextField (10);
		
		JLabel Branch = new JLabel ("Branch:");
		JTextField BranchField = new JTextField (10);

		q1.add(AccId);
		q1.add(AccIdField);
		
		q1.add(Name);
		q1.add(NameField);
		
		q1.add(PhNum);
		q1.add(PhField);
		
		q1.add(Email);
		q1.add(EmailField);
		
		q1.add(AddLine1);
		q1.add(Add1Field);

		q1.add(AddLine2);
		q1.add(Add2Field);
		
		q1.add(County);
		q1.add(CountyField);
		
		q1.add(DateJoin);
		q1.add(DateField);
		
		q1.add(Branch);
		q1.add(BranchField);
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new BorderLayout());
		JButton Details = new JButton("Edit Details");
		buttonpanel.add(Details, BorderLayout.WEST);
	
		q1.add(buttonpanel);

		JLabel RentHis = new JLabel ("Rental History");
		RentHis.setFont(fancyFont);
		
		JLabel Status = new JLabel ("Status:");
		JTextField StatusField = new JTextField (10);
		
		JLabel AmDue = new JLabel ("Amount Due:");
		JTextField AmDueField = new JTextField (10);
		
		JLabel MovieCheck = new JLabel ("Movies Checked Out:");
		MovieCheck.setFont(fancyFont);
		
		JTextField MovieField = new JTextField();
		MovieField.setPreferredSize(new Dimension(100,50));
		JButton CheckVid = new JButton ("Check Video");
		
		JLabel OutDate = new JLabel ("CheckOut Date:");
		JTextField OutDateField = new JTextField (10);
		
		JLabel InDate = new JLabel ("Return Date:");
		JTextField InDateField = new JTextField (10);
		
		q3.add(Status);
		q3.add(StatusField);
		
		q3.add(AmDue);
		q3.add(AmDueField);
		q2.add(q3);
		
		q5.add(MovieField);
		q5.add(CheckVid);
		
		q6.add(OutDate);
		q6.add(OutDateField);
		
		q7.add(InDate);
		q7.add(InDateField);
		
		q4.add(RentHis);
		q4.add(q2);
		q4.add(MovieCheck);
		q4.add(q5);
		q4.add(q6);
		q4.add(q7);
		
		pane.add(q1, BorderLayout.WEST);
		pane.add(AccDetails,BorderLayout.NORTH);
		pane.add(q4, BorderLayout.EAST);

		return pane;
	}
}