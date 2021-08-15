/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.HDNhapDao;
import data.UserDao;
import empty.ChuKho;
import empty.DetailsHDNhap;
import empty.MatHang;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class hdnhap extends HttpServlet {

    UserDao ud = new UserDao();
    ArrayList<MatHang> mhs = ud.getMatHang();
    ArrayList<DetailsHDNhap> m;
    float sum;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hdnhap</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet hdnhap at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        String sophieu = request.getParameter("sophieu");
         mhs = ud.getMatHang();
        sum = 0;
        m = new ArrayList<>();
        request.setAttribute("mhs", mhs);
        HDNhapDao hn = new HDNhapDao();
        ArrayList<ChuKho> cks = hn.getChuKho();
        request.setAttribute("chukho", cks);
        String namechukho = null;

        String idchukho = request.getParameter("chukho");
        if (idchukho == null) {
            namechukho = "...";
        } else {
            for (ChuKho ck : cks) {
                if (ck.getId() == Integer.parseInt(idchukho)) {
                    namechukho = ck.getName();
                }

            }
        }
        if (sophieu == null) {
            sophieu = "";
        }
        request.setAttribute("chukho", cks);
        request.setAttribute("nameck", namechukho);
        request.setAttribute("sophieu", sophieu);
        request.getRequestDispatcher("hdnhaphang.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean exist = false;

        HDNhapDao hn = new HDNhapDao();
        ArrayList<ChuKho> cks = hn.getChuKho();
        request.setAttribute("chukho", cks);
        String namechukho = request.getParameter("nameck");
        String sophieu = request.getParameter("sophieu");
        String loaihang = request.getParameter("loaihang");
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        float dongia = 0;
        if (soluong > 0 && loaihang != null) {
            DetailsHDNhap t = new DetailsHDNhap();
            t.setName(loaihang);
            t.setSoluong(soluong);

            for (MatHang mh : mhs) {
                if (mh.getName().equals(loaihang)) {
                    t.setTotal(mh.getPrice() * soluong);
                    sum = sum + t.getTotal();
                    dongia = mh.getPrice();
                }
            }
            for (DetailsHDNhap temp : m) {
                if (t.getName().equals(temp.getName())) {
                    temp.setSoluong(t.getSoluong() + temp.getSoluong());
                    for (MatHang mh : mhs) {
                        if (mh.getName().equals(temp.getName())) {

                            temp.setTotal(mh.getPrice() * temp.getSoluong());
                        }
                    }
                    exist = true;
                }
            }
            t.setDongia(dongia);
            if (exist == false) {
                m.add(t);
            }
        }
        for (MatHang mh : mhs) {
            if (mh.getName().equals(loaihang)) {
                mhs.remove(mh);
                break;
            }
        }
        request.setAttribute("mhs", mhs);
        request.setAttribute("tongtien", sum);
        request.setAttribute("sophieu", sophieu);
        request.setAttribute("nameck", namechukho);
        request.getSession().setAttribute("list", m);
        request.getRequestDispatcher("hdnhaphang.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
