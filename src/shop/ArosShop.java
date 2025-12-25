package shop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import products.*; // import all products

public class ArosShop {
	private static List<ShopItem> shopList = new ArrayList<>();
	private static List<ShopItem> purchasedItems = new ArrayList<>();
	private static Set<String> itemTypes = new HashSet<>(List.of("Weapon", "Armor", "Potion"));
	private static String fILE_NAME = "products.txt"; // initial product list to load to shop 
	
	public static String addItemToShop(ShopItem item) {	
		if(searchItemById(item.getId()) != null) {
			return "Item ID Already Exists!"; // item with same ID already exists
		}
		
		// if set does not contain item type
		if(!itemTypes.contains(item.getType())) {
			return "Invalid Item Type! Must be one of: "+ "(" + String.join(", ", itemTypes) + ")";
		}
		
		shopList.add(item); // add item to shop
		ShopItem.setTotalNumOfItems(ShopItem.getTotalNumOfItems() + item.getQuantity()); // increment total item count as much as quantity
		return "Item Added to the Shop List Successfully";
	}
	
	public static boolean deleteItem(ShopItem item) {
		if(item.getQuantity() > 0) {
			return false; // cannot delete item with stock available
		}
		shopList.remove(item);
		return true; // item deleted successfully
	}
	
	public static ShopItem searchItemById(int id) {
		ShopItem foundItem;
		for(ShopItem item : shopList) {
			if(item.getId() == id) {
				foundItem = item;
				return foundItem;
			}
		}
		return null;
	}
	
	public static String searchItemByType(String type) {
		String res = "";
		for(ShopItem item : shopList) {
			if(item.getType().equalsIgnoreCase(type)) {
				res += item.toString() + "\n------------------\n";
			}
		}
		return res;
	}
	
	public static String searchItemByName(String name) {
		String res = "";
		for(ShopItem item : shopList) {
			if(item.getName().equalsIgnoreCase(name)) {
				res += item.toString() + "\n------------------\n";
			}
		}
		return res;
	}
	
	public static String displayAll() {
		String res = "";
		for(ShopItem item : shopList) {
			res += item.toString() + "\n------------------\n";
		}
		return res;
	}
	
	public static String purchaseItem(ShopItem item, int quantity) {
		if(item.purchase(quantity)) { // it decreased stock if successful
			purchasedItems.add(item);
			ShopItem.setTotalNumOfItems(ShopItem.getTotalNumOfItems() - quantity); // decrease total item count
			deleteItem(item); // try to delete item if quantity is 0
			return "Purchased " + item.getName() + " Successfully"; // purchase successful
		}
		return "Could Not Purchase " + item.getName() + " Due To Insufficient Stock"; // purchase failed
	}
	
	public static List<ShopItem> getShopList() {
		return shopList;
	}
	
	public static List<ShopItem> getPurchasedItems() {
		return purchasedItems;
	}
	
	public static void loadProductsToShop() {
		File file = new File(fILE_NAME);
		try {
			Scanner sc = new Scanner(file);
			String[] att = null;
			String line = null;
			ShopItem item = null;
			Stats stats = null;
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				att = line.split("\\*"); // split by *
				String itemType = att[0];
				
				if(itemType.equalsIgnoreCase("Weapon")) {
					stats = new Stats(att[7], att[8], att[9],att[10]);
					stats.calculateNeededStrength();
					item = new Weapon(
							itemType,
							att[1],
							att[2],
							att[3],
							att[4],
							att[5],
							att[6],
							stats
							);
				}
				else if(itemType.equalsIgnoreCase("Armor")) {
					stats = new Stats(att[8], att[9], att[10], att[11]);
					stats.calculateNeededStrength();
					item = new Armor(
							itemType,
							att[1],
							att[2],
							att[3],
							att[4],
							att[5],
							att[6],
							att[7],
							stats
							);
			
				}
				else if(itemType.equalsIgnoreCase("Potion")) {
					item = new Potion(
							itemType,
							att[1],
							att[2],
							att[3],
							att[4],
							att[5],
							att[6],
							att[7],
							att[8],
							att[9]
							); // No Stats for Potion
				}
				
				if(item != null) {
					item.calculateFinalPrice(); // calculate final price before adding to shop
					item.calculatePower();
					addItemToShop(item); // add item to shop
				}
			} // while
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	} // loadProductsToShop
	
	public static String[] getItemTypesArray() {
		String[] typesArray = new String[itemTypes.size()];
		int i = 0;
		for (String typeString : itemTypes) {
			typesArray[i] = typeString;
			i++;
		}
		return typesArray;
	} // for GUI ComboBox
}
