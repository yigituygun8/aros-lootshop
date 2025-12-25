package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LobbyFrame extends JFrame {

	
	// Multiple Frames Connection
	private AdminBridgePswd passwordSection = new AdminBridgePswd(this);
	private ShoppingFrame shop = new ShoppingFrame(this);
	
	private JPanel contentPane;

	public LobbyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Shop Menu");
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuLbl = new JLabel("Aros Shop");
		menuLbl.setForeground(new Color(3, 51, 110));
		menuLbl.setHorizontalAlignment(SwingConstants.CENTER);
		menuLbl.setBounds(286, 11, 306, 59);
		contentPane.add(menuLbl);
		menuLbl.setFont(new Font("Consolas", Font.BOLD, 50));
		
		JButton adminBtn = new JButton("To The Secret Passage");
		adminBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				adminBtn.setBackground(new Color(123, 179, 255)); // hover color
			}
			@Override
			public void mouseExited(MouseEvent e) {
				adminBtn.setBackground(new Color(95, 150, 241)); // original color
			}
		});
		adminBtn.setForeground(Color.WHITE);
		adminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				passwordSection.setVisible(true);
			}
		});
		adminBtn.setBounds(39, 168, 279, 97);
		contentPane.add(adminBtn);
		adminBtn.setFont(new Font("Consolas", Font.BOLD, 20));
		adminBtn.setBackground(new Color(95, 150, 241));
		
		JButton shopBtn = new JButton("Seek the Shopkeeper");
		shopBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				shopBtn.setBackground(new Color(123, 179, 255)); // hover color
			}
			@Override
			public void mouseExited(MouseEvent e) {
				shopBtn.setBackground(new Color(95, 150, 241)); // original color
			}
		});
		shopBtn.setForeground(Color.WHITE);
		shopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				shop.setVisible(true);
			}
		});
		shopBtn.setBounds(569, 168, 279, 97);
		contentPane.add(shopBtn);
		shopBtn.setFont(new Font("Consolas", Font.BOLD, 20));
		shopBtn.setBackground(new Color(95, 150, 241));
		
		JButton leaveBtn = new JButton("Leave Here");
		leaveBtn.setForeground(Color.WHITE);
		leaveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leaveBtn.setBackground(new Color(123, 179, 255)); // hover color
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leaveBtn.setBackground(new Color(95, 150, 241)); // original color
			}
		});
		leaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // close the lobby frame
			}
		});
		leaveBtn.setBounds(308, 346, 279, 97);
		contentPane.add(leaveBtn);
		leaveBtn.setFont(new Font("Consolas", Font.BOLD, 20));
		leaveBtn.setBackground(new Color(95, 150, 241));
		
		JLabel lblNewLabel = new JLabel("No One Knows What Lies Beyond There");
		lblNewLabel.setFont(new Font("Consolas", Font.ITALIC, 15));
		lblNewLabel.setBounds(34, 276, 307, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Don't Create Fuss About Us Out There");
		lblNewLabel_1.setFont(new Font("Consolas", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(308, 454, 325, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Here You Can Find What You Seek");
		lblNewLabel_2.setFont(new Font("Consolas", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(579, 282, 269, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel( "<html><body style='text-align: center;'>Welcome, adventurer…<br>" +
			    "Beyond law and light,<br>" +
			    "Where shadows bargain deep in the night.</body></html>");
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_3.setBounds(261, 74, 384, 70);
		contentPane.add(lblNewLabel_3);
	}
}
