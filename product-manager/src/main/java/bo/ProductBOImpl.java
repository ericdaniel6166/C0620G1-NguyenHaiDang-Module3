package bo;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import dto.ProductDTO;
import model.Product;

import java.util.List;

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
//        if (product.getProductId() != null && !Validator.regex(REGEX_SERVICE_NAME, product.getProductId())) {
//            message += "Invalid Product ID: Product ID is a positive integer. <br>";
//        }
//        if (this.searchProductById(product.getProductId()) != null) {
//            message += "Invalid Product ID: Product ID already exists. <br>";
//        }
//        if (!Validator.regex(REGEX_PERSON_NAME, product.getProductName())) {
//            message += "Invalid name: Please input valid name (ex: An Binh). <br>";
//        }
//        if (!Validator.regex(REGEX_ID_NUMBER, product.getIdNumber())) {
//            message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
//        }
//        if (!Validator.regex(REGEX_POSITIVE_NUMBER, product.getSalary())) {
//            message += "Invalid Salary: Salary is a positive number. <br>";
//        }
//        if (!Validator.regex(REGEX_PHONE, product.getPhone())) {
//            message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
//        }
//        if (!Validator.regex(REGEX_EMAIL, product.getEmail())) {
//            message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
//        }
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

//        if (!Validator.regex(REGEX_PERSON_NAME, product.getProductName())) {
//            message += "Invalid Name: Please input valid name. <br>";
//        }
//        if (!Validator.regex(REGEX_ID_NUMBER, product.getIdNumber())) {
//            message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
//        }
//        Double salaryEdit = null;
//        if (!Validator.regex(REGEX_POSITIVE_NUMBER, product.getSalary())) {
//            message += "Invalid Salary: Salary is a positive number. <br>";
//        }
//        if (!Validator.regex(REGEX_PHONE, product.getPhone())) {
//            message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
//        }
//        if (!Validator.regex(REGEX_EMAIL, product.getEmail())) {
//            message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
//        }
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
    public List<ProductDTO> searchProductByPrice(String price) {
        return this.productDAO.searchProductByPrice(price);
    }

    @Override
    public List<ProductDTO> searchProductByCategory(String category) {
        return this.productDAO.searchProductByCategory(category);
    }

    @Override
    public List<ProductDTO> searchProductByColor(String color) {
        return this.productDAO.searchProductByColor(color);
    }
}
