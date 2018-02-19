package fr.polytech.ihm;

import fr.polytech.ihm.Model.Data;
import fr.polytech.ihm.Model.Task;
import javafx.beans.property.BooleanProperty;
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
import javafx.util.converter.NumberStringConverter;

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

    private Task task;
    private boolean alreadyUpvoted=false;
    private boolean adminMode=false;

    @FXML
    public void initialize(){
        this.setAdminMode(true);
        if(!adminMode){
            this.resolvedVisuAdmin.setDisable(true);
            this.resolvedVisuAdmin.setVisible(false);
        }
        Data.addTask("Test Task","Alexandre","Françis","Test",new Date().toString(),"Polytech", "This is not Sparta but just a test AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAhhhhhhh !",2,2);
        this.task=Data.getById(1);

        if(this.task!=null){
            this.titleVisuAdmin.setText("Titlt Task: " +this.task.titleProperty().get());
            this.authorVisuAdmin.setText("Author: "+this.task.authorProperty().get());
            this.assigneeVisuAdmin.setText("Assignee: "+this.task.assigneeProperty().get());
            this.categoryVisuAdmin.setText("Category: "+this.task.categoryProperty().get());
            this.dateVisuAdmin.setText("Date: "+this.task.dateProperty().get());
            this.locationVisuAdmin.setText("Location: "+this.task.locationProperty().get());
            this.descriptionVisuAdmin.setText(this.task.descriptionProperty().get());
            //this.displayUpvoteVisuAdmin.setText("+"+this.task.upvoteProperty().toString());
            this.displayUpvoteVisuAdmin.textProperty().bindBidirectional(this.task.upvoteProperty(),new NumberStringConverter());
        }else{
            //TODO : gest error
            this.titleVisuAdmin.setText("Titlt Task: Error");
        }
    }

    public void setTask(Task t){
        this.task=t;
    }

    public void setAdminMode(boolean admin){
        this.adminMode=admin;
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

    public void onClickUpvote(MouseEvent mouseEvent){
        if(!alreadyUpvoted){
            this.task.upvoteTask();
            this.alreadyUpvoted=true;
            this.upvoteVisuAdmin.setText("Downvote");
        }else{
            this.task.downvoteTask();
            this.alreadyUpvoted=false;
            this.upvoteVisuAdmin.setText("Upvote");
        }
    }

    public void onClickDelete(MouseEvent mouseEvent){
        if(adminMode){
            this.task.deleteTask();
        }
    }
}
