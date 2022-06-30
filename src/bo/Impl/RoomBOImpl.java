package bo.Impl;

import bo.RoomBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dto.RoomDTO;
import entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
public class RoomBOImpl implements RoomBO {

    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean add(RoomDTO roomDTO) throws Exception {
        return roomDAO.add(new Room(
                roomDTO.getRoomID(),
                roomDTO.getRoomType(),
                roomDTO.getRoomQty(),
                roomDTO.getMonthlyRent()
        ));

    }

    @Override
    public List<RoomDTO> findAll() throws Exception {
        ArrayList<RoomDTO> roomDTOS = new ArrayList<>();
        List<Room> all = roomDAO.findAll();
        for (Room room : all) {
            roomDTOS.add(new RoomDTO(
                    room.getRoomID(),
                    room.getRoomType(),
                    room.getRoomQty(),
                    room.getMonthlyRent()
            ));
        }
        return roomDTOS;
    }

    @Override
    public RoomDTO find(String id) throws Exception {
        Room r2 = roomDAO.find(id);
        return new RoomDTO(
                r2.getRoomID(),
                r2.getRoomType(),
                r2.getRoomQty(),
                r2.getMonthlyRent()
        );
    }

    @Override
    public boolean delete(String id) throws Exception {
        return roomDAO.delete(id);
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {
        return roomDAO.update(new Room(
                roomDTO.getRoomID(),
                roomDTO.getRoomType(),
                roomDTO.getRoomQty(),
                roomDTO.getMonthlyRent()
        ));
    }

    @Override
    public String generateNewRoomId() throws SQLException, ClassNotFoundException {
        return roomDAO.generateId();
    }
}
