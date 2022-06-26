package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.UILoader;

import java.io.IOException;

public class LoginPageFormController {
    public TextField txtName;
    public PasswordField txtPwd;
    public AnchorPane loginContext;

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        if (txtName.getText().equals("")) {
            if (txtPwd.getText().equals("")) {
                UILoader.load("MainForm",loginContext);
            }
        }
    }
}

