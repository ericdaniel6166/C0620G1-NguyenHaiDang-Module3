package bo;

import common.Validator;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dto.ProductDTO;
import model.Product;

import java.util.List;

import static common.Validator.*;

public class ProductBOImpl implements ProductBO {
    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<ProductDTO> listProduct() {
        return this.productDAO.listProduct();
    }

    @Override
    public String addProduct(Product product) {
        String message = "";
        boolean productAdded = false;
        if (!"".equals(product.getProductId()) && !Validator.regex(REGEX_POSITIVE_INTEGER, product.getProductId())) {
            message += "Invalid Product ID: Product ID is a positive integer. <br>";
        }
        if (!"".equals(product.getProductId()) && this.searchProductById(product.getProductId()) != null) {
            message += "Invalid Product ID: Product ID already exists. <br>";
        }
        if (!Validator.regex(REGEX_NOT_NULL, product.getProductName())) {
            message += "Invalid Product Name: Product ID can't be empty. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_NUMBER, product.getPrice())) {
            message += "Invalid Price: Price must be a positive number. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_INTEGER, product.getQuantity())) {
            message += "Invalid Quantity: Quantity must be a positive integer. <br>";
        }
        if (!Validator.regex(REGEX_NOT_NULL, product.getDescription())) {
            message += "Invalid Description: Description can't be empty. <br>";
        }


        if ("".equals(message)) {
            productAdded = this.productDAO.addProduct(product);
            message = "Product was successfully added.";
        }
        return message;
    }

    @Override
    public String editProduct(Product product) {
        String message = "";
        boolean productEdited = false;

        if (!Validator.regex(REGEX_NOT_NULL, product.getProductName())) {
            message += "Invalid Product Name: Product ID can't be empty. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_NUMBER, product.getPrice())) {
            message += "Invalid Price: Price must be a positive number. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_INTEGER, product.getQuantity())) {
            message += "Invalid Quantity: Quantity must be a positive integer. <br>";
        }
        if (!Validator.regex(REGEX_NOT_NULL, product.getDescription())) {
            message += "Invalid Description: Description can't be empty. <br>";
        }

        if ("".equals(message)) {
            productEdited = this.productDAO.editProduct(product);
            message = "Product was successfully edited.";
        }
        return message;
    }

    @Override
    public String deleteProduct(String id) {
        String message = "";
        boolean productDeleted = false;
        productDeleted = this.productDAO.deleteProduct(id);
        message = "Product was successfully deleted.";
        return message;
    }

    @Override
    public ProductDTO searchProductById(String id) {
        return this.productDAO.searchProductById(id);
    }

    @Override
    public List<ProductDTO> searchProductByName(String productName) {
        return this.productDAO.searchProductByName(productName);
    }

    @Override
    public List<ProductDTO> searchProduct(String productName, String categoryName, String colorName, String price, String quantity, String description) {
        return this.productDAO.searchProduct(productName, categoryName, colorName, price, quantity, description);
    }
}
