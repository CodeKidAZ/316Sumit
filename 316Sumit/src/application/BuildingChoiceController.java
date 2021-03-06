package application;

import java.net.URL;
import java.util.ResourceBundle;

import cst316.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;

public class BuildingChoiceController extends AnchorPane {
	@FXML 
	private ResourceBundle resources;
	@FXML 
	private URL location;
	@FXML
	private TextArea descriptionBox;
	@FXML
	private ComboBox<String> dropMenu;
	@FXML
	private Button returnButton;
	@FXML
	private ImageView buildingPicture;
	@FXML
	private Button purchaseButton;
	
	private String output;
	private Main application;
	private Player player;

	// Event Listener on ComboBox[#dropMenu].onAction
	@FXML
	public void dropMenuFired(ActionEvent event) {
		output = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
		switch(output) {
			case "Basic Building": 
				Image image = new Image("file:/../res/building_1.png");
				buildingPicture.setImage(image);
				descriptionBox.clear();
				descriptionBox.appendText("Cost: x \n");
				descriptionBox.appendText("Description: The basic building for entrepreneurs.");
				break;
			case "Factory":
				Image image2 = new Image("file:/../res/building_2.png");
				buildingPicture.setImage(image2);
				descriptionBox.clear();
				descriptionBox.appendText("Cost: x \n");
				descriptionBox.appendText("Description: A small scale factory for mass production");				; 
				break;
			case "Advanced Building": 
				Image image3 = new Image("file:/../res/building_3.png");
				buildingPicture.setImage(image3);
				descriptionBox.clear();
				descriptionBox.appendText("Cost: x \n");
				descriptionBox.appendText("Description: A larger building and factory combo yeilds great production");
				break;
			case "Corporate HQ": 
				Image image4 = new Image("file:/../res/building_4.png");
				buildingPicture.setImage(image4);
				descriptionBox.clear();
				descriptionBox.appendText("Cost: x \n");
				descriptionBox.appendText("Description: The best building in the game yields massive production");	
				break;
		}
	}
	// Event Listener on ComboBox[#dropMenu].onContextMenuRequested
	@FXML
	public void changeMenu(ContextMenuEvent event) {};
	// Event Listener on Button[#returnButton].onAction
	@FXML
	public void returnButtonFired(ActionEvent event) throws Exception {
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		ctr.setApp(application);
		ctr.setPlayer(player);
	}
	
	//@Override
	public void setApp(Main app) {
		application = app;
		dropMenu.getItems().setAll("Basic Building",
								   "Factory",
								   "Advanced Building",
							 	   "Corporate HQ");
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/*
	 * When things come together, add an if statement checking the player's
	 * money balance, and add this asset to their list if they have enough
	 * and subtract that for their current amount.
	 */
	
	@FXML
	public void purchaseButtonFired(ActionEvent event) {
		if(output != null) {
			switch(output) {
			case "Basic Building": 
				break;
			case "Factory":
				break;
			case "Advanced Building":
				break;
			case "Corporate HQ":
				break;
			}
		}
	}
}
