package fr.polytech.ihm;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        /* MacOS theme (old versions) */
        //AquaFx.style();

        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);

        /* Current theme: Material design-like */
        StyleManager.getInstance().addUserAgentStylesheet("/styles/styles.css");

        /* Windows theme */
        //StyleManager.getInstance().addUserAgentStylesheet("/styles/windows-ui.css");

        log.info("Starting Hello JavaFX and Maven demonstration application");

        String fxmlFile = "/fxml/LoginScreen.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode);
        stage.setTitle("Ecran de connexion");
        stage.setScene(scene);
        stage.getIcons().add(new Image("images/index.png"));
        stage.setResizable(false);
        stage.show();
    }
}
