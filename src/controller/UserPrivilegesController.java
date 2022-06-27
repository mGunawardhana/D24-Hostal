package controller;

import bo.*;
import com.jfoenix.controls.JFXButton;
import dto.UserDTO;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.List;
import java.util.Optional;

public class UserPrivilegesController {
    private final StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.STUDENT);
    private final RoomBO roomBO = (RoomBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.ROOM);
    private final ReserveBO reserveBO = (ReserveBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.RESERVE);
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
        //======================================================

        UserTbl.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            userRowNumber = (Integer) newValue;
//            removeBtn.setDisable(false);
//            addBtn.setDisable(false);
//            updateBtn.setDisable(true);
//

            try {
                setUserData(userObList.get(userRowNumber).getUserID());
            } catch (Exception e) {
                new Alert(Alert.AlertType.WARNING, "Error").show();
            }
        });


    }

    //================================================================
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

    //================================================================


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

    }

    public void removeOnAction(ActionEvent actionEvent) {


    }
}
