package controller;

import bo.BOFactory;
import bo.ReserveBO;
import dto.ReserveDTO;
import dto.UserDTO;
import entity.Reserve;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import util.UILoader;

import java.io.IOException;
import java.util.List;

public class ReserveViewFormController {

    private final ReserveBO reserveBO = (ReserveBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.RESERVE);


    public AnchorPane reserveContext;
    public TableView<ReserveDTO> reserveTbl;
    public TableColumn<Reserve,String> dateCol;
    public TableColumn<Reserve,String> reserveIDCol;
    public TableColumn<Reserve,String> statusCol;
    public TableColumn<Reserve,String> roomIDCol;
    public TableColumn<Reserve,String> studentIDCol;
    ObservableList<ReserveDTO> reserveObList = FXCollections.observableArrayList();


    public void initialize(){
        reserveIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        roomIDCol.setCellValueFactory(new PropertyValueFactory<>("room_ID"));
        studentIDCol.setCellValueFactory(new PropertyValueFactory<>("student_ID"));

        try {
            loadReserve();
        } catch (Exception ignored) {
        }

    }
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        UILoader.load("MainForm", reserveContext);
    }

    public void loadReserve() throws Exception {
        reserveObList.clear();
        List<ReserveDTO> all = reserveBO.findAll();
        for (ReserveDTO reserveDTO : all) {
            reserveObList.add(reserveDTO);
        }
        reserveTbl.setItems(reserveObList);
    }
}
