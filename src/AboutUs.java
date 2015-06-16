import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;



/* Class:AboutUs
 * Description: Gives the information about the author and the version of the software
 * */
class AboutUs extends JFrame
{
	public AboutUs()
	{
		setLayout(new FlowLayout());
		add(new JLabel("MyDiary"));
		add(new JLabel("Version 0.0.1"));
		add(new JLabel("Developed By"));
		add(new JLabel("S.D."));
		this.setLocation(600, 200);
		setSize(200,200);
		setVisible(true);
	}
}
