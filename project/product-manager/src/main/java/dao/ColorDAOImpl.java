package dao;

import model.Color;
import model.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDAOImpl implements ColorDAO {
    public static final String SELECT_COLOR_NAME_BY_ID = "SELECT color_id, color_name FROM color where color_id = ? ;";
    public static final String SELECT_ALL_COLOR = "SELECT * FROM color;";
    private BaseDAO baseDAO = new BaseDAO();


    @Override
    public List<Color> listColor() {
        List<Color> colorList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_COLOR);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String colorId = (resultSet.getString("color_id"));
                String colorName = resultSet.getString("color_name");
                Color color = new Color(colorId, colorName);
                colorList.add(color);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colorList;
    }

    @Override
    public Color searchColorById(String id) {
        Color color = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_COLOR_NAME_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String colorId = (resultSet.getString("color_id"));
                String colorName = resultSet.getString("color_name");
                color = new Color(colorId, colorName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return color;
    }
}
