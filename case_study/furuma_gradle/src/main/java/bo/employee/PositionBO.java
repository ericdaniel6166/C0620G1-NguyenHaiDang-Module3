package bo.employee;

import model.employee.Position;

import java.util.List;

public interface PositionBO {
    List<Position> listPosition();
    Position searchPositionById(Integer id);
}
