package dao.custom.impl;

import dao.custom.UserDAO;
import entity.SuperEntity;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean add(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Object o) throws Exception {
        return false;
    }

    @Override
    public SuperEntity find(Object o) throws Exception {
        return null;
    }

    @Override
    public List findAll() throws Exception {
        return null;
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
