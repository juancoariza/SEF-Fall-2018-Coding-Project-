package sample;

import java.io.File;
import java.util.Scanner;
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

  User user = new User();
  String password = "";
  String email = "";

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
  private TextField mainUsernameInfo;

  @FXML
  private PasswordField mainPasswordInfo;

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
  public void checkExistingAccount() throws IOException {

        /*
        if (UsernameInfo.getText() != databaseValue) {
            existingUsernameErrorMSG.setVisible(true);


        }

        else {
            existingUsernameErrorMSG.setVisible(false);
        } */

  }

  public void checkCorrectPassword() throws IOException {
  }


  /***************************************************************
   /* METHODS RELATED TO BUTTON PRESS
   ****************************************************************/
  @FXML
  void handleSignup(ActionEvent event) throws Exception {
    Stage stage;
    Parent root;

//  get reference to the button's stage
    stage = (Stage) signupButton.getScene().getWindow();
    //load up OTHER FXML document
    root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  void handleLogin(ActionEvent event) throws Exception {

    Stage stage;
    Parent root;
    //Search user method
    searchUsers();

    if (mainPasswordInfo.getText().equals(password)) {
      stage = (Stage) loginButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    } else {
      System.out.println("Passwords are not the same");
    }


  }

  public void searchUsers() {
    try {
      Scanner sc = new Scanner(new File("src/sample/UserInfo.txt"));
      while (sc.hasNextLine()) {
        String line = sc.nextLine().substring(4);
        if (mainUsernameInfo.getText().equals(line)) {
          System.out.println("Email has been found");
          user.name = sc.nextLine().substring(4);
          user.username = sc.nextLine().substring(4);
          password = sc.nextLine().substring(4);          ///MAKE SEX STRING
          user.sex = sc.nextLine().substring(4);          ///MAKE AGE STRING
          user.age = sc.nextLine().substring(4);
          user.targetWeight = sc.nextLine().substring(4);       ///ADD TARGET WEIGHT
          user.currentWeight = sc.nextLine().substring(4);    ///AD CURRENT WEIGHT
          System.out.println(password);
        } else {

        }
      }
    } catch (Exception ex) {
      System.out.println(ex);
    }


  }
  /***************************************************************
   /* ININTIALIZABLE
   ****************************************************************/
  @Override
  public void initialize (URL location, ResourceBundle resources){

    existingPasswordErrorMSG.setVisible(false);
    existingUsernameErrorMSG.setVisible(false);
  }
}



