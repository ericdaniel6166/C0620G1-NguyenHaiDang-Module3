package bo;

import model.Level;

import java.util.List;

public interface LevelBO {
    List<Level> listLevel();
    Level searchLevelById(Integer id);
}
