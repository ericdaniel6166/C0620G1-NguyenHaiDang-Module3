package bo;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import model.Category;

import java.util.List;

public class CategoryBOImpl implements CategoryBO {
    private CategoryDAO categoryDAO=new CategoryDAOImpl();

    @Override
    public List<Category> listCategory() {
        return this.categoryDAO.listCategory();
    }

    @Override
    public Category searchCategoryById(String id) {
        return this.searchCategoryById(id);
    }
}
