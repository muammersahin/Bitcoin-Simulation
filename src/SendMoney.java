import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendMoney extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String mail;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SendMoney(String mail) {
		this.mail = mail;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterMalAddress = new JLabel("ENTER MAIL ADDRESS OF USER");
		lblEnterMalAddress.setBounds(12, 38, 184, 16);
		contentPane.add(lblEnterMalAddress);
		
		textField = new JTextField();
		textField.setBounds(210, 35, 216, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterAmount = new JLabel("ENTER AMOUNT");
		lblEnterAmount.setBounds(12, 69, 176, 16);
		contentPane.add(lblEnterAmount);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(210, 66, 216, 22);
		contentPane.add(textField_1);
		
		JLabel lblYourBalance = new JLabel("YOUR BALANCE");
		lblYourBalance.setBounds(257, 169, 95, 16);
		contentPane.add(lblYourBalance);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(DB.getBalance(mail)+" BTC");
		textArea.setBackground(SystemColor.inactiveCaption);
		textArea.setBounds(365, 158, 84, 27);
		contentPane.add(textArea);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ad = textField.getText();
				Float f = Float.parseFloat(textField_1.getText());
				Float lastb = DB.getBalance(ad);
				Float anab = DB.getBalance(mail);
				Float total = f + lastb;
				Float totalana = anab-f;
				String sql = "update userbalance set BALANCE="+total+" where mail='"+ad+"'";
				String sql2 = "update userbalance set BALANCE="+totalana+" where mail='"+mail+"'";
				DB.executeU(sql2);
				DB.executeU(sql);
                textArea.setText(DB.getBalance(mail) + " BTC");

				
			}
		});
		btnSend.setBounds(12, 160, 97, 25);
		contentPane.add(btnSend);
	}
}
