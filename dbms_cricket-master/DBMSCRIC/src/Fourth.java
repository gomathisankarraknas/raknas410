import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Fourth 
{
	
	public static void login()
	{
		JFrame f = new JFrame();
		
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JButton b1 = new JButton("Get Details");
		JButton b2 = new JButton("Cancel");
		JTextArea a = new JTextArea("ICC Rank");
		a.setMaximumSize(new Dimension(400,60));
		JPanel p =new JPanel();				
		JPanel panel2 = new JPanel();
		JTextArea d = new JTextArea();
		d.setBackground(Color.CYAN);

		ActionListener l1 = new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				String i = e.getActionCommand();
				if(i=="Get Details")
				{
					d.append("Team Name\t Points\t Rank\t \n");
					ArrayList<String> a = yes();
			        String[] item = a.toArray(new String[a.size()]);  
					for (String r:item)
					{
						d.append(r + "\n");
					}
					
				}
				else if(i=="Cancel")
				{
					f.dispose();
				}			
			}
		};
		a.setSize(100,100);
		p.add(a);
		d.setEditable(false);
		a.setEditable(false);
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
		f.setSize(300, 250);
		f.setVisible(true);
	 	
	
	}

	 public static ArrayList yes()
	  { 
		   
		 ArrayList<String> det = new ArrayList<String>();
		 try{  
				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","sime1999");  
		  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				
				String q  = "select team_name,points,rownum from rank";
				ResultSet rs=stmt.executeQuery(q);
				while(rs.next())
				{
					System.out.println(1);
					det.add(rs.getString(1)+"\t"+rs.getInt(2) +"\t"+rs.getInt(3));
				}
		  
		con.close();  
		
		  
		}catch(Exception e){ System.out.println(e);}  
		 
		 return det;
	  }
	
	public static void main(String[] args)
	{
		Fourth s1 = new Fourth();
		s1.login();
		Output r =new Output();
//		r.yes(s);
		
	}
}
