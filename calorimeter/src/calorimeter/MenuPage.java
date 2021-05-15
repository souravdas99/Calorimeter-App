package calorimeter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MenuPage extends JFrame implements ActionListener{

	JLabel l1;
	JButton b1,b2,b3,b4;
	String username;

	MenuPage( String username){
		this.username = username;


	l1 = new JLabel("MENU PAGE");
	l1.setFont(new Font("Osward", Font.BOLD, 38));

	b1 = new JButton("Calculate Calorie");
	b1.setBackground(Color.BLACK);
	b1.setForeground(Color.WHITE);

	b2 = new JButton("Delete Account");
	b2.setBackground(Color.BLACK);
	b2.setForeground(Color.WHITE);

	b3 = new JButton("Delete Last Exercise");
	b3.setBackground(Color.BLACK);
	b3.setForeground(Color.WHITE);

	b4 = new JButton("Exit");
	b4.setBackground(Color.BLACK);
	b4.setForeground(Color.WHITE);

	setLayout(null);

	l1.setBounds(270, 40, 450, 40);
	add(l1);

	b1.setFont(new Font("Arial", Font.BOLD, 15));
	b1.setBounds(170, 250, 200, 50);
	add(b1);

	b2.setFont(new Font("Arial", Font.BOLD, 15));
	b2.setBounds(430, 250, 200, 50);
	add(b2);

	b3.setFont(new Font("Arial", Font.BOLD, 15));
	b3.setBounds(170, 350, 200, 50);
	add(b3);

	b4.setFont(new Font("Arial", Font.BOLD, 15));
	b4.setBounds(430, 350, 200, 50);
	add(b4);

	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);

	getContentPane().setBackground(Color.WHITE);

	setSize(840,830);
    setLocation(300,10);
	setVisible(true);


	}



	public void actionPerformed(ActionEvent ae){
		try {
			if(ae.getSource() == b1) {
				setVisible(false);
				new Exercise(username).setVisible(true);

			}
			else if(ae.getSource() == b2) {

				Conn conn1 = new Conn();
    			String q2 = "delete from personal_details where username = '"+username+"'";
    			boolean rs2 = conn1.s.execute(q2);
    			JOptionPane.showMessageDialog(null, "Account Deleted!");

			}

            else if(ae.getSource() == b3) {

        			Conn conn2 = new Conn();
        			String q4 = "delete from exercise where username = '"+username+"'";
        			boolean rs4 = conn2.s.execute(q4);
        			JOptionPane.showMessageDialog(null, "Last Exercise Deleted!");

            }

            else if(ae.getSource() == b4) {

            	System.exit(0);

			}

          }			


		catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new MenuPage("").setVisible(true);


	}

}
