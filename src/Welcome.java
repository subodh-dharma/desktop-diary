import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Welcome extends JFrame
{
	public static void main(String[] args)
	{
		new Welcome();
		
	}
	Welcome()
	{
		setSize(500,500);
		add(new CreateProfile());
		setTitle("Create Profile");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
}

/* 
 * Class CreateProfile
 * 
 * Description : GUI to enter details of the profile of the user.
 * 
 * */
class CreateProfile extends JPanel implements ActionListener
{
	JLabel LName=new JLabel("            Name");
	JLabel LAge=new JLabel("            Age");
			
	JTextField TName=new JTextField();
	JTextField TAge=new JTextField();
	JTextField TDOB=new JTextField();
	JTextField TMailId =new JTextField();
	JTextField TContact = new JTextField();
	JPasswordField TPassword = new JPasswordField();
	JButton buttonOK = new JButton("OK");
	JButton buttonCancel = new JButton("Cancel");
	
	CreateProfile()
	{
		
		setLayout(new GridLayout(14,1));
		
		
		add(LName);add(TName);	for(int i=0;i<2;i++)add(new JLabel());
		add(LAge); add(TAge);	for(int i=0;i<2;i++)add(new JLabel());
		add(new JLabel("            Date of Birth")); add(TDOB);	for(int i=0;i<2;i++)add(new JLabel());
		add(new JLabel("            Email ID")); add(TMailId);	for(int i=0;i<2;i++)add(new JLabel());
		add(new JLabel("            Contact No.")); add(TContact); for(int i=0;i<2;i++)add(new JLabel());
		add(new JLabel("            Password")); add(TPassword); for(int i=0;i<2;i++)add(new JLabel());
		add(buttonOK);add(buttonCancel);
		
		buttonOK.addActionListener(this);
		buttonCancel.addActionListener(this);
		
		setSize(100,100);
				
	}
	
	File f=null;
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(buttonOK))
		{
			Profile newProfile = new Profile();
			newProfile.setName(TName.getText());
			newProfile.setAge(TAge.getText());
			newProfile.setContact(TContact.getText());
			newProfile.setDob(TDOB.getText());
			newProfile.setMailid(TMailId.getText());
			
			
			Configuration newConf = new Configuration();
			newConf.setAccess(1);
			newConf.setUser(TName.getText());
			newConf.setPassword(TPassword.getText());
			
			File fileProfile = new File("config/profile.txt");
			File fileInitConf = new File("config/init.conf");
			try {
				FileOutputStream fos = new FileOutputStream(fileProfile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(newProfile);
				oos.flush();
				oos.close();
				
				FileOutputStream fos1 = new FileOutputStream(fileInitConf);
				ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
				oos1.writeObject(newConf);
				oos1.flush();
				oos1.close();
				
				new LogIn();
				init.w.dispose();
				setVisible(false);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else
		{
			init.w.dispose();
		}
		if(ae.getSource().equals(buttonCancel))
		{
			init.w.dispose();
		}
	}
	
}
