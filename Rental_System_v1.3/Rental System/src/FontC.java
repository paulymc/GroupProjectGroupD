
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontC extends JFrame implements ActionListener {
	
		JButton add = new JButton("Increase");
		JButton minus = new JButton("Decrease");
		JButton goBack = new JButton("Return");
		Container setF = new JPanel();
	public FontC(String title)
	{
		super("Font Size");
		setSize(600,600);
		setContentPane(setFont());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setJMenuBar(createMenu());
		setVisible(true);
		setResizable(false);							//resizing not allowed 
		
	}
	
	

	public Container setFont()
	{
		//Container setF = new JPanel();
		
		JPanel newPanel = new JPanel();
		JLabel change = new JLabel("Change Font Size");
		
		add.addActionListener(this);
		minus.addActionListener(this);
		goBack.addActionListener(this);
		
		newPanel.add(change);
		
		newPanel.add(add);
		newPanel.add(minus);
		newPanel.add(goBack);
		setF.add(newPanel);
		//setF.add(minus);
		//setF.add(add);
		//setF.add(goBack);
		return setF;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object action = e.getSource();
		
		if(action == add)
		{
			GUI.size++;	
		}
		if(action == minus)
		{
			GUI.size--;
		}
		if(action == goBack)
		{
			setVisible(false);
		}
		// TODO Auto-generated method stub
		
	}
	

}
