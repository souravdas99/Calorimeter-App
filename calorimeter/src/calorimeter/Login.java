package calorimeter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	JLabel l0, l1, l2, l3;
	JTextField tf1;
	JPasswordField pf1;
	JButton b1, b2, b3;

	Login() {

		setTitle("LOGIN PAGE");

		l1 = new JLabel("CALORIMETER");
		l1.setFont(new Font("Osward", Font.BOLD, 38));

		l2 = new JLabel("Username:");
		l2.setFont(new Font("Raleway", Font.BOLD, 28));

		l3 = new JLabel("PIN:");
		l3.setFont(new Font("Raleway", Font.BOLD, 28));

		tf1 = new JTextField(15);
		pf1 = new JPasswordField(15);

		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2 = new JButton("CLEAR");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		b3 = new JButton("SIGN UP");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);

		setLayout(null);

		l1.setBounds(200, 40, 450, 40);
		add(l1);

		l2.setBounds(125, 145, 375, 30);
		add(l2);

		l3.setBounds(125, 130, 375, 200);
		add(l3);

		tf1.setFont(new Font("Arial", Font.BOLD, 14));
		tf1.setBounds(270, 150, 230, 30);
		add(tf1);

		pf1.setFont(new Font("Arial", Font.BOLD, 14));
		pf1.setBounds(270, 220, 230, 30);
		add(pf1);

		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.setBounds(270, 300, 100, 30);
		add(b1);

		b2.setFont(new Font("Arial", Font.BOLD, 14));
		b2.setBounds(400, 300, 100, 30);
		add(b2);

		b3.setFont(new Font("Arial", Font.BOLD, 14));
		b3.setBounds(270, 350, 230, 30);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);

		setSize(840,830);
        setLocation(300,10);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		try {
			if (ae.getSource() == b1) {
				Conn c1 = new Conn();
				String username = tf1.getText();
				String pin = pf1.getText();
				String q = "select * from personal_details where username = '" + username + "' and pin = '" + pin + "'";
				ResultSet rs = c1.s.executeQuery(q);
				if (rs.next()) {
					setVisible(false);
					 new MenuPage(username).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Username or PIN");
				}
			} else if (ae.getSource() == b2) {
				tf1.setText("");
				pf1.setText("");
			} else if (ae.getSource() == b3) {
				setVisible(false);
				new Signup().setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Login().setVisible(true);

	}

}
