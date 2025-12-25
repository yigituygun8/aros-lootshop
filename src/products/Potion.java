package products;

public class Potion extends ShopItem{

	private String effect; // e.g., "Healing", "Strength Boost", "Poisonous
	private String duration; // e.g., "5 minute(s)", "2 hour(s)", "1 hour(s)"
	private boolean isHazardous;
	private boolean throwable;
	
	public Potion() {}
	
	public Potion(String type, String id, String name, String price, String rarity, String quantity, String effect, String duration, String isHazardous, String throwable) {
		super(type, Integer.parseInt(id), name, Double.parseDouble(price), rarity, Integer.parseInt(quantity));
		this.effect = effect;
		this.duration = duration;
		this.isHazardous = Boolean.parseBoolean(isHazardous);
		this.throwable = Boolean.parseBoolean(throwable);
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
		
		//calculate time in seconds
		String[] divide = this.duration.split(" ");
		int time = Integer.parseInt(divide[0]);
		if(divide[1].equalsIgnoreCase("hour(s)"))
			time *= 60 * 60;
		if(divide[1].equalsIgnoreCase("minute(s)"))
			time *= 60;
		
		power_mult += Math.floor(10 * (time / (time + 600))) / 10; // longer duration increases power
		// Calculation Explanation: to obtain a value between 0 and 1, we use time / (time + 600). 
		// Multiplying by 10 and flooring gives us one decimal place. (e.g. 0.8574 -> 8.574 -> 8 -> 0.8)
		
		if(throwable) {
			if(isHazardous)
				power_mult += 0.3;
			else
				power_mult += 0.1;
		}
		else // drinkable
			if(isHazardous)
				power_mult -= 0.5;
			else
				power_mult += 0.1;
			
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
		
		if(throwable)
			price_mult += 0.2;
		
		String[] divide = this.duration.split(" ");
		if(divide[1].equalsIgnoreCase("hour(s)"))
			price_mult += 0.5;
		else if(divide[1].equalsIgnoreCase("minute(s)"))
			price_mult += 0.3;
		
		this.base_price *= price_mult;
		this.base_price = Math.round(this.base_price);
	}

	@Override
	public String toString() {
		return  "Potion Details:\n" 
				+ super.toString() 
				+ "\nPotion Effect = " + effect 
				+ "\nDuration = " + duration
				+ "\nIs it throwable? " + (throwable ? "Yes!" : "No!")
				+ "\nIs it hazardous? " + (isHazardous ? "Yes!" : "No!");
	}
}
