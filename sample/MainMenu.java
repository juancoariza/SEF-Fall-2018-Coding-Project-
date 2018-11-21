package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;


public class MainMenu implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}