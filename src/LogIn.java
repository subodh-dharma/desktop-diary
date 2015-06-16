import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class LogIn extends JFrame implements ActionListener
{
	JTextField textUsername=new JTextField();
	JPasswordField textPassword = new JPasswordField();
	JButton buttonLogin = new JButton("Login");
	JPanel panelError = new JPanel();
	JPanel panelUI = new JPanel();
	JLabel labelError = new JLabel("Username/Password incorrect");
	
	public static void main(String[] args)
	{
		new LogIn();
	}
	
	public LogIn()
	{
		setTitle("Log In");
		setLayout(new FlowLayout());
		panelUI.setLayout(new GridLayout(6,4));
		
		
		for(int i=0;i<2;i++)
			add(new JLabel());
		
		panelUI.add(new JLabel("              Username   "));
		panelUI.add(textUsername);
		
		panelUI.add(new JLabel("              Password   "));
		panelUI.add(textPassword);
		
		for(int i=0;i<2;i++)
			panelUI.add(new JLabel());
		
		buttonLogin.addActionListener(this);
		
		panelUI.add(buttonLogin);
		panelUI.add(new JLabel());
		add(panelError);
		add(panelUI);
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(500,100);
		setSize(300,180);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(buttonLogin))
		{
			System.out.println("Press Login");
			File fileInit = new File("config/init.conf");
			Configuration readConf = new Configuration();
			
			
			try {
				FileInputStream fin = new FileInputStream(fileInit);
				ObjectInputStream oin = new ObjectInputStream(fin);
				
				readConf= (Configuration)oin.readObject();
				if(textUsername.getText().equals(readConf.getUser()) && textPassword.getText().equals(readConf.getPassword()))
				{		new StartUp();
						this.dispose();
				}
				else
				{		
					labelError.setForeground(Color.RED);
					panelError.add(labelError);
					this.revalidate();
					this.repaint();
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
}
