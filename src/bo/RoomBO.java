package bo;

import dto.RoomDTO;

import java.sql.SQLException;
import java.util.List;
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
public interface RoomBO extends SuperBO {
    boolean add(RoomDTO roomDTO) throws Exception;

    List<RoomDTO> findAll() throws Exception;

    RoomDTO find(String id) throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(RoomDTO roomDTO) throws Exception;

    String generateNewRoomId() throws SQLException, ClassNotFoundException;


}
