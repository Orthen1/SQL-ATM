package Atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Registration extends JFrame implements ActionListener {

	PreparedStatement ps;
	ResultSet rs;
	int isCredit;
	int Id;
	JLabel meno = new JLabel("Name:");
	JLabel priezvysko = new JLabel("Last Name:");
	JLabel pin = new JLabel("PIN:");
	JLabel limit = new JLabel("Limit:");
	JLabel passChec = new JLabel("PIN Check:");
	JTextField pinChec = new JTextField();
	JTextField name = new JTextField();
	JTextField lastName = new JTextField();
	JTextField pass = new JTextField();
	JTextField oneTimeLim = new JTextField();

	JButton submit = new JButton("Submit");

	JCheckBox credit = new JCheckBox("Credit");
	JCheckBox debit = new JCheckBox("Debit");

	String cardGen() {

		String[] nums = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String crdNo = "";

		for (int i = 0; i < 4; i++) {
			Random random = new Random();

			crdNo = crdNo + random.nextInt(nums.length);
		}

		return crdNo;

	}

	Boolean compPass() {
		String pin = pass.getText();
		String checPin = pinChec.getText();
		if (pin.equals(checPin)) {
			return true;
		} else {
			return false;

		}
	}

	public Registration(Login login) {

		meno.setBounds(50, 50, 50, 50);
		priezvysko.setBounds(50, 100, 100, 50);
		pin.setBounds(50, 150, 50, 50);
		passChec.setBounds(50, 200, 100, 50);
		limit.setBounds(50, 250, 100, 50);
		name.setBounds(120, 60, 200, 30);
		lastName.setBounds(120, 110, 200, 30);
		pass.setBounds(120, 160, 200, 30);
		pinChec.setBounds(120, 210, 200, 30);
		oneTimeLim.setBounds(120, 260, 200, 30);

		credit.setBounds(50, 300, 100, 50);
		credit.setBorderPainted(false);
		credit.addActionListener(this);
		credit.setVisible(true);

		debit.setBounds(150, 300, 100, 50);
		debit.setBorderPainted(false);
		debit.addActionListener(this);
		debit.setVisible(true);

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
		this.add(passChec);
		this.add(limit);
		this.add(name);
		this.add(lastName);
		this.add(pass);
		this.add(pinChec);
		this.add(oneTimeLim);
		this.add(submit);
		this.add(credit);
		this.add(debit);

		this.setLayout(null);
		this.setVisible(true);

		String count = "Select count(accId) as CountId from accounts";
		try {
			ps = Connect.getConnection().prepareCall(count);
			rs = ps.executeQuery();

			if (rs.next()) {
				Id = rs.getInt(1) + 1;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {
			if (compPass() == true) {
				String sql = "INSERT INTO `accounts`.`accounts` (`noCard`, `pin`, `balance`, `accId`, `FirstName`, `LastName`, `isCredit`, `cardLimit`) VALUES ('"
						+ cardGen() + "','" + pass.getText() + "', '5','" + Id + "', '" + name.getText() + "', '"
						+ lastName.getText() + "', '" + isCredit + "', '" + oneTimeLim.getText() + "');";
				try {
					ps = Connect.getConnection().prepareStatement(sql);
					ps.execute();
					System.out.println("Hell yea");
					Login login = new Login("ATM");
					login.setLocation(this.getLocationOnScreen());
					this.setVisible(false);
					login.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();

				}

			} else {
				JOptionPane.showMessageDialog(submit, "PIN sa nezhoduje");
				

			}
		}
		if (e.getSource() == debit) {
			if (debit.isSelected()) {
				credit.setEnabled(false);
				isCredit = 0;

			} else {
				credit.setEnabled(true);
			}

		}
		if (e.getSource() == credit) {
			if (credit.isSelected()) {
				debit.setEnabled(false);
				isCredit = 1;
			} else {
				debit.setEnabled(true);

			}
		}
	}
}
