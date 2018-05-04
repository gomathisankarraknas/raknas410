import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Navigation 
{
	public void login()
	{
		
		JButton ss =new JButton("Player Details");
		JButton fun =new JButton("Player Comparison");
		JButton third =new JButton("Player Records");
		JButton fourth =new JButton("ICC Rank");
		JButton fifth =new JButton("Coach Details");
		JButton sixth =new JButton("role");
		JPanel p = new JPanel();
		p.add(ss);
		p.add(fun);
		p.add(third);
		p.add(fourth);
		p.add(fifth);
		p.add(sixth);
		
		JFrame f = new JFrame();
		f.add(p);
		
		 ActionListener l1 = new ActionListener() 
			{
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{	
					String i = e.getActionCommand();
					if(i=="Player Details")
					{
						Secondscreen s = new Secondscreen();
						s.login();
						f.dispose();
					}
					else if(i=="Player Comparison")
					{
						Function f3 = new Function();
						f3.login();
						f.dispose();
					}			
					else if(i=="ICC Rank")
					{
						Fourth f1 = new Fourth();
						f1.login();
						f.dispose();
					}			
					else if(i=="Player Records")
					{
						Third f2 = new Third();
						f2.login();
							f.dispose();
					}			
					else if(i=="Coach Details")
					{
						Fifth f4 = new Fifth();
						f4.login();
						   f.dispose();
					}			
					else if(i=="role")
					{
						Sixth f6 = new Sixth();
						f6.login();
			f.dispose();
					}			
					
					
					
				}
			};
			
			ss.addActionListener(l1);
			fun.addActionListener(l1);
			third.addActionListener(l1);
			fourth.addActionListener(l1);
			fifth.addActionListener(l1);
			sixth.addActionListener(l1);

			f.setSize(300,200);
			f.setVisible(true);
		
		
	}

}
