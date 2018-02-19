package fr.polytech.ihm;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import fr.polytech.ihm.Model.Data;
import fr.polytech.ihm.Model.EnumCategory;
import fr.polytech.ihm.Model.EnumLocation;
import fr.polytech.ihm.Model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private ListView<Task> listViewToDo;

    @FXML
    private ListView<Task> listViewInProgress;

    @FXML
    private ListView<Task> listViewDone;

    @FXML
    private Button addIncidentButton;

    private Task currentTask;

    private ObservableList<Task> toDoItems = FXCollections.observableArrayList(Data.getData());

    static class Cell extends ListCell<Task>{
        HBox hbox = new HBox();
        VBox vBox = new VBox();
        VBox vBox2 = new VBox();
        Label title = new Label("");
        Label date = new Label("");
        Label author = new Label("");
        Label location = new Label("");
        Label emergencyLevel = new Label("");
        Button goNext = new Button("->");

        public Cell(){
            super();
            vBox.getChildren().addAll(title, date, author, location);
            vBox2.getChildren().addAll(emergencyLevel, goNext);
            vBox2.setAlignment(Pos.CENTER);
            vBox2.setSpacing(10);
            hbox.setSpacing(20);
            hbox.getChildren().addAll(vBox, vBox2);
        }

        public void updateItem(Task task, boolean empty){
            super.updateItem(task, empty);
            setText(null);
            setGraphic(null);

            if(task != null && !empty){
                title.setText(task.getTitle());
                date.setText(task.getDate());
                author.setText(task.getAuthor());
                location.setText(task.getLocation());
                emergencyLevel.setText("" + task.getEmergencyLvl());
                setGraphic(hbox);
            }
        }
    }

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
        listViewToDo.setItems(toDoItems);
        listViewToDo.setCellFactory(param -> new Cell());
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
