package products;

public class Stats {

	private String status; // New, Field Tested, Battle Scarred (worst)
	private String durability; // Low, Medium, High
	private String neededStrength; 
	private double weight;
	private boolean isMagical;
	
	public Stats(){}
	
	public Stats(String status, String durability, String weight, String isMagical) {
		this.status = status;
		this.durability = durability;
		this.weight = Double.parseDouble(weight);
		this.isMagical = Boolean.parseBoolean(isMagical);
	}
	
	// Based on weight, determine needed strength
	public void calculateNeededStrength() {
		if(weight < 5) {
			neededStrength = "Low";
		}
		else if(weight >=5 && weight <=8) {
			neededStrength = "Medium";
		}
		else {
			neededStrength = "High";
		}
	}
	

	public String getStatus() {
		return status;
	}

	public String getDurability() {
		return durability;
	}

	public boolean isMagical() {
		return isMagical;
	}

	@Override
	public String toString() {
		String temp="";
		
		if(isMagical==true)
			temp+="Yes!";
		else
			temp+="No!";
		
		return 		"	Status: " + status 
				+ "\n	Durability: " + durability 
				+ "\n	Needed Strength:" + neededStrength
				+ "\n	Weight: " + weight 
				+ "\n	Is it magical? " + temp;
	}
}