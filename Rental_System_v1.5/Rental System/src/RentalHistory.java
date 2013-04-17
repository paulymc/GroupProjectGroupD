import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentalHistory extends JFrame implements ActionListener{
	
	Container hist = new JPanel();
	JList historyr = new JList();
	JButton returnm = new JButton("Return");
	
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
		JScrollPane scroll = new JScrollPane(hist);
		
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		returnm.addActionListener(this);
		
		hist.add(header);
		hist.add(scroll);
		hist.add(returnm);
		
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
		
	}

}
