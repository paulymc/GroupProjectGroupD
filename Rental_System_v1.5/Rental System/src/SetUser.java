import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetUser extends JFrame implements ActionListener{
	
	Container uses = new JPanel();
	
	JButton newUser = new JButton("Add User");
	JButton removeUser = new JButton("Delete User");
	JButton returnMenu = new JButton("Return");
	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	JTextField name = new JTextField();
	JTextField role = new JTextField();
	
	JCheckBox manager = new JCheckBox();
	
	public SetUser(String User)
	{
		super("Set User");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(userpane());
		setResizable(false);
		setVisible(true);
	}

	public Container userpane()
	{
		JLabel title = new JLabel("User Settings");
		
		uses.setLayout(new GridLayout(7,0));
		
		newUser.addActionListener(this);
		removeUser.addActionListener(this);
		returnMenu.addActionListener(this);
		manager.addActionListener(this);
		name.addActionListener(this);
		role.addActionListener(this);
		save.addActionListener(this);
		cancel.addActionListener(this);
		
		uses.add(title);
		uses.add(name);
		uses.add(role);
		uses.add(manager);
		uses.add(save);
		uses.add(cancel);
		uses.add(returnMenu);
		
		
		
		return uses;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object action = e.getSource();
		
		if(action == returnMenu)
		{
			this.setVisible(false);
		}
		if(action == save)
		{
			JOptionPane.showMessageDialog(null, "New User Added");
		}
		if(action == cancel)
		{
			this.setVisible(false);
		}
		

	}

}
