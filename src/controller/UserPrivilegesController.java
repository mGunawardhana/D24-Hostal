package controller;

import bo.BOFactory;
import bo.RoomBO;
import bo.UserBO;
import com.jfoenix.controls.JFXButton;
import dto.RoomDTO;
import dto.UserDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserPrivilegesController {

    private final UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.USER);


    public TextField userNameTxt;
    public PasswordField passwordTxt;
    public TableView<UserDTO> UserTbl;
    public TableColumn<UserDTO, String> userNameCol;
    public TableColumn<UserDTO, String> passwordCol;
    ObservableList<UserDTO> obList = FXCollections.observableArrayList();
    int rowNumber;

    public void initialize() {
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));

        try {
            loadTable();
            UserTbl.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserTbl.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            rowNumber = (Integer) newValue;
//            btnadd.setDisable(true);


            try {
                setUserData(obList.get(rowNumber).getPassword());
            } catch (Exception e) {
                new Alert(Alert.AlertType.WARNING, "Error").show();
            }
        });


    }

    private void setUserData(String password) throws Exception {
        List<UserDTO> all = userBO.findAll();
        for (UserDTO userDTO : all) {
            if (userDTO.getPassword().equals(password)) {
//============================================================================================================================================
                passwordTxt.setText(userDTO.getPassword());
                userNameTxt.setText(String.valueOf(userDTO.getUserName()));//***************************************

//============================================================================================================================================

            }
        }
    }

    public void loadTable() {
        obList.clear();
        List<UserDTO> all = userBO.findAll();

        for (UserDTO userDTO : all) {
            obList.add(userDTO);
        }
        UserTbl.setItems(obList);
    }

//    public void addRoom(MouseEvent mouseEvent) {
//        if (userNameTxt.getText().trim().isEmpty() || passwordTxt.getText().trim().isEmpty()) {
//            new Alert(Alert.AlertType.WARNING, "Empty text Fields").show();
//        } else {
//            UserDTO userDTO = new UserDTO(
//                    userNameTxt.getText(),
//                    passwordTxt.getText()
//            );
//
//
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            Optional<ButtonType> result = alert.showAndWait();
//
//            if (result.get() == ButtonType.OK) {
//                try {
//                    if (userBO.add(userDTO)) {
//                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
//                        alert2.setTitle("Message");
//                        alert2.setContentText("Saved..");
//                        alert2.show();
//
//                        loadTable();
//                        UserTbl.refresh();
////                        clear();
//
//                    } else {
//                        new Alert(Alert.AlertType.WARNING, "Try Again..").show();
//                    }
//                } catch (Exception e) {
//                    new Alert(Alert.AlertType.WARNING, e.getClass().getSimpleName()).show();
//                }
//            }
//        }
  //  }

    public void addOnAction(ActionEvent actionEvent) {

        if (userNameTxt.getText().trim().isEmpty() || passwordTxt.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Empty text Fields").show();
        } else {
            UserDTO userDTO = new UserDTO(
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

                        try {
                            loadTable();
                            UserTbl.refresh();
                        }catch (NullPointerException e){e.printStackTrace();}

//                        clear();

                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again..").show();
                    }
                } catch (Exception e) {
                   e.printStackTrace();
                }
            }
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void removeOnAction(ActionEvent actionEvent) {
    }
}
