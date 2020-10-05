package dao.employee;

import model.employee.Level;

import java.util.List;

public interface LevelDAO {
    List<Level> listLevel();
    Level searchLevelById(Integer id);
}
