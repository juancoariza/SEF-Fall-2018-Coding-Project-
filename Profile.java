package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Profile implements Initializable {

    /* USER DATA TO BE COLLECTED FOR FUTURE USE */
    private String name;
    private String username;
    private char sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Set user's sex and age on profile screen, and to display on choice box
    ObservableList sexes = FXCollections.observableArrayList();
    ObservableList ages = FXCollections.observableArrayList();

    // workaround for populating an integer array with known values. Easier than hard-coding an array of integers
    List<Integer> agesStream = IntStream.rangeClosed(13, 85).boxed().collect(Collectors.toList());

    /***************************************************************
     /* PROFILE'S ANCHOR PANE FXML ELEMENTS
     ****************************************************************/

    @FXML
    private AnchorPane mainLoginScreen;

    @FXML
    private Button finalizeAcctButton;

    @FXML
    private Label acctText;

    @FXML
    private Label mainNameLabel;

    @FXML
    private TextField nameCollector;

    @FXML
    private Label ageLabel;

    @FXML
    private ChoiceBox<Integer> userAge;

    @FXML
    private ChoiceBox<Character> userSex;

    @FXML
    private TextField usernameCollector;

    @FXML
    private Label sexLabel;

    @FXML
    private Label mainUsernameLabel;

    @FXML
    private Button cancelToLoginButton;

    @FXML
    private ImageView profilePic;

    @FXML
    private Label photoLabel;

    @FXML
    private Button imageChooserButton;

    Stage stageHere;
    Parent rootHere;


    /***************************************************************
     /* METHODS RELATED TO PROFILE VALUES SELECTION
     ****************************************************************/

    // loads character values into Choice Boxes
    // TODO: Connect image choose button to image pathfinder

    public void loadSex() {
        sexes.removeAll();
        char Male = 'M';
        char Female = 'F';
        sexes.addAll(Male, Female);
        userSex.getItems().addAll(sexes);

    }

    public void loadAge() {
        ages.removeAll();
        ages.addAll(agesStream);
        userAge.getItems().addAll(ages);

    }

    /***************************************************************
     /* METHODS RELATED TO BUTTON BINDS
     ****************************************************************/
    @SuppressWarnings("Duplicates")
    public void handleCancelActions() {
        cancelToLoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // if the user cancels out of creating a profile, all the input will reset to clear (or default) values
                nameCollector.clear();
                usernameCollector.clear();

                stageHere=(Stage) cancelToLoginButton.getScene().getWindow();
                //load up Login FXML document
                try {
                    rootHere = FXMLLoader.load(getClass().getResource("Login.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene scene = new Scene(rootHere);
                stageHere.setScene(scene);
                stageHere.show();
            }
        });

    }

    @SuppressWarnings("Duplicates")
    public void handleProfileActions() {
        finalizeAcctButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // if the user proceeds to create an account and profile, all input data will be saved and the program
                // will load the main menu screen
                setName(nameCollector.toString());
                setUsername(usernameCollector.toString());
                setAge(userAge.getSelectionModel().getSelectedItem());
                setSex(userSex.getSelectionModel().getSelectedItem());
                // TODO: save the user's selected image


                stageHere=(Stage) finalizeAcctButton.getScene().getWindow();
                //load up Login FXML document
                try {
                    rootHere = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene scene = new Scene(rootHere);
                stageHere.setScene(scene);
                stageHere.show();
            }
        });

    }


    /***************************************************************
     /* INITIALIZABLE
     ****************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadSex();
        loadAge();
        userAge.setItems(ages);
        userSex.setItems(sexes);

        handleCancelActions();
        handleProfileActions();

    }
}
