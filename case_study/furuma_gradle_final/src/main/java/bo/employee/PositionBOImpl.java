package bo.employee;

import dao.employee.PositionDAO;
import dao.employee.PositionDAOImpl;
import model.employee.Position;

import java.util.List;

public class PositionBOImpl implements PositionBO {
    private PositionDAO positionDAO = new PositionDAOImpl();

    @Override
    public List<Position> listPosition() {
        return this.positionDAO.listPosition();
    }

    @Override
    public Position searchPositionById(Integer id) {
        return positionDAO.searchPositionById(id);
    }
}
