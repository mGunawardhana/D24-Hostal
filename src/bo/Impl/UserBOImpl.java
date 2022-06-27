package bo.Impl;

import bo.UserBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.User;

import java.util.List;

public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);


    @Override
    public boolean add(UserDTO userDTO) throws Exception {
        return userDAO.add(new User(
                userDTO.getUserName(),
                userDTO.getPassword()
        ));
    }

    @Override
    public List<UserDTO> findAll() throws Exception {
        return null;
    }

    @Override
    public UserDTO find(String id) throws Exception {
        return null;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        return false;
    }
}
