package hust.soict.dsai.aims.screen;

import java.awt.Insets;
import java.io.IOException;

import hust.soict.dsai.aimsproject.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class StoreController {

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {

    }
    
	private Store store;
	public StoreController (Store store) {
		this.store = store;
	}
	
	@FXML
	public void initialize() {
		final String ITEM_FXML_FILE_PATH = "/hust/soict/[globalict/dsai]/aims/screen/customer/view/Item.fxml"; 
		int column= 0;
		int row = 1;
		for (int i=0; i<store.getItemsInStore().size(); i++) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH)); 
				ItemController itemController = new ItemController(cart);
				fxmlLoader.setController (itemController);
				AnchorPane anchorPane = new AnchorPane(); anchorPane = fxmlLoader.load();
				itemController.setData(store.getItemsInStore().get(i));
				if (column== 3) {
					column = 0;
					row++;
				}
				gridPane.add(anchorPane, column++, row);
				GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
	}
}
