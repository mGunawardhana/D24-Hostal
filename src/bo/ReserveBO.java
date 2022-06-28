package bo;

import dto.ReserveDTO;
import entity.Room;
import entity.Student;

import java.sql.SQLException;
import java.util.List;
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
public interface ReserveBO extends SuperBO {

    boolean add(ReserveDTO reserveDTO) throws Exception;

    List<ReserveDTO> findAll() throws Exception;

    ReserveDTO find() throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(ReserveDTO reserveDTO) throws Exception;

    String generateNewRoomId() throws SQLException, ClassNotFoundException;

    Room getRoom(String id) throws Exception;

    Student getStudent(String id) throws Exception;

    List<ReserveDTO> getregRoom(String id) throws Exception;
}
