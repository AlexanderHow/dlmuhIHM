package fr.polytech.ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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

    @FXML
    public void accessUserData(ActionEvent event) {

    }

    @FXML
    public void addIncident(ActionEvent event) {

    }

    @FXML
    public void upvote(ActionEvent event) {

    }

}
