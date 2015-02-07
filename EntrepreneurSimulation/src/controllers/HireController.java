package controllers;
import application.MainA;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HireController implements Initializable 
{
   
    
    @FXML
    private Label hireTitleLabel;
    @FXML
    private Button backButton;
    @FXML
    private Button doneButton;
    
    private MainA a;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void backMethod(ActionEvent event) 
    {
        System.out.println("YOU CLICKED BACK");
        a.openHireScreen();
        
    }

    @FXML
    private void doneMethod(ActionEvent event) 
    {
         System.out.println("YOU CLICKED DONE");
        a.openHireScreen();
    }

    public void setMainA(MainA aThis) 
    {
        this.a = a;
    }
    

}
