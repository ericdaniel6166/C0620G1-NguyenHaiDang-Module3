package dao.employee;

import model.employee.Position;

import java.util.List;

public interface PositionDAO {
    List<Position> listPosition();

    Position searchPositionById(String id);
}
