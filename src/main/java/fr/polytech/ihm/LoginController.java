package fr.polytech.ihm;

import fr.polytech.ihm.Model.LoginCheck;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    public void initialize() {

    }

    public void onClick(MouseEvent mouseEvent) throws Exception {
        LoginCheck loginCheck = new LoginCheck(username.getText(), password.getText());
        if(loginCheck.isAdmin())
            this.loadView("/fxml/list_incidents.fxml");
        if(loginCheck.isValid())
            this.loadView("/fxml/list_incidents.fxml");
        else {
            username.setText("");
            password.setText("");
        }
    }

    private void loadView(String name) throws Exception{
        String fxmlFile = name;
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) login.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
            Scene scene = new Scene(rootNode, 1200, 700);
            stage.setTitle("Hello JavaFX and Maven");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
