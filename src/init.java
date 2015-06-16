import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class init {

	static Welcome w;
	
	public static void main(String[] arg)
	{
		
		File folder1 = new File("data");
		folder1.mkdir();
		File folder2 = new File("config");
		folder2.mkdir();
		
		try{
		File file= new File("config/init.conf");
		
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Configuration objConf=(Configuration)oin.readObject();
		
		if(objConf.getAccess()==0)
		{
			w = new Welcome();
		}else
		{
			new LogIn();
		}
		
		
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
			
				File f = new File("config/init.conf");
				try {
					f.createNewFile();
					FileOutputStream fout = new FileOutputStream(f);
					ObjectOutputStream oout = new ObjectOutputStream(fout);
					
					Configuration c= new Configuration();
					c.setAccess(0);
					c.setUser("");
					c.setPassword("");
					
					oout.writeObject(c);
					oout.flush();
					oout.close();
					
					String a[]=new String[]{"123"};
					main(a);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
