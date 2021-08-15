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
import empty.DetailsHDXuat;
import empty.HoaDonNhapHang;
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
public class showHDNhap extends HttpServlet {

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
            out.println("<title>Servlet showHDNhap</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showHDNhap at " + request.getContextPath() + "</h1>");
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
          HDNhapDao hn = new HDNhapDao();
        ArrayList<ChuKho> cks = hn.getChuKho();
        int id = Integer.parseInt(request.getParameter("id"));
        HDNhapDao hd = new HDNhapDao();
        ArrayList<DetailsHDNhap> dhds =(ArrayList)hd.getDetailsHDNhap(id);
        for (DetailsHDNhap dhd : dhds) {
            dhd.setDongia(dhd.getTotal()/dhd.getSoluong());
        }
       HoaDonNhapHang hds = hd.getHDNhapbyId(id);
        for (ChuKho ck : cks) {
            if(ck.getId() == hds.getIdchukho()){
                request.setAttribute("chukho",ck);
            }
        }
        request.setAttribute("hds",hds);
        float tongthanhtoan = hds.getTongtien() - hds.getChietkhau();
        request.setAttribute("dhds",dhds);
        request.setAttribute("tongthanhtoan",tongthanhtoan);
       request.getRequestDispatcher("ShowHDNhap.jsp").forward(request, response);
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
