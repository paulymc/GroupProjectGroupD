package TeamProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class AccDetails extends JFrame implements ActionListener
{
	JButton Details = new JButton("Edit Details");
	JButton CheckVid = new JButton ("Check Video");

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
		Container pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.setBackground(Color.GRAY);
		
		JPanel AccDetpanel = new JPanel();
		AccDetpanel.setBackground(Color.RED);
		
		JPanel Accinfo = new JPanel();
		Accinfo.setLayout(new GridLayout(10,2));
		Accinfo.setBorder(BorderFactory.createLineBorder(Color.GRAY,30));
		
		JPanel RentStatus = new JPanel();
		RentStatus.setLayout(new GridLayout(1,4));
		
		JPanel RentHistory = new JPanel();
		RentHistory.setBorder(BorderFactory.createLineBorder(Color.GRAY,30));
		RentHistory.setLayout(new GridLayout(6,0));
		RentHistory.setBackground(Color.RED);
		
		JPanel AmountDue = new JPanel();
		JPanel Movies = new JPanel();
		JPanel rentedOn = new JPanel();
		JPanel returnedOn = new JPanel();
		
		JLabel AccDetails = new JLabel ("  Account Details");
		Font fancyFont = new Font ("Serif",Font.BOLD,24);
		AccDetails.setFont(fancyFont);
		
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
		buttonpanel.add(Details, BorderLayout.WEST);
	
		Accinfo.add(buttonpanel);

		JLabel RentHis = new JLabel ("Rental History");
		RentHis.setFont(fancyFont);
		
		JLabel Status = new JLabel ("Status:");
		JTextField StatusField = new JTextField (10);
		
		JLabel AmDue = new JLabel ("Amount Due:");
		JTextField AmDueField = new JTextField (10);
		
		JLabel MovieCheck = new JLabel ("Movies Checked Out:");
		MovieCheck.setFont(fancyFont);
		
		JTextField MovieField = new JTextField();
		MovieField.setPreferredSize(new Dimension(150,30));
		
		
		JLabel OutDate = new JLabel ("CheckOut Date:");
		JTextField OutDateField = new JTextField (10);
		
		JLabel InDate = new JLabel ("Return Date:");
		JTextField InDateField = new JTextField (10);
		
		AmountDue.add(Status);
		AmountDue.add(StatusField);
		
		AmountDue.add(AmDue);
		AmountDue.add(AmDueField);
		RentStatus.add(AmountDue);
		
		Movies.add(MovieField);
		Movies.add(CheckVid);
		
		rentedOn.add(OutDate);
		rentedOn.add(OutDateField);
		
		returnedOn.add(InDate);
		returnedOn.add(InDateField);
		
		RentHistory.add(RentHis);
		RentHistory.add(RentStatus);
		RentHistory.add(MovieCheck);
		RentHistory.add(Movies);
		RentHistory.add(rentedOn);
		RentHistory.add(returnedOn);
		AccDetpanel.add(AccDetails);
		
		pane.add(Accinfo, BorderLayout.WEST);
		pane.add(AccDetpanel,BorderLayout.NORTH);
		pane.add(RentHistory, BorderLayout.EAST);
		
		Details.addActionListener(this);
		CheckVid.addActionListener(this);

		return pane;
	}
	
public void actionPerformed(ActionEvent e) {
		
		Object fire = e.getSource();
		
		if(fire == Details)
		{
			new Password("DVD Rentel");
			setVisible(false);
		}
		
		if(fire == CheckVid)
		{
			new Password("Rentel");
			setVisible(false);
		}
}
}