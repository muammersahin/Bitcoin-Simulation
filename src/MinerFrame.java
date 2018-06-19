import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MinerFrame extends JFrame {

	private JPanel contentPane;
	public static String mail;
	public static String loading = "";
	private JLabel label;
	int counter = 0;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MinerFrame(String mail) {
		
		GeneralTaskClass gtc = new GeneralTaskClass();
		Thread t1 = new Thread(gtc);
		t1.start();

		this.mail = mail;
		setForeground(SystemColor.desktop);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 623);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 54));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(62, 448, 214, 104);
		contentPane.add(btnNewButton);
		
		JLabel lblLabelForHs = new JLabel("LABEL FOR HS");
		lblLabelForHs.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblLabelForHs.setForeground(Color.WHITE);
		lblLabelForHs.setBounds(84, 194, 176, 52);
		contentPane.add(lblLabelForHs);
	

		
		JLabel lblCurrentBalance = new JLabel("Current Balance");
		lblCurrentBalance.setForeground(Color.WHITE);
		lblCurrentBalance.setBounds(12, 31, 104, 16);
		contentPane.add(lblCurrentBalance);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(107, 24, 118, 35);
		contentPane.add(textArea);
		textArea.setText(DB.getBalance(mail)+" BTC");
		

		
			label = new JLabel("...");
			label.setFont(new Font("Tahoma", Font.PLAIN, 75));
			label.setForeground(Color.WHITE);
			label.setBounds(121, 320, 168, 88);
			contentPane.add(label);
		

	}
	
	public void setLabel(String str){
		label.setText(str);
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	

}
