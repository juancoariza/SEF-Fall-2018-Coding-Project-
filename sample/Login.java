package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class Login implements Initializable {

    /* Elements of the GUI screen*/

    @FXML
    private AnchorPane mainLoginScreen;

    @FXML
    private PasswordField PasswordInfo;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Label mainPasswordLabel;

    @FXML
    private Label mainUsernameLabel;

    @FXML
    private Label existingUsernameErrorMSG;

    @FXML
    private Label existingPasswordErrorMSG;

    @FXML
    private TextField UsernameInfo;

    @FXML
    private Label welcomeText;

    @FXML
    private Label hook;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        
        Stage stage;
        Parent root;
        
        if(event.getSource()==signupButton){
            //get reference to the button's stage         
            stage=(Stage) signupButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("AccountCreate.fxml"));
        }
        else{
            stage=(Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        existingPasswordErrorMSG.setVisible(false);
        existingUsernameErrorMSG.setVisible(false);
    }
}


