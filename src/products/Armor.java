package products;

public class Armor extends ShopItem{
	private int defence; // amount of damage it can absorb
	private String material; // leather, iron, dragon scale
	private Stats stats;
	
	public Armor() {}
	
	public Armor(String type, String id, String name, String price, String rarity, String quantity, String defence, String material, Stats stats) {
		super(type, Integer.parseInt(id), name, Double.parseDouble(price), rarity, Integer.parseInt(quantity));
		this.defence = Integer.parseInt(defence);
		this.material = material;
		this.stats = stats;
	}
	
	@Override
	public boolean purchase(int quantity) {
		if(this.quantity >= quantity) { // enough stock available
			this.quantity -= quantity; // reduce stock
			return true; // purchase successful
		}
		return false;
	}
	
	@Override
	public void calculatePower() {
		double power_mult = 1.0;
		
		// assume defence differse between 10-100
		power_mult += this.defence / 100.0;
		
		if(stats.isMagical())
			power_mult += 1;
		
		if(stats.getDurability().equalsIgnoreCase("medium"))
			power_mult += 0.2;
			
		else if(stats.getDurability().equalsIgnoreCase("high"))
			power_mult += 0.5;
		
		this.power =  BASE_POWER * power_mult;
		this.power = Math.round(this.power);
	}
	
	@Override
	public void calculateFinalPrice() {
		double price_mult = 1.0;
		if(this.rarity.equalsIgnoreCase("mythic"))
			price_mult += 1;
		else if(this.rarity.equalsIgnoreCase("epic"))
			price_mult += 0.5;
		else if(this.rarity.equalsIgnoreCase("common"))
			price_mult += 0.2;
		
		
		if(stats.getDurability().equalsIgnoreCase("low"))
			price_mult -= -0.2; // discount for low durability items
		else if(stats.getDurability().equalsIgnoreCase("high"))
			price_mult += 0.2; // increase price for high durability items
		
		
		if(this.isBroken()) price_mult -= 1;
		
		if(stats.getStatus().equalsIgnoreCase("New")) price_mult += 0.5; // increase price for new items
		else if(stats.getStatus().equalsIgnoreCase("Battle Scarred")) price_mult -= 0.2; // slight discount for battle scarred (worst) items
		
		this.base_price *= price_mult;
		this.base_price = Math.round(this.base_price);
	}
	
	// Considered broken if it has low durability and is battle scarred
	public boolean isBroken() {
		return stats.getDurability().equalsIgnoreCase("low") && stats.getStatus().equalsIgnoreCase("Battle Scarred");
	}
	
	public String toString() {
		return "Armor Details:\n"
				+ super.toString()
				+ "\nDefence = " + defence
				+ "\nMaterial =  " + material
				+ "\nStats:\n" + stats;
	}	
	
}
