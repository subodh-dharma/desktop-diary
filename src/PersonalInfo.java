import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.*;
/*
 * Class: PersonalInfo
 * Description:GUI to enter the details of the user
 * 
 * */
class PersonalInfo extends JFrame implements ActionListener
{
	private JTextField textName=new JTextField();
	private JTextField textAge=new JTextField();
	private JTextField textDob=new JTextField();
	private JTextField textMailid=new JTextField();
	private JTextField textContact=new JTextField();
	private JButton okButton=new JButton("OK");
	
	
	File file;
	FileInputStream fis;
	ObjectInputStream ois;
	
	
	public PersonalInfo()
	{
		/*File settings for the Profile*/
		Profile readProfile=new Profile();
		file=new File("config/profile.txt");
		try{
			
			fis=new FileInputStream(file);
			
			
			try{
			ois=new ObjectInputStream(fis);	
			readProfile=(Profile)ois.readObject();}
			catch(Exception e){ System.out.println("Third"+e);}
				
		/* Layout for PersonalInfo Window */
		setLayout(new GridLayout(10,2));
		add(new JLabel("Name"));
		add(textName);
		add(new JLabel("Age"));
		add(textAge);
		add(new JLabel("DOB"));
		add(textDob);
		add(new JLabel("eMail"));
		add(textMailid);
		add(new JLabel("Contact"));
		add(textContact);
		add(okButton);
		okButton.addActionListener(this);
		
		textName.setText(readProfile.getName());
		textAge.setText(readProfile.getAge());
		textDob.setText(readProfile.getDob());
		textMailid.setText(readProfile.getMailid());
		textContact.setText(readProfile.getContact());
		
		setLocation(600,200);
		setSize(300,300);
		setVisible(true);
		
		}
		catch(Exception e)
		{
			System.out.println("First"+e);
		}
	}
	
	Profile profile=new Profile();
	
	public void actionPerformed(ActionEvent ae)
	{
		profile.setName(textName.getText());
		profile.setAge(textAge.getText());
		profile.setDob(textDob.getText());
		profile.setMailid(textMailid.getText());
		profile.setContact(textContact.getText());
		try{
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		oos.writeObject(profile);
		
		this.dispose();
		
		}catch(Exception e)
		{
			System.out.println("Second"+e);
		}
		
		
	}
}
