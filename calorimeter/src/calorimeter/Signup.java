  
package calorimeter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup extends JFrame implements ActionListener {

	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3;
	JButton b;

	Signup(){

		setFont(new Font ("System",Font.BOLD,22));

		l1 = new JLabel("CALORIMETER");
		l1.setFont(new Font ("Raleway",Font.BOLD,38));

		l2 = new JLabel("Personal Details ");
		l2.setFont(new Font ("Raleway",Font.BOLD,22));

		l3 = new JLabel("Username:");
		l3.setFont(new Font ("Raleway",Font.BOLD,20));

		l4 = new JLabel("Age:");
		l4.setFont(new Font ("Raleway",Font.BOLD,20));

		l5 = new JLabel("Weight:");
		l5.setFont(new Font ("Raleway",Font.BOLD,20));

		t1 = new JTextField();
		t1.setFont(new Font("Raleway",Font.BOLD,14));

		t2 = new JTextField();
		t2.setFont(new Font("Raleway",Font.BOLD,14));

		t3 = new JTextField();
		t3.setFont(new Font("Raleway",Font.BOLD,14));


		b = new JButton("Create Account");
		b.setFont(new Font("Raleway",Font.BOLD,14));
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);


		setLayout(null);

        l1.setBounds(260,20,600,40);
        add(l1);

        l2.setBounds(320,80,600,30);
        add(l2);

        l3.setBounds(100,140,200,30);
        add(l3);

        t1.setBounds(220,140,400,30);
        add(t1);

        l4.setBounds(100,190,200,30);
        add(l4);

        t2.setBounds(220,190,400,30);
        add(t2);

        l5.setBounds(100,240,200,30);
        add(l5);


        t3.setBounds(220,240,400,30);
        add(t3);


        b.setBounds(320,320,150,30);
        add(b);

        b.addActionListener(this); 

        getContentPane().setBackground(Color.WHITE);

        setSize(840,830);
        setLocation(300,10);
        setVisible(true);
	}	

	public void actionPerformed(ActionEvent ae) {

        String username = t1.getText();
        String age = t2.getText();
        String weight = t3.getText();


        try {
        	if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Fill all the required fields");
        	}
        	else{
        		 Conn c1 = new Conn();
                 ResultSet r1 = c1.s.executeQuery("select * from personal_details where username = '"+username+"' ");

                 if(r1.next()){
                	 JOptionPane.showMessageDialog(null,"username already used!");
                 }
                 else {
                	 Random ran = new Random();
                	 long first3 = (ran.nextLong() % 9000L) + 1000L;
                     String pin = "" + Math.abs(first3);

             		Conn conn = new Conn();
             		String q1 = "insert into personal_details values('"+username+"','"+age+"','"+weight+"','"+pin+"')";
             		conn.s.executeUpdate(q1);
             		JOptionPane.showMessageDialog(null, "Account created"+ "Card Number: " + username + "\n Pin:"+ pin);
             		setVisible(false);
             		new MenuPage(username).setVisible(true);

             	}
        	}



        }
        catch(Exception e){
        	e.printStackTrace();
        }


	}





	public static void main(String[] args) {
		new Signup().setVisible(true);

	}

}
