package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenu implements Initializable {

    // used to switch screens
    Stage stageMainMenu;
    Parent rootMainMenu;


    @FXML
    private TabPane mainMenuTabs;

    /***************************************************************
     /* FITHUB TAB FXML ELEMENTS
     ****************************************************************/
    @FXML
    private Tab fithubTab;

    @FXML
    private AnchorPane fithubAnchor;

    @FXML
    private Pane selectWorkoutPane;

    @FXML
    private Label ExeLabel1;

    @FXML
    private Button selectWorkoutButton;

    @FXML
    private Pane customWorkoutPane;

    @FXML
    private Label ExeLabel2;

    @FXML
    private Button customWorkoutButton;

    @FXML
    private Pane nutritionStatsPane;

    @FXML
    private Label ExeLabel4;

    @FXML
    private Button nutritionStatsButton;

    @FXML
    private Pane nutritionTrackerPane;

    @FXML
    private Label ExeLabel5;

    @FXML
    private Button nutritionTrackerButton;

    /***************************************************************
     /* FEED TAB FXML ELEMENTS
     ****************************************************************/

    @FXML
    private Tab feedTab;

    @FXML
    private AnchorPane feedAnchor;

    @FXML
    private Pane feedMSG1;

    @FXML
    private Pane feedMSG2;

    @FXML
    private Pane feedMSG3;

    @FXML
    private Pane feedMSG4;

    /***************************************************************
     /* SETTINGS TAB FXML ELEMENTS
     ****************************************************************/

    @FXML
    private Tab settingsTab;

    @FXML
    private AnchorPane settingsAnchor;

    @FXML
    private Accordion generalSettings;

    @FXML
    private TitledPane workoutSettings;

    @FXML
    private TitledPane profileSettings;

    @FXML
    private TitledPane nutritionSettings;

    @FXML
    private Button changeUserProfileButton;

    @FXML
    private ImageView userPFP;

    @FXML
    private Label nameDisplay;

    @FXML
    private Label usernameDisplay;

    @FXML
    private Button signoutButton;


    /***************************************************************
     /* METHODS RELATED TO TAB SWITCHING POLICIES
     ****************************************************************/





    /***************************************************************
     /* METHODS RELATED TO FITHUB ITEMS
     ****************************************************************/

    @FXML
    private void handleFitHubButtonAction(ActionEvent event) throws IOException {

        if (event.getSource() == selectWorkoutButton) {

            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("WorkoutSelect.fxml")));

        }

        else if (event.getSource() == nutritionStatsButton) {

            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("NutritionStats.fxml")));

        }

        else if (event.getSource() == customWorkoutButton) {

            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("sample.fxml")));

        }

        else if (event.getSource() == nutritionTrackerButton) {

            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("NutritionTracker.fxml")));

        } else {

            // known bug: doing this creates a copy of the entire main menu screen (tabs included))
            // This can be solved by setting the default 4-option fit hub menu into its own FXML file that is loaded
            // within the Fit hub tab's tab pane.
            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        }


    }

    /***************************************************************
     /* METHODS RELATED TO SETTINGS ITEMS
     ****************************************************************/
    // TODO: Complete Settings Tab Items




    /***************************************************************
     /* GENERAL INITIALIZABLE FOR ALL TAB PANES
     ****************************************************************/

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
