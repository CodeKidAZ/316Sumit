
package controllers;

import application.MainA;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class WorkersListController implements Initializable 
{
     private MainA a;
    @FXML
    private Label hrTitleLabel;
     @FXML
    private TableView<Employee> workerTable;
    private ObservableList<Employee> workerData = FXCollections.observableArrayList(); 
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Number> wageColumn;
    @FXML
    private Button backButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        System.out.println("init worker list controller");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    // -> is lambda expression
        wageColumn.setCellValueFactory(cellData -> cellData.getValue().getWageProperty()); 
        
        System.out.println("hired Tree is : "+ HRController.hiredTree.size());
        Set<String> setNames = HRController.hiredTree.keySet();      //get keys from Employee Tree Map
        //System.out.println("Names are " + setNames);
        for (String key: setNames)
        {
            
            String employeeName = HRController.hiredTree.get(key).getName();
             System.out.println("EmployeeNames are " + key);
            
            int employeeWage = HRController.hiredTree.get(key).getWage();
            Employee node = new Employee(employeeName, employeeWage);
            workerData.add(node);
        }
         workerTable.setItems(workerData);
       
    }    
    public void setMainA(MainA a)
    {
        this.a = a;
    }

    @FXML
    private void backMethod(ActionEvent event) 
    {
        System.out.println("YOU CLICKED BACK");
        a.openHRScreen();
    }
}
