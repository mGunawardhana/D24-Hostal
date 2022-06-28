package controller;

import bo.BOFactory;
import bo.UserBO;
import dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.UILoader;

import java.util.List;

/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */

/*
 * TODO - > add RegX
 *  */

public class LoginPageFormController {
    private final UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.USER);
    public TextField txtName;
    public PasswordField txtPwd;
    public AnchorPane loginContext;


    public void logInOnAction(ActionEvent actionEvent) throws Exception {
        List<UserDTO> userDTOS = userBO.findAll();
        for (UserDTO userDTO_00 : userDTOS) {
            if (txtName.getText().equals(userDTO_00.getUserName())) {
                for (UserDTO userDTO_01 : userDTOS) {
                    if (txtPwd.getText().equals(userDTO_01.getPassword())) {
                        try {
                            UILoader.load("MainForm", loginContext);
                        }catch (NullPointerException ignored){
                        }
                    }
                }
            }
        }
    }
}

