package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aimsproject.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	@FXML
	private TableView<Media> tblMedia;
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediacategory;
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	@FXML 
	private Button btnPlay;
	@FXML
	private Button btnRemove;
	
	public CartScreenController (Cart cart) {
		super();
		this.cart = cart;
	}

	@FXML
	private void initialize() {
		
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title")); 
		colMediacategory.setCellValueFactory (new PropertyValueFactory<Media, String>("category")); 
		colMediaCost.setCellValueFactory (new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems (this.cart.getItems0rdered());
		
		btnPlay.setVisible(false); 
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<Media>() {
			@Override
			public void changed (ObservableValue<? extends Media> observable, Media oldValue,Media newValue) {
				if(newValue!=null) {
					updateButtonBar(newValue);
				}
			}
		});
	}
	void updateButtonBar (Media media) {
		btnRemove.setVisible(true); 
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
		}
	}
}

