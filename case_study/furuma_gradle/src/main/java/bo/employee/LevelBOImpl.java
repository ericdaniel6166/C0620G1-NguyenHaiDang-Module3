package bo.employee;

import dao.employee.LevelDAO;
import dao.employee.LevelDAOImpl;
import model.employee.Level;

import java.util.List;

public class LevelBOImpl implements LevelBO {
    private LevelDAO levelDAO = new LevelDAOImpl();

    @Override
    public List<Level> listLevel() {
        return this.levelDAO.listLevel();
    }

    @Override
    public Level searchLevelById(Integer id) {
        return levelDAO.searchLevelById(id);
    }
}
