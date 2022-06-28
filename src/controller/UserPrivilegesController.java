package controller;

import bo.BOFactory;
import bo.UserBO;
import com.jfoenix.controls.JFXButton;
import dto.UserDTO;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.UILoader;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */

/*
* TODO - > add RegX
*  */

public class UserPrivilegesController {
    private final UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.USER);


    public TextField userNameTxt;
    public PasswordField passwordTxt;
    public TableView<UserDTO> UserTbl;
    public TableColumn<User, String> userNameCol;
    public TableColumn<User, String> passwordCol;
    public AnchorPane context;

    public TableColumn<User, String> UserID;
    public JFXButton addBtn;
    public JFXButton updateBtn;
    public JFXButton removeBtn;
    public TextField userIDTxt;
    int userRowNumber;
    int rowNumber;

    ObservableList<UserDTO> userObList = FXCollections.observableArrayList();


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

        UserTbl.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            userRowNumber = (Integer) newValue;
            removeBtn.setDisable(false);
            addBtn.setDisable(true);
            updateBtn.setDisable(false);

            try {
                setUserData(userObList.get(userRowNumber).getUserID());
            } catch (Exception e) {
                new Alert(Alert.AlertType.WARNING, "Error").show();
            }
        });

    }

    private void setUserData(String userID) throws Exception {
        List<UserDTO> userDTOS = userBO.findAll();
        for (UserDTO userDTO : userDTOS) {
            if (userDTO.getUserID().equals(userID)) {
                userIDTxt.setText(userDTO.getUserID());
                userNameTxt.setText(userDTO.getUserName());
                passwordTxt.setText(userDTO.getPassword());
            }
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
        if (userIDTxt.getText().trim().isEmpty() || userNameTxt.getText().trim().isEmpty() || passwordTxt.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Empty text Fields").show();
        } else {
            UserDTO userDTO = new UserDTO(
                    userIDTxt.getText(),
                    userNameTxt.getText(),
                    passwordTxt.getText()
            );


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                try {
                    if (userBO.add(userDTO)) {
                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setTitle("Message");
                        alert2.setContentText("Saved..");
                        alert2.show();

//                        setRoomID();
                        UserTbl.refresh();
                        loadUser();
//                        clear();

                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again..").show();
                    }
                } catch (Exception e) {
                    new Alert(Alert.AlertType.WARNING, e.getClass().getSimpleName()).show();
                }
            }
        }

    }

    public void updateOnAction(ActionEvent actionEvent) {
        UserTbl.refresh();
        UserDTO userDTO = new UserDTO(
                userIDTxt.getText(),
                userNameTxt.getText(),
                passwordTxt.getText()

        );

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> result = alert.showAndWait();


        if (result.get() == ButtonType.OK) {
            try {
                if (userBO.update(userDTO)) {
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Message");
                    alert2.setContentText("Saved..");
                    alert2.show();


                    userObList.remove(userRowNumber);
                    userObList.add(userDTO);
                    UserTbl.refresh();


                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again..").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        UserTbl.refresh();

    }

    public void removeOnAction(ActionEvent actionEvent) {
        UserTbl.refresh();
        try {
            List<UserDTO> all = userBO.findAll();//==============================================
            all.removeIf(userDTO -> !userDTO.getUserID().equals(userIDTxt.getText()));


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                boolean bool = false;
                for (UserDTO userDTO : all) {
                    bool = userBO.delete(userDTO.getUserID());//----------------
                }
                if (bool && userBO.delete(userIDTxt.getText())) {

                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Message");
                    alert2.setContentText("Saved..");
                    alert2.show();

                    loadUser();
                    UserTbl.refresh();

                }
            }
        } catch (Exception ignored) {
        }
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        UILoader.load("MainForm", context);
    }

    public void delete(MouseEvent mouseEvent) {

        try {
            List<UserDTO> all = userBO.findAll();//==============================================
            all.removeIf(userDTO -> !userDTO.getUserID().equals(userIDTxt.getText()));


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                boolean bool = false;
                for (UserDTO userDTO : all) {
                    bool = userBO.delete(userDTO.getUserID());//----------------
                }
                if (bool && userBO.delete(userIDTxt.getText())) {

                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Message");
                    alert2.setContentText("Saved..");
                    alert2.show();

                    loadUser();
                    UserTbl.refresh();

                }
            }
        } catch (Exception ignored) {
        }
    }
}
