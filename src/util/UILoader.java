package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
public class UILoader {
    public static void loadOnTheCurrentPane(String filename, AnchorPane context) throws IOException {
        URL resource = UILoader.class.getResource("../view/" + filename + ".fxml");
        Parent load = FXMLLoader.load(resource);
        context.getChildren().clear();
        context.getChildren().add(load);
    }

    public static void load(String filename, AnchorPane context) throws IOException {
        URL resource = UILoader.class.getResource("../view/" + filename + ".fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) context.getScene().getWindow();
        window.setScene(new Scene(load));
        window.centerOnScreen();
    }
}
