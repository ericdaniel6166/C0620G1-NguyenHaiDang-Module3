package controller;

import bo.*;
import dto.ProductDTO;
import model.Category;
import model.Color;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/list_product")
public class ProductServlet extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBOImpl();
    private ColorBO colorBO = new ColorBOImpl();
    private ProductBO productBO= new ProductBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addProduct(request, response);
                listProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                listProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                listProduct(request, response);
                break;
            case "search_by_name":
                searchProductByName(request, response);
            default:
                break;
        }
    }

    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) {
        boolean productSearched = false;
        String message = "";
        List<ProductDTO> productDTOList = null;
        try {
            String productNameSearch = request.getParameter("productNameSearch");
            productDTOList = this.productBO.searchProductByName(productNameSearch);
            if (productDTOList == null) {
                message += "Product Name " + '"' + productNameSearch + '"' + " is not found";
            } else {
                message = "Product Name " + '"' + productNameSearch + '"';
            }

            request.setAttribute("productDTOList", productDTOList);
            request.setAttribute("message", message);

            List<Category> categoryList = this.categoryBO.listCategory();
            request.setAttribute("categoryList", categoryList);

            List<Color> colorList = this.colorBO.listColor();
            request.setAttribute("colorList", colorList);


            RequestDispatcher dispatcher = request.getRequestDispatcher("view/list_product.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            String productIdEdit = (request.getParameter("productIdEdit"));

            String productNameEdit = request.getParameter("productNameEdit");

            String categoryIdEdit = (request.getParameter("categoryIdEdit"));
            String colorIdEdit = (request.getParameter("colorIdEdit"));

            String priceEdit = request.getParameter("priceEdit");

            String quantityEdit = request.getParameter("quantityEdit");
            String descriptionEdit = request.getParameter("descriptionEdit");


            Product product = new Product(productIdEdit,productNameEdit,priceEdit,quantityEdit,descriptionEdit,colorIdEdit,categoryIdEdit);
            message = this.productBO.editProduct(product);

            request.setAttribute("message", message);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            String productIdDelete = (request.getParameter("productIdDelete"));
            message = this.productBO.deleteProduct(productIdDelete);

            request.setAttribute("message", message);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            String productIdAdd = request.getParameter("productIdAdd");

            String productNameAdd = request.getParameter("productNameAdd");

            String categoryIdAdd = (request.getParameter("categoryIdAdd"));

            String colorIdAdd = (request.getParameter("colorIdAdd"));

            String priceAdd = request.getParameter("priceAdd");

            String quantityAdd = request.getParameter("quantityAdd");
            String descriptionAdd = request.getParameter("descriptionAdd");

            Product product = new Product(productIdAdd, productNameAdd, priceAdd,quantityAdd,descriptionAdd,colorIdAdd,categoryIdAdd);
            message = this.productBO.addProduct(product);

            request.setAttribute("message", message);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
//                showAddForm(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
//                showDeleteForm(request, response);
                break;
            case "view":
//                viewProduct(request,response);
                break;

            default:
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<ProductDTO> productDTOList = this.productBO.listProduct();
            request.setAttribute("productDTOList", productDTOList);

            List<Category> categoryList = this.categoryBO.listCategory();
            request.setAttribute("categoryList", categoryList);

            List<Color> colorList = this.colorBO.listColor();
            request.setAttribute("colorList", colorList);


            RequestDispatcher dispatcher = request.getRequestDispatcher("view/list_product.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
