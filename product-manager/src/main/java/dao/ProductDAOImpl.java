package dao;

import dto.ProductDTO;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    public static final String LIST_PRODUCT_VIEW = "SELECT * FROM view_product;";
    private static final String INSERT_PRODUCT = "INSERT INTO product VALUES (?,?,?,?,?,?,?);";
    private static final String UPDATE_PRODUCT = "update product set product_name=?,price=?,quantity=?,color_id=?,category_id=?, description=? where product_id=?;";
    private static final String DELETE_PRODUCT = "DELETE FROM product WHERE product_id = ?;";

    private static final String SEARCH_PRODUCT_BY_ID_VIEW = "SELECT * FROM view_product where product_id = ?;";
    private static final String SEARCH_PRODUCT_BY_NAME_VIEW = "SELECT * FROM view_product WHERE product_name LIKE CONCAT('%',?,'%');";
    private static final String SEARCH_PRODUCT = "SELECT * FROM view_product WHERE product_name LIKE CONCAT('%', ?, '%') and price like CONCAT('%', ?, '%') and quantity like CONCAT('%', ?, '%') and description like CONCAT('%', ?, '%') and category_name like CONCAT('%', ?, '%') and color_name like CONCAT('%', ?, '%');";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<ProductDTO> listProduct() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(LIST_PRODUCT_VIEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productId = (resultSet.getString("product_id"));
                String productName = resultSet.getString("product_name");

                String categoryId = (resultSet.getString("category_id"));
                String categoryName = resultSet.getString("category_name");

                String colorId = (resultSet.getString("color_id"));
                String colorName = resultSet.getString("color_name");


                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String description = resultSet.getString("description");
                ProductDTO productDTO = new ProductDTO(productId, productName,price,quantity,description,colorId,categoryId,categoryName,colorName);
                productDTOList.add(productDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public boolean addProduct(Product product) {
        boolean rowInsert = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_PRODUCT);
            String productId = product.getProductId();
            if (!"".equals(productId)) {
                preparedStatement.setString(1, productId);
            } else {
                preparedStatement.setString(1, null);
            }

            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getPrice());
            preparedStatement.setString(4, product.getQuantity());
            preparedStatement.setString(5, product.getColorId());
            preparedStatement.setString(6, product.getCategoryId());
            preparedStatement.setString(7, product.getDescription());

            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public boolean editProduct(Product product) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setString(4, product.getColorId());
            preparedStatement.setString(5, product.getCategoryId());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setString(7, product.getProductId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;

    }

    @Override
    public boolean deleteProduct(String id) {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_PRODUCT);
            preparedStatement.setString(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;

    }

    @Override
    public ProductDTO searchProductById(String id) {
        ProductDTO productDTO = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_PRODUCT_BY_ID_VIEW);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productId = (resultSet.getString("product_id"));
                String productName = resultSet.getString("product_name");

                String categoryId = (resultSet.getString("category_id"));
                String categoryName = resultSet.getString("category_name");

                String colorId = (resultSet.getString("color_id"));
                String colorName = resultSet.getString("color_name");


                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String description = resultSet.getString("quantity");
                productDTO = new ProductDTO(productId,productName,price,quantity,description,colorId,categoryId,categoryName,colorName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTO;
    }

    @Override
    public List<ProductDTO> searchProductByName(String name) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO=null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_PRODUCT_BY_NAME_VIEW);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productId = (resultSet.getString("product_id"));
                String productName = resultSet.getString("product_name");

                String categoryId = (resultSet.getString("category_id"));
                String categoryName = resultSet.getString("category_name");

                String colorId = (resultSet.getString("color_id"));
                String colorName = resultSet.getString("color_name");


                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                productDTO = new ProductDTO(productId,productName,price,quantity,categoryId,colorId,categoryId,categoryName,colorName );
                productDTOList.add(productDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> searchProduct(String productNameSearch, String categoryNameSearch, String colorNameSearch, String priceSearch, String quantitySearch, String descriptionSearch) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_PRODUCT);
            preparedStatement.setString(1, productNameSearch);
            preparedStatement.setString(2, priceSearch);
            preparedStatement.setString(3, quantitySearch);
            preparedStatement.setString(4, descriptionSearch);
            preparedStatement.setString(5, categoryNameSearch);
            preparedStatement.setString(6, colorNameSearch);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productId = (resultSet.getString("product_id"));
                String productName = resultSet.getString("product_name");

                String categoryId = (resultSet.getString("category_id"));
                String categoryName = resultSet.getString("category_name");

                String colorId = (resultSet.getString("color_id"));
                String colorName = resultSet.getString("color_name");


                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String description = resultSet.getString("description");
                ProductDTO productDTO = new ProductDTO(productId, productName,price,quantity,description,colorId,categoryId,categoryName,colorName);
                productDTOList.add(productDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }
}
