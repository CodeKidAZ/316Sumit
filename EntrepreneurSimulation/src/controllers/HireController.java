package controllers;
import application.MainA;

import java.net.URL;
import java.util.Hashtable;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HireController implements Initializable 
{
      private MainA a;
      Random random = new Random();
    //protected Hashtable<String, Employee> employees = new Hashtable<String,Employee>();
    @FXML
    private Label hireTitleLabel;
    @FXML
    private Button backButton;
    @FXML
    private Button doneButton;
    @FXML
    private Label nameLabel1;
    @FXML
    private Label wageLabel1;
    @FXML
    private ImageView imageEmployee1;
    @FXML
    private Label wageLabel2;
    @FXML
    private Label nameLabel2;
    @FXML
    private ImageView imageEmployee2;
    @FXML
    private Label wageLabel3;
    @FXML
    private Label nameLabel3;
    @FXML
    private ImageView imageEmployee3;
    @FXML
    private Label wageLabel4;
    @FXML
    private Label nameLabel4;
    @FXML
    private ImageView imageEmployee4;
    @FXML
    private Label wageLabel5;
    @FXML
    private Label nameLabel5;
    @FXML
    private ImageView imageEmployee5;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Image image = new Image("images/employeeImage.png");
        imageEmployee1.setImage(image);
        imageEmployee2.setImage(image);
        imageEmployee3.setImage(image);
        imageEmployee4.setImage(image);
        imageEmployee5.setImage(image);
        
        int size = employees.keySet().size();
        int index=(int)(Math.random() * size)+1;
        System.out.println(index);
        for(Integer i : map.keySet()){
            if(index==1){
                System.out.println(i);
                break;
            }
            else{
                index--;
            }
        }
      
        
        System.out.println(System.getProperty("user.dir"));
       /* try 
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
                 System.out.println("Size is " +employees.size());
            }
            //Close the input stream
            in.close();
            //chekding comment again
        } 
        catch (Exception e) 
        {   //Catch exception if any
            System.err.println("Error: " + e.getMessage());
        } */
    }    

    @FXML
    private void backMethod(ActionEvent event) 
    {
        System.out.println("YOU CLICKED BACK");
        a.openHRScreen();
    }

    @FXML
    private void doneMethod(ActionEvent event) 
    {
         System.out.println("YOU CLICKED DONE");
         a.openHRScreen();
    }

    public void setMainA(MainA a) 
    {
        this.a = a;
    }

    @FXML
    private void emp1Clicked(MouseEvent event) 
    {
        nameLabel1.setText("this is employee 1");
    }
    

}
