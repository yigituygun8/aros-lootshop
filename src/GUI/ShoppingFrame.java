package GUI;

import shop.ArosShop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShoppingFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField itemNameTF;
	private JComboBox typesCB;
	private JTextArea dispTA;
	
	// Multiple Frames Connection
    private PurchaseFrame purchaseFrame = new PurchaseFrame(this);
    private LobbyFrame lf;
	
	public void fillComboBox() {
		typesCB.setModel(new DefaultComboBoxModel(ArosShop.getItemTypesArray()));
	}
	
	public JTextArea getDispTA() {
		return dispTA;
	} // for PurchaseFrame to update display area after purchase

	public ShoppingFrame(LobbyFrame menu) {
		lf = menu;
		
		setTitle("Buy Items My Lord! - Best Quality in the Realm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		typesCB = new JComboBox();
		typesCB.setBounds(10, 48, 115, 20);
		contentPane.add(typesCB);
		fillComboBox(); // fill combo box with item types
		
		JLabel typesLabel = new JLabel("What Can I Get For You, My Lord?");
		typesLabel.setForeground(new Color(159, 168, 0));
		typesLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 23));
		typesLabel.setHorizontalAlignment(SwingConstants.LEFT);
		typesLabel.setBounds(10, 15, 456, 23);
		contentPane.add(typesLabel);
		
		dispTA = new JTextArea();
		dispTA.setFont(new Font("Consolas", Font.PLAIN, 12));
		dispTA.setText("\t\t\t\t  What Can I Get You, Sir?\n");
		dispTA.setEditable(false); // text area read-only
		
		JScrollPane scrollPane = new JScrollPane(dispTA);
		scrollPane.setBounds(10, 110, 655, 223);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Search Your Desired Item By Name: ");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNewLabel.setBounds(198, 50, 306, 20);
		contentPane.add(lblNewLabel);
		
		itemNameTF = new JTextField();
		itemNameTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String enteredName = itemNameTF.getText().trim();
					
					String resultByName = ArosShop.searchItemByName(enteredName);
					dispTA.setText("\t\t\t\t\tAvailable Items in Shop\n\n");
		
					if(resultByName.isEmpty()) {
						dispTA.append("We don't have " + enteredName + " in our Shop, My Lord!\n");
					}
					else {
						dispTA.append("Is that what you desired?\n\n");
						dispTA.append(resultByName + "\n");
						
					}
				}
			}
		});
		itemNameTF.setFont(new Font("Consolas", Font.ITALIC, 10));
		itemNameTF.setHorizontalAlignment(SwingConstants.CENTER);
		itemNameTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) { // clear placeholder text on "focus" event
 				if(itemNameTF.getText().equals("Enter Item Name Here...")) {
					itemNameTF.setText("");
					itemNameTF.setFont(new Font("Consolas", Font.PLAIN, 14)); // change font to normal
				}
			}
		});
		itemNameTF.setBounds(446, 42, 219, 32);
		contentPane.add(itemNameTF);
		itemNameTF.setColumns(10);
		itemNameTF.setText("Enter Item Name Here...");
		
		JButton btnNewButton = new JButton("Bring Me The Item!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredName = itemNameTF.getText().trim();
				
				String resultByName = ArosShop.searchItemByName(enteredName);
				dispTA.setText("\t\t\t\t\tAvailable Items in Shop\n\n");
	
				if(resultByName.isEmpty()) {
					dispTA.append("We don't have " + enteredName + " in our Shop, My Lord!\n");
				}
				else {
					dispTA.append("Is that what you desired?\n\n");
					dispTA.append(resultByName + "\n");
					
				}
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBounds(517, 78, 148, 22);
		contentPane.add(btnNewButton);
		
		JButton btnBackToLobby = new JButton("Back to Lobby");
		btnBackToLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				lf.setVisible(true);
			}
		});
		btnBackToLobby.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnBackToLobby.setForeground(new Color(0, 0, 128));
		btnBackToLobby.setBackground(Color.WHITE);
		btnBackToLobby.setBounds(517, 343, 148, 22);
		contentPane.add(btnBackToLobby);
		
		JButton btnBringMeAll = new JButton("Bring Me Those Only!");
		btnBringMeAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedType = typesCB.getSelectedItem().toString();
				String resultByType = ArosShop.searchItemByType(selectedType);
				dispTA.setText("\t\t\t\t\tAvailable Items in Shop\n\n");
				
				if(resultByType.isEmpty()) {
					dispTA.append("We don't have any " + selectedType + "!\n");
				}
				else {
					dispTA.append("Those Are All " + selectedType + " My Lord!\n\n");					
					dispTA.append(resultByType + "\n");
				}
			}
		});
		btnBringMeAll.setForeground(new Color(0, 0, 128));
		btnBringMeAll.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnBringMeAll.setBackground(Color.WHITE);
		btnBringMeAll.setBounds(10, 78, 166, 22);
		contentPane.add(btnBringMeAll);
		
		JButton btnPurchase = new JButton("Purchase Item");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purchaseFrame.setVisible(true);
			}
		});
		btnPurchase.setForeground(new Color(0, 0, 128));
		btnPurchase.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnPurchase.setBackground(Color.WHITE);
		btnPurchase.setBounds(10, 343, 115, 22);
		contentPane.add(btnPurchase);
	}
}
