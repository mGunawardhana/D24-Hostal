package controller;

import bo.BOFactory;
import bo.UserBO;
import dto.UserDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class UserPrivilegesController {

    private final UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.USER);


    public TextField userNameTxt;
    public PasswordField passwordTxt;
    public TableView<UserDTO> UserTbl;
    public TableColumn userNameCol;
    public TableColumn passwordCol;
    public AnchorPane context;
    public TextField userID;
    public TableColumn UserID;
    ObservableList<UserDTO> userObList = FXCollections.observableArrayList();
    int rowNumber;

    public void initialize() {
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        UserID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        UserTbl.refresh();
        try {
            loadUser();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void loadUser() throws Exception {
        userObList.clear();
        List<UserDTO> all = userBO.findAll();
        for (UserDTO userDTO : all) {
            userObList.add(userDTO);
        }
        UserTbl.setItems(userObList);


    }



    public void addOnAction(ActionEvent actionEvent) {

    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void removeOnAction(ActionEvent actionEvent) {
    }
}
