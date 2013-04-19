

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	JButton newAcc = new JButton("New Account");
	JButton returnq = new JButton("Return");
    Container pane = new JPanel();
	JTextField seacrh = new JTextField();
	JButton searching = new JButton("Search");
	JButton save = new JButton("Save");
	JPanel buttonpanel = new JPanel();
	JButton Rental = new JButton("Rental History");
	
// Constructor for frame 
	JTextField AccIdField = new JTextField (10);
	JTextField NameField = new JTextField (10);
	JTextField PhField = new JTextField (10);
	JTextField EmailField = new JTextField (10);
	JTextField Add1Field = new JTextField (10);
	JTextField Add2Field = new JTextField (10);
	JTextField CountyField = new JTextField (10);
	JTextField DateField = new JTextField (10);
	JTextField BranchField = new JTextField (10);


	//To hold the username and password for the database
	String username,password;
	
	int id ;//for the update functionality
	
	public AccDetails (String myTitle,String user,String pass) 
	{
		super (myTitle);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		setContentPane(Pane());
		setVisible(true);
		setResizable(false);

		username = user;
		password = pass;
		
	//System.out.println("Username is : " + username + "Password is: "+ password );
		
	}

	public Container Pane() 
        {
		
		pane.setLayout(new BorderLayout());
		pane.setBackground(Color.GRAY);
		
		JPanel AccDetpanel = new JPanel();
		AccDetpanel.setBackground(Color.RED);
		
		JPanel Accinfo = new JPanel();
		Accinfo.setLayout(new GridLayout(12,2));
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
		AccIdField.setEditable(false);
		JLabel Name = new JLabel ("  Name:");
		NameField.setEditable(false);
		JLabel PhNum = new JLabel ("  Phone Number:");
		PhField.setEditable(false);
		JLabel Email = new JLabel ("  Email:");
		EmailField.setEditable(false);
		JLabel AddLine1 = new JLabel ("  Address Line 1:");
		Add1Field.setEditable(false);
		JLabel AddLine2 = new JLabel ("  Address Line 2:");
		
		Add2Field.setEditable(false);
		
		JLabel County = new JLabel ("  County:");
		
		
		CountyField.setEditable(false);
		
		JLabel DateJoin = new JLabel ("  Date Joined:");
	
		DateField.setEditable(false);
		
		JLabel Branch = new JLabel ("  Branch:");
	
		BranchField.setEditable(false);
		
		Accinfo.add(seacrh);
		Accinfo.add(searching);
		searching.setToolTipText("Search for Customer by name");
		
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
		Accinfo.add(Rental);
		
		
		buttonpanel.setLayout(new BorderLayout());
		buttonpanel.add(Details, BorderLayout.WEST);
		buttonpanel.add(newAcc,BorderLayout.EAST);
		//buttonpanel.add(Rental,BorderLayout.SOUTH);
		buttonpanel.add(returnq);
		
		
	
		Accinfo.add(buttonpanel);

		JLabel RentHis = new JLabel ("Rental History");
		RentHis.setFont(fancyFont);
		
		JLabel Status = new JLabel ("Status:");
		JTextField StatusField = new JTextField (10);
		StatusField.setEditable(false);
		
		JLabel AmDue = new JLabel ("Amount Due:");
		JTextField AmDueField = new JTextField (10);
		AmDueField.setEditable(false);
		
		JLabel MovieCheck = new JLabel ("Movies Checked Out:");
		MovieCheck.setFont(fancyFont);
		
		JTextField MovieField = new JTextField();
		MovieField.setEditable(false);
		MovieField.setPreferredSize(new Dimension(150,30));
		
		
		JLabel OutDate = new JLabel ("CheckOut Date:");
		JTextField OutDateField = new JTextField (10);
		OutDateField.setEditable(false);
		
		JLabel InDate = new JLabel ("Return Date:");
		JTextField InDateField = new JTextField (10);
		InDateField.setEditable(false);
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
		//pane.add(RentHistory, BorderLayout.EAST);
		searching.addActionListener(this);
		Details.addActionListener(this);
		CheckVid.addActionListener(this);
		newAcc.addActionListener(this);
        returnq.addActionListener(this);
        Rental.addActionListener(this);
		return pane;
	}
	
	public void actionPerformed(ActionEvent e) 
 {
		
		Object fire = e.getSource();
		
		if(fire == Details)
		{
			AccIdField.setEditable(true);
		    NameField.setEditable(true); 			 
		    PhField.setEditable(true); 
			 EmailField.setEditable(true); 
			 Add1Field.setEditable(true); 
			 Add2Field.setEditable(true); 
			 CountyField.setEditable(true); 
			 DateField.setEditable(true); 
			 BranchField.setEditable(true); 

			 save.addActionListener(this);
			 returnq.setText("Save");
			 buttonpanel.add(save);
			 pane.repaint();
		}
		
		if(fire == CheckVid)
		{
			
		}
		if(fire == newAcc)
		{
			new createAcc("DVD RENTAL");
		}
		if(fire == returnq)
		{
			Model up_cust = new Model(username,password);	 
			up_cust.UpdateCust(id,NameField.getText(),PhField.getText(),EmailField.getText(),Add1Field.getText());
			this.setVisible(false);
		}
		if(fire == save)
		{
			Model up_cust = new Model(username,password);	 
			up_cust.UpdateCust(id,NameField.getText(),PhField.getText(),EmailField.getText(),Add1Field.getText());
			 AccIdField.setEditable(false);
		     NameField.setEditable(false); 			 
		     PhField.setEditable(false); 
			 EmailField.setEditable(false); 
			 Add1Field.setEditable(false); 
			 Add2Field.setEditable(false); 
			 CountyField.setEditable(false); 
			 DateField.setEditable(false); 
			 BranchField.setEditable(false); 
		}
		if(fire == Rental)
		{
			new RentalHistory("Rental History");
		}
		
		if(fire == searching)
		{
			Model dis_cust = new Model(username, password);
			ResultSet res_cust = dis_cust.getCust(seacrh.getText());
			try {
				while(res_cust.next())
				{
					int ph;
					id = res_cust.getInt("custId");
					String name = res_cust.getString("custName");
					String email,add;
					ph =res_cust.getInt("custPhone");
					email =res_cust.getString("custEmail");
					add =res_cust.getString("custAddr");
					System.out.println("Id : "+id+"	Name: "+name);
					
				     NameField.setText(name); 			 
				     PhField.setText(""+ph);
					 EmailField.setText(email);
					 Add1Field.setText(add);  
					
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dis_cust.closeStm();
			dis_cust.closeResultSet();
			dis_cust.closeDB();
		}
		
 }
}