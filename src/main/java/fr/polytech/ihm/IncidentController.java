package fr.polytech.ihm;

import fr.polytech.ihm.Model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class IncidentController {

    @FXML
    private ComboBox<?> categoryIncident;

    @FXML
    private Button userButton;

    @FXML
    private Label incidentTitle;

    @FXML
    private Label incidentLocalisation;

    @FXML
    private Label incidentDate;

    @FXML
    private Label incidentDescription;

    @FXML
    private Label importanceIncident;

    @FXML
    private Label incidentScore;

    @FXML
    private Button upvoteIncidentButton;

    @FXML
    private Button addIncidentButton;

    private Task currentTask;
    @FXML
    public void accessUserData(ActionEvent event) {

    }

    @FXML
    public void addIncident(ActionEvent event) throws IOException {
        String fxmlFile = "/fxml/deposer.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) addIncidentButton.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void upvote(ActionEvent event) {
        /*
        int nbUpvote = currentTask.getUpvote();
        */
    }

}
