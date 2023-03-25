package Atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Atm.Login;

public class Balance extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label = new JLabel();
	JButton Return = new JButton("return");
	Font font = new Font("SANS_SERIF", 30, 30);
	

	public Balance(welcome welcome) {
		label.setFont(font);
		label.setBounds(180, 100, 500, 50);
		label.setText(String.valueOf( Login.balance + " €"));

		Return.setBounds(350, 400, 100, 50);
		Return.setBackground(new Color(123, 122, 121));
		Return.setVisible(true);
		Return.addActionListener(this);
 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ATM");
		this.setSize(500, 500);
		this.setResizable(false);
		this.add(label);
		this.add(Return);

		this.setLayout(null);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == Return) {
			welcome welcome = new welcome("ATM", null);
			this.setVisible(false);
			welcome.setLocation(this.getLocation());
			welcome.setVisible(true);

		}

	}

}
