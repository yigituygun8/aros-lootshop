package products;

import interfaces.Purchasable;

public abstract class ShopItem implements Purchasable {
	
	protected String type; // Weapon, Armor, Potion 
	protected int id;
	protected String name;
    protected double base_price; // base price
    protected String rarity; // Mythic, Epic, Common
    protected int quantity; // indicates available stock
    protected final int BASE_POWER = 100; // base power for calculations
    protected double power; // calculated power
    private static int totalNumOfItems = 0; // tracks total number of items in the shop
    
    public ShopItem() {}
    
    public ShopItem(String type, int id, String name, double price, String rarity, int quantity) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.base_price = price;
		this.rarity = rarity;
		this.quantity = quantity;
	}
    
    public String getName() {
    	return this.name;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public int getQuantity() {
		return this.quantity;
	}
    
    public String getType() {
		return this.type;
    }
    
    public static int getTotalNumOfItems() {
		return totalNumOfItems;
	}
    
    public static void setTotalNumOfItems(int totalNumOfItems) {
		ShopItem.totalNumOfItems = totalNumOfItems; // static variable so accessed by class name
	}
    
    
    public abstract void calculatePower(); // abstract method - will be implemented by subclasses
    public abstract void calculateFinalPrice(); // discount or tax can be applied in subclasses
    
    public String toString() {
		return 	"\nID: " + id 
				+ "\nName: " + name 
				+ "\nType: " + type 
				+ "\nPower: " + power
				+ "\nPrice: " + base_price + " Golds" // base_price is updated in calculateFinalPrice() in subclasses
				+ "\nRarity: " + rarity 
				+ "\nStock Quantity: " + quantity;
	}
}
