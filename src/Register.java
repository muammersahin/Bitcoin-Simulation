import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtMail;
	private JTextField txtPassword;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Register() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
			  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
			
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(107, 47, 116, 22);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setText("Surname");
		txtSurname.setColumns(10);
		txtSurname.setBounds(107, 106, 116, 22);
		contentPane.add(txtSurname);
		
		txtMail = new JTextField();
		txtMail.setText("Mail");
		txtMail.setColumns(10);
		txtMail.setBounds(107, 170, 116, 22);
		contentPane.add(txtMail);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(107, 226, 116, 22);
		contentPane.add(txtPassword);
		
		txtId = new JTextField();
		txtId.setText("ID");
		txtId.setColumns(10);
		txtId.setBounds(107, 292, 116, 22);
		contentPane.add(txtId);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = txtName.getText();
				String surname = txtSurname.getText();
				String mail = txtMail.getText();
				String password = txtPassword.getText();
				String id = ""+Integer.parseInt(txtId.getText());
				String query = "insert into user values"+"('"+name+"','"+surname+"','"+ mail +
						"','" + password + "','"+id+ "')";
				if(DB.executeU(query)==1){
					System.out.println("Successfull");
				}
				
			}
		});
		btnRegister.setBounds(112, 383, 97, 25);
		contentPane.add(btnRegister);
	}

}
