package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import products.Armor;
import products.*;
import shop.ArosShop;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AdminPanelFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField priceTextField;
	private JTextField rarityTextField;
	private JTextField quantityTextField;
	/**
	 * @wbp.nonvisual location=81,-31
	 */
	private final JLabel label = new JLabel("New label");
	private JTextField defenceTextField;
	private JTextField materialTextField;
	/**
	 * @wbp.nonvisual location=221,-31
	 */
	private final JLabel label_1 = new JLabel("New label");
	private JTextField damageTextField;
	private JTextField statusTextField;
	private JTextField durabilityTextField;
	private JTextField neededStrengthTextField;
	private JTextField weightTextField;
	private JTextField effectTextField;
	private JTextField durationTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();

	private LobbyFrame menu;

	/**
	 * Create the frame.
	 */
	public AdminPanelFrame(LobbyFrame menu) {
		this.menu = menu;
		setTitle("Admin Panel - Manage the Shop!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to the Shop Inventory!");
		welcomeLabel.setForeground(new Color(108, 65, 190));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 30));
		welcomeLabel.setBounds(72, 14, 559, 43);
		contentPane.add(welcomeLabel);
		
		JLabel itemTypeLabel = new JLabel("Select Item Type:");
		itemTypeLabel.setForeground(new Color(128, 0, 64));
		itemTypeLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		itemTypeLabel.setBounds(36, 68, 170, 23);
		contentPane.add(itemTypeLabel);
		

		JLabel idLabel = new JLabel("Enter item ID:");
		idLabel.setForeground(new Color(128, 0, 64));
		idLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		idLabel.setBounds(25, 209, 109, 14);
		contentPane.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(150, 204, 162, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter item name:");
		lblNewLabel.setForeground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewLabel.setBounds(25, 246, 109, 14);
		contentPane.add(lblNewLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(150, 241, 162, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter item price:");
		lblNewLabel_1.setForeground(new Color(128, 0, 64));
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(25, 290, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(150, 285, 162, 20);
		contentPane.add(priceTextField);
		priceTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter item rarity:");
		lblNewLabel_2.setForeground(new Color(128, 0, 64));
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(25, 338, 109, 14);
		contentPane.add(lblNewLabel_2);
		
		rarityTextField = new JTextField();
		rarityTextField.setBounds(150, 333, 162, 20);
		contentPane.add(rarityTextField);
		rarityTextField.setColumns(10);
		
		JLabel quantityLabel = new JLabel("Enter item quantity:");
		quantityLabel.setForeground(new Color(128, 0, 64));
		quantityLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		quantityLabel.setBounds(25, 388, 120, 14);
		contentPane.add(quantityLabel);
		
		quantityTextField = new JTextField();
		quantityTextField.setBounds(150, 385, 162, 20);
		contentPane.add(quantityTextField);
		quantityTextField.setColumns(10);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBounds(397, 219, 298, 183);
		contentPane.add(statusPanel);
		statusPanel.setLayout(null);
		statusPanel.setVisible(true);
		
		JLabel statusLabel = new JLabel("Enter status:");
		statusLabel.setForeground(new Color(128, 0, 64));
		statusLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		statusLabel.setBounds(10, 14, 81, 14);
		statusPanel.add(statusLabel);
		
		statusTextField = new JTextField();
		statusTextField.setBounds(160, 9, 123, 20);
		statusPanel.add(statusTextField);
		statusTextField.setColumns(10);
		
		JLabel durabilityLabel = new JLabel("Enter durability:");
		durabilityLabel.setForeground(new Color(128, 0, 64));
		durabilityLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		durabilityLabel.setBounds(10, 49, 113, 14);
		statusPanel.add(durabilityLabel);
		
		durabilityTextField = new JTextField();
		durabilityTextField.setBounds(160, 44, 123, 20);
		statusPanel.add(durabilityTextField);
		durabilityTextField.setColumns(10);
		
		JLabel neededStrengthLabel = new JLabel("Enter needed strength:");
		neededStrengthLabel.setForeground(new Color(128, 0, 64));
		neededStrengthLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		neededStrengthLabel.setBounds(10, 81, 164, 14);
		statusPanel.add(neededStrengthLabel);
		
		neededStrengthTextField = new JTextField();
		neededStrengthTextField.setBounds(160, 76, 123, 20);
		statusPanel.add(neededStrengthTextField);
		neededStrengthTextField.setColumns(10);
		
		JLabel weightLabel = new JLabel("Enter weight:");
		weightLabel.setForeground(new Color(128, 0, 64));
		weightLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		weightLabel.setBounds(10, 116, 81, 14);
		statusPanel.add(weightLabel);
		
		weightTextField = new JTextField();
		weightTextField.setBounds(160, 113, 123, 20);
		statusPanel.add(weightTextField);
		weightTextField.setColumns(10);
		
		JLabel magicalLabel = new JLabel("Is it magical?");
		magicalLabel.setForeground(new Color(128, 0, 64));
		magicalLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		magicalLabel.setBounds(10, 153, 113, 14);
		statusPanel.add(magicalLabel);
		
		JRadioButton mYesRB = new JRadioButton("Yes!");
		mYesRB.setFont(new Font("Consolas", Font.PLAIN, 11));
		buttonGroup_1.add(mYesRB);
		mYesRB.setBounds(127, 147, 59, 23);
		statusPanel.add(mYesRB);
		
		JRadioButton mNoRB = new JRadioButton("No");
		mNoRB.setFont(new Font("Consolas", Font.PLAIN, 11));
		buttonGroup_1.add(mNoRB);
		mNoRB.setBounds(203, 147, 89, 23);
		statusPanel.add(mNoRB);
		
		JPanel armorPanel = new JPanel();
		armorPanel.setBounds(397, 132, 245, 76);
		contentPane.add(armorPanel);
		armorPanel.setLayout(null);
		
		JLabel defenceLabel = new JLabel("Enter defence:");
		defenceLabel.setForeground(new Color(128, 0, 64));
		defenceLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		defenceLabel.setBounds(10, 11, 87, 14);
		armorPanel.add(defenceLabel);
		
		defenceTextField = new JTextField();
		defenceTextField.setBounds(117, 8, 110, 20);
		armorPanel.add(defenceTextField);
		defenceTextField.setColumns(10);
		
		JLabel materialLabel = new JLabel("Enter material:");
		materialLabel.setForeground(new Color(128, 0, 64));
		materialLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		materialLabel.setBounds(10, 47, 97, 14);
		armorPanel.add(materialLabel);
		
		materialTextField = new JTextField();
		materialTextField.setBounds(117, 44, 110, 20);
		armorPanel.add(materialTextField);
		materialTextField.setColumns(10);
		
		JPanel potionPanel = new JPanel();
		potionPanel.setBounds(397, 198, 298, 106);
		contentPane.add(potionPanel);
		potionPanel.setLayout(null);
		potionPanel.setVisible(false);
		
		JLabel effectLabel = new JLabel("Enter effect:");
		effectLabel.setForeground(new Color(128, 0, 64));
		effectLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		effectLabel.setBounds(10, 11, 86, 14);
		potionPanel.add(effectLabel);
		
		effectTextField = new JTextField();
		effectTextField.setBounds(123, 6, 157, 20);
		potionPanel.add(effectTextField);
		effectTextField.setColumns(10);
		
		JLabel durationLabel = new JLabel("Enter duration:");
		durationLabel.setForeground(new Color(128, 0, 64));
		durationLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		durationLabel.setBounds(10, 36, 103, 14);
		potionPanel.add(durationLabel);
		
		durationTextField = new JTextField();
		durationTextField.setBounds(123, 31, 157, 20);
		potionPanel.add(durationTextField);
		durationTextField.setColumns(10);
		
		JLabel hazardousLabel = new JLabel("Is it hazardous?");
		hazardousLabel.setForeground(new Color(128, 0, 64));
		hazardousLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		hazardousLabel.setBounds(10, 61, 103, 14);
		potionPanel.add(hazardousLabel);
		
		JRadioButton hYesRB = new JRadioButton("Yes");
		hYesRB.setFont(new Font("Consolas", Font.PLAIN, 11));
		buttonGroup_2.add(hYesRB);
		hYesRB.setBounds(136, 57, 43, 23);
		potionPanel.add(hYesRB);
		
		JRadioButton hNoRB = new JRadioButton("No");
		hNoRB.setFont(new Font("Consolas", Font.PLAIN, 11));
		buttonGroup_2.add(hNoRB);
		hNoRB.setBounds(191, 58, 109, 23);
		potionPanel.add(hNoRB);
		
		JLabel lblNewLabel_4 = new JLabel("Is it throwable?");
		lblNewLabel_4.setForeground(new Color(128, 0, 64));
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(10, 86, 103, 14);
		potionPanel.add(lblNewLabel_4);
		
		JRadioButton tYesRB = new JRadioButton("Yes");
		tYesRB.setFont(new Font("Consolas", Font.PLAIN, 11));
		buttonGroup_3.add(tYesRB);
		tYesRB.setBounds(136, 82, 48, 23);
		potionPanel.add(tYesRB);
		
		JRadioButton tNoRB = new JRadioButton("No");
		tNoRB.setFont(new Font("Consolas", Font.PLAIN, 11));
		buttonGroup_3.add(tNoRB);
		tNoRB.setBounds(191, 82, 109, 23);
		potionPanel.add(tNoRB);
		
		JPanel weaponPanel = new JPanel();
		weaponPanel.setBounds(397, 132, 245, 76);
		contentPane.add(weaponPanel);
		weaponPanel.setLayout(null);
		weaponPanel.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Enter damage:");
		lblNewLabel_3.setForeground(new Color(128, 0, 64));
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 34, 85, 14);
		weaponPanel.add(lblNewLabel_3);
		
		damageTextField = new JTextField();
		damageTextField.setBounds(102, 31, 133, 20);
		weaponPanel.add(damageTextField);
		damageTextField.setColumns(10);
		
		JRadioButton armorRB = new JRadioButton("Armor");
		armorRB.setForeground(new Color(128, 0, 0));
		armorRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				armorPanel.setVisible(true);
				statusPanel.setVisible(true);
				weaponPanel.setVisible(false);
				potionPanel.setVisible(false);
			}
		});
		armorRB.setSelected(true);
		buttonGroup.add(armorRB);
		armorRB.setFont(new Font("Consolas", Font.BOLD, 16));
		armorRB.setBounds(36, 98, 109, 23);
		contentPane.add(armorRB);


		JRadioButton weaponRB = new JRadioButton("Weapon");
		weaponRB.setForeground(new Color(128, 0, 0));
		weaponRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				armorPanel.setVisible(false);
				statusPanel.setVisible(true);
				weaponPanel.setVisible(true);
				potionPanel.setVisible(false);
			}
		});
		buttonGroup.add(weaponRB);
		weaponRB.setFont(new Font("Consolas", Font.BOLD, 16));
		weaponRB.setBounds(36, 124, 109, 23);
		contentPane.add(weaponRB);
		
		JRadioButton potionRB = new JRadioButton("Potion");
		potionRB.setForeground(new Color(128, 0, 0));
		potionRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				armorPanel.setVisible(false);
				statusPanel.setVisible(false);
				weaponPanel.setVisible(false);
				potionPanel.setVisible(true);
			}
		});
		buttonGroup.add(potionRB);
		potionRB.setFont(new Font("Consolas", Font.BOLD, 16));
		potionRB.setBounds(36, 150, 109, 23);
		contentPane.add(potionRB);
		
		JButton btnBackToLobby = new JButton("Back to Lobby");
		btnBackToLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menu.setVisible(true);
			}
		});
		btnBackToLobby.setFont(new Font("Consolas", Font.BOLD, 10));
		btnBackToLobby.setForeground(new Color(0, 0, 128));
		btnBackToLobby.setBackground(new Color(196, 228, 255));
		btnBackToLobby.setBounds(270, 436, 174, 23);
		contentPane.add(btnBackToLobby);
		
		JLabel warningLabel = new JLabel("");
		warningLabel.setBackground(new Color(255, 196, 196));
		warningLabel.setForeground(new Color(255, 0, 0));
		warningLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 11));
		warningLabel.setBounds(112, 413, 369, 23);
		contentPane.add(warningLabel);
		
		JButton addButon = new JButton("ADD");
		addButon.setBackground(new Color(250, 201, 247));
		addButon.setForeground(new Color(64, 0, 64));
		addButon.setFont(new Font("Consolas", Font.BOLD, 11));
		addButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String id,name,price,rarity,quantity;
			    
			    id=idTextField.getText();
			    name=nameTextField.getText();
			    price=priceTextField.getText();
			    rarity=rarityTextField.getText();
			    quantity=quantityTextField.getText();
			    
			    if(id.equalsIgnoreCase("") || name.equalsIgnoreCase("") || 
			    		price.equalsIgnoreCase("") || rarity.equalsIgnoreCase("") ||
			    		quantity.equalsIgnoreCase(""))
			    	warningLabel.setText("Please fill all the fields!");
			    
			    else if(armorRB.isSelected())
				{
					String defence,material,durability ,weight,status;
					
					defence=defenceTextField.getText();
					material=materialTextField.getText();
					durability=durabilityTextField.getText();
					weight=weightTextField.getText();
					status=statusTextField.getText();
					
					if(defence.equalsIgnoreCase("") || material.equalsIgnoreCase("") ||
							durability.equalsIgnoreCase("") ||
							weight.equalsIgnoreCase("") || status.equalsIgnoreCase("") ||
							!mYesRB.isSelected() && !mNoRB.isSelected())
						warningLabel.setText("Please fill all the fields!");
					else
					{
						String magical="";
						if(mYesRB.isSelected())
							magical="true";
						else if(mNoRB.isSelected())
							magical="false";
						
						Stats s=new Stats(status,durability,weight,magical);
						s.calculateNeededStrength(); // based on weight
						Armor a=new Armor("Armor",id,name, price,rarity, quantity,defence,material,s);
						a.calculatePower();
						a.calculateFinalPrice();
						warningLabel.setText(ArosShop.addItemToShop(a));
					}
				}
			    
			    else if(weaponRB.isSelected())
			    {
			    	String damage,durability ,weight,status;
			    	
			    	damage=damageTextField.getText();
			    	durability=durabilityTextField.getText();
					weight=weightTextField.getText();
					status=statusTextField.getText();
					
					if(damage.equalsIgnoreCase("") ||
							durability.equalsIgnoreCase("") ||
							weight.equalsIgnoreCase("") || status.equalsIgnoreCase("") ||
							!mYesRB.isSelected() && !mNoRB.isSelected())
						warningLabel.setText("Please fill all the fields!");
					else
					{
						String magical="";
						if(mYesRB.isSelected())
							magical="true";
						else if(mNoRB.isSelected())
							magical="false";
						
						Stats s=new Stats(status,durability,weight,magical);
						s.calculateNeededStrength(); // based on weight
						Weapon w=new Weapon("Weapon",id,name,price,rarity,quantity,damage,s);
						w.calculatePower();
						w.calculateFinalPrice();
						warningLabel.setText(ArosShop.addItemToShop(w));
					}
			    }
			    
			    else if(potionRB.isSelected())
			    {
			    	String effect,duration,isHazardous="",throwable="";
			    	
			    	effect=effectTextField.getText();
			    	duration=durationTextField.getText();
			    	
			    	if(effect.equalsIgnoreCase("") || duration.equalsIgnoreCase("") ||
			    			!hYesRB.isSelected() && !hNoRB.isSelected() ||
			    			!tYesRB.isSelected() && !tNoRB.isSelected())
			    		warningLabel.setText("Please fill all the fields!");
			    	
			    	else
			    	{
			    		if(hYesRB.isSelected())
			    			isHazardous="true";
			    		else if(hNoRB.isSelected())
			    			isHazardous="false";
			    		
			    		if(tYesRB.isSelected())
			    			throwable="true";
			    		else if(tNoRB.isSelected())
			    			throwable="false";
			    		
			    		Potion p= new Potion("Potion",id,name,price,rarity,quantity,effect,duration,isHazardous, throwable);
			    		p.calculatePower();
			    		p.calculateFinalPrice();
			    		warningLabel.setText(ArosShop.addItemToShop(p));
			    	}
			    }
				
			}
		});
		addButon.setBounds(491, 413, 89, 23);
		contentPane.add(addButon);
	}
}
