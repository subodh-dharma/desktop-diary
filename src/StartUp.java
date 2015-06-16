import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * Class : StartUp
 * Description: Entry point for the application
 * 
 * */
public class StartUp extends JFrame implements ActionListener,KeyListener{

	private JMenuBar menubar=new JMenuBar();;
	private JMenu menuGeneral,menuHelp,menuSettings;
	private JButton startWriting =new JButton(" Go!! ");
	private JButton goToDate=new JButton("Go To Date");
	private JTextField textDate =new JTextField();
	private JTextField textMonth =new JTextField();
	private JTextField textYear =new JTextField();
	
	/* Default Constructor */
	StartUp()
	{	super("MyDiary");
	
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		setLayout(new GridLayout(10,20));
		//setLayout(new BorderLayout());
		setMenuBar();
				
		add(((new JPanel()).add(menubar)),BorderLayout.NORTH);
		//
		JPanel centralPanel =new JPanel();
		//centralPanel.setSize(600,100);
		centralPanel.setLayout(new GridLayout(2,2));
		
		
		centralPanel.add(new JLabel("Start Writing for Today!!"));
		centralPanel.add(startWriting);
		
		textDate.setText("dd/mm/yyyy");
		textDate.addKeyListener(this);
		centralPanel.add(textDate);
		centralPanel.add(goToDate);
		//
		add(centralPanel,BorderLayout.CENTER);
		add(new JPanel(),BorderLayout.SOUTH);
		
		setLocation(500,100);
		
		
		startWriting.addActionListener(this);
		goToDate.addActionListener(this);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	
	/* Set the menubar items using the function setMenuBar() */	
	JMenuItem menuPersonalInfo,menuSecurity,menuAbout,menuFileSetting;
	private void setMenuBar()
	{
		menuGeneral=new JMenu("General");
		menuHelp=new JMenu("Help");
		menuSettings=new JMenu("Settings");
		
		menuPersonalInfo=new JMenuItem("Personal Info");
		menuPersonalInfo.addActionListener(this);
		menuGeneral.add(menuPersonalInfo);
		
		menuSecurity=new JMenuItem("Security");
		menuGeneral.add(menuSecurity);
		menuSecurity.addActionListener(this);
		
		menuAbout=new JMenuItem("About Us");
		menuAbout.addActionListener(this);
		menuHelp.add(menuAbout);
		
		menuFileSetting=new JMenuItem("File Settings");
		menuFileSetting.addActionListener(this);
		menuSettings.add(menuFileSetting);
		
		menubar.add(menuGeneral);
		//menubar.add(menuSettings);
		menubar.add(menuHelp);
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(menuAbout))
		{
			new AboutUs();
		}else if (e.getSource().equals(menuPersonalInfo))
		{
			new PersonalInfo();
		}else if (e.getSource().equals(startWriting))
		{
			new TextEditor("today");
		}else if (e.getSource().equals(menuFileSetting))
		{
			new Settings();
		}else if (e.getSource().equals(goToDate))
		{
			new TextEditor(textDate.getText());
		}else if(e.getSource().equals(menuSecurity))
		{
			new SecurityMain();
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		
	}
		
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(textDate.getText().equals("dd/mm/yyyy"))
		textDate.setText("");
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		new StartUp();

	}
}
