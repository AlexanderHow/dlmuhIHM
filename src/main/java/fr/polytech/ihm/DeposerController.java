package fr.polytech.ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DeposerController {

    @FXML
    private TextField titleTextId;

    @FXML
    private TextField whoTextId;

    @FXML
    private ComboBox<?> cBoxEmergencyId;

    @FXML
    private TextField hourTextId;

    @FXML
    private DatePicker dateId;

    @FXML
    private ComboBox<?> cBoxLocalisationId;

    @FXML
    private ComboBox<?> cBoxCategoryId;

    @FXML
    private TextArea descriptionId;

    @FXML
    private Button clearButton;

    @FXML
    private Button exeButton;

}
