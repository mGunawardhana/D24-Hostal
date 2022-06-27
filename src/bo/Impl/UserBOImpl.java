package bo.Impl;

import bo.UserBO;
import dto.UserDTO;

import java.util.List;

public class UserBOImpl implements UserBO {
    @Override
    public boolean add(UserDTO userDTO) throws Exception {
        return false;
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
