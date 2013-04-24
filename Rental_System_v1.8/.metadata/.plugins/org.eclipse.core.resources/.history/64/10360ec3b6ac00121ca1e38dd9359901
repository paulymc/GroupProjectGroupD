

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	//JButton CheckVid = new JButton ("Check Video");
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
	JTextField AddField = new JTextField (10);
	JTextField DateField = new JTextField (10);
	JTextField search = new JTextField();
	
	//all labels needed for this GUI
	JLabel AccDetails = new JLabel ("  Account Details");
	JLabel AccId = new JLabel ("  Account ID:");
	JLabel Name = new JLabel ("  Name:");
	JLabel PhNum = new JLabel ("  Phone Number:");
	JLabel Email = new JLabel ("  Email:");
	JLabel AddLine1 = new JLabel ("  Address Line:");
	//JLabel AddLine2 = new JLabel ("  Address Line 2:");
	JLabel DateJoin = new JLabel ("  Date Joined:");

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
		AddField.setEditable(false);	
		DateField.setEditable(false);
		
		Accinfo.add(search); //add  search textfield
		Accinfo.add(searching); //add search buttn
		searching.setToolTipText("Search for Customer by name");
		
		Accinfo.add(AccId); //add accid label to accinfo panel
		Accinfo.add(AccIdField); //add accid textfield to accinfo panel
		
		Accinfo.add(Name); //add Name label to accinfo panel
		Accinfo.add(NameField);//add Name textfield to accinfo panel
		
		Accinfo.add(PhNum); //add PhNum label to accinfo panel
		Accinfo.add(PhField);//add PhNum textfield to accinfo panel
		
		Accinfo.add(Email); //add Email label to accinfo panel
		Accinfo.add(EmailField);//add Email textfield to accinfo panel
		
		Accinfo.add(AddLine1); //add AddLine1 label to accinfo panel
		Accinfo.add(AddField);//add Email textfield to accinfo panel

		
		Accinfo.add(DateJoin); //add DateJoin label to accinfo panel
		Accinfo.add(DateField);//add DateJoin textfield to accinfo panel
		
		
		Accinfo.add(Rental);
		Accinfo.add(Delete);
		
		
		//buttonpanel.setLayout(new BorderLayout());
		buttonpanel.add(Details);
		buttonpanel.add(save);
		buttonpanel.add(newAcc);
		buttonpanel.add(returnq);
		
		
		Accinfo.add(buttonpanel);
		AccDetpanel.add(AccDetails);
		pane.add(Accinfo, BorderLayout.WEST);
		pane.add(AccDetpanel,BorderLayout.NORTH);
	
		searching.addActionListener(this);
		Details.addActionListener(this);
		newAcc.addActionListener(this);
        returnq.addActionListener(this);
        Rental.addActionListener(this);
        Delete.addActionListener(this);
        save.addActionListener(this);
		
        return pane;
	}
	
	public void actionPerformed(ActionEvent e) 
 {
		
		Object fire = e.getSource();
		
		if(fire == Details)
		{
			AccIdField.setEditable(false);
		    NameField.setEditable(true); 			 
		    PhField.setEditable(true); 
			EmailField.setEditable(true); 
			AddField.setEditable(true); 

			buttonpanel.add(save);
			pane.repaint();
		}
		
		
		if(fire == newAcc)
		{
			new createAcc("DVD RENTAL",username,password);
		}
		if(fire == returnq)
		{
			this.setVisible(false);
		}
		if(fire == save)
		{
			Model up_cust = new Model(username,password);	 
			int custId = Integer.parseInt(AccIdField.getText());
			up_cust.UpdateCust(custId,NameField.getText(),PhField.getText(),EmailField.getText(),AddField.getText());
			 
			AccIdField.setEditable(false);
		    NameField.setEditable(false); 			 
		    PhField.setEditable(false); 
			EmailField.setEditable(false); 
			AddField.setEditable(false); 
			DateField.setEditable(false); 
		}
		if(fire == Rental) //ID SHOULD BE PASSED 
		{
			
			int id = Integer.parseInt(AccIdField.getText());

				System.out.println("Username:"+username+"	Password:"+password);
				new RentalHistory("Rental History",username,password,id);
		}
		
		if(fire == Delete)
		{
			Model del_cust = new Model(username,password);	 
			int custId = Integer.parseInt(AccIdField.getText());
			del_cust.DeleteCust(custId);
			 
		}
		
		if(fire == searching)
		{
			String searchName = search.getText();
			if(searchName.length() >= 1)
			{
				Model dis_cust = new Model(username, password);
				ResultSet res_cust = dis_cust.getCust(search.getText());
				try 
				{
					while(res_cust.next())
					{
						String custId = res_cust.getString("custId");
						String phone = res_cust.getString("custPhone");
						String name = res_cust.getString("custName");
						String email = res_cust.getString("custEmail");
						String add = res_cust.getString("custAddr");
						System.out.println("Id : "+id+"	Name: "+name + " Address: " + add);
						
						
						
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						Date joindate = Calendar.getInstance().getTime();   
						String dateJoined = df.format(joindate);



						AccIdField.setText(custId);
					    NameField.setText(name); 			 
					    PhField.setText(phone);
						EmailField.setText(email);
						AddField.setText(add);  
						DateField.setText(dateJoined);
					}
				}
				catch (SQLException e1) 
				{
				e1.printStackTrace();
				}
				
				dis_cust.closeStm();
		
				dis_cust.closeResultSet();
			
				dis_cust.closeDB();
			}
			else
			{
				System.out.println("No customer to be displayed");
			}
		}
		
 }
}