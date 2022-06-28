package bo;

import dto.RoomDTO;
import dto.StudentDTO;
import dto.UserDTO;

import java.util.List;
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
public interface UserBO extends SuperBO {
    boolean add(UserDTO userDTO) throws Exception;

    List<UserDTO> findAll() throws Exception;

    UserDTO find(String id) throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(UserDTO userDTO) throws Exception;
}
