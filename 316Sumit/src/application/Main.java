package application;
	
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

import cst316.Management;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage stage;
	private final double MINIMUM_WINDOW_WIDTH = 1280;
                 private final double MINIMUM_WINDOW_HEIGHT = 720;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// This will need to be redone, really badly!
			Management management = new Management();
			BorderPane root = new BorderPane();
			stage = primaryStage;
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
			primaryStage.setScene(scene);
			primaryStage.show();
			//LoginController ctr = (LoginController) replaceSceneContent("Login.fxml", LoginController.class
                                                LandingController ctr = (LandingController) replaceSceneContent("Landing.fxml", LandingController.class);
                                                //LoginController ctr = (LoginController) replaceSceneContent("Login.fxml");
			ctr.setApp(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// A lot of this was taken from the Oracle JFX samples, changes will be made
        /*public Node replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(); 
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page = new AnchorPane();
         try {
            page = (AnchorPane) loader.load();  //page is root node
        } catch (IOException e)
         {
             e.printStackTrace();
         }*/
        
        public Node replaceSceneContent(String fxml, Class<? extends AnchorPane> cls) throws Exception {
        FXMLLoader loader = new FXMLLoader(); //good
        
       // loader.setController(cls.getConstructor().newInstance()); //set controller good
        //InputStream in = Main.class.getResourceAsStream(fxml);
        //loader.setBuilderFactory(new JavaFXBuilderFactory());
            System.out.println(loader.getControllerFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page = new AnchorPane();
         try {
             
            page = (AnchorPane) loader.load();  //page is root node
        } catch (IOException e)
         {
             e.printStackTrace();
         }
         
       /* try {
            page = (AnchorPane) loader.load(in);  //page is root node
        } finally {
            in.close();
        }*/
        
        // Store the stage width and height in case the user has resized the window
        double stageWidth = stage.getWidth();
        if (!Double.isNaN(stageWidth)) {
            stageWidth -= (stage.getWidth() - stage.getScene().getWidth());
        }
        
        double stageHeight = stage.getHeight();
        if (!Double.isNaN(stageHeight)) {
            stageHeight -= (stage.getHeight() - stage.getScene().getHeight());
        }
        
        Scene scene = new Scene(page);
        if (!Double.isNaN(stageWidth)) {
            page.setPrefWidth(stageWidth);
        }
        if (!Double.isNaN(stageHeight)) {
            page.setPrefHeight(stageHeight);
        }
        
        stage.setScene(scene);
        stage.sizeToScene();
        return (Node) loader.getController();
    }
	
	/**
	 * If the provided class has been loaded from a jar file that is on the local file system, will find the absolute path to that jar file.
	 * Stolen from: http://stackoverflow.com/questions/1983839/determine-which-jar-file-a-class-is-from
	 * 
	 * @param context The jar file that contained the class file that represents this class will be found. Specify {@code null} to let {@code LiveInjector}
	 *                find its own jar.
	 * @throws IllegalStateException If the specified class was loaded from a directory or in some other way (such as via HTTP, from a database, or some
	 *                               other custom classloading device).
	 */
	public static String findPathJar(Class<?> context, String resource) throws IllegalStateException {
	    if (context == null) context = Main.class;
	    String rawName = context.getName();
	    String classFileName;
	    /* rawName is something like package.name.ContainingClass$ClassName. We need to turn this into ContainingClass$ClassName.class. */ {
	        int idx = rawName.lastIndexOf('.');
	        classFileName = (idx == -1 ? rawName : rawName.substring(idx+1)) + ".class";
	    }

	    String uri = context.getResource(classFileName).toString();
	    if (uri.startsWith("file:")) throw new IllegalStateException("This class has been loaded from a directory and not from a jar file.");
	    if (!uri.startsWith("jar:file:")) {
	        int idx = uri.indexOf(':');
	        String protocol = idx == -1 ? "(unknown)" : uri.substring(0, idx);
	        throw new IllegalStateException("This class has been loaded remotely via the " + protocol +
	                " protocol. Only loading from a jar on the local file system is supported.");
	    }

	    int idx = uri.indexOf('!');
	    //As far as I know, the if statement below can't ever trigger, so it's more of a sanity check thing.
	    if (idx == -1) throw new IllegalStateException("You appear to have loaded this class from a local jar file, but I can't make sense of the URL!");

        return uri.substring(0, idx) + "!" + resource;
	}
}
