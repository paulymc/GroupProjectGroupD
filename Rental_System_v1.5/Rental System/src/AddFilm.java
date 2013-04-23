import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class AddFilm extends JFrame implements ActionListener {
	
	Container films = new JPanel();
	
	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	JButton returnmenu = new JButton("Stock Menu");
	
	JTextField Name1 = new JTextField();
	JTextField Director1 = new JTextField();
	JTextField Quantity1 = new JTextField();
	JTextField rent = new JTextField();
	JTextField Year = new JTextField();
	

	
	//To hold the username and password for the database
	String username,password;
	
	public AddFilm(String title,String user,String pass)
	{
		super(title);
		setSize(800,600);
		setLocationRelativeTo(null);
		setContentPane(AddFilmScreen());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		username = user;
		password = pass;
		
	}
	
	public Container AddFilmScreen()
	{
		JLabel name = new JLabel("Name:");
		JLabel Director = new JLabel("Director:");
		JLabel QTY = new JLabel("Quantity:");
		JLabel Genre = new JLabel("Rent:");
		JLabel Year = new JLabel("Year:");
		

			
			//Container Screen = new JPanel();
		films.setLayout(new BorderLayout());
		Font Font2 = new Font("Aerial",Font.BOLD,32);
			
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(17,2));
		JLabel StockTitle = new JLabel("   Stock");
		
		save.addActionListener(this);
		cancel.addActionListener(this);
		returnmenu.addActionListener(this);
			
		StockTitle.setFont(Font2);
			
		//Adding components to the info panel / screen 
		
		info.add(Director);
		info.add(Director1);
		info.add(Year);
		info.add(this.Year);
		info.add(QTY);
		info.add(Quantity1);
		info.add(Genre);
		info.add(rent);
		info.add(name);
		info.add(Name1);
		info.add(save);
		info.add(cancel);
		info.add(returnmenu);
		//Action Listeners set here 
		films.add(info);
			//Layout of the screen set here 
		return films;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object Event = e.getSource();
		// TODO Auto-generated method stub
		if(Event == save)
		{
			Model new_St = new Model(username, password);
			
			int quant = Integer.parseInt(Quantity1.getText());
			
			new_St.NewStock(Name1.getText(),Integer.parseInt(Year.getText()) , Director1.getText(),Integer.parseInt( rent.getText()), quant);	
			JOptionPane.showMessageDialog(null, "Film Added");
			
			
		}
		if(Event == cancel)
		{
			this.setVisible(false);
		}
		if(Event == returnmenu)
		{
			this.setVisible(false);
		}
		
	}

}
