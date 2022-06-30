package bo.Impl;

import bo.UserBO;
import dao.DAOFactory;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.User;

import java.util.ArrayList;
import java.util.List;

/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean add(UserDTO userDTO) throws Exception {
        return userDAO.add(new User(
                userDTO.getUserID(),
                userDTO.getUserName(),
                userDTO.getPassword()
        ));
    }

    @Override
    public List<UserDTO> findAll() throws Exception {
        ArrayList<UserDTO> userDTOS = new ArrayList<>();
        List<User> all = userDAO.findAll();
        for (User user : all) {
            userDTOS.add(new UserDTO(
                    user.getUserID(), user.getUserName(), user.getPassword()
            ));
        }
        return userDTOS;
    }

    @Override
    public UserDTO find(String id) throws Exception {
        User user = userDAO.find(id);
        return new UserDTO(
                user.getUserID(),
                user.getUserName(),
                user.getPassword()
        );
    }

    @Override
    public boolean delete(String id) throws Exception {
        return userDAO.delete(id);
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        return userDAO.update(new User(
                userDTO.getUserID(),
                userDTO.getUserName(),
                userDTO.getPassword()
        ));
    }
}
