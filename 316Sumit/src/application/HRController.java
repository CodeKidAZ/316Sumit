package application;
//
import cst316.Player;
import cst316.Employee;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 *
 * @author Sumit
 */
public class HRController extends AnchorPane {
    private Main application;
     private Player player;
    //public static TreeMap<String, Employee> empTree = new TreeMap<String,Employee>(); //to store all employee data
    //public static TreeMap<String, Employee> hiredTree = new TreeMap<String,Employee>(); // to store all hired employees data
    
    public static ObservableList<Employee> CompanyList = FXCollections.observableArrayList(); // to store list of companies
    //=========================USER DEFINED VARIABLES========================================
    @FXML
    private Label hrTitleLabel;
    @FXML
    private Button hireButton;
    @FXML
    private Button fireButton;
    @FXML
    private Button workersListButt;
    @FXML
    private Button incorporateButton;
    @FXML
    private Button createCompanyButton;
    @FXML
    private TableView<Employee> CompanyTableView;
    @FXML
    private TableColumn<Employee, String> companyNameColumn;
    @FXML
    private TableColumn<Employee, Number> employeesColumn;
    
    //____________________________________________________SET METHODS
    public void setApp(Main app) {
        this.application = app;
        companyNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    // -> is lambda expression
        CompanyTableView.setItems(CompanyList); 
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    @FXML
    //____________________________________________________BACK BUTTON
    private void onBack() throws Exception {
        System.out.println("YOU CLICKED BACK");
        
        LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }
    
     //____________________________________________________OPEN HIRE SCREEN
    @FXML
    private void openHire(ActionEvent event) throws Exception {
        
        System.out.println("YOU CLICKED HIRE");
        HireController ctr = (HireController) application.replaceSceneContent("Hire.fxml", HireController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }
    //____________________________________________________OPEN HIRE SCREEN
    @FXML
    private void openFire(ActionEvent event) throws Exception {
        System.out.println("YOU CLICKED FIRE");
        FireController ctr = (FireController) application.replaceSceneContent("Fire.fxml", FireController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    //____________________________________________________OPEN WORKERS LIST SCREEN
    @FXML
    private void openWorkersList(ActionEvent event) throws Exception {
         WorkersListController ctr = (WorkersListController) application.replaceSceneContent("WorkersList.fxml", WorkersListController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
        
    }
    
     //____________________________________________________OPEN CORP SCREEN
    @FXML
    private void openCorpScreen(ActionEvent event) throws Exception{
        CorpController ctr = (CorpController) application.replaceSceneContent("Corp.fxml", CorpController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

     //____________________________________________________CREATE COMPANY
    @FXML
    private void createCompany(ActionEvent event) {
    
       Optional<String> response = Dialogs.create().lightweight()
            .title("HUMAN RESOURCE")
            .masthead("Create a Company")
            .message("Please name your new company.")
            .showTextInput("MyCompanyName");
        
       if(response.isPresent())
       {
           System.out.println("Company Name is " + response.get());
          
       }
       Employee a = new Employee(response.get()+".Corp",0);
       CompanyList.add(a);
       CompanyTableView.setItems(CompanyList); 
  
        //wageColumn.setCellValueFactory(cellData -> cellData.getValue().getWageProperty()); 
       
            
    }
    
}
