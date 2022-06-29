package controller;

import bo.BOFactory;
import bo.UserBO;
import dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    public Label lblHide;


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

    public void showPasswordOnMousePressed(MouseEvent mouseEvent) {
        Image img = new Image("assets/show.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setFitWidth(30);
        lblHide.setGraphic(view);
//
//        txtPwd.setPromptText(txtPwd.getText());
//        txtPwd.setVisible(true);
//        txtPwd.setText("");
//
//        txtPwd.requestFocus();

        txtPwd.setStyle("-fx-background-color:#3742fa ");
        txtPwd.setPromptText(txtPwd.getText());
        txtPwd.setText("");
        txtPwd.setDisable(true);

    }


    /*** --------------------------------------------HIDE PASSWORD----------------------------------------------------*/

    public void hidePasswordOnMousePressed(MouseEvent mouseEvent) {
        Image img = new Image("assets/hide.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setFitWidth(30);
        lblHide.setGraphic(view);


        txtPwd .setText(txtPwd.getPromptText());
        txtPwd.setPromptText("");
        txtPwd.setDisable(false);
        txtPwd.setStyle("-fx-control-inner-background:#ffffff ");

//        txtPwd.setText(txtPwd.getPromptText());
//        txtPwd.setPromptText("");
//        txtPwd.setDisable(false);

    }



}

