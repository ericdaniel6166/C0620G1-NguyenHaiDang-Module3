package bo;

import model.Position;

import java.util.List;

public interface PositionBO {
    List<Position> listPosition();
    Position searchPositionById(Integer id);
}
