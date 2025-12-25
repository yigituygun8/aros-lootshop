package shop;

import GUI.*;

public class shopMain {

	public static void main(String[] args) {
		ArosShop.loadProductsToShop(); // load products from file to shop inventory
		LobbyFrame mainFrame = new LobbyFrame();
		mainFrame.setVisible(true);
	}

}
