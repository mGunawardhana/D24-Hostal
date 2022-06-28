package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.UILoader;

import java.io.IOException;

/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */

/*
 * TODO - > add RegX
 *  */

public class MainFormController {
    public AnchorPane context;
    public JFXButton studentBtn;
    public JFXButton programBtn;


    public void openStudentDetail(MouseEvent mouseEvent) throws IOException {
        UILoader.load("StudentRegistrationForm", context);
    }

    public void openProgramDetails(MouseEvent mouseEvent) throws IOException {
        UILoader.load("RoomForm", context);
    }

    public void userOnAction(ActionEvent actionEvent) throws IOException {
        UILoader.load("UserPrivilegesForm",context);
    }

    public void ReserveOnAction(ActionEvent actionEvent) throws IOException {
        UILoader.load("ReserveViewForm",context);
    }
}
