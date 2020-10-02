package dao;

import model.Position;

import java.util.List;

public interface PositionDAO {
    List<Position> listPosition();
    Position searchPositionById(Integer id);
}
