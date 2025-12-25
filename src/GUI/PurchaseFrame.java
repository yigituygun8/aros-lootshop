package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import products.ShopItem;
import shop.ArosShop;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PurchaseFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ShoppingFrame shoppingFrame;
	private JTextField idTF;
	private JTextField quantityTF;

	/**
	 * Create the frame.
	 */
	public PurchaseFrame(ShoppingFrame shoppingFrame) {
		this.shoppingFrame = shoppingFrame;
		setTitle("Complete Your Purchase!");  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		idTF = new JTextField();
		idTF.setBounds(66, 11, 57, 20);
		contentPane.add(idTF);
		idTF.setColumns(10);
		
		JLabel idLbl = new JLabel("Item ID:");
		idLbl.setFont(new Font("Consolas", Font.PLAIN, 11));
		idLbl.setBounds(10, 16, 67, 14);
		contentPane.add(idLbl);
		
		JTextArea dispTA = new JTextArea();
		dispTA.setBounds(10, 42, 413, 218);
		contentPane.add(dispTA);
		dispTA.setEditable(false);
		
		JButton btnBackToShop = new JButton("Back to Shop List");
		btnBackToShop.setBounds(10, 279, 148, 21);
		btnBackToShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnBackToShop.setForeground(new Color(0, 0, 128));
		btnBackToShop.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnBackToShop.setBackground(Color.WHITE);
		contentPane.add(btnBackToShop);
		
		JButton buyBtn = new JButton("Buy");
		buyBtn.setForeground(new Color(0, 0, 128));
		buyBtn.setBackground(new Color(255, 255, 255));
		buyBtn.setFont(new Font("Consolas", Font.PLAIN, 11));
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTF.getText().equalsIgnoreCase("") || quantityTF.getText().equalsIgnoreCase("")) {
					dispTA.setText("Please fill the necesarry boxes");
					return;
				}
				int id = Integer.parseInt(idTF.getText());
				int quantity = Integer.parseInt(quantityTF.getText());
				
				ShopItem buyItem = ArosShop.searchItemById(id);
				
				if(buyItem == null) {
					dispTA.setText("No item with the given ID found!!");
				}
				else {
					dispTA.setText(ArosShop.purchaseItem(buyItem, quantity));
					if(ArosShop.searchItemById(id) != null) { // if item still exists after purchase
						shoppingFrame.getDispTA().setText(ArosShop.searchItemByType(ArosShop.searchItemById(id).getType()));
						dispTA.append("\nStock is updated! - Item's New Stock: " + ArosShop.searchItemById(id).getQuantity());
					}
					else {
						shoppingFrame.getDispTA().setText("The item you purchased is out of stock and has been removed from the shop list.");
						dispTA.append("\nYou can return to the shop list to see the updated items.");
					}
				}
			}
		});
		buyBtn.setBounds(334, 11, 89, 20);
		contentPane.add(buyBtn);
		
		quantityTF = new JTextField();
		quantityTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(idTF.getText().equalsIgnoreCase("") || quantityTF.getText().equalsIgnoreCase("")) {
						dispTA.setText("Please fill the necesarry boxes");
						return;
					}
					int id = Integer.parseInt(idTF.getText());
					int quantity = Integer.parseInt(quantityTF.getText());
					
					ShopItem buyItem = ArosShop.searchItemById(id);
					
					if(buyItem == null) {
						dispTA.setText("No item with the given ID found!!");
					}
					else {
						dispTA.setText(ArosShop.purchaseItem(buyItem, quantity));
						if(ArosShop.searchItemById(id) != null) { // if item still exists after purchase
							shoppingFrame.getDispTA().setText(ArosShop.searchItemByType(ArosShop.searchItemById(id).getType()));
							dispTA.append("\nStock is updated! - Item's New Stock: " + ArosShop.searchItemById(id).getQuantity());
						}
						else {
							shoppingFrame.getDispTA().setText("The item you purchased is out of stock and has been removed from the shop list.");
							dispTA.append("\nYou can return to the shop list to see the updated items.");
						}
					}
				}
			}
		});
		quantityTF.setBounds(225, 11, 57, 20);
		contentPane.add(quantityTF);
		quantityTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantity:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewLabel.setBounds(163, 16, 57, 14);
		contentPane.add(lblNewLabel);
	}
}
