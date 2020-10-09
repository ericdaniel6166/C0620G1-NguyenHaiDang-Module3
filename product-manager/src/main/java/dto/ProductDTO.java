package dto;

public class ProductDTO {
    private String productId;
    private String productName;
    private String price;
    private String quantity;
    private String description;
    private String colorId;
    private String categoryId;
    private String categoryName;
    private String colorName;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", description='" + description + '\'' +
                ", colorId='" + colorId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", colorName='" + colorName + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public ProductDTO(String productId, String productName, String price, String quantity, String description, String colorId, String categoryId, String categoryName, String colorName) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.colorId = colorId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.colorName = colorName;
    }

    public ProductDTO() {
    }
}
