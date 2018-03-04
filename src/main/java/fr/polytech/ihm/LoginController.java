package fr.polytech.ihm;

import fr.polytech.ihm.Model.LoginCheck;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Text errorText;

    private TranslateTransition anim;

    @FXML
    public void initialize() {

        wizz();

    }

    public void onClick(MouseEvent mouseEvent) throws Exception {
        this.accountCheck();
    }

    private void accountCheck() throws Exception {
        LoginCheck loginCheck = new LoginCheck(username.getText(), password.getText());
        if (loginCheck.isAdmin() || loginCheck.isValid())
            this.loadView("/fxml/list_incidents.fxml", loginCheck.isAdmin());
        else {
            username.setText("");
            password.setText("");
            errorText.setText("Identifiant ou Mot de passe erronés");
            anim.play();
        }
    }

    private void loadView(String name, boolean isAdmin) throws Exception {
        String fxmlFile = name;
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) login.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
            Scene scene = new Scene(rootNode);
            IncidentController controller = loader.<IncidentController>getController();
            controller.setAdminMode(isAdmin);
            stage.setTitle("Liste des incidents");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPressed(KeyEvent keyEvent) throws Exception {
        if (keyEvent.getCode() == KeyCode.ENTER)
            this.accountCheck();
    }

    public void wizz() {
        TranslateTransition t = new TranslateTransition();
        t.setNode(errorText);
        t.setToX(-30);
        t.setAutoReverse(true);
        t.setCycleCount(6);
        t.setRate(4);
        anim = t;
    }
}
