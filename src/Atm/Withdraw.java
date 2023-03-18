package Atm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Withdraw extends JFrame implements ActionListener {

	JButton[] withBut = new JButton[7];
	JButton ten;
	JButton twenty;
	JButton fifty;
	JButton hundred;
	JButton twohundred;
	JButton threehundred;
	JButton other;

	JPanel panel = new JPanel();

	public Withdraw() {
		ten = new JButton("10");
		twenty = new JButton("20");
		fifty = new JButton("50");
		hundred = new JButton("100");
		twohundred = new JButton("200");
		threehundred = new JButton("300");
		other = new JButton("Other");

		withBut[0] = ten;
		withBut[1] = twenty;
		withBut[2] = fifty;
		withBut[3] = hundred;
		withBut[4] = twohundred;
		withBut[5] = threehundred;
		withBut[6] = other;

		for (int i = 0; i < 7; i++) {
			withBut[i].setVisible(true);
			withBut[i].setBackground(new Color(123, 122, 121));
			withBut[i].addActionListener(this);

		}

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ATM");
		this.setSize(500, 500);
		this.setResizable(false);

		panel.setBounds(10, 20, 465, 400);
		panel.setLayout(new GridLayout(4, 2, 50, 30));
		panel.add(ten);
		panel.add(hundred);
		panel.add(twenty);
		panel.add(twohundred);
		panel.add(fifty);
		panel.add(threehundred);
		panel.add(other);

		this.add(panel);

		this.setLayout(null);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ten) {
			Login.balance -= 10;
			welcome welcome = new welcome("ATM", null);
			this.setVisible(false);
			welcome.setLocation(this.getLocation());
		}
		if (e.getSource() == twenty) {
			Login.balance -= 20;
			welcome welcome = new welcome("ATM", null);
			this.setVisible(false);
			welcome.setLocation(this.getLocation());
		}
		if (e.getSource() == fifty) {
			Login.balance -= 50;
			welcome welcome = new welcome("ATM", null);
			this.setVisible(false);
			welcome.setLocation(this.getLocation());
		}
		if (e.getSource() == hundred) {
			Login.balance -= 100;
			welcome welcome = new welcome("ATM", null);
			this.setVisible(false);
			welcome.setLocation(this.getLocation());
		}
		if (e.getSource() == twohundred) {
			Login.balance -= 200;
			welcome welcome = new welcome("ATM", null);
			this.setVisible(false);
			welcome.setLocation(this.getLocation());
		}
		if (e.getSource() == threehundred) {
			Login.balance -= 300;
			welcome welcome = new welcome("ATM", null);
			this.setVisible(false);
			welcome.setLocation(this.getLocation());
			// System.exit(1);
		}

		if (e.getSource() == other) {
			Other ine = new Other();
			this.setVisible(false);
			ine.setLocation(this.getLocation());
		}
	}
}
