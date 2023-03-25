package Atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Registration extends JFrame implements ActionListener {
	
	JLabel meno = new JLabel("Name:");
	JLabel priezvysko = new JLabel("Last Name:");
	JLabel pin = new JLabel("PIN");
	JTextField name = new JTextField();
	JTextField lastName = new JTextField();
	JTextField pass = new JTextField();
	
	
	JButton submit = new JButton("Submit");
	
	

	public Registration(Login login) {
		
		meno.setBounds(50,50,50,50);
		priezvysko.setBounds(50,100,100,50);
		pin.setBounds(50,150,50,50);
		name.setBounds(120,60,200,30);
		lastName.setBounds(120,110,200,30);
		pass.setBounds(120,160,200,30);
		
		submit.setBounds(190, 400, 100, 20);
		submit.setVisible(true);
		submit.addActionListener(this);
		submit.setFocusable(false);
		submit.setContentAreaFilled(false);
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Registration");
		this.setSize(500, 500);
		this.setResizable(false);
		
		this.add(meno);
		this.add(priezvysko);
		this.add(pin);
		this.add(name);
		this.add(lastName);
		this.add(pass);
		this.add(submit);
		this.setLayout(null);
		this.setVisible(true);

		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
