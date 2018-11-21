package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CreateAccount implements Initializable {

    /* used to store the correct username and password from the account creation controller
     Once the user input passes the input checking, it will be stored onto a database */


    /* username, password, and respective getters/setters */
    private String password = "";
    private String userEmail = "";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    @FXML
    private AnchorPane mainAccountCreatePane;

    @FXML
    private Label mainEmailLabel;

    @FXML
    private TextField mainUsernameInfo;

    @FXML
    private PasswordField mainPasswordInfo;

    @FXML
    private Button createAcctButton;

    @FXML
    private Label mainPasswordLabel;

    @FXML
    private Label acctText;

    @FXML
    private PasswordField confirmPasswordInfo;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private Label shortPasswordErrorMSG;

    @FXML
    private Label passwordMismatchErrorMSG;

    @FXML
    private Label invalidEmailErrorMSG;

    @FXML
    private Button cancelToLoginMain;

    /* username and password input handling methods */

    // the following algorithm is provided by GeeksforGeeks
    // https://www.geeksforgeeks.org/check-email-address-valid-not-java/

    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public void checkEmailProperty(TextField mainUsernameInfo) {
        if (isValid(mainUsernameInfo.getText())) {
            invalidEmailErrorMSG.setVisible(false);
            setUserEmail(mainUsernameInfo.getText());

        } else {
            invalidEmailErrorMSG.setVisible(true);

        }

    }

    public void checkPasswordLength(PasswordField mainPasswordInfo) {
        if (mainPasswordInfo.getLength() < 8) {
            shortPasswordErrorMSG.setVisible(true);

        } else {
            shortPasswordErrorMSG.setVisible(false);
        }
    }

    public void checkMatchingPasswords(PasswordField mainPasswordInfo, PasswordField confirmPasswordInfo) {

        if (mainPasswordInfo.getText().compareTo(confirmPasswordInfo.getText()) != 0) {
            passwordMismatchErrorMSG.setVisible(true);
            mainPasswordInfo.clear();
            confirmPasswordInfo.clear();

        } else {
            passwordMismatchErrorMSG.setVisible(false);
            setPassword(confirmPasswordInfo.toString());
        }


    }

    // binding buttons' onAction methods
    public void handleAccountCreationActions() {
        createAcctButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // on the user's click of the "Create account" button, the program will check
                // if the password input is > 8 characters, and it matches to the confirm password

                checkEmailProperty(mainUsernameInfo);
                checkPasswordLength(mainPasswordInfo);
                checkMatchingPasswords(mainPasswordInfo, confirmPasswordInfo);

            }
        });

    }

    public void handleCancelActions() {
        cancelToLoginMain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // if the user decides to cancel the account creation, their input data will
                // be cleared, and they will be returned to the LoginMain screen

                mainUsernameInfo.clear();
                mainPasswordInfo.clear();
                confirmPasswordInfo.clear();
                // ScreenManager.getInstance().switchToScreen("Screens/iCodeFitLoginMain.fxml");

            }
        });

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // hides the error messages on screen start-up. They will appear if the passwords mismatch
        // or if the password is too short

        invalidEmailErrorMSG.setVisible(false);
        shortPasswordErrorMSG.setVisible(false);
        passwordMismatchErrorMSG.setVisible(false);

        handleAccountCreationActions();
        handleCancelActions();

    }
}
