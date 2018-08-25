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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

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
	public BankTransactions() {
		setForeground(SystemColor.textInactiveText);
		setTitle("Transaction Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
				   balance= balance-amt;
				   JOptionPane.showMessageDialog(Frame,"New bal "+balance);
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
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login L=new Login();
			}
		});
		btnGoBack.setBounds(480, 249, 116, 23);
		contentPane.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(-71, -804, 1130, 1349);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Raksh\\Downloads\\geek-zombie-icon.png"));
		lblNewLabel_1.setBounds(85, 95, 273, 271);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Raksh\\Downloads\\wallpaper\\_minflat__dark_material_design_wallpaper__4k__by_dakoder-d8fjqzu.jpg"));
		lblNewLabel_2.setBounds(0, 0, 701, 366);
		contentPane.add(lblNewLabel_2);
	}

	
}
