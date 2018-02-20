package fr.polytech.ihm;

import fr.polytech.ihm.Model.Data;
import fr.polytech.ihm.Model.Task;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.util.Date;

public class VisualiserController {
    @FXML
    private Button returnVisuAdmin;

    @FXML
    private Label titleVisuAdmin;

    @FXML
    private ImageView imgEmergencyVisuAdmin;

    @FXML
    private Label authorVisuAdmin;

    @FXML
    private Label assigneeVisuAdmin;

    @FXML
    private Label categoryVisuAdmin;

    @FXML
    private Label dateVisuAdmin;

    @FXML
    private Label locationVisuAdmin;

    @FXML
    private TextArea descriptionVisuAdmin;

    @FXML
    private Label displayUpvoteVisuAdmin;

    @FXML
    private Button upvoteVisuAdmin;

    @FXML
    private Text saveText;

    @FXML
    private Button resolvedVisuAdmin;

    @FXML
    private Button retroButton;

    @FXML
    private TextField reassignField;

    @FXML Button reassignButton;

    private Task task;
    private boolean alreadyUpvoted=false;
    private boolean adminMode=false;

    @FXML
    public void initialize(){
        if(!adminMode){
            this.resolvedVisuAdmin.setDisable(true);
            this.resolvedVisuAdmin.setVisible(false);
            this.reassignButton.setDisable(true);
            this.reassignButton.setVisible(false);
            this.reassignField.setDisable(true);
            this.reassignField.setVisible(false);
        }
        this.refresh();
    }

    private void refresh(){
        if(this.task!=null){
            if(task.resolvedProperty().get()==1) {
                retroButton.setVisible(false);
            }
            this.titleVisuAdmin.setText(" " + this.task.titleProperty().get());
            this.authorVisuAdmin.setText(" "+this.task.authorProperty().get());
            this.assigneeVisuAdmin.setText(" "+this.task.assigneeProperty().get());
            this.categoryVisuAdmin.setText(" "+this.task.categoryProperty().get());
            this.dateVisuAdmin.setText(" "+this.task.dateProperty().get());
            this.locationVisuAdmin.setText(" "+this.task.locationProperty().get());
            this.descriptionVisuAdmin.setText(this.task.descriptionProperty().get());
            //this.displayUpvoteVisuAdmin.setText("+"+this.task.upvoteProperty().toString());
            this.displayUpvoteVisuAdmin.textProperty().bindBidirectional(this.task.upvoteProperty(),new NumberStringConverter());
            Image emergencyLevel;
            switch (task.getEmergencyLvl()) {
                case 1:
                    emergencyLevel = new Image("/images/green.png");
                    imgEmergencyVisuAdmin.setImage(emergencyLevel);
                    break;
                case 2:
                    emergencyLevel = new Image("/images/orange.png");
                    imgEmergencyVisuAdmin.setImage(emergencyLevel);
                    break;
                case 3:
                    emergencyLevel = new Image("/images/red.png");
                    imgEmergencyVisuAdmin.setImage(emergencyLevel);
            }
        }else{
            //TODO : gest error
            this.titleVisuAdmin.setText("Title Task: Error");
        }
    }

    public void setTask(Task t){
        this.task=t;
        this.refresh();
    }

    public void setAdminMode(boolean admin){
        this.adminMode=admin;
        if(adminMode){
            this.resolvedVisuAdmin.setDisable(false);
            this.resolvedVisuAdmin.setVisible(true);
            this.reassignField.setDisable(false);
            this.reassignField.setVisible(true);
            this.reassignButton.setDisable(false);
            this.reassignButton.setVisible(true);
        }
    }

    @FXML
    public void onClickReturn(MouseEvent mouseEvent) {

        String fxmlFile = "/fxml/list_incidents.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage=(Stage) returnVisuAdmin.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
            IncidentController controller = loader.<IncidentController>getController();
            controller.setAdminMode(adminMode);
            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
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

    @FXML
    public void onClickDelete(MouseEvent mouseEvent){
        if(adminMode){
            this.task.deleteTask();
        }
        String fxmlFile = "/fxml/list_incidents.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage=(Stage) returnVisuAdmin.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
            IncidentController controller = loader.<IncidentController>getController();
            controller.setAdminMode(adminMode);
            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void saveDescription(MouseEvent mouseEvent) {
        task.setNewDescription(descriptionVisuAdmin.getText());
        saveText.setVisible(true);
    }


    public void retrograde(ActionEvent actionEvent) {
        task.decrementResolved();
        String fxmlFile = "/fxml/list_incidents.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage=(Stage) returnVisuAdmin.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
            IncidentController controller = loader.<IncidentController>getController();
            controller.setAdminMode(adminMode);
            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void supprSaveDisplay(MouseEvent mouseEvent) {
        saveText.setVisible(false);
    }

    public void reassign(ActionEvent actionEvent) {
        String who = reassignField.getText().toString();
        task.reassign(who);
        assigneeVisuAdmin.setText(" "+who);
        reassignField.setText("");

    }
}
