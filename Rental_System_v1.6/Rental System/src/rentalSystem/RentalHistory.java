package rentalSystem;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentalHistory extends JFrame implements ActionListener{
	
	Container hist = new JPanel();
	JList historyr = new JList();
	JButton returnm = new JButton("Return");
	JButton rent = new JButton("Rent DVD");
	JButton returndvd = new JButton("Return DVD");
	JButton confirm = new JButton("Confirm");
	JTextField DVDField;
	
	public RentalHistory(String title)
	{
		super(title);
		setSize(800,600);
		setContentPane(history());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public Container history()
	{
		JLabel header = new JLabel("Rental History");
		historyr.setLayoutOrientation(JList.VERTICAL);
		JScrollPane scroll = new JScrollPane(historyr);
		
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		returnm.addActionListener(this);
		rent.addActionListener(this);
		returndvd.addActionListener(this);
		confirm.addActionListener(this);
		
		DVDField = new JTextField ();
		DVDField.setPreferredSize(new Dimension(500,40));
		DVDField.setEditable(false);
		
		hist.add(header);
		hist.add(scroll);
		hist.add(returnm);
		hist.add(rent);
		hist.add(returndvd);
		hist.add(DVDField);
		hist.add(confirm);
		
		return hist;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object Event = e.getSource();
		
		if(Event == returnm)
		{
			this.setVisible(false);
		}
		
		if(Event == rent)
		{
			DVDField.setEditable(true);
		}
		
		if(Event == returndvd)
		{
			DVDField.setEditable(true);
		}
		
		if(Event == confirm)
		{
			DVDField.setEditable(false);
		}
		
	}

}
