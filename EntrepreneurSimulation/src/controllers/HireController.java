package controllers;
import application.MainA;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.in;

import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.JSONObject;
import org.json.JSONTokener;

public class HireController implements Initializable 
{
   
    protected Hashtable<String, Employee> employees = new Hashtable<String,Employee>();
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
        System.out.println(System.getProperty("user.dir"));
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("src\\dataFiles\\employeeData.txt"));
            String strLine;
       
            while ((strLine = br.readLine()) != null) 
            {
                 JSONObject obj = new JSONObject(strLine);                  //extract employee info from datafile
                 String name = obj.get("name").toString();
                 int wage = (int)obj.get("wage");
                 
                 Employee empObject = new Employee(name, wage);      //create employee objects
                 employees.put(name, empObject);                               //store employee object into hashtable
                 
                 //System.out.println("Employee Name is "+ obj.get("name") + " Wage is "+ obj.get("wage"));
                 System.out.println(name + " "+wage);
                 //System.out.println("Sumit's wage is " + employees.get("Sumit").getWage());
            }
            //Close the input stream
            in.close();
            //chekding comment again
        } 
        catch (Exception e) 
        {   //Catch exception if any
            System.err.println("Error: " + e.getMessage());
        } 
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
