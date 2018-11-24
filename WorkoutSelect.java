package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class WorkoutSelect implements Initializable {

    ObservableList workoutTypes = FXCollections.observableArrayList();
    ObservableList workoutSpecs = FXCollections.observableArrayList();

    @FXML
    private SplitPane workoutScreen;

    @FXML
    private AnchorPane workoutTypePane;

    @FXML
    private ListView<String> workoutTypeListview;

    @FXML
    private ListView<String> workoutSpecListview;



    public void loadLeftsideListview() {

        String workA = "Cardio";
        String workB = "Arms";
        String workC = "Upper Body";
        String workD = "Abdominal & Core";
        String workE = "Legs";
        workoutTypes.addAll(workA, workB, workC, workD, workE);
        workoutTypeListview.getItems().addAll(workoutTypes);

    }

    public void loadRightsideListview() {

        String exeA = "Jogging";
        String exeB = "Push-ups";
        String exeC = "Burpees";
        String exeD = "Planks";
        String exeE = "Squats";
        workoutSpecs.addAll(exeA, exeB, exeC, exeD, exeE);
        workoutSpecListview.getItems().addAll(workoutSpecs);

    }

    /*@FXML
    private void displaySelectionDetails(ActionEvent event) {
        String exercise = workoutTypeListview.getSelectionModel().getSelectedItem();

    } */


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // loads the list view options on screen start-up
        loadLeftsideListview();
        loadRightsideListview();

    }
}
