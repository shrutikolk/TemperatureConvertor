package temperature;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;



public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception
	{
		super.init();
	}
	
	@Override 
	public void start(Stage primaryStage)throws IOException
	{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
			VBox rootNode = loader.load();
			
			MenuBar menuBar = createMenu();
			rootNode.getChildren().add(0,menuBar);		
			
			Scene scene = new Scene(rootNode);
			
			primaryStage.setTitle("Temperature Convertor");
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	private MenuBar createMenu()
	{
	    Menu fileMenu = new Menu ("File");
	    MenuItem newMenuItem = new MenuItem("New");
	    
	    newMenuItem.setOnAction(event -> {System.out.println("New");});
	    
	    SeparatorMenuItem separator = new SeparatorMenuItem();
	    MenuItem exitMenuItem = new MenuItem("Exit");
	    
	    exitMenuItem.setOnAction(event -> 
	    {
	    	Platform.exit();
	    	System.exit(0);
	    });
	    
	    fileMenu.getItems().addAll(newMenuItem,separator,exitMenuItem);
	    
	    Menu helpMenu = new Menu ("Help");
	    MenuItem aboutMenuItem = new MenuItem("About App");
	    
	    aboutMenuItem.setOnAction(event -> aboutApp());
	    
	    helpMenu.getItems().addAll(aboutMenuItem);
	    
	    MenuBar menuBar = new MenuBar();
	    menuBar.getMenus().addAll(fileMenu,helpMenu);
	    
	    return menuBar;
	    
	}
	
	private void aboutApp()
	{
	    Alert alertbox = new Alert(Alert.AlertType.INFORMATION);
	    alertbox.setTitle("About the App");
	    alertbox.setHeaderText("Temperature Conversion");
	    alertbox.setContentText("This Tool is used to convert Temperature in Celcius to Farenheit and vice versa.");
	    alertbox.show();
	    
	}
	
	@Override
	public void stop() throws Exception
	{
		super.stop();
	}
}
