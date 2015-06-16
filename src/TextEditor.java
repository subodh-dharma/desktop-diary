import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/*
 * Class: TextEditor
 * Description:GUI to enter the text for given date.
 * 			   Contains a text area to write and a disabled field to display today's date.
 * */
public class TextEditor extends JFrame implements ActionListener 
{
	JLabel labelDate=new JLabel("Date  ",JLabel.RIGHT);
	JLabel textDate=new JLabel();
	JTextArea textareaWriteUp=new JTextArea();
	JButton saveButton=new JButton("Save");
	JButton cancelButton=new JButton("Close");

	public TextEditor(String dateString)
	{
		setSize(700,500);
		setLayout(new BorderLayout());
		setLocation(500,100);
		setTitle("Today's Update");
		JPanel northPanel=new JPanel();
		JPanel southPanel=new JPanel();
		textareaWriteUp.setSize(10, 10);

		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);
		textareaWriteUp.addFocusListener(new InternalFocusListen());
		//North Panel Components
		northPanel.setLayout(new GridLayout(3,6));
		northPanel.add(new JLabel());
		northPanel.add(new JLabel());
		northPanel.add(new JLabel());

		northPanel.add(new JLabel());
		northPanel.add(labelDate);
		northPanel.add(textDate);

		northPanel.add(new JLabel());
		northPanel.add(new JLabel());
		northPanel.add(new JLabel());

		//South Panel Components
		southPanel.setLayout(new GridLayout(3,6));
		southPanel.add(new JLabel());
		southPanel.add(new JLabel());
		southPanel.add(new JLabel());

		southPanel.add(new JLabel());
		southPanel.add(saveButton);
		southPanel.add(cancelButton);

		southPanel.add(new JLabel());
		southPanel.add(new JLabel());
		southPanel.add(new JLabel());

		//Frame Components
		add(northPanel,BorderLayout.NORTH);
		add(new JPanel(),BorderLayout.EAST);
		add(new JPanel(),BorderLayout.WEST);
		add(southPanel,BorderLayout.SOUTH);
		add(textareaWriteUp,BorderLayout.CENTER);
		
		if(dateString.equals("today"))
		textDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		else
		textDate.setText(dateString);
		
		setVisible(true);

		//Fetch Existing Contents of the File.
		String stringDate="";
		if(dateString.equals("today"))
		{stringDate = textDate.getText();
		}else
		{stringDate= dateString;
		}
		stringDate=stringDate.replaceAll("/","");
		
		String FileName = stringDate+".txt";
		System.out.println("Filename:"+FileName);

		
		try{

			//+FileName
			File file = new File("data/"+FileName);

			if(file.exists()){}
			else{	file.createNewFile();}

			FileReader fReader = new FileReader(file);
			BufferedReader buffreader =new BufferedReader(fReader);
			textareaWriteUp.setText(buffreader.readLine());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(cancelButton))
		{
			this.dispose();

		}else if(ae.getSource().equals(saveButton))
		{
			String stringDate = textDate.getText();
			stringDate=stringDate.replaceAll("/","");

			String FileName = "data/"+stringDate+".txt";
			
			
			try{
				
				File file = new File(FileName);
				if(file.exists()){}
				else{	file.createNewFile();}
				FileWriter fWriter = new FileWriter(file);
				BufferedWriter buffWriter = new BufferedWriter(fWriter);
				//
				buffWriter.write(textareaWriteUp.getText().toString());
				buffWriter.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			System.out.println(stringDate);
			saveButton.setText("Saved");
		}

	}
	
	private class InternalFocusListen implements FocusListener
	{

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			saveButton.setText("Save");
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
