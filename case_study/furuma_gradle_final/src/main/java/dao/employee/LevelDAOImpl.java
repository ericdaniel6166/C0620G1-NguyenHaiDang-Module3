package dao.employee;

import dao.BaseDAO;
import model.employee.Level;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LevelDAOImpl implements LevelDAO {
    public static final String SELECT_ALL_LEVELS = "SELECT * FROM levels;";
    public static final String SELECT_LEVEL_NAME_BY_ID ="SELECT level_id, level_name FROM levels where level_id = ? ;";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<Level> listLevel() {
        List<Level> levelList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_LEVELS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer levelId = Integer.valueOf(resultSet.getString("level_id"));
                String levelName = resultSet.getString("level_name");
                Level level = new Level(levelId, levelName);
                levelList.add(level);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return levelList;
    }

    @Override
    public Level searchLevelById(Integer id) {
        Level level = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_LEVEL_NAME_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer levelId = Integer.valueOf(resultSet.getString("level_id"));
                String levelName =resultSet.getString("level_name");
                level = new Level(levelId, levelName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return level;
    }
}
