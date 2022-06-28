package dao;

import entity.SuperEntity;

import java.sql.SQLException;
import java.util.List;
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
public interface SuperDAO<Entity extends SuperEntity, ID> {
    boolean add(Entity entity) throws Exception;

    boolean update(Entity entity) throws Exception;

    boolean delete(ID id) throws Exception;

    Entity find(ID id) throws Exception;

    List<Entity> findAll() throws Exception;

    String generateId() throws SQLException, ClassNotFoundException;
}
