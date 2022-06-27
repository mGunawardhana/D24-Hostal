package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.UILoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


//    Connection con = null;
//        try {
//        con = DBConnection.getInstance().getConnection();
//    } catch (SQLException | ClassNotFoundException ignored) {
//    }
//
//    String query = "SELECT * FROM cashier";
//    PreparedStatement stm = con.prepareStatement(query);
//
//    String CashierID = CashierUserNameTxt.getText();
//    String CashierPsw = CashierPwdTxt.getText();
//
//        CashierUserNameTxt.setDisable(false);
//        CashierPwdTxt.setDisable(false);
//
//    ResultSet rst = stm.executeQuery(query);
//        if (rst.next()) {
//        attempt2++;
//        if (attempt2 <= 2) {
//            if (CashierID.equals(rst.getString(2)) && CashierPsw.equals(rst.getString(3))) {
//                CashierImg.setVisible(false);
//                UILoader.AdminORCashierUI("CustomerManagementForm", OwnerUnderCashier);
//                NotificationController.LoginSuccessfulNotification("");
//            } else {
//                CashierImg.setVisible(false);
//                NotificationController.LoginUnSuccessfulNotification("CASHIER", attempt2);
//            }
//        } else {
//            CashierUserNameTxt.setDisable(true);
//            CashierPwdTxt.setDisable(true);
//            CashierImg.setVisible(true);
//            NotificationController.LoginUnSuccessfulNotification("", 2);
//        }
//    }
}

