package bo;

import dto.ProductDTO;
import model.Product;

import java.util.List;

public interface ProductBO {
    List<ProductDTO> listProduct();

    String addProduct(Product product);

    String editProduct(Product product);

    String deleteProduct(String id);

    ProductDTO searchProductById(String id);

    List<ProductDTO> searchProductByName(String name);

    List<ProductDTO> searchProduct(String productName, String categoryName, String colorName, String price, String quantity, String description);
}
