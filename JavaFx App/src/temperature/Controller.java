/**
 * Class name: Controller
 * @version 1.8.0_221
 * @author ShrutiSinha 
 * @date 15 Sept 2019
 * 
 * Description:
 * This Tool is used to convert Temperature in Celcius to Farenheit and vice versa.
 * 
 **/

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

/*
 * Class to initialize and implement the data obtained
 */
public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel;
	
    @FXML
    public ChoiceBox<String> choiceBox;//choiceBox for user options
	
    @FXML
    public TextField userInputField;//TextField to take user's input
	
    @FXML
    public Button convertButton;//button to bring the application to action
	
    private static final String C_to_F = "Celcius to Farenheit";//setting default values
    private static final String F_to_C = "Farenheit to Celcius";//setting default values
	
    private boolean isC_to_F = true;//for check
	
    /*
     * Method to get user inputs
     */
    @Override
    public void initialize(URL location, ResourceBundle resouces) {
        //setting options to the checkBox
        choiceBox.getItems().add(C_to_F);
        choiceBox.getItems().add(F_to_C);
		
        choiceBox.setValue(C_to_F);
		
        //getting the selected option
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
            if(newValue.equals(C_to_F)) { //checking the selected option*/ 
                isC_to_F = true;
            }
            else {
                isC_to_F = false;
            }
       }); 
			
        convertButton.setOnAction(event -> {
            convert();
        });//sending the control to convert method for further actions
	}

    /*
     * Method to convert the temperature
     */
    private void convert() {
        String input = userInputField.getText();//getting user input
        float enteredTemperature =0.0f;
		
        //checking the validation the input made by the user
        try {
            enteredTemperature = Float.parseFloat(input);
        }
        catch(Exception exception) {
            warnuser();//if the input is wrong user is warned
            return;
        }
		
        float newTemperature = 0.0f;
		
        //temperature calculation
        if(isC_to_F) {
            newTemperature = (enteredTemperature*9/5)+32;
        }
        else {
            newTemperature = (enteredTemperature-32)*5/9;
        }
        display(newTemperature);//the display of converted temperature
    }

    /*
     * Method to show AlertBox for warning user
     */
    private void warnuser() {
        Alert alertbox = new Alert(Alert.AlertType.WARNING);
        alertbox.setTitle("Error Occured");
        alertbox.setHeaderText("Invalid Temperature Entered");
        alertbox.setContentText("Please Enter a Valid Temperature.");
        alertbox.show();
    }
	
    /*
     * Method to display the output of the Application 
     */
    private void display(float newTemperature) {
        String unit = isC_to_F?"F":"C";
        Alert alertbox = new Alert(Alert.AlertType.INFORMATION);
        alertbox.setTitle("Result");
        alertbox.setHeaderText("Message");
        alertbox.setContentText("The New Temperature is "+newTemperature+unit);
        alertbox.show();
        userInputField.clear();
    }
}//end of Controller class