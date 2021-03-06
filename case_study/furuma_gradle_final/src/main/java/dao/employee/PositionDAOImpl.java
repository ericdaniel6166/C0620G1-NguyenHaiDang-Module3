package dao.employee;

import dao.BaseDAO;
import model.employee.Position;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAOImpl implements PositionDAO {
    public static final String SELECT_ALL_POSITIONS = "SELECT * FROM positions;";
    public static final String SELECT_POSITION_NAME_BY_ID ="SELECT position_id, position_name FROM positions where position_id = ? ;";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<Position> listPosition() {
        List<Position> positionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_POSITIONS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String positionId = String.valueOf(resultSet.getString("position_id"));
                String positionName = resultSet.getString("position_name");
                Position position = new Position(positionId, positionName);
                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }
    @Override
    public Position searchPositionById(String id) {
        Position position = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_POSITION_NAME_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String positionId = String.valueOf(resultSet.getString("position_id"));
                String positionName =resultSet.getString("position_name");
                position = new Position(positionId, positionName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return position;
    }
}
