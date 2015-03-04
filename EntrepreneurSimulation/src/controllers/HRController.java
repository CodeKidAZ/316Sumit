package controllers;
//
import application.MainA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static java.lang.System.in;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author Sumit
 */
public class HRController implements Initializable 
{
    private MainA a;
    public static TreeMap<String, Employee> empTree = new TreeMap<String,Employee>(); //to store all employee data
    public static TreeMap<String, Employee> hiredTree = new TreeMap<String,Employee>(); // to store all hired employees data
    
    //=========================USER DEFINED VARIABLES========================================
    
    @FXML
    private Label hrTitleLabel;
    @FXML
    private Button hireButton;
    @FXML
    private Button fireButton;
    @FXML
    private Button workersListButt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //_________________________________________________ LOAD EMPLOYEE DATA FROM JSON FILE
         if(empTree.size() ==0)
         {
        	 String strLine=" ";
             try 
            {
            	/*File file = new File("src/dataFiles/employeeData.txt");
            	FileReader filereader = new FileReader(file.getAbsolutePath());
            	BufferedReader br = new BufferedReader(filereader);
                */
                BufferedReader br = new BufferedReader(new FileReader("src/dataFiles/employeeData.txt"));
                //System.out.println(file.getCanonicalPath());
           
                while ((strLine = br.readLine()) != null) 
                {
                     JSONObject obj = new JSONObject(strLine);                  //extract employee info from datafile
                     String name = obj.get("name").toString();
                     int wage = (int)obj.get("wage");
                     Employee empObject = new Employee(name, wage);     //create employee objects
                     empTree.put(name, empObject);                                //store employee object into hashtable
                    
                }
                in.close();
            } 
            catch (Exception e) 
            {   //Catch exception if any
                System.err.println("Error: " + e.getMessage());
                System.out.println("Error "+ strLine);
            } 
         }
         else
         {
        	 System.out.println("empTree size is "+empTree.size());
         }
    }    

    @FXML //_________________________________OPEN HIRE SCREEN
    private void openHire(ActionEvent event) 
    {
        System.out.println("YOU CLICKED HIRE");
        a.openHireScreen();
    }

    @FXML  //________________________________OPEN FIRE SCREEN
    private void openFire(ActionEvent event) 
    {
        System.out.println("YOU CLICKED FIRE");
        a.openFireScreen();
    }
    public void setMainA(MainA a)
    {
        this.a = a;
        
    }

    @FXML //_________________________________OPEN WORKERS LIST SCREEN
    private void openWorkersList(ActionEvent event) 
    {
        System.out.println("YOU CLICKED WORKERS LIST");
        a.openWorkersListScreen();
        
    }
    
}
