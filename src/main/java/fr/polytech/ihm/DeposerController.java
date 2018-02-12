package fr.polytech.ihm;

import fr.polytech.ihm.Model.EnumCategory;
import fr.polytech.ihm.Model.EnumLocation;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DeposerController {

    @FXML
    private TextField titleTextId;

    @FXML
    private TextField whoTextId;

    @FXML
    private ComboBox<String> cBoxEmergencyId;

    @FXML
    private TextField hourTextId;

    @FXML
    private DatePicker dateId;

    @FXML
    private ComboBox<String> cBoxLocalisationId;

    @FXML
    private ComboBox<String> cBoxCategoryId;

    @FXML
    private TextArea descriptionId;

    @FXML
    private Button clearButton;

    @FXML
    private Button exeButton;

    @FXML
    private void initialize(){
        cBoxEmergencyId.getItems().addAll("1","2","3");

        for (EnumLocation l : EnumLocation.values()) {
            cBoxLocalisationId.getItems().add(l.toString());
        }
        for (EnumCategory c : EnumCategory.values()) {
            cBoxCategoryId.getItems().add(c.toString());
        }
    }

    public void delete(MouseEvent mouseEvent) {

        titleTextId.setText("");
        whoTextId.setText("");
        cBoxEmergencyId.setPromptText("Urgence");
        hourTextId.setText("");
        dateId.setPromptText("Date");
        cBoxLocalisationId.setPromptText("Localisation");
        cBoxCategoryId.setPromptText("Categorie");
        descriptionId.setText("");


    }

    public void submit(MouseEvent mouseEvent) {
        String fxmlFile = "/fxml/list_incidents.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage=(Stage) exeButton.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
