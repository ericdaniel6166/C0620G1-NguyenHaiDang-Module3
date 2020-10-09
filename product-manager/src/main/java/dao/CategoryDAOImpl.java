package dao;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    public static final String SELECT_CATEGORY_NAME_BY_ID = "SELECT category_id, category_name FROM category where category_id = ? ;";
    public static final String SELECT_ALL_CATEGORY = "SELECT * FROM category;";
    private BaseDAO baseDAO = new BaseDAO();


    @Override
    public List<Category> listCategory() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String categoryId = (resultSet.getString("category_id"));
                String categoryName = resultSet.getString("category_name");
                Category category = new Category(categoryId, categoryName);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category searchCategoryById(String id) {
        Category category = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_CATEGORY_NAME_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String categoryId = (resultSet.getString("category_id"));
                String categoryName = resultSet.getString("category_name");
                category = new Category(categoryId, categoryName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
