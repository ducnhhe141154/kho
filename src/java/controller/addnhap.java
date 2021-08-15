/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.HDNhapDao;
import data.KhoDao;
import data.UserDao;
import empty.ChuKho;
import empty.DetailsHDNhap;
import empty.HoaDonNhapHang;
import empty.MatHang;
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
public class addnhap extends HttpServlet {

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
            out.println("<title>Servlet addnhap</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addnhap at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        HDNhapDao hd = new HDNhapDao();
        int id_hoadon = hd.getNewIdNhap() + 1;
        UserDao ud = new UserDao();
        ArrayList<MatHang> mhs = ud.getMatHang();
        HDNhapDao hn = new HDNhapDao();
        String nameck = request.getParameter("nameck");
        int idchukho = 0;
        ArrayList<ChuKho> cks = hn.getChuKho();
        for (ChuKho ck : cks) {
            if (ck.getName().equals(nameck)) {
                idchukho = ck.getId();
            }
        }

        KhoDao kd = new KhoDao();

        ArrayList<DetailsHDNhap> t = (ArrayList) request.getSession().getAttribute("list");
        for (DetailsHDNhap temp : t) {
            for (MatHang mh : mhs) {
                if (mh.getName().equals(temp.getName())) {
                    hd.insert(id_hoadon, mh.getId(), temp.getSoluong());
                }
            }
        }
        request.getSession().invalidate();
        Date date = Date.valueOf(request.getParameter("date"));
        Float tongtien = hd.getSumNhap(id_hoadon);
        String file = request.getParameter("file");
        String note = request.getParameter("note");
        Float chietkhau = Float.parseFloat(request.getParameter("chietkhau"));
        int sophieu = Integer.parseInt(request.getParameter("sophieu"));
        HoaDonNhapHang h = new HoaDonNhapHang(idchukho, id_hoadon, date, chietkhau, tongtien, file, note, sophieu);
        hd.insertHoaDon(h);
        kd.getnewValueNhap(id_hoadon);
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
