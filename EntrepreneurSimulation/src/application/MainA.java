
package application;

import controllers.*;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainA extends Application 
{
    private Stage primaryStage;
    private AnchorPane root;
    
    @Override
    public void start(Stage primaryStage) 
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("The Entreprenuership Game");
        openHRScreen();
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
    public Stage getPrimaryStage() 
    {
        return primaryStage;
    }
    //___________________________________________________HR SCREEN
    public void openHRScreen() 
    {
        try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/fxmlFiles/HR.fxml"));

            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
           HRController controller = loader.getController();
           controller.setMainA(this);
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    //____________________________________________________HIRE SCREEN
    public void openHireScreen()
    {
         try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/fxmlFiles/hire.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            HireController controller = loader.getController();
           controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
    }
    //____________________________________________________FIRE SCREEN
    public void openFireScreen()
    {
         try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/fxmlFiles/fire.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            FireController controller = loader.getController();
            controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
        
    }
}
