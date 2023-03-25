package Atm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Atm.Login;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class welcome extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String accName = Login.firstName;
	JLabel hello = new JLabel();
	JButton[] butArr = new JButton[4];
	JPanel panel = new JPanel();

	JButton balance;
	JButton withdraw;
	JButton deposit;
	JButton exit;

	public welcome(String name, Login login) {
		
		balance = new JButton("Balance");
		withdraw = new JButton("Withdraw");
		deposit = new JButton("Deposit");
		exit = new JButton("Exit");
		
		butArr[0] = balance;
		butArr[1] = withdraw;
		butArr[2] = deposit;
		butArr[3] = exit;
		
		for(int i = 0 ; i < 4; i++) {
			butArr[i].setSize(100,50);
			butArr[i].setBackground(new Color(123, 122, 121));
			butArr[i].setForeground(getBackground());
			butArr[i].addActionListener(this);
			butArr[i].setFocusable(false);
			
		}
		
		hello.setText("Welcome " + accName );
		hello.setBounds(200, 5, 500, 20);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(name);
		this.setSize(500, 500);
		this.setResizable(false);
		
		panel.setBounds(30, 70, 420, 250);
		panel.setLayout(new GridLayout(2, 2, 50, 50));
		panel.add(butArr[0]);
		panel.add(butArr[1]);
		panel.add(butArr[2]);
		panel.add(butArr[3]);
		
		
		this.add(hello);
		this.add(panel);

		this.setLayout(null);
		this.setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == balance) {
			
			Balance balanCe = new Balance(welcome.this);
			balanCe.setLocation(this.getLocation());
			this.setVisible(false);
			balanCe.setVisible(true);

		}
		if(e.getSource()==exit) {
		System.exit(1);
		
		}
		if(e.getSource() == withdraw) {
			Withdraw withDraw = new Withdraw();
			withDraw.setLocation(this.getLocation());
			this.setVisible(false);
			withDraw.setVisible(true);
		}
		if(e.getSource() == deposit) {
			Deposit Deposit = new Deposit();
			Deposit.setLocation(this.getLocation());
			this.setVisible(false);
			Deposit.setVisible(true);
		}
	}
}
