import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection connection=null;
	private JFrame Frame;
	public Register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setTitle("Registration Form");
		connection=SqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(229, 59, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(229, 159, 136, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(229, 113, 136, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(362, 77, -130, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(362, 131, -130, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(229, 177, 136, 2);
		contentPane.add(separator_2);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(UIManager.getColor("ComboBox.foreground"));
		lblName.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblName.setBounds(74, 62, 89, 14);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblPassword.setBounds(74, 116, 113, 14);
		contentPane.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password");
		lblReenterPassword.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblReenterPassword.setBounds(23, 162, 196, 14);
		contentPane.add(lblReenterPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		btnSubmit.setFont(new Font("Segoe Print", Font.BOLD, 15));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query1="insert into userinfo(name,password)values(?,?)";
					PreparedStatement pst=connection.prepareStatement(query1);
					pst.setString(1,textField.getText()); 
					pst.setString(2,textField_1.getText()); 
					
					pst.execute();
					//res.close();
					pst.close();
					JOptionPane.showMessageDialog(null, "registration done");
					JOptionPane.showMessageDialog(null, "Open the Application");
					
					dispose();
					
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(null, "registration done");
				}
				
				
				}
		});
		btnSubmit.setBounds(153, 211, 128, 23);
		contentPane.add(btnSubmit);
		
		JLabel material = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/mat1.jpg")).getImage(); 
		material.setIcon(new ImageIcon(img));
		material.setBounds(0, 0, 426, 259);
		contentPane.add(material);
	}
}
