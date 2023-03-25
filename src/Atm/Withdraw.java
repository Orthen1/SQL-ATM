package Atm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Withdraw extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PreparedStatement ps;
	JButton[] withBut = new JButton[7];
	JButton ten;
	JButton twenty;
	JButton fifty;
	JButton hundred;
	JButton twohundred;
	JButton threehundred;
	JButton other;

	JPanel panel = new JPanel();

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

	void RetrunScreen() {
		welcome welcome = new welcome("ATM", null);
		welcome.setLocation(this.getLocation());
		this.setVisible(false);
		welcome.setVisible(true);
		System.out.println("1");
	}

	Boolean isDebit(String typeOfCard) {
		if (typeOfCard == "debit") {
			return true;
		} else {
			return false;
		}

	}

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
		String debit = "debit";
		if (e.getSource() == ten) {
			if (Login.isCredit == false) {
				System.out.println(Login.isCredit);
				if (Login.balance - 10 == 0) {
					Login.balance -= 10;
					upData();
					RetrunScreen();
				} else if (Login.balance - 10 < 0) {
					JOptionPane.showMessageDialog(ten, "Nedostatok prostreidkov na ucte");
					RetrunScreen();
				}

			} else {
				Login.balance -= 10;
				upData();

			}

		}
		if (e.getSource() == twenty) {
			if (Login.isCredit == false) {
				System.out.println(Login.isCredit);
				if (Login.balance - 20 == 0) {
					Login.balance -= 20;
					upData();
					RetrunScreen();
				} else if (Login.balance - 20 < 0) {
					JOptionPane.showMessageDialog(twenty, "Nedostatok prostreidkov na ucte");
					RetrunScreen();
				}

			} else {
				Login.balance -= 20;
				upData();

			}
		}
		if (e.getSource() == fifty) {
			if (Login.isCredit == false) {
				System.out.println(Login.isCredit);
				if (Login.balance - 50 == 0) {
					Login.balance -= 50;
					upData();
					RetrunScreen();
				} else if (Login.balance - 50 < 0) {
					JOptionPane.showMessageDialog(fifty, "Nedostatok prostreidkov na ucte");
					RetrunScreen();
				}

			} else {
				Login.balance -= 50;
				upData();

			}
		}
		if (e.getSource() == hundred) {
			if (Login.isCredit == false) {
				System.out.println(Login.isCredit);
				if (Login.balance - 100 == 0) {
					Login.balance -= 100;
					upData();
					RetrunScreen();
				} else if (Login.balance - 100 < 0) {
					JOptionPane.showMessageDialog(hundred, "Nedostatok prostreidkov na ucte");
					RetrunScreen();
				}

			} else {
				Login.balance -= 100;
				upData();

			}
		}
		if (e.getSource() == twohundred) {
			if (Login.isCredit == false) {
				System.out.println(Login.isCredit);
				if (Login.balance - 200 == 0) {
					Login.balance -= 200;
					upData();
					RetrunScreen();
				} else if (Login.balance - 200 < 0) {
					JOptionPane.showMessageDialog(twohundred, "Nedostatok prostreidkov na ucte");
					RetrunScreen();
				}

			} else {
				Login.balance -= 100;
				upData();
				
			}
		}
		if (e.getSource() == threehundred) {
			if (Login.isCredit == false) {
				System.out.println(Login.isCredit);
				if (Login.balance - 300 == 0) {
					Login.balance -= 300;
					upData();
					RetrunScreen();
				} else if (Login.balance - 300 < 0) {
					JOptionPane.showMessageDialog(threehundred, "Nedostatok prostreidkov na ucte");
					RetrunScreen();
				}

			} else {
				Login.balance -= 300;
				upData();

			}
			// System.exit(1);
		}

		if (e.getSource() == other) {
			Other ine = new Other();
			this.setVisible(false);
			ine.setLocation(this.getLocation());
		}
	}
}
