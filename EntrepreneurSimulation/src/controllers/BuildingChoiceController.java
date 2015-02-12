
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;

public class BuildingChoiceController implements Initializable 
{
    @FXML
    private TextArea descriptionBox;
    @FXML
    private Button purchaseButton;
    @FXML
    private ComboBox<String> dropMenu;
    @FXML
    private Button returnButton;
    @FXML
    private ImageView buildingPicture;

    String output;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        {
            dropMenu.getItems().setAll("Basic Building",
                    "Factory",
                    "Advanced Building",
                    "Corporate HQ");
        }
       
    }    

    @FXML
    private void purchaseButtonFired(ActionEvent event) 
    {
        {
            if (output != null) 
            {
                switch (output) 
                {
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

    @FXML
    private void changeMenu(ContextMenuEvent event) {
    }

    @FXML
    private void dropMenuFired(ActionEvent event) 
    {
        {
            output = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
            switch (output) {
                case "Basic Building":
                    Image image = new Image("images/building_1.png");
                    buildingPicture.setImage(image);
                    descriptionBox.clear();
                    descriptionBox.appendText("Cost: x \n");
                    descriptionBox.appendText("Description: The basic building for entrepreneurs.");
                    break;
                case "Factory":
                    Image image2 = new Image("images/building_2.png");
                    buildingPicture.setImage(image2);
                    descriptionBox.clear();
                    descriptionBox.appendText("Cost: x \n");
                    descriptionBox.appendText("Description: A small scale factory for mass production");
                    ;
                    break;
                case "Advanced Building":
                    Image image3 = new Image("images/building_3.png");
                    buildingPicture.setImage(image3);
                    descriptionBox.clear();
                    descriptionBox.appendText("Cost: x \n");
                    descriptionBox.appendText("Description: A larger building and factory combo yeilds great production");
                    break;
                case "Corporate HQ":
                    Image image4 = new Image("images/building_4.png");
                    buildingPicture.setImage(image4);
                    descriptionBox.clear();
                    descriptionBox.appendText("Cost: x \n");
                    descriptionBox.appendText("Description: The best building in the game yields massive production");
                    break;
            }
        }
    }

    @FXML
    private void returnButtonFired(ActionEvent event) {
    }
    
}
