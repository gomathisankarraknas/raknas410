import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Function {
	
	private static String s;
	static JComboBox<String> file = new JComboBox<String>();	
	static JComboBox<String> file1 = new JComboBox<String>();	
	public JFrame login()
	{
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","sime1999");  
	  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			
			
			
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select player_name from player");  
		while(rs.next())
		{
			file1.addItem(rs.getString(1));
			file.addItem(rs.getString(1));  
		}
	//step5 close the connection object  
	con.close();  
	  
	}catch(Exception e){ System.out.println(e);} 
		
		JFrame f = new JFrame();
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JButton b1 = new JButton("Get Details");
		JButton b2 = new JButton("Cancel");
		JTextArea a = new JTextArea("Player Name 1");
		JPanel p =new JPanel();				
		JPanel panel2 = new JPanel();
		JTextArea d = new JTextArea();
		JTextArea a1 = new JTextArea("Player Name 2");

		ActionListener l1 = new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				String i = e.getActionCommand();
				if(i=="Get Details")
				{
				
					String s = (String)file.getSelectedItem();
					String s1 = (String)file1.getSelectedItem();
					
					String details = new Function().yes(s,s1);
					d.setText("Player Name with Maximum Runs\n");
					d.append(details);
					
				}
				else if(i=="Cancel")
				{
					f.dispose();
				}			
			}
		};
		a.setSize(300,300);
		p.add(a);
		d.setEditable(false);
		a.setEditable(false);
		p.add(file);
		p.add(a1);
		p.add(file1);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
	

		panel2.add(b1);
		panel2.add(b2);
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
		
		panel.add(p);
		panel.add(d);
		panel.add(panel2);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		
		f.add(panel);
		b1.addActionListener(l1);
		b2.addActionListener(l1);
		f.setSize(300, 200);
		f.setVisible(true);
		
		return f;
	 	
	
	}

	 public String yes(String name,String name1)
	  { 
		  
		 String det = null;
		 try{  
				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","sime1999");  
		  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				
				
				String query = "select com1('"+ name +"','"+ name1 + "') from dual";
				
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				det =  rs.getString(1);			
		  
				con.close();  
		  
		}catch(Exception e){ System.out.println(e);}  
		 
		 return det;
	  }
	
	public static void main(String[] args)
	{
		Function c = new Function();
		c.login();
		Output r =new Output();
//		r.yes(s);
		
		
	}

}

