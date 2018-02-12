package fr.polytech.ihm;

import fr.polytech.ihm.Model.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class VisualiserController {
    @FXML
    private Text titleVisuAdmin;

    @FXML
    private Text authorVisuAdmin;

    @FXML
    private Text assigneeVisuAdmin;

    @FXML
    private Text categoryVisuAdmin;

    @FXML
    private Text dateVisuAdmin;

    @FXML
    private Text locationVisuAdmin;

    @FXML
    private TextArea descriptionVisuAdmin;

    @FXML
    private Button upvoteVisuAdmin;

    @FXML
    private Text displayUpvoteVisuAdmin;

    @FXML
    private ImageView imgEmergencyVisuAdmin;

    @FXML
    private Button returnVisuAdmin;

    @FXML
    private Button resolvedVisuAdmin;

    //TODO : initialize on click
    @FXML
    public void initialize(){
        Task t = new Task("Test Task","Alexandre","Françis","Test",new Date().toString(),"Polytech", "This is not Sparta but just a test AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAhhhhhhh !",2,2);
        this.titleVisuAdmin.setText("Titlt Task: " +t.titleProperty().get());
        this.authorVisuAdmin.setText("Author: "+t.authorProperty().get());
        this.assigneeVisuAdmin.setText("Assignee: "+t.assigneeProperty().get());
        this.categoryVisuAdmin.setText("Category: "+t.categoryProperty().get());
        this.dateVisuAdmin.setText("Date: "+t.dateProperty().get());
        this.locationVisuAdmin.setText("Location: "+t.locationProperty().get());
        this.descriptionVisuAdmin.setText(t.descriptionProperty().get());
        this.displayUpvoteVisuAdmin.setText("+"+t.upvoteProperty().toString());

    }

    public void onClickReturn(MouseEvent mouseEvent) {

        String fxmlFile = "/fxml/list_incidents.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage=(Stage) returnVisuAdmin.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
