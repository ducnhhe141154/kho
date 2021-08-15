/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.UserDao;
import empty.MatHang;
import empty.DetailsHDXuat;
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
public class hdthongke extends HttpServlet {

    ArrayList<DetailsHDXuat> m;
    UserDao ud = new UserDao();
    ArrayList<MatHang> mhs = ud.getMatHang();

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
            out.println("<title>Servlet hdthongke</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet hdthongke at " + request.getContextPath() + "</h1>");
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
        sum = 0;
        mhs = ud.getMatHang();
        m = new ArrayList<>();
        request.setAttribute("mhs", mhs);
        request.getRequestDispatcher("hdthongke.jsp").forward(request, response);
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

        String loaihang = request.getParameter("loaihang");
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        float dongia = 0;
        if (soluong > 0 && loaihang !=null) {
            DetailsHDXuat t = new DetailsHDXuat();
            t.setName(loaihang);
            t.setSoluong(soluong);

            for (MatHang mh : mhs) {
                if (mh.getName().equals(loaihang)) {
                    t.setTotal(mh.getPrice() * soluong);
                    sum = sum + t.getTotal();
                    dongia = mh.getPrice();
                }
            }
            t.setDongia(dongia);
            if (exist == false) {
                m.add(t);
            }
            for (MatHang mh : mhs) {
                if (mh.getName().equals(loaihang)) {
                    mhs.remove(mh);
                    break;
                }
            }
        }
        request.setAttribute("mhs", mhs);
        request.setAttribute("tongtien", sum);
        request.getSession().setAttribute("list", m);
        request.getRequestDispatcher("hdthongke.jsp").forward(request, response);
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
