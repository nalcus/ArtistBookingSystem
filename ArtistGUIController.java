import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ArtistGUIController extends Application {
    private LiveEvent liveEvent;
    private ArtistGUIView artistGUIView;
    public ArtistGUIController() {
        liveEvent = new LiveEvent();
        artistGUIView = new ArtistGUIView();
        artistGUIView.setAddArtistAction(this::addArtist);
        artistGUIView.setDisplayArtistsAction(this::displayArtists);
        artistGUIView.setBookArtistsAction(this::bookArtists);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void addArtist(ActionEvent event) {
        String errorMessage = "";
        try {
            String name = artistGUIView.getName(); // was this left blank?
            if (name.isEmpty()) {
                errorMessage = "Name must not be empty.";
                throw new IllegalArgumentException();
            }

            try {
                String styleText = artistGUIView.getStyle(); // was this left blank?

                if (styleText.isEmpty()) {
                    errorMessage = "Style must not be empty.";
                    throw new IllegalArgumentException();
                }

                try {
                    String experienceText = artistGUIView.getExperience(); // was this left blank?

                    if (experienceText.isEmpty()) {
                        errorMessage = "Experience must not be empty.";
                        throw new IllegalArgumentException();
                    }


                    int experience = Integer.parseInt(experienceText);

                    DJ.EquipmentTypes equipmentType = artistGUIView.getEquipmentTypesField(); // getting info from view


                    Artist artist = new DJ(name, styleText, experience, equipmentType); // send info to the model for processing
                    liveEvent.addArtist(artist);
                } catch (NumberFormatException ex) {
                    errorMessage = "Experience must be numeric.";
                    throw new IllegalArgumentException();
                }

            } catch (IllegalArgumentException ex) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText(null);
                error.setContentText(errorMessage);
                error.showAndWait();

            }
        } catch (IllegalArgumentException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText(null);
            error.setContentText(errorMessage);
            error.showAndWait();

        }

        finally {

            artistGUIView.clearInputs();
            artistGUIView.hideResultText();
        }


    }

    @Override
    public void start(Stage primaryStage) {
        ArtistGUIController controller = new ArtistGUIController();

        Scene scene = new Scene(controller.artistGUIView.getParent(), 600, 500, Color.TRANSPARENT);
        primaryStage.setTitle("Artist Booking System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void displayArtists(ActionEvent event) {
        ArrayList<Artist> artistList = liveEvent.getArtistList();
        String output = "";
        int index = 1;
        for (Artist a : artistList) {
            output += "[" + index + "] " + a.toString() + "\n";
            index++;
        }
        artistGUIView.displayResultText("Artists:", output); // send results back to the view
    }

    private void bookArtists(ActionEvent event) {
        ArrayList<Artist> artistList = liveEvent.getArtistList();
        String output = "";
        int index = 1;
        for (Artist a : artistList) {
            output += "[" + index + "] " + a.book() + "\n";
            index++;
        }
        artistGUIView.displayResultText("Artists:", output); // send results back to the view
    }

}

