package Atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Other extends JFrame implements ActionListener{
	Font font = new Font("SANS_SERIF", 30, 30);
	JTextField text = new JTextField();
	JButton withdraw = new JButton("Withdraw");

	public Other() {
		text.setBounds(40, 40, 400, 50);
		text.setFont(font);

		withdraw.addActionListener(this);
		withdraw.setBackground(new Color(123, 122, 121));
		withdraw.setBounds(135, 100, 200, 50);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ATM");
		this.setSize(500, 500);
		this.setResizable(false);

		this.add(withdraw);
		this.add(text);
		this.setLayout(null);
		this.setVisible(true);

	}

	@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == withdraw) {
				Login.balance -= Double.parseDouble(text.getText());

				welcome welcome = new welcome("ATM", null);
				welcome.setLocation(this.getLocation());
				this.setVisible(false);
				welcome.setVisible(true);
			}

		
	}
}