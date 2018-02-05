package fr.polytech.ihm;

import fr.polytech.ihm.Model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
}
