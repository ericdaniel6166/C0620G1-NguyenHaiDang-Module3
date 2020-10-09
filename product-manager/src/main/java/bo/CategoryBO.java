package bo;

import model.Category;

import java.util.List;

public interface CategoryBO {
    List<Category> listCategory();

    Category searchCategoryById(String id);
}
