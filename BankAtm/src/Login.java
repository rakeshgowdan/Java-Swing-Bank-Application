import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
public class Login {

	private JFrame frmMiniAtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmMiniAtm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 Connection connection=null;
	 private JTextField textField;
	 private JPasswordField passwordField;
                
	/**
	 * Create the application.
	 */
	
	public Login() {
		initialize();
		connection=SqlConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMiniAtm = new JFrame();
		frmMiniAtm.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		frmMiniAtm.setForeground(new Color(0, 128, 128));
		frmMiniAtm.setTitle("MINI ATM");
		frmMiniAtm.setBackground(new Color(255, 255, 255));
		frmMiniAtm.setBounds(100, 100, 795, 508);
		frmMiniAtm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMiniAtm.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 389, 469);
		frmMiniAtm.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Raksh\\Downloads\\LKqGil5J_400x400.png"));
		lblNewLabel.setBounds(0, 0, 389, 400);
		panel.add(lblNewLabel);
		
		JLabel lblBankAtm = new JLabel("MINI ATM");
		lblBankAtm.setFont(new Font("MV Boli", Font.BOLD, 18));
		lblBankAtm.setForeground(Color.WHITE);
		lblBankAtm.setBounds(120, 140, 184, 76);
		panel.add(lblBankAtm);
		
		JLabel lblMiniAtm = new JLabel("MINI ATM");
		lblMiniAtm.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 20));
		lblMiniAtm.setBounds(111, 411, 278, 47);
		panel.add(lblMiniAtm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(382, 0, 397, 469);
		frmMiniAtm.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("Lucida Handwriting", Font.PLAIN, 18));
		lblUserName.setBounds(42, 143, 153, 14);
		panel_1.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Lucida Handwriting", Font.PLAIN, 18));
		lblPassword.setBounds(42, 234, 123, 14);
		panel_1.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(52, 168, 292, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(52, 201, 292, -7);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(57, 286, 287, -7);
		panel_1.add(separator_1);
		
		JRadioButton rdbtnSb = new JRadioButton("S/B");
		rdbtnSb.setBackground(new Color(47, 79, 79));
		rdbtnSb.setBounds(51, 303, 66, 23);
		panel_1.add(rdbtnSb);
		
		JRadioButton rdbtnFd = new JRadioButton("F/D");
		rdbtnFd.setBackground(new Color(47, 79, 79));
		rdbtnFd.setBounds(156, 303, 75, 23);
		panel_1.add(rdbtnFd);
		
		JRadioButton rdbtnCs = new JRadioButton("C/S");
		rdbtnCs.setBackground(new Color(47, 79, 79));
		rdbtnCs.setBounds(269, 303, 75, 23);
		panel_1.add(rdbtnCs);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			    	 
					String query="select * from userinfo where name=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textField.getText()); 
					pst.setString(2,passwordField.getText()); 
					
					ResultSet res=pst.executeQuery();
				    int count=0;
					while(res.next())
					{
						count+=1;
					}
					if(count==1)
					{
						//JOptionPane.showMessageDialog(null, "user name and password is correct");
						frmMiniAtm.dispose();
						BankTransactions object=new BankTransactions();
						object.setVisible(true);
					
					}else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "duplicate user name and password ");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, " user name and password not correct,TRY AGAIN!!!!");
					}
			    	
			    
			res.close();
			pst.close();
			}
			    catch(Exception e1)
			    {
			    	JOptionPane.showMessageDialog(null, e1);
			    	
			}
			    }
		});
		btnNewButton.setBounds(52, 380, 97, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setForeground(SystemColor.desktop);
		btnNewButton_1.setBounds(255, 380, 89, 23);
		panel_1.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(52, 259, 292, 20);
		panel_1.add(passwordField);
		
		JButton btnNewUserSignup = new JButton("New User? Signup");
		btnNewUserSignup.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewUserSignup.setBounds(134, 435, 162, 23);
		panel_1.add(btnNewUserSignup);
	}
}
