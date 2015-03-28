package application;
//
import cst316.Player;
import cst316.Employee;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.action.Action;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
//import org.controlsfx.dialog.Dialogs;

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
    private Button workersListButt;
    @FXML
    private Button incorporateButton;
    @FXML
    private TableView<Employee> CompanyTableView;
    @FXML
    private TableColumn<Employee, String> companyNameColumn;
    @FXML
    private TableColumn<Employee, Number> employeesColumn;
    @FXML
    private TableColumn<?, ?> employeesColumn1;
    @FXML
    private TableColumn<?, ?> employeesColumn11;
    @FXML
    private ImageView fireImage;
    @FXML
    private ImageView hireImage1;
    @FXML
    private ImageView createCompanyImage;
    
    //____________________________________________________SET METHODS
    public void setApp(Main app) {
        this.application = app;
        companyNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    // -> is lambda expression
        CompanyTableView.setItems(CompanyList); 
        
        Image fire = new Image(this.getClass().getClassLoader().getResourceAsStream("res/deleteEmployee.png"));
        fireImage.setImage(fire);
        Image hire = new Image(this.getClass().getClassLoader().getResourceAsStream("res/hireEmployee.png"));
        hireImage1.setImage(hire);
        Image company = new Image(this.getClass().getClassLoader().getResourceAsStream("res/createCompany.png"));
        createCompanyImage.setImage(company);
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

    //____________________________________________________FIRE
    @FXML
    private void fireMouseExit(MouseEvent event) {
        fireImage.setScaleX(1);
        fireImage.setScaleY(1);
        
    }

    @FXML
    private void fireMouseEnter(MouseEvent event) {
       fireImage.setScaleX(1.2);
        fireImage.setScaleY(1.2);
        
    }

    @FXML
    private void openFire(MouseEvent event) throws Exception {
        System.out.println("YOU CLICKED FIRE");
        FireController ctr = (FireController) application.replaceSceneContent("Fire.fxml", FireController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    //_________________________________________________________HIRE
    @FXML
    private void openHire(MouseEvent event) throws Exception {
        System.out.println("YOU CLICKED HIRE");
        HireController ctr = (HireController) application.replaceSceneContent("Hire.fxml", HireController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    @FXML
    private void hireMouseExit(MouseEvent event) {
         hireImage1.setScaleX(1);
        hireImage1.setScaleY(1);
    }

    @FXML
    private void hireMouseEnter(MouseEvent event) {
         hireImage1.setScaleX(1.2);
        hireImage1.setScaleY(1.2);
    }

    //____________________________________________________CREATE COMPANY
    @FXML
    private void createCompanyMouseExit(MouseEvent event) {
         createCompanyImage.setScaleX(1);
        createCompanyImage.setScaleY(1);
    }

    @FXML
    private void createCompanyMouseEnter(MouseEvent event) {
        createCompanyImage.setScaleX(1.2);
        createCompanyImage.setScaleY(1.2);
    }

    @FXML
    private void createCompany(MouseEvent event) 
    {
        TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("HUMAN RESOURCE");
    	dialog.setHeaderText("Create a Company");
    	dialog.setContentText("Please enter new company name:");
    
    	Optional<String> result = dialog.showAndWait();
    	result.ifPresent(name -> System.out.println("Your name: " + name));
           System.out.println("Company Name is " + result.get());
           Employee a = new Employee(result.get()+".Corp",0);
           CompanyList.add(a);
           CompanyTableView.setItems(CompanyList); 
    }
    
    
    
}
