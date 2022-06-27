package controller;

import com.jfoenix.controls.JFXButton;
import dto.UserDTO;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserPrivilegesController {

    public TextField userNameTxt;
    public PasswordField passwordTxt;
    public JFXButton addOnAction;
    public JFXButton updateOnAction;
    public JFXButton removeOnAction;
    public TableView<UserDTO> UserTbl;
    public TableColumn<UserDTO, String> userNameCol;
    public TableColumn<UserDTO, String> passwordCol;

    public void initialize() {
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
    }




}
