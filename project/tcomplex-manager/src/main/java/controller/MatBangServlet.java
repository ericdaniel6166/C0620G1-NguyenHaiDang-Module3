package controller;

import bo.*;
import dto.MatBangDTO;
import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MatBangServlet", urlPatterns = "/list_mat_bang")
public class MatBangServlet extends HttpServlet {
//    private LoaiMatBangBO loaiMatBangBO = new LoaiMatBangBOImpl();
//    private TrangThaiBO trangThaiBO = new TrangThaiBOImpl();
//    private MatBangBO matBangBO = new MatBangBOImpl();

    private LoaiMatBangBO loaiMatBangBO=new LoaiMatBangBOImpl();
    private MatBangBO matBangBO=new MatBangBOImpl();
    private TrangThaiBO trangThaiBO=new TrangThaiBOImpl() {
    };


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":

                addMatBang(request, response);
                listMatBang(request, response);
                break;
            case "edit":
//                editMatBang(request, response);
//                listMatBang(request, response);
                break;
            case "delete":
                deleteMatBang(request, response);
                listMatBang(request, response);
                break;
            case "search_by_name":
//                searchMatBangByName(request, response);
            case "search":
                searchMatBang(request, response);

            default:
                break;
        }
    }

    private void deleteMatBang(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            String maMatBangDelete = (request.getParameter("maMatBangDelete"));
            message = this.matBangBO.deleteMatBang(maMatBangDelete);

            request.setAttribute("message", message);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void addMatBang(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
//            private String maMatBang;
//            private String trangThaiId;
//            private String dienTich;
//            private String tang;
//            private String loaiMatBangId;
//            private String giaTien;
//            private String ngayBatDau;
//            private String ngayKetThuc;
            String maMatBangAdd = request.getParameter("maMatBangAdd");

            String trangThaiIdAdd = request.getParameter("trangThaiIdAdd");

            String loaiMatBangIdAdd = (request.getParameter("loaiMatBangIdAdd"));

            String dienTichAdd = (request.getParameter("dienTichAdd"));

            String tangAdd = request.getParameter("tangAdd");

            String giaTienAdd = request.getParameter("giaTienAdd");
            String ngayBatDauAdd = request.getParameter("ngayBatDauAdd");
            String ngayKetThucAdd = request.getParameter("ngayKetThucAdd");

            MatBang matBang = new MatBang(maMatBangAdd,trangThaiIdAdd,dienTichAdd,tangAdd,loaiMatBangIdAdd,giaTienAdd,ngayBatDauAdd,ngayKetThucAdd);
            message = this.matBangBO.addMatBang(matBang);

            request.setAttribute("message", message);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void searchMatBang(HttpServletRequest request, HttpServletResponse response) {
        boolean matBangSearched = false;
        String message = "";
        List<MatBangDTO> matBangDTOList = null;
        try {
            String tangSearch = request.getParameter("tangSearch");
            String giaTienSearch = request.getParameter("giaTienSearch");
            String loaiMatBangTenSearch = request.getParameter("loaiMatBangTenSearch");
//            String descriptionSearch = request.getParameter("descriptionSearch");
//            String loaiMatBangNameSearch = request.getParameter("loaiMatBangNameSearch");
//            String trangThaiNameSearch = request.getParameter("trangThaiNameSearch");

//            searchMatBang(String tang, String giaTien, String loaiMatBangTen)
            matBangDTOList = this.matBangBO.searchMatBang(tangSearch,giaTienSearch,loaiMatBangTenSearch);
            if (matBangDTOList.size() == 0) {
                message += "not found";
            } else {
                message = "found";
            }

            request.setAttribute("matBangDTOList", matBangDTOList);
            request.setAttribute("message", message);

            List<LoaiMatBang> loaiMatBangList = this.loaiMatBangBO.listLoaiMatBang();
            request.setAttribute("loaiMatBangList", loaiMatBangList);

            List<TrangThai> trangThaiList = this.trangThaiBO.listTrangThai();
            request.setAttribute("trangThaiList", trangThaiList);


            RequestDispatcher dispatcher = request.getRequestDispatcher("view/list_mat_bang.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
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
//                viewMatBang(request,response);
                break;

            default:
                listMatBang(request, response);
                break;
        }
    }

    private void listMatBang(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<MatBangDTO> matBangDTOList = this.matBangBO.listMatBang();
            request.setAttribute("matBangDTOList", matBangDTOList);

            List<LoaiMatBang> loaiMatBangList = this.loaiMatBangBO.listLoaiMatBang();
            request.setAttribute("loaiMatBangList", loaiMatBangList);

            List<TrangThai> trangThaiList = this.trangThaiBO.listTrangThai();
            request.setAttribute("trangThaiList", trangThaiList);


            RequestDispatcher dispatcher = request.getRequestDispatcher("view/list_mat_bang.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
