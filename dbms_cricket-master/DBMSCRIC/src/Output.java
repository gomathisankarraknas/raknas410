import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Output
{
	JPanel panel = new JPanel();
  public void yes(String name)
  { 
	  
	  JTextArea a = new JTextArea();
	 try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","sime1999");  
	  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			
			
			String query = "select player_name,age,height from player where player_name = '" + name + "'";  
			ResultSet rs=stmt.executeQuery(query);  
			
			a.setText("Player Name\tPlayer Age\tPlayer Height           \n");
			a.append("-------------------------------------------------------------------------\n");
		while(rs.next())  
			a.append( rs.getString(1)+"\t"+rs.getInt(2) +"\t"+rs.getInt(3));			
		a.setEditable(false);
		a.setForeground(Color.BLACK);
		a.setBackground(Color.white);
	//step5 close the connection object  
	con.close();  
	  
	}catch(Exception e){ System.out.println(e);}  
	  
	 	panel.add(a);
	  	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JOptionPane.showConfirmDialog(panel, panel,   "Player details",JOptionPane.DEFAULT_OPTION);
  }
}
