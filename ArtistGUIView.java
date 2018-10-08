import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Arrays;

public class ArtistGUIView {

    VBox primaryBox;
    private TextField nameField, styleField, experienceField;
    private ComboBox<DJ.EquipmentTypes> equipmentTypesComboBox;
    private Text titleText, nameLabel, styleLabel, experienceLabel, equipmentTypesLabel, resultLabel;
    private TextArea result;
    private Button addButton, displayButton, bookButton;

    ArtistGUIView() {
        primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(20);

        titleText = new Text("Artist Booking System\n\nPlease enter artist info below.");
        HBox titleBox = new HBox(titleText);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setSpacing(10);
        primaryBox.getChildren().add(titleBox);

        nameLabel = new Text("Artist's Name:");
        nameField = new TextField();
        HBox nameBox = new HBox(nameLabel, nameField);
        nameBox.setAlignment(Pos.CENTER);
        nameBox.setSpacing(10);
        primaryBox.getChildren().add(nameBox);

        styleLabel = new Text("Artist's Style:");
        styleField = new TextField();
        HBox styleBox = new HBox(styleLabel, styleField);
        styleBox.setAlignment(Pos.CENTER);
        styleBox.setSpacing(10);
        primaryBox.getChildren().add(styleBox);


        experienceLabel = new Text("Artist's Experience (in months):");
        experienceField = new TextField();
        HBox experienceBox = new HBox(experienceLabel, experienceField);
        experienceBox.setAlignment(Pos.CENTER);
        experienceBox.setSpacing(10);
        primaryBox.getChildren().add(experienceBox);


        equipmentTypesLabel = new Text("Artist's Equipment Type:");
        ObservableList<DJ.EquipmentTypes> statusOptions = FXCollections.observableArrayList((Arrays.asList(DJ.EquipmentTypes.values())));
        equipmentTypesComboBox = new ComboBox<DJ.EquipmentTypes>(statusOptions);
        equipmentTypesComboBox.setValue(DJ.EquipmentTypes.CDJS);
        HBox equipmentTypesBox = new HBox(equipmentTypesLabel, equipmentTypesComboBox);
        equipmentTypesBox.setAlignment(Pos.CENTER);
        equipmentTypesBox.setSpacing(10);
        primaryBox.getChildren().add(equipmentTypesBox);


        addButton = new Button("Add Artist");
        displayButton = new Button("Display Artist Data");
        bookButton = new Button("Book Artists");

        HBox buttonBox = new HBox(addButton, displayButton, bookButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);
        primaryBox.getChildren().add(buttonBox);

        resultLabel = new Text("");

        result = new TextArea("");
        result.setVisible(false);
        result.setEditable(false);
        VBox resultBox = new VBox(resultLabel, result);
        resultBox.setAlignment(Pos.CENTER);
        resultBox.setSpacing(10);
        primaryBox.getChildren().add(resultBox);

    }

    public Parent getParent() {
        return primaryBox;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public void setStyleField(TextField styleField) {
        this.styleField = styleField;
    }

    public void setExperienceField(TextField experienceField) {
        this.experienceField = experienceField;
    }

    public String getName() {
        return nameField.getText();
    }

    public String getStyle() {
        return styleField.getText();
    }

    public String getExperience() {
        return experienceField.getText();
    }

    public DJ.EquipmentTypes getEquipmentTypesField() {
        return equipmentTypesComboBox.getValue();
    }

    public void setEquipmentTypesField(DJ.EquipmentTypes equipmentType) {
        equipmentTypesComboBox.setValue(equipmentType);
    }

    public void setAddArtistAction(EventHandler<ActionEvent> handler) {
        addButton.setOnAction(handler);
    }
    public void setDisplayArtistsAction(EventHandler<ActionEvent> handler) { displayButton.setOnAction(handler);}
    public void setBookArtistsAction(EventHandler<ActionEvent> handler) { bookButton.setOnAction(handler);}

    public void displayResultText(String label, String output) {

        resultLabel.setText(label);
        result.clear();
        result.setText(output);
        result.setVisible(true);
    }

    public void hideResultText() {
        result.clear();
        result.setVisible(false);
        resultLabel.setText("");
    }

    public void clearInputs() {
        nameField.clear();
        styleField.clear();
        experienceField.clear();
        equipmentTypesComboBox.setValue(DJ.EquipmentTypes.CDJS);
    }
}
