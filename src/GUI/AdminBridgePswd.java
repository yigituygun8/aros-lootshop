package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class AdminBridgePswd extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordTf;
	private final char[] PASSWORD = { 'g', 'o', 'k', 's', 'i', 'n'}; // password to access admin panel - we love goksin

	private AdminPanelFrame adminPanel;
	private LobbyFrame lf;
	/**
	 * Create the frame.
	 */
	public AdminBridgePswd(LobbyFrame menu) {
		lf = menu; // connect to lobby frame
		adminPanel = new AdminPanelFrame(menu); // connect AdminPanel with lobby frame
		
		setTitle("Password Required");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 222);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 221, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel passLbl = new JLabel("Dost thou know the password?");
		passLbl.setBackground(new Color(255, 255, 255));
		passLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passLbl.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 13));
		passLbl.setBounds(10, 42, 298, 14);
		contentPane.add(passLbl);
		
		passwordTf = new JPasswordField();
		passwordTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { // can send password by pressing Enter, too
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					char[] password = passwordTf.getPassword();
					
					if(Arrays.equals(password, PASSWORD)) {
						passwordTf.setText(""); // clear after successful login
						passLbl.setText("Dost thou know the password?"); // reset the label
						dispose();
						lf.setVisible(false);
						adminPanel.setVisible(true);
						
					}
					else {
						passLbl.setText("I Guess You Do Not Know The Password!");
					}
				}
				
			}
		});
		passwordTf.setBounds(68, 61, 180, 20);
		contentPane.add(passwordTf);
		
		JButton returnBtn = new JButton("Back to Lobby");
		returnBtn.setForeground(new Color(255, 255, 255));
		returnBtn.setBackground(new Color(0, 128, 0));
		returnBtn.setFont(new Font("Consolas", Font.BOLD, 13));
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordTf.setText(""); // clear password field
				passLbl.setText("Did You Learn The Password?");
				lf.setVisible(true);
				dispose();
			}
		});
		returnBtn.setBounds(81, 132, 149, 23);
		contentPane.add(returnBtn);
		
		JButton enterBtn = new JButton("Enter");
		enterBtn.setForeground(new Color(255, 255, 255));
		enterBtn.setBackground(new Color(0, 128, 0));
		enterBtn.setFont(new Font("Consolas", Font.BOLD, 13));
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] password = passwordTf.getPassword();
				
				if(Arrays.equals(password, PASSWORD)) {
					passwordTf.setText(""); // clear after successful login
					passLbl.setText("Dost thou know the password?"); // reset the label
					dispose();
					lf.setVisible(false);
					adminPanel.setVisible(true);
					
				}
				else {
					passLbl.setText("I Guess You Do Not Know The Password!");
				}
				
			}
		});
		enterBtn.setToolTipText("");
		enterBtn.setBounds(96, 97, 120, 23);
		contentPane.add(enterBtn);
	}
}
