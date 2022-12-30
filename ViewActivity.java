import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;




class ViewActivity extends JFrame
{
	Container c;
	TextArea taData;
	JButton btnBack;

	ViewActivity()
	{
		c =getContentPane();
		c.setLayout(new FlowLayout());
		taData = new TextArea(8 ,20);
		btnBack = new JButton("Back");


		Font f = new Font("Arial " , Font.BOLD , 30);
		btnBack.setFont(f);
		taData.setFont(f);
		
		c.add(btnBack);
		c.add(taData);
		
		
		ActionListener a1 = (ae) -> {
			MainActivity a = new MainActivity();
			dispose();
				
		};
		btnBack.addActionListener(a1);
		
	taData.setEditable(false);
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");


		SessionFactory sf = cfg.buildSessionFactory();
		Session s = null;
		

	
		try{
		 s = sf.openSession();
		System.out.println("connected");
		java.util.List<Employee> emp = new ArrayList<>();
		emp = s.createQuery("from Employee").list();
		String info  = " ";
		for(Employee e : emp)
			info = info + e + "\n";
		taData.setText(info);
		
		}
		
	
	catch (Exception e) {
		System.out.println("connected");
	}
	
	finally
{
	s.close();
	System.out.println("disconnected ");
	
	
	
}
	
	

		
		
	setTitle("View Page ");
	setSize(500 ,500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
}
	
