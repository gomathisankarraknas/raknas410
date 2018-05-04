

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class New1
{
	public void insert(String username,String password,String num3)
	{  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","sime1999");  
  
			PreparedStatement stmt=con.prepareStatement("insert into register"
					+ " values(?,?,?)");  
			stmt.setString(1,username);
			stmt.setString(2,password);
			stmt.setString(3, num3);
  
			int i=stmt.executeUpdate();    
  
			con.close();  
			JOptionPane.showMessageDialog(null, "Insert Successfull");
  
}catch(Exception e){ JOptionPane.showMessageDialog(null, e); }  
}  
	public void create()
	{
		JTextField name = new JTextField(10);
		JTextField age = new JTextField(10);
		JTextField dob = new JTextField("DD/MM/YYYY");
		JTextField email = new JTextField("example@gmail.com");
		JTextField username = new JTextField(10);
		JPasswordField pass = new JPasswordField(10);
		JPasswordField cpass = new JPasswordField(10);
		JButton otp = new JButton("Send Otp");
		JTextField totp = new JTextField(20);
		
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("Name"));
		panel.add(name);
		panel.add(new JLabel("Email"));
		panel.add(email);
		panel.add(otp);
		panel.setMaximumSize(new Dimension(200, 140));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    
		
		JPanel panel1 = new JPanel();
		JButton ok = new JButton("OK");
		JButton clear = new JButton("CLEAR");
	//	JPanel panelc  = new JPanel();
	//	panelc.add(clear);
		panel1.add(new JLabel("Otp"));
	//	totp.add(ok);
		panel1.add(totp);
//		panel1.add(panelc,BoxLayout.LINE_AXIS);
		panel1.add(ok);
		panel1.add(new JLabel("password"));
		panel1.add(pass);
		panel1.add(new JLabel("Confirm Password"));
		panel1.add(cpass);
		panel1.setMaximumSize(new Dimension(200, 150));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	    
	    JButton create = new JButton("CREATE");
	    JPanel panel3 = new JPanel();
		panel3.add(create);
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));



		 JButton reset = new JButton("RESET");
		    JPanel panel5 = new JPanel();
		    panel5.add(reset);
		    
		
		
		JFrame f = new JFrame("Create");
		JPanel panel2 = new JPanel();
		panel2.add(panel);
		panel2.add(panel1);
		panel2.add(panel3);
		panel2.add(panel5);
		panel2.setMaximumSize(new Dimension(200, 150));
	    panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));	   

	    
	    
	    ActionListener l1 = new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				String i = e.getActionCommand();
				if(i=="Send Otp")
				{
					
					Send s = new Send();
					Otp o = new Otp();
					int k = o.ran();
					String sk = Integer.toString(k);
					s.send("OTP VERIFICATION",email.getText() ,sk);
					if(sk == otp.getText())
					{
						JTextArea t = new JTextArea();
						t.setText("OTP IS CORRECT");
						t.setEditable(false);
						panel.add(t);
						
					}
					else
					{
						
					}

				}
				if(i=="CREATE")
				{
					
					String nam = name.getText().toString();
					String em = email.getText().toString();
					String password = pass.getText().toString();
					String cpassword  = cpass.getText().toString();
					pass.show();
					if(!password.equals(cpassword))
					{
						JOptionPane.showMessageDialog(null, "Password Incorrect");
					}
					else
					{
						new New1().insert(nam,em,password);
					}
					
					Login l = new Login();
					l.login();
				}
				else if(i=="RESET")
				{
					name.setText("");
					age.setText("");
					email.setText("");
					totp.setText("");
					username.setText("");
					pass.setText("");
					cpass.setText("");
				}
				
			}
		};

	     
		f.add(panel2);
		reset.addActionListener(l1);
		otp.addActionListener(l1);
		create.addActionListener(l1);
		f.setSize(400,450);
		f.setVisible(true);
	}
}

public class New 
{
	public static void main(String[] args)
	{
		New1 n = new New1();
		n.create();
	}
}