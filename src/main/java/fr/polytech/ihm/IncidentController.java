package fr.polytech.ihm;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import fr.polytech.ihm.Model.EnumCategory;
import fr.polytech.ihm.Model.EnumLocation;
import fr.polytech.ihm.Model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class IncidentController {

    @FXML
    private ComboBox<String> categoryIncident;

    @FXML
    private ComboBox<String> locationIncident;

    @FXML
    private ComboBox<String> resolutionIncident;

    @FXML
    private Button decoButton;

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
    public void initialize() {
        for (EnumCategory cat: EnumCategory.values()) {
            categoryIncident.getItems().add(cat.toString());
        }
        for (EnumLocation loc: EnumLocation.values()) {
            locationIncident.getItems().add(loc.toString());
        }
        resolutionIncident.getItems().addAll(
                "A faire",
                "En cours",
                "Terminé"
        );
    }

    @FXML
    public void addIncident(ActionEvent event) throws IOException {
        String fxmlFile = "/fxml/deposer.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 700, 620);
            Stage stage = new Stage();
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

    @FXML
    public void disconnect(MouseEvent mouseEvent) {
        String fxmlFile = "/fxml/LoginScreen.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) decoButton.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
