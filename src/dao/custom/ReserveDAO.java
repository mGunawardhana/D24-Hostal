package dao.custom;

import dao.SuperDAO;
import entity.Room;
import entity.Reserve;
import entity.Student;

import java.util.List;
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
public interface ReserveDAO extends SuperDAO<Reserve, String> {
    Room getProgram(String id) throws Exception;

    List<Reserve> getRegProgram(String sid) throws Exception;

    Student getStudent(String id) throws Exception;
}
