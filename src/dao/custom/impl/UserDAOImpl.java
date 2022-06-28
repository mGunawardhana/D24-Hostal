package dao.custom.impl;

import controller.UserPrivilegesController;
import dao.custom.UserDAO;
import entity.Room;
import entity.Student;
import entity.SuperEntity;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.List;
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public boolean add(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);


        transaction.commit();
        session.close();
        return  true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        boolean bool = false;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        // student id eken eyage reserve eka hyganna oni
        // reserve eken adala room no eka ganna haki
        //a room number eke dn thiyena quantity ekata ekak ekathu karanna

//        Student student = studentDAO.find(reserveDTO.getSID());
//        Room room = roomDAO.find(reserveDTO.getRID());
//        room.setRoomQty( room.getRoomQty() - 1);
//        roomDAO.update(room);

        Query query = session.createQuery("DELETE FROM User WHERE UserID=:id");
        query.setParameter("id", s);

        if (query.executeUpdate() > 0) {
            bool = true;
        }

        transaction.commit();
        session.close();
        return bool;
    }

    @Override
    public User find(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, s);

        Query query = session.createQuery("SELECT userName FROM User ORDER BY UserID DESC ");
        Query query2 = session.createQuery("SELECT password FROM User ORDER BY UserID DESC");

        System.out.println(query);

        transaction.commit();

        session.close();
        return user;
    }

    @Override
    public List findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query program = session.createQuery("FROM User");

        List<User> list = program.list();

        transaction.commit();

        session.close();
        return list;
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
