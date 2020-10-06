package dao;

import model.TypeOfClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfClassDAOImpl implements TypeOfClassDAO {

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<TypeOfClass> findAllTypeOfClass() {
        List<TypeOfClass> typeOfClasses = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().
                            prepareStatement("select id, `name` " +
                                    "from type_of_class");

            ResultSet resultSet = preparedStatement.executeQuery();

            TypeOfClass typeOfClass;
            while (resultSet.next()) {
                Integer id = Integer.valueOf(resultSet.getString("id"));
                String name = resultSet.getString("name");

                typeOfClass = new TypeOfClass(id, name);
                typeOfClasses.add(typeOfClass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeOfClasses;
    }
}
