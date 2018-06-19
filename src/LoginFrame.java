import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPassword;
	MainGUI mg = null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setText("Username");
		txtId.setBounds(93, 120, 182, 37);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(93, 181, 182, 37);
		contentPane.add(txtPassword);
		
		JButton btnLogn = new JButton("LOGIN");
		btnLogn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mail = txtId.getText();
				String password = txtPassword.getText();
				String sql = "select * from user where Mail='"+ mail + "' and Password="+password;
				ResultSet rs = DB.executeQ(sql);
				
					try {
						rs.next();
						if(rs.getString(3).equals(mail)){
							mg = new MainGUI(mail);
							mg.setVisible(true);
							dispose();
						}
				
					} catch (SQLException e) {
						System.out.println("Mail yada Þifre Yalnýþ");
					}
			
			}
		});
		btnLogn.setBounds(77, 243, 97, 25);
		contentPane.add(btnLogn);
		
		JButton btnRegster = new JButton("REGISTER");
		btnRegster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register r = new Register();
				r.setVisible(true);
			}
		});
		btnRegster.setBounds(195, 243, 97, 25);
		contentPane.add(btnRegster);
		
		JLabel label = new JLabel("CoinTrexx");
		label.setFont(new Font("Tahoma", Font.ITALIC, 22));
		label.setBounds(125, 48, 114, 38);
		contentPane.add(label);
	}
}
