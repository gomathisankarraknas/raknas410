import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sixth
{
	private static String s;
	static JComboBox<String> file = new JComboBox<String>();	

	public static void login()
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
			file.addItem(rs.getString(1));  
	  
	//step5 close the connection object  
	con.close();  
	  
	}catch(Exception e){ System.out.println(e);} 
		
		JFrame f = new JFrame();
		
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JButton b1 = new JButton("Get Details");
		JButton b2 = new JButton("Cancel");
		JTextArea a = new JTextArea("Enter The Name");
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
				
					String s = (String)file.getSelectedItem();
					String details = new Sixth().yes(s);
					d.setText("Role Name\t  Position no        \n");
					d.append("---------------------------------------------------------------------------\n");
					d.append(details);
					
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
		p.add(file);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		

		panel2.add(b1);
		panel2.add(b2);
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
		
		panel.add(p);
		panel.add(d);
		panel.add(panel2);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		
		
		f.add(panel);
		//f.setContentPane(new JLabel(new ImageIcon("F:\\id\\top.jpg")));
		b1.addActionListener(l1);
		b2.addActionListener(l1);
		f.setSize(300, 200);
		f.setVisible(true);
	 	
	
	}

	 public String yes(String name)
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
				
				
				String query = "select role_name,position_no from role where player_id in (select player_id from player where player_name = '" + name + "')";  
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				det =  rs.getString(1)+"\t"+rs.getInt(2);			
		  
		con.close();  
		
		  
		}catch(Exception e){ System.out.println(e);}  
		 
		 return det;
	  }
	
	public static void main(String[] args)
	{
		Sixth s6 = new Sixth();
		s6.login();
		Output r =new Output();
//		r.yes(s);
		
	}
		
}
