package calorimeter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Exercise extends JFrame implements ActionListener {

	JLabel l1,l2;
	JComboBox c1;
	JButton b1;
	String weight;
	String username;


	Exercise(String username){
		this.username = username;

		l1 = new JLabel("Calorie Counter");
		l1.setFont(new Font("Raleway", Font.BOLD, 38));

		l2 = new JLabel("Speed:");
		l2.setFont(new Font("Raleway", Font.BOLD, 20));


	    String speed[] = {"Running, 5 mph (12 minute mile)",
	    		"Running, 5.2 mph (11.5 minute mile)",
	    		"Running, 6 mph (10 min mile)",
	    		"Running, 6.7 mph (9 min mile)",
	    		"Running, 7 mph (8.5 min mile)",
	    		"Running, 7.5mph (8 min mile)",
	    		"Running, 8 mph (7.5 min mile)",
	    		"Running, 8.6 mph (7 min mile)",
	    		"Running, 9 mph (6.5 min mile)",
	    		"Running, 10 mph (6 min mile)",
	    		"Running, 10.9 mph (5.5 min mile)"};
	    c1 = new JComboBox(speed);
	    c1.setBackground(Color.WHITE);
	    c1.setFont(new Font("Raleway", Font.BOLD, 14));



	    b1 = new JButton("Calculate");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway", Font.BOLD, 20));

        l1.setBounds(260,20,600,40);
        add(l1);


        l2.setBounds(220,190,200,30);
        add(l2);

        c1.setBounds(300, 190, 330, 30);
        add(c1);


        b1.setBounds(325,320,140,30);
        add(b1);;

        b1.addActionListener(this); 

        getContentPane().setBackground(Color.WHITE);

        setSize(840,830);
        setLocation(300,10);
        setVisible(true);

	}




public void actionPerformed(ActionEvent ae){
	try {

		Date date = new Date();
		String type = (String)c1.getSelectedItem(); 
	    int calorie = 0;



	    if(type == "Running, 5 mph (12 minute mile)") {
    	calorie = 472;
    }
        else if(type == "Running, 5.2 mph (11.5 minute mile)") {
    	calorie = 531;
    }
        else if(type == "Running, 6 mph (10 min mile)") {
    	calorie = 590;
    }
        else if(type == "Running, 6.7 mph (9 min mile)") {
    	calorie = 649;
    }
        else if(type == "Running, 7 mph (8.5 min mile)") {
    	calorie = 679;
    }
        else if(type == "Running, 7.5mph (8 min mile)") {
    	calorie = 738;
    }
        else if(type == "Running, 8 mph (7.5 min mile)") {
    	calorie = 797;
    }
        else if(type == "Running, 8.6 mph (7 min mile)") {
    	calorie = 826;
    }
        else if(type == "Running, 9 mph (6.5 min mile)") {
        	calorie = 885;
    }
        else if(type == "Running, 10 mph (6 min mile)") {
        	calorie = 944;
    }
        else if(type == "Running, 10.9 mph (5.5 min mile)") {
        	calorie = 1062;
    }

	   JOptionPane.showMessageDialog(null,"Calorie burned today: "+ calorie);
	   Conn conn = new Conn();

	   String q1 = "insert into exercise values('"+username+"','"+type+"','"+calorie+"','"+date+"')";	   
       conn.s.executeUpdate(q1);



	}



	catch(Exception e){
		e.printStackTrace();
	}

	}


	public static void main(String[] args) {
		new Exercise("").setVisible(true);

	}
}

