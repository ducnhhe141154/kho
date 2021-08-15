/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import empty.DetailsHDXuat;
import empty.HoaDonXuatHang;
import java.sql.Date;
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
public class HDXuatDao extends DBContext {

    public int getNewIdXuat() {
        int newid = 0;
        try {
            String sql = "select Max(id) as nid from DetailsHDXuat";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                newid = rs.getInt("nid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newid;
    }

    public void insert(int id_hoadon, String loaihang, int soluong) {
        try {
            String sql = "INSERT INTO [dbo].[DetailsHDXuat]\n"
                    + "           ([id]\n"
                    + "           ,[loaihang]\n"
                    + "           ,[soluong])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id_hoadon);
            stm.setString(2, loaihang);
            stm.setInt(3, soluong);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public float getSumXuat(int id) {
        float sum = 0;
        try {
            String sql = "select Sum(soluong*price) as total from DetailsHDXuat d\n"
                    + "inner join Mathang m\n"
                    + "on d.loaihang = m.name\n"
                    + "where d.id = ?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                sum = rs.getInt("total");
            }

        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }

    public void insertHoaDon(HoaDonXuatHang h) {
        try {
            String sql = "INSERT INTO [dbo].[HoaDonXuatHang]\n"
                    + "           ([id_details]\n"
                    + "           ,[date]\n"
                    + "           ,[tongtien]\n"
                    + "           ,[URL]\n"
                    + "           ,[note])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, h.getId_details());
            stm.setDate(2, h.getDate());
            stm.setFloat(3, h.getTongtien());
            stm.setString(4, h.getURL());
            stm.setString(5, h.getNote());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<HoaDonXuatHang> getHDXuat() {
        ArrayList<HoaDonXuatHang> hds = new ArrayList<>();
        try {
            String sql = "select * from HoaDonXuatHang";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonXuatHang hdxh = new HoaDonXuatHang(rs.getInt("id"), rs.getInt("id_details"), rs.getDate("date"), rs.getFloat("tongtien"), rs.getString("URL"), rs.getString("note"));
                hds.add(hdxh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hds;
    }

    public ArrayList<HoaDonXuatHang> getHDXuatbyDate(int date) {
        ArrayList<HoaDonXuatHang> hds = new ArrayList<>();
        try {
            String sql = "select * from HoaDonXuatHang \n"
                    + "                   where Month(date) = ?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, date);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonXuatHang hdxh = new HoaDonXuatHang(rs.getInt("id"), rs.getInt("id_details"), rs.getDate("date"), rs.getFloat("tongtien"), rs.getString("URL"), rs.getString("note"));
                hds.add(hdxh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hds;
    }

    public HoaDonXuatHang getHDXuatbyId(int id) {
        HoaDonXuatHang hdxh = new HoaDonXuatHang();
        try {
            String sql = "select * from HoaDonXuatHang "
                    + "where id_details = ?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                hdxh = new HoaDonXuatHang(rs.getInt("id"), rs.getInt("id_details"), rs.getDate("date"), rs.getFloat("tongtien"), rs.getString("URL"), rs.getString("note"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hdxh;
    }

    public ArrayList<DetailsHDXuat> getDetailsHDXuat(int id) {
        ArrayList<DetailsHDXuat> dhd = new ArrayList<>();
        try {
            String sql = "SELECT d.id,d.loaihang,d.soluong,d.soluong*m.price as total FROM [dbo].[DetailsHDXuat] d\n"
                    + "inner join MatHang m\n"
                    + "on m.name = d.loaihang\n"
                    + "  where d.id =?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                DetailsHDXuat dh = new DetailsHDXuat();
                dh.setName(rs.getString("loaihang"));
                dh.setSoluong(rs.getInt("soluong"));
                dh.setTotal(rs.getFloat("total"));
                dhd.add(dh);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dhd;
    }

    public ArrayList<DetailsHDXuat> gettotalHDMonth(int month,int nam) {
        ArrayList<DetailsHDXuat> dhd = new ArrayList<>();
        try {
            String sql = "SELECT d.loaihang,sum(d.soluong) as soluong,sum(d.soluong*m.price) as total FROM [dbo].[DetailsHDXuat] d\n" +
"                     inner join MatHang m \n" +
"                     on m.name = d.loaihang\n" +
"                    	left outer join HoaDonXuatHang h\n" +
"                    on h.id_details = d.id\n" +
"                    	where MONTH(date) =? and Year(date)= ?\n" +
"			group by d.loaihang";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, month);
            stm.setInt(2, nam);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){    
                DetailsHDXuat dh = new DetailsHDXuat();
                dh.setName(rs.getString("loaihang"));
                dh.setSoluong(rs.getInt("soluong"));
                dh.setTotal(rs.getFloat("total"));
                dhd.add(dh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dhd;
    } 
    }
   
    
            

