package fr.polytech.ihm;

import fr.polytech.ihm.Model.Data;
import fr.polytech.ihm.Model.EnumCategory;
import fr.polytech.ihm.Model.EnumLocation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DeposerController {

    public Label error;
    @FXML
    private TextField titleTextId;

    @FXML
    private TextField whoTextId;

    @FXML
    private ComboBox<Integer> cBoxEmergencyId;

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

    private Data data;

    @FXML
    private void initialize(){
        cBoxEmergencyId.getItems().addAll(1,2,3);

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
        if (titleTextId.getText().isEmpty() || whoTextId.getText().isEmpty() || hourTextId.getText().isEmpty() ||dateId.getValue() == null
                || cBoxCategoryId.getValue()==null || cBoxEmergencyId.getValue()==null || cBoxLocalisationId.getValue()==null){
            error.setVisible(true);
        }else {
            String title = titleTextId.getText();
            String who = whoTextId.getText();
            int emergency = cBoxEmergencyId.getValue();
            String hour = hourTextId.getText();
            String date = dateId.getValue().toString();
            String location = cBoxLocalisationId.getValue();
            String category = cBoxCategoryId.getValue();
            String description = descriptionId.getText();
            Data.addTask(title,who,null,category,date,location,description,0,emergency);
            try {
                Stage stage = (Stage) exeButton.getScene().getWindow();
                Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                Scene scene = new Scene(rootNode);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
