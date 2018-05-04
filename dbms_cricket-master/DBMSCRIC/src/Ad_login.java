

import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Ad_login 
{
	public void create(String username,String password)
	{  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","sime1999");  
  
			PreparedStatement stmt=con.prepareStatement("insert into user_details"
					+ " values(?,?)");  
			stmt.setString(1,username);
			stmt.setString(2,password);
  
			stmt.executeUpdate();    
			
			
  
			con.close();  
			JOptionPane.showMessageDialog(null, "Insert Successfull");
  
}catch(Exception e){ JOptionPane.showMessageDialog(null, e); }  
  
}  
	public static void login()
	{
		JTextField t = new JTextField(20);
		JTextField t1 = new JTextField(20);
		JPasswordField p = new JPasswordField(20);
		JPanel panel = new JPanel();
		JFrame f = new JFrame("Login");
		panel.add(new JLabel("Email Id"));
		panel.add(t);
		panel.add(new JLabel("Password"));
		panel.add(p);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	    
		JPanel panel2 = new JPanel();
		JButton b2 = new JButton("LOGIN");
		JButton b3 = new JButton("RESET");
		panel2.add(b2);
		panel2.add(b3);
		
		JPanel panel3 = new JPanel();
		JButton b1 = new JButton("CREATE A ACCOUNT");
		panel3.add(b1);
		
		JPanel panel1 = new JPanel();
		panel1.add(panel);
		panel1.add(panel2);
		panel1.add(panel3);

		ActionListener l1 = new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				String i = e.getActionCommand();
				if(i=="LOGIN")
				{
					f.dispose();
					Secondscreen s=new Secondscreen();
					String username = t.getText().toString();
					System.out.println(username);
					String password  = p.getText().toString();
					new Login().create(username, password);
					//c.create(username,password);
					
					s.login();
				}
				else if(i=="RESET")
				{
					t.setText("");
					p.setText("");
				}
				if(i=="CREATE A ACCOUNT")
				{
					f.dispose();
					New1 n = new New1();
					n.create();
				}			
			}
		};

		f.add(panel1);
		b1.addActionListener(l1);
		b2.addActionListener(l1);
		b3.addActionListener(l1);
		f.setSize(300, 250);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		Ad_login l = new Ad_login();
		l.login();
	}

}
