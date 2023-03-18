package Atm;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login extends JFrame implements ActionListener {

	static PreparedStatement ps;
	static ResultSet rs;
	static String name = "ATM";
	static Double balance;
	static String firstName;
	JLabel label1 = new JLabel("Enter card no.");
	JLabel label2 = new JLabel("Enter PIN");
	TextField card = new TextField();
	TextField pin = new TextField();
	Font myFont = new Font("Skia", 40, 40);


	static ArrayList<Acounts> Acount = new ArrayList<Acounts>();

	Login(String name) {

		label1.setBounds(200, 0, 100, 50);
		card.setBounds(140, 50, 200, 50);
		card.setFont(myFont);
		card.addActionListener(this);
		label2.setBounds(215, 100, 100, 50);
		pin.setBounds(140, 150, 200, 50);
		pin.setFont(myFont);
		pin.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(name);
		this.setSize(500, 500);
		this.setResizable(false);

		this.add(label1);
		this.add(card);
		this.add(label2);
		this.add(pin);

		this.setLayout(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {

		Login atm = new Login(name);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cN = card.getText();
		String pw = pin.getText();
		String sql = "SELECT * FROM accounts WHERE noCard = ? AND pin = ?";
		try {
			ps = Connect.getConnection().prepareCall(sql);

			ps.setString(1, cN); // username / cardNo
			ps.setString(2, pw); // password / pin
			rs = ps.executeQuery();

			if (rs.next()) {
				firstName= rs.getString(5);
				balance = rs.getDouble(3);
				welcome welcome = new welcome(name, Login.this);
				welcome.setLocation(this.getLocationOnScreen());
				this.setVisible(false);
				welcome.setVisible(true);
				System.out.println("1");
			} else {

				card.setText("");
				pin.setText("");

			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}
}
