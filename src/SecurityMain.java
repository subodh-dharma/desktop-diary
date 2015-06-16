import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SecurityMain extends JFrame implements ActionListener
{
	JButton buttonPassword = new JButton("Change Password");
	JButton buttonEncryptionKey = new JButton("Change Encryption Key...");
	
	//Passsword Panel
	JPanel panelPasswordChange = new JPanel();
	JPasswordField currentPassword = new JPasswordField();
	JPasswordField newPassword = new JPasswordField();
	JPasswordField confirmPassword = new JPasswordField();
	JButton buttonPasswordOK = new JButton("OK");
	JButton buttonPasswordCancel = new JButton("Cancel");
	
	//Encryption Key Panel
	JPanel panelEncryption = new JPanel();
	JTextField textEncryptionKey =new JTextField();
	JTextField textNewEncryptionKey =new JTextField();
	JButton buttonEncryptOK = new JButton("OK");
	JButton buttonEncryptCancel = new JButton("Cancel");
	
	public SecurityMain()
	{
		this.setLayout(new GridLayout(4,1));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Security Settings");
		add(new JLabel());
		add(buttonPassword);
		//add(buttonEncryptionKey);
		
		buttonPassword.addActionListener(this);
		buttonEncryptionKey.addActionListener(this);
		
		//PAssword Panel Components
		panelPasswordChange.setName("Password Change");
		panelPasswordChange.setLayout(new GridLayout (4,8));
		panelPasswordChange.add(new JLabel("Current Password"));
		panelPasswordChange.add(currentPassword);
		panelPasswordChange.add(new JLabel("New Password"));
		panelPasswordChange.add(newPassword);
		panelPasswordChange.add(new JLabel("Confirm Password"));
		panelPasswordChange.add(confirmPassword);
		panelPasswordChange.add(buttonPasswordOK);
		panelPasswordChange.add(buttonPasswordCancel);
		
		buttonPasswordOK.addActionListener(this);
		buttonPasswordCancel.addActionListener(this);
		
		
		//Encryption Panel Components
		panelEncryption.setName("Encryption Key");
		panelEncryption.setLayout(new GridLayout(4,8));
		panelEncryption.add(new JLabel("Current Encryption Key"));
		panelEncryption.add(textEncryptionKey);
		panelEncryption.add(new JLabel("New Encryption Key"));
		panelEncryption.add(textNewEncryptionKey);
		panelEncryption.add(buttonEncryptOK);
		panelEncryption.add(buttonEncryptCancel);
		
		buttonEncryptOK.addActionListener(this);
		buttonEncryptCancel.addActionListener(this);
		
		setLocation(600,100);
		setSize(300,500);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(buttonPassword))
		{	add(panelPasswordChange);
			this.revalidate();
			this.repaint();
		}else if(ae.getSource().equals(buttonPasswordOK))
		{	remove(panelPasswordChange);
			this.repaint();
		}else if(ae.getSource().equals(buttonPasswordCancel))
		{   remove(panelPasswordChange);
			this.repaint();
		}else if(ae.getSource().equals(buttonEncryptOK))
		{	remove(panelEncryption);
			this.repaint();
		}else if(ae.getSource().equals(buttonEncryptCancel))
		{   remove(panelEncryption);
			this.repaint();
		}else if(ae.getSource().equals(buttonEncryptionKey))
		{	add(panelEncryption);
			this.revalidate();
			this.repaint();
	}
	}
	
	
}
