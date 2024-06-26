package Atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps;

	Font font = new Font("SANS_SERIF", 30, 30);
	JTextField text = new JTextField();
	JButton deposit = new JButton("Deposit");

	public Deposit() {
		text.setBounds(40, 40, 400, 50);
		text.setFont(font);

		deposit.addActionListener(this);
		deposit.setBackground(new Color(123, 122, 121));
		deposit.setBounds(135, 100, 200, 50);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ATM");
		this.setSize(500, 500);
		this.setResizable(false);

		this.add(deposit);
		this.add(text);
		this.setLayout(null);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == deposit) {
			Login.balance += Double.parseDouble(text.getText());
			String bal = String.valueOf(Login.balance);
			String id = String.valueOf(Login.accId);
			String sql = "update accounts set balance = ? where accId = ?";
			try {
				ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, bal); // balance
				ps.setString(2, id); // id
				ps.execute();

				
				welcome welcome = new welcome("ATM", null);
				welcome.setLocation(this.getLocation());
				this.setVisible(false);
				welcome.setVisible(true);
				System.out.println("1");

			} catch (SQLException e1) {
				e1.printStackTrace();

			}

		}
	}
}
