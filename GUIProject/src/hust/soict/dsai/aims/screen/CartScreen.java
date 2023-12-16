package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aimsproject.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.io.IOException;

//import javafx.embed.swing.JFXPanel;
import javax.swing.JFrame;

public class CartScreen extends JFrame{ 
	private static Cart cart;
	public CartScreen(Cart cart) { 
		super();
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel(); 
		this.add(fxPanel);
		
		this.setTitle("Cart"); 
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader (getClass().getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController (cart);
					loader.setController(controller);
					Parent root = loader.load(); 
					fxPanel.setScene(new Scene(root));
				}catch (IOException e) {
						e.printStackTrace();
					}
				}
			
		});
	}
}

