package temperature;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
	
	@FXML
	public Label welcomeLabel;
	
	@FXML
	public ChoiceBox<String> choiceBox;
	
	@FXML
	public TextField userInputField;
	
	@FXML
	public Button convertButton;
	
	private static final String C_to_F = "Celcius to Farenheit";
	private static final String F_to_C = "Farenheit to Celcius";
	
	private boolean isC_to_F = true;
	
	@Override
	public void initialize(URL location, ResourceBundle resouces)
	{
		choiceBox.getItems().add(C_to_F);
		choiceBox.getItems().add(F_to_C);
		
		choiceBox.setValue(C_to_F);
		
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
			if(newValue.equals(C_to_F))
			{
				isC_to_F = true;
			}
			else
			{
				isC_to_F = false;
			}
		});
			
		convertButton.setOnAction(event -> {
			convert();
		});
	}

	private void convert() 
	{
		String input = userInputField.getText();
		float enteredTemperature =0.0f;
		
		try
		{
		    enteredTemperature = Float.parseFloat(input);
		}
		catch(Exception exception)
		{
			warnuser();
			return;
		}
		
		float newTemperature = 0.0f;
		
		if(isC_to_F)
		{
			newTemperature = (enteredTemperature*9/5)+32;
		}
		else
		{
			newTemperature = (enteredTemperature-32)*5/9;
		}
		display(newTemperature);
		}

	private void warnuser() 
	{
		Alert alertbox = new Alert(Alert.AlertType.WARNING);
	    alertbox.setTitle("Error Occured");
	    alertbox.setHeaderText("Invalid Temperature Entered");
	    alertbox.setContentText("Please Enter a Valid Temperature.");
	    alertbox.show();
		
	}

	private void display(float newTemperature)
	{
		String unit = isC_to_F?"F":"C";
		
		Alert alertbox = new Alert(Alert.AlertType.INFORMATION);
	    alertbox.setTitle("Result");
	    alertbox.setHeaderText("Message");
	    alertbox.setContentText("The New Temperature is "+newTemperature+unit);
	    alertbox.show();
	}
}
	