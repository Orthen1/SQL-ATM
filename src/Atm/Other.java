package Atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Other extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PreparedStatement ps;
	Font font = new Font("SANS_SERIF", 30, 30);
	JTextField text = new JTextField();
	JButton withdraw = new JButton("Withdraw");

	void upData() {
		String bal = String.valueOf(Login.balance);
		String id = String.valueOf(Login.accId);
		String sql = "update accounts set balance = ? where accId = ?";
		try {
			ps = Connect.getConnection().prepareStatement(sql);
			ps.setString(1, bal); // balance
			ps.setString(2, id); // id
			ps.execute();

		} catch (SQLException e1) {
			e1.printStackTrace();

		}
	}

	void ReturnScreen() {
		welcome welcome = new welcome("ATM", null);
		welcome.setLocation(this.getLocation());
		this.setVisible(false);
		welcome.setVisible(true);
		System.out.println("1");
	}

	Boolean limit() {

		if (Integer.parseInt(text.getText()) > Login.cardLimit) {
			return true;
		} else
			return false;
	}

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
			if ((Login.isCredit == false && limit() == false) || (Login.isCredit == false)) {
				if ((Login.balance - Double.parseDouble(text.getText())) == 0) {
					Login.balance -= Double.parseDouble(text.getText());
					upData();
					ReturnScreen();
				} else if (Login.balance - Double.parseDouble(text.getText()) < 0) {
					JOptionPane.showMessageDialog(text, "Nedostatok prostreidkov na ucte");
					ReturnScreen();
				} else if (Login.isCredit == false && limit() == true) {
					JOptionPane.showMessageDialog(text, "Precerpany limit");
					ReturnScreen();
				}
			}
			else if(Login.isCredit == true && limit() == true){
				JOptionPane.showMessageDialog(text, "Precerpany limit");
				ReturnScreen();
			}else {
				Login.balance -= Double.parseDouble(text.getText());
				upData();
				ReturnScreen();
			}
		}
	}
}