package dao;

import dto.ProductDTO;
import model.Product;

import java.util.List;

public interface ProductDAO {
    List<ProductDTO> listProduct();

    boolean addProduct(Product product);

    boolean editProduct(Product product);

    boolean deleteProduct(String id);

    ProductDTO searchProductById(String id);

    List<ProductDTO> searchProductByName(String name);
    List<ProductDTO> searchProductByPrice(String price);
    List<ProductDTO> searchProductByCategory(String category);
    List<ProductDTO> searchProductByColor(String color);


}
