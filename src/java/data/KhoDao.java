/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import empty.Kho;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KhoDao extends DBContext {

    public ArrayList<Kho> getKho() {
        ArrayList<Kho> kho = new ArrayList<>();
        try {
            String sql = "select k.idsp,m.name,k.soluong from Kho k\n"
                    + "inner join MatHang m\n"
                    + "on m.id = k.idsp";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Kho m = new Kho();
                m.setIdsp(rs.getInt("idsp"));
                m.setNamesp(rs.getString("name"));
                m.setSoluong(rs.getInt("soluong"));
                kho.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kho;
    }
    public void getnewValueXuat(int id){
         try {
            String sql = "select k.idsp,k.SoLuong - d.soluong as new from DetailsHDXuat d\n"
                    + "inner join MatHang m\n"
                    + "on m.name = d.loaihang\n"
                    + "inner join Kho k\n"
                    + "on k.idsp = m.id\n"
                    + "where d.id =?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                UpdateKho(rs.getInt("idsp"), rs.getInt("new"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getnewValueNhap(int id){
         try {
            String sql = "select k.idsp,k.SoLuong + d.soluong as new from DetailsHDXuat d\n"
                    + "inner join MatHang m\n"
                    + "on m.name = d.loaihang\n"
                    + "inner join Kho k\n"
                    + "on k.idsp = m.id\n"
                    + "where d.id =?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                UpdateKho(rs.getInt("idsp"), rs.getInt("new"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UpdateKho(int idsp,int soluong) {
        try {
            String sql = "UPDATE [dbo].[Kho]\n"
                    + "   SET [SoLuong] = ?\n"
                    + " WHERE idsp = ?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, soluong);
            stm.setInt(2, idsp);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
