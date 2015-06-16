import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Settings extends JFrame implements ActionListener
{
	static String fileLocation;
	JLabel labelFileLoc=new JLabel("File Location Path");
	JTextField textFileLoc=new JTextField();
	JFileChooser fileChooser;
	JButton buttonBrowse =new JButton("Browse..");

	Settings()
	{
		setSize(400,100);
		setLocation(500,200);
		setVisible(true);
		setLayout(new GridLayout(3,3));
		setTitle("File Settings");
		buttonBrowse.addActionListener(this);
		
		add(new JLabel());
		add(new JLabel());add(new JLabel());
		add(labelFileLoc);
		add(textFileLoc);
		//add(fileChooser);
		add(buttonBrowse);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
 		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		fileChooser=new JFileChooser();
		File f=null;
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.showOpenDialog(new JFrame());
		f=fileChooser.getSelectedFile();
		textFileLoc.setText(f.getPath());
		fileLocation=f.getPath()+"/";
	}
}
