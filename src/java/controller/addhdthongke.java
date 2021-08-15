/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.HDXuatDao;
import data.KhoDao;
import empty.HoaDonXuatHang;
import empty.DetailsHDXuat;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class addhdthongke extends HttpServlet {

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
            out.println("<title>Servlet addhdthongke</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addhdthongke at " + request.getContextPath() + "</h1>");
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
        //add
        HDXuatDao hd = new HDXuatDao();
        KhoDao kd = new KhoDao();
        int id_hoadon = hd.getNewIdXuat() +1;
        ArrayList<DetailsHDXuat> t = (ArrayList)request.getSession().getAttribute("list");
        for(DetailsHDXuat temp : t) {
            hd.insert(id_hoadon, temp.getName(), temp.getSoluong());
        }
        request.getSession().invalidate();
         Date date = Date.valueOf(request.getParameter("date"));
         Float tongtien = hd.getSumXuat(id_hoadon);
         String file = request.getParameter("file");
         String note = request.getParameter("note");
        HoaDonXuatHang h = new HoaDonXuatHang(id_hoadon, date, tongtien, file, note);
        hd.insertHoaDon(h);
        kd.getnewValueXuat(id_hoadon);
        response.sendRedirect("main");
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
