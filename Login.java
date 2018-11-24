package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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


public class Login implements Initializable {

    /***************************************************************
     /* LOGIN FXML ELEMENTS
     ****************************************************************/

    @FXML
    private AnchorPane mainLoginScreen;

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
    private PasswordField PasswordInfo;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Label welcomeText;

    @FXML
    private Label hook;

    /***************************************************************
     /* METHODS RELATED TO INPUT VERIFICATION
     ****************************************************************/
    public void checkExistingAccount () throws IOException {

        /*
        if (UsernameInfo.getText() != databaseValue) {
            existingUsernameErrorMSG.setVisible(true);


        }

        else {
            existingUsernameErrorMSG.setVisible(false);
        } */


    }

    public void checkCorrectPassword () throws IOException {}



    /***************************************************************
     /* METHODS RELATED TO BUTTON PRESS
     ****************************************************************/
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        
        Stage stage;
        Parent root;
        
        if(event.getSource()==signupButton){
            //get reference to the button's stage         
            stage=(Stage) signupButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        }
        else{
            // TODO: import input verification methods from CreateAccount.java here
            // TODO: check for existing accounts (using text database)
            stage=(Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /***************************************************************
     /* ININTIALIZABLE
     ****************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        existingPasswordErrorMSG.setVisible(false);
        existingUsernameErrorMSG.setVisible(false);
    }
}


