import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class BankTransactions extends JFrame {
	
    private JFrame Frame;
	private JPanel contentPane;
	public double balance=10000;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankTransactions frame = new BankTransactions();
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
	public BankTransactions() {
		connection=SqlConnection.dbConnector();
		setForeground(SystemColor.textInactiveText);
		setTitle("Transaction Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//retrieve balance
	/*	String query1="select balance from userinfo where name=? and password=?";
		PreparedStatement pst=connection.prepareStatement(query1);
	pst.setString(1,textField.getText()); 
	pst.setString(2,textField_1.getText()); 
		
	pst.execute();
		
	pst.close();*/
		
		
		JButton btnDeposit = new JButton("DEPOSIT");
		btnDeposit.setBounds(480, 51, 116, 23);
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			  {  
			  
			if(e.getActionCommand()=="DEPOSIT")
			   {
				String str = JOptionPane.showInputDialog(null, "Enter amount to be Deposited : ", "Deposit",1);
				double amount;
				try{
					   amount= Double.valueOf(str).doubleValue();
					   balance= balance+amount;
					   JOptionPane.showMessageDialog(Frame,"New bal "+balance);
					}catch(Exception ie)
					   {
					   JOptionPane.showMessageDialog(Frame,"Invalid Input!! please enter correct Amount");
					   }
					 }  
			   }  
			
		});
		contentPane.setLayout(null);
		contentPane.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.setBounds(480, 120, 116, 23);
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str = JOptionPane.showInputDialog( null,"Enter amount to be Withdraw : ", "Withdraw", 1);
				   double amt;
				   try{
				   amt= Double.valueOf(str).doubleValue();
				   if(amt<balance)
				   {
				   balance= balance-amt;
				   JOptionPane.showMessageDialog(Frame,"New bal "+balance);
				   }
				   else
				   {
					   JOptionPane.showMessageDialog(Frame,"not much balance");
				   }
				 }
				   catch(Exception ie)
				   {
				   JOptionPane.showMessageDialog(Frame,"Invalid Input!! please enter correct Amount");
				   }
				       
				 }
				
			
		});
		contentPane.add(btnWithdraw);
		
		JButton btnNewButton = new JButton("BALANCE");
		btnNewButton.setBounds(480, 180, 116, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(Frame,"New bal "+balance);
				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblSelectAOperation = new JLabel("SELECT A OPERATION");
		lblSelectAOperation.setBounds(51, 24, 337, 71);
		lblSelectAOperation.setForeground(SystemColor.infoText);
		lblSelectAOperation.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		contentPane.add(lblSelectAOperation);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnClose.setBackground(SystemColor.activeCaption);
		btnClose.setBounds(480, 311, 116, 23);
		contentPane.add(btnClose);
		
		JButton btnGoBack = new JButton("Log out");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Frame,"Logged out");
				dispose();
			}
		});
		btnGoBack.setBounds(480, 249, 116, 23);
		contentPane.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/zombie.png")).getImage(); 
		lblNewLabel.setIcon(new ImageIcon(img2));
	
		lblNewLabel.setBounds(-70, -812, 1130, 1349);
		contentPane.add(lblNewLabel);
		
		JLabel zombie = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/zombie.png")).getImage(); 
		zombie.setIcon(new ImageIcon(img));
		
		zombie.setBounds(85, 95, 273, 271);
		contentPane.add(zombie);
		
		
		
		JLabel lblAutoGeneratedBalance = new JLabel("Auto Generated Balance");
		lblAutoGeneratedBalance.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
		lblAutoGeneratedBalance.setBounds(291, 163, 179, 40);
		contentPane.add(lblAutoGeneratedBalance);
		
		JLabel label = new JLabel("10000");
		label.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		label.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
		label.setBounds(331, 203, 57, 14);
		contentPane.add(label);
		
		JLabel fullimage = new JLabel("New label");
		Image img3 = new ImageIcon(this.getClass().getResource("/abstract.jpg")).getImage(); 
		fullimage.setIcon(new ImageIcon(img3));
		fullimage.setBounds(0, 0, 701, 366);
		contentPane.add(fullimage);	}
}
