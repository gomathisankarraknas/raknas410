import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ad_insert
{
	
	static JFrame f = new JFrame();
	JButton Update = new JButton("Update");
	JButton Cancel = new JButton("Cancel");
	JPanel top_panel_tot = new JPanel();
	JLabel d = new JLabel("Cric Stat");
	JLabel dspace = new JLabel("             ");
	JTextField runs_scored = new JTextField();
	JTextField wickets = new JTextField();
	JTextField balls_faced = new JTextField();
	JTextField not_out = new JTextField();
	JTextField runs_given = new JTextField();
	static JComboBox<String> file = new JComboBox<String>();
	
	
	 public void yes(String name)
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
				
				
				String query = "update stats set  "  
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				det =  rs.getString(1)+"\t"+rs.getInt(2) +"\t"+rs.getInt(3);			
		  
		con.close();  
		
		  
		}catch(Exception e){ System.out.println(e);}  
		 
		 	  }
	
	public void insert()
	{
		in_or_up();
		 //Top and player name Panel
		   d.setFont(new Font("",Font.PLAIN,50));
		   d.setForeground(Color.blue);
		   d.setBackground(Color.green);
		   JPanel temp = new JPanel();
		   temp.add(d);
		   file.setPreferredSize(new Dimension(1,25));
		   //temp.add(file);
		   file.setMaximumSize(new Dimension(300, 25));
		   temp.setLayout(new BoxLayout(temp,BoxLayout.Y_AXIS));
		   
		   //input Panel
		   JPanel temp1 = new JPanel();
           temp1.setBorder(new EmptyBorder(2, 3, 2, 3));
           temp1.add(file);
		   temp1.add(new JLabel("   "));
		   temp1.add(new JLabel("Scored Runs"));
		   temp1.add(runs_scored);
		  
		   temp1.add(new JLabel("Wickets"));
		   temp1.add(wickets);
		   
		   temp1.add(new JLabel("Balls Faced"));
		   temp1.add(balls_faced);
		   
		   temp1.add(new JLabel("Not Out"));
		   temp1.add(not_out);
		   
		    temp1.add(new JLabel("Runs Given"));
		   temp1.add(runs_given);
		   temp1.setMaximumSize(new Dimension(200, 250));
		   temp1.setLayout(new BoxLayout(temp1,BoxLayout.Y_AXIS));
		   
		   //Button Panel
		   JPanel temp2 = new JPanel();
		   temp2.add(Update);
		   temp2.add(Cancel);
		   temp2.setLayout(new BoxLayout(temp2,BoxLayout.X_AXIS));
		   
		   //Button,Top,Player total
		   top_panel_tot.add(temp);
		   //dspace.setFont(new Font("     ",Font.PLAIN,10));
		   top_panel_tot.add(dspace);
		   top_panel_tot.add(temp1);
		   top_panel_tot.add(dspace);
		   top_panel_tot.add(temp2);
		   top_panel_tot.setLayout(new BoxLayout(top_panel_tot, BoxLayout.Y_AXIS));
		  
		 //Total Frame 
		 f.add(top_panel_tot);
		 f.setSize(300,450);
		 f.setVisible(true);
		 
		
		
		 
		 //Onclik
		 ActionListener l1 = new ActionListener() 
			{
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{	
					String i = e.getActionCommand();
					if(i=="Update")
					{
					
						String s = (String)file.getSelectedItem();
						System.out.print(s);
											
					}
					else if(i=="Cancel")
					{
						f.dispose();
					}			
				}
			};
			
			Update.addActionListener(l1);
			Cancel.addActionListener(l1);

	}
	
	public static void in_or_up()
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
		
	}
	
	public static void main(String[] args)
	{
		Ad_insert a= new Ad_insert();
		a.insert();
	}
}
