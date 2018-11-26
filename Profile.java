package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    //FILE LOCATION -- Used in method to print to text file
    private static final String FILENAME = "src/sample/UserInfo.txt";

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
                setName(nameCollector.getText());
                setUsername(usernameCollector.getText());
                setAge(userAge.getSelectionModel().getSelectedItem());
                setSex(userSex.getSelectionModel().getSelectedItem());


                //Testing retrieval of information.
//                System.out.println("Print Name: " + name);
//                System.out.println("Print UserName: " + username);
//                System.out.println("Print Age: " + age);
//                System.out.println("Print Sex: " + sex);


                //Retrieving Account UN & PW From previous screen
                CreateAccount createdAcc = new CreateAccount();
                String userPW = createdAcc.getPassword();
                String userEM = createdAcc.getUserEmail();

                //Upload Information onto TextFile, using addUserInfoText Method
                addUserInfoText(userEM,name,username,userPW,sex,age);



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

    //PRINT USERINFO TO TEXT FILE.............
    public void addUserInfoText(String email, String name, String username, String password, char sex, int age) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {


            File file = new File(FILENAME);

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write("------------------");
            bw.newLine();
            bw.write("EM: "+ email);
            bw.newLine();
            bw.write("NM: " + name);
            bw.newLine();
            bw.write("UN: " + username);
            bw.newLine();
            bw.write("PW: "+ password);
            bw.newLine();
            bw.write("SX: " + sex);
            bw.newLine();
            bw.write("AG: " + age);
            bw.newLine();

            

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }




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
