package fr.polytech.ihm;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import fr.polytech.ihm.Model.Data;
import fr.polytech.ihm.Model.EnumCategory;
import fr.polytech.ihm.Model.EnumLocation;
import fr.polytech.ihm.Model.Task;
import javafx.animation.TranslateTransition;
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class IncidentController {

    public ImageView arrow;
    @FXML
    private ComboBox<String> categoryIncident;

    @FXML
    private ComboBox<String> locationIncident;

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

    private boolean adminMode = false;

    private ObservableList<Task> toDoItems = FXCollections.observableArrayList(Data.getInstance().getDataToDo());
    private ObservableList<Task> inProgressItems = FXCollections.observableArrayList(Data.getInstance().getDataInProgress());
    private ObservableList<Task> doneItems = FXCollections.observableArrayList(Data.getInstance().getDataDone());
    private TranslateTransition anim;

    static class Cell extends ListCell<Task> {
        HBox hbox = new HBox();
        VBox vBox = new VBox();
        VBox vBox2 = new VBox();
        Label title = new Label("");
        Label date = new Label("");
        Label author = new Label("");
        Label location = new Label("");
        Image emergencyLevel = new Image("/images/pastillergence.png");
        ImageView emergencyViewer = new ImageView(emergencyLevel);

        Button goNext = new Button("→");

        public Cell() {
            super();
            emergencyViewer.setFitHeight(30);
            emergencyViewer.setFitWidth(30);
            vBox.getChildren().addAll(title, date, author, location);
            vBox2.getChildren().addAll(emergencyViewer, goNext);
            vBox2.setAlignment(Pos.CENTER_RIGHT);
            vBox2.setSpacing(10);
            hbox.setAlignment(Pos.CENTER);
            hbox.setMaxWidth(280);
            hbox.setSpacing(20);
            hbox.getChildren().addAll(vBox, vBox2);
            hbox.setHgrow(vBox, Priority.ALWAYS);
            hbox.setHgrow(vBox2, Priority.ALWAYS);
            goNext.setOnAction(e -> {
                getItem().incrementResolved();
                String fxmlFile = "/fxml/list_incidents.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) goNext.getScene().getWindow();
                    Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            });
        }

        public void updateItem(Task task, boolean empty) {
            super.updateItem(task, empty);
            setText(null);
            setGraphic(null);

            if (task != null && !empty) {
                title.setText(task.getTitle());
                date.setText(task.getDate());
                author.setText(task.getAuthor());
                location.setText(task.getLocation());
                Image emergencyLevel;
                switch (task.getEmergencyLvl()) {
                    case 1:
                        emergencyLevel = new Image("/images/green.png");
                        emergencyViewer.setImage(emergencyLevel);
                        break;
                    case 2:
                        emergencyLevel = new Image("/images/orange.png");
                        emergencyViewer.setImage(emergencyLevel);
                        break;
                    case 3:
                        emergencyLevel = new Image("/images/red.png");
                        emergencyViewer.setImage(emergencyLevel);
                }
                setGraphic(hbox);
            }
        }
    }

    @FXML
    public void accessUserData(ActionEvent event) {

    }

    @FXML
    public void initialize() throws IOException {
        for (EnumCategory cat : EnumCategory.values()) {
            categoryIncident.getItems().add(cat.toString());
        }
        for (EnumLocation loc : EnumLocation.values()) {
            locationIncident.getItems().add(loc.toString());
        }

        listViewToDo.setItems(toDoItems);
        listViewToDo.setCellFactory(param -> new Cell());

        listViewInProgress.setItems(inProgressItems);
        listViewInProgress.setCellFactory(param -> new Cell());

        listViewDone.setItems(doneItems);
        listViewDone.setCellFactory(param -> new Cell());

        arrowMove();

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
    public void disconnect(ActionEvent event) {
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

    @FXML
    void displayTask(MouseEvent event) {
        if (!listViewToDo.getItems().isEmpty() && listViewToDo.getSelectionModel().getSelectedItem() != null) {
            String fxmlFile = "/fxml/visuadmin.fxml";
            FXMLLoader loader = new FXMLLoader();
            try {
                Stage stage = (Stage) listViewToDo.getScene().getWindow();
                Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
                Scene scene = new Scene(rootNode);
                VisualiserController controller = loader.<VisualiserController>getController();
                controller.setAdminMode(this.adminMode);
                controller.setTask(listViewToDo.getSelectionModel().getSelectedItem());
                stage.setTitle("Liste des incidents");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            arrow.setVisible(true);
            anim.play();
            anim.setOnFinished(event1 -> {
                arrow.setVisible(false);
            });
        }
    }

    @FXML
    void displayTaskDone(MouseEvent event) throws IOException, InterruptedException {
        if (!listViewDone.getItems().isEmpty() && listViewDone.getSelectionModel().getSelectedItem() != null) {
            String fxmlFile = "/fxml/visuadmin.fxml";
            FXMLLoader loader = new FXMLLoader();
            try {
                Stage stage = (Stage) listViewDone.getScene().getWindow();
                Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
                Scene scene = new Scene(rootNode);
                VisualiserController controller = loader.<VisualiserController>getController();
                controller.setAdminMode(this.adminMode);
                controller.setTask(listViewDone.getSelectionModel().getSelectedItem());
                stage.setTitle("Liste des incidents");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            arrow.setVisible(true);
            anim.play();
            anim.setOnFinished(event1 -> {
                arrow.setVisible(false);
            });
        }
    }

    @FXML
    void displayTaskInProgress(MouseEvent event) {
        if (!listViewInProgress.getItems().isEmpty() && listViewInProgress.getSelectionModel().getSelectedItem() != null) {
            String fxmlFile = "/fxml/visuadmin.fxml";
            FXMLLoader loader = new FXMLLoader();
            try {
                Stage stage = (Stage) listViewInProgress.getScene().getWindow();
                Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
                Scene scene = new Scene(rootNode);
                VisualiserController controller = loader.<VisualiserController>getController();
                controller.setAdminMode(this.adminMode);
                controller.setTask(listViewInProgress.getSelectionModel().getSelectedItem());
                stage.setTitle("Liste des incidents");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            arrow.setVisible(true);
            anim.play();
            anim.setOnFinished(event1 -> {
                arrow.setVisible(false);
            });
        }
    }


    public void setAdminMode(boolean b) {
        this.adminMode = b;
    }

    public void arrowMove(){

        TranslateTransition t = new TranslateTransition();
        t.setNode(arrow);
        t.setToX(-30);
        t.setAutoReverse(true);
        t.setCycleCount(6);
        t.setRate(4);
        anim=t;

    }
}
