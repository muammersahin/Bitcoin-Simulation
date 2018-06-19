import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	String mail;
	private final JLabel lblUser = new JLabel("Username");

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MainGUI(String mail) {
		
		this.mail = mail;
		
		lblUser.setText("Mail address: " + mail);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 377);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("SEND MONEY");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SendMoney sm = new SendMoney(mail);
				sm.setVisible(true);
			}
		});
		btnAdd.setBounds(25, 268, 127, 23);
		contentPane.add(btnAdd);
		
		JLabel lblCointrexx = new JLabel("CoinTrexx");
		lblCointrexx.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblCointrexx.setBounds(25, 7, 114, 38);
		contentPane.add(lblCointrexx);
		
		JButton btnLogIn = new JButton("EXIT");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnLogIn.setBounds(481, 19, 89, 23);
		contentPane.add(btnLogIn);
		
		JButton btnSignUp = new JButton("MINE");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MinerFrame mf = new MinerFrame(mail);
				mf.setVisible(true);
			}
		});
		btnSignUp.setBounds(494, 268, 89, 23);
		contentPane.add(btnSignUp);
		
		JLabel JLabel2 = new JLabel("");
		JLabel2.setBounds(25, 15, 114, 38);
		ImageIcon icon = new ImageIcon("/src/photos/coin.jpg");
		JLabel2.setIcon(icon);
		//JLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Cointrex/src/photos/coin.jpg")));
		contentPane.add(JLabel2);
		
		JTextArea txtrA = new JTextArea();
		txtrA.setText(DB.getBtcIndex()+"$");
		txtrA.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		txtrA.setBounds(268, 107, 184, 38);
		contentPane.add(txtrA);
		
		JLabel lblCurrentBalence = new JLabel("CURRENT BALANCE OF BTC");
		lblCurrentBalence.setBounds(73, 107, 172, 38);
		contentPane.add(lblCurrentBalence);
		
		JLabel lblYourBalance = new JLabel("YOUR BALANCE");
		lblYourBalance.setBounds(73, 190, 172, 16);
		contentPane.add(lblYourBalance);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(DB.getBalance(mail)+" BTC");
		textArea.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		textArea.setBounds(268, 179, 184, 38);
		contentPane.add(textArea);
		lblUser.setBounds(25, 58, 534, 36);
		contentPane.add(lblUser);
		
		
		
	}
}
