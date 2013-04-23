

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
	//All the buttons needed for this GUI
	JButton Details = new JButton("Edit Details");
	JButton CheckVid = new JButton ("Check Video");
	JButton newAcc = new JButton("New Account");
	JButton returnq = new JButton("Return");
	JButton searching = new JButton("Search");
	JButton save = new JButton("Save");
	JButton Rental = new JButton("Rental History");
	JButton Delete = new JButton("Delete Customer");
	
	//Container and any panels need for this GUI
    Container pane = new JPanel();
    JPanel buttonpanel = new JPanel();
    JPanel AccDetpanel = new JPanel();
    JPanel Accinfo = new JPanel();
	
// all the text field needed for this GUI
	JTextField AccIdField = new JTextField (10);
	JTextField NameField = new JTextField (10);
	JTextField PhField = new JTextField (10);
	JTextField EmailField = new JTextField (10);
	JTextField Add1Field = new JTextField (10);
	JTextField Add2Field = new JTextField (10);
	JTextField CountyField = new JTextField (10);
	JTextField DateField = new JTextField (10);
	JTextField BranchField = new JTextField (10);
	JTextField seacrh = new JTextField();
	
	//all labels needed for this GUI
	JLabel AccDetails = new JLabel ("  Account Details");
	JLabel AccId = new JLabel ("  Account ID:");
	JLabel Name = new JLabel ("  Name:");
	JLabel PhNum = new JLabel ("  Phone Number:");
	JLabel Email = new JLabel ("  Email:");
	JLabel AddLine1 = new JLabel ("  Address Line 1:");
	JLabel AddLine2 = new JLabel ("  Address Line 2:");
	JLabel County = new JLabel ("  County:");
	JLabel DateJoin = new JLabel ("  Date Joined:");
	JLabel Branch = new JLabel ("  Branch:");

	//To hold the username and password for the database
	String username,password;
	
	int id ;//for the update functionality
	
	public AccDetails (String myTitle,String user,String pass) 
	{
		//code to create the frame
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
		pane.setLayout(new BorderLayout());//layout type for the container
		pane.setBackground(Color.GRAY); //background colour
		
		AccDetpanel.setBackground(Color.RED);
		
		Accinfo.setLayout(new GridLayout(12,2));
		Accinfo.setBorder(BorderFactory.createLineBorder(Color.GRAY,30));
		
		Font fancyFont = new Font ("Serif",Font.BOLD,24);
		AccDetails.setFont(fancyFont);
		
		//set the textfields to not editable
		AccIdField.setEditable(false);
		NameField.setEditable(false);
		PhField.setEditable(false);
		EmailField.setEditable(false);
		Add1Field.setEditable(false);
		Add2Field.setEditable(false);		
		CountyField.setEditable(false);	
		DateField.setEditable(false);
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
		Accinfo.add(Delete);
		
		buttonpanel.setLayout(new BorderLayout());
		buttonpanel.add(Details, BorderLayout.WEST);
		buttonpanel.add(newAcc,BorderLayout.EAST);
		buttonpanel.add(returnq);
		
		Accinfo.add(buttonpanel);
		AccDetpanel.add(AccDetails);
		pane.add(Accinfo, BorderLayout.WEST);
		pane.add(AccDetpanel,BorderLayout.NORTH);
	
		searching.addActionListener(this);
		Details.addActionListener(this);
		CheckVid.addActionListener(this);
		newAcc.addActionListener(this);
        returnq.addActionListener(this);
        Rental.addActionListener(this);
        Delete.addActionListener(this);
		
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
			new createAcc("DVD RENTAL",username,password);
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
			System.out.println("Username:"+username+"	Password:"+password);
			new RentalHistory("Rental History",username,password,id);
		}
		
		if(fire == Delete)
		{
			
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