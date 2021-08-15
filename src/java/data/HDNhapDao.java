/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import empty.ChuKho;
import empty.DetailsHDNhap;
import empty.HoaDonNhapHang;
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
public class HDNhapDao extends DBContext {

    public ArrayList<ChuKho> getChuKho() {
        ArrayList<ChuKho> cks = new ArrayList<>();
        try {
            String sql = "select  * from ChuKho";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ChuKho ck = new ChuKho(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("address"));
                cks.add(ck);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cks;
    }

    public void insertHoaDon(HoaDonNhapHang h) {
        try {
            String sql = "INSERT INTO [dbo].[HoaDonNhapHang]\n"
                    + "           ([id_chukho]\n"
                    + "           ,[date]\n"
                    + "           ,[ChietKhau]\n"
                    + "           ,[id_details]\n"
                    + "           ,[tongtien]\n"
                    + "           ,[URL]\n"
                    + "           ,[note]\n"
                    + "           ,[sophieu])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, h.getIdchukho());
            stm.setDate(2, h.getDate());
            stm.setFloat(3, h.getChietkhau());
            stm.setInt(4, h.getId_details());
            stm.setFloat(5, h.getTongtien());
            stm.setString(6, h.getURL());
            stm.setString(7, h.getNote());
            stm.setInt(8, h.getSophieu());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getNewIdNhap() {
        int newid = 0;
        try {
            String sql = "select Max(id) as nid from DetailsHDNhap";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                newid = rs.getInt("nid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newid;
    }

    public void insert(int id_hoadon, int idsp, int soluong) {
        try {
            String sql = "INSERT INTO [dbo].[DetailsHDNhap]\n"
                    + "           ([id]\n"
                    + "           ,[id_sp]\n"
                    + "           ,[soluong])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id_hoadon);
            stm.setInt(2, idsp);
            stm.setInt(3, soluong);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public float getSumNhap(int id) {
        float sum = 0;
        try {
            String sql = " select Sum(soluong*price) as total from DetailsHDNhap d\n" +
"                    inner join Mathang m\n" +
"                    on d.id_sp = m.id\n" +
"                    where d.id = ?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                sum = rs.getInt("total");
            }

        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }

    public ArrayList<HoaDonNhapHang> getHDNhap() {
        ArrayList<HoaDonNhapHang> hds = new ArrayList<>();
        try {
            String sql = "select * from HoaDonNhapHang";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonNhapHang hdnh = new HoaDonNhapHang();
                hdnh.setId(rs.getInt("id"));
                hdnh.setIdchukho(rs.getInt("id_chukho"));
                hdnh.setDate(rs.getDate("date"));
                hdnh.setChietkhau(rs.getFloat("ChietKhau"));
                hdnh.setId_details(rs.getInt("id_details"));
                hdnh.setTongtien(rs.getFloat("tongtien"));
                hdnh.setURL(rs.getString("URL"));
                hdnh.setNote(rs.getString("note"));
                hdnh.setSophieu(rs.getInt("sophieu"));
                hds.add(hdnh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hds;
    }

    public ArrayList<HoaDonNhapHang> getHDNhapbySoPhieu(int sophieu) {
        ArrayList<HoaDonNhapHang> hds = new ArrayList<>();
        try {
            String sql = "select * from HoaDonNhapHang "
                    + "where sophieu =?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, sophieu);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonNhapHang hdnh = new HoaDonNhapHang();
                hdnh.setId(rs.getInt("id"));
                hdnh.setIdchukho(rs.getInt("id_chukho"));
                hdnh.setDate(rs.getDate("date"));
                hdnh.setChietkhau(rs.getFloat("ChietKhau"));
                hdnh.setId_details(rs.getInt("id_details"));
                hdnh.setTongtien(rs.getFloat("tongtien"));
                hdnh.setURL(rs.getString("URL"));
                hdnh.setNote(rs.getString("note"));
                hdnh.setSophieu(rs.getInt("sophieu"));
                hds.add(hdnh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hds;
    }

    public HoaDonNhapHang getHDNhapbyId(int id) {
        HoaDonNhapHang hdnh = null;
        try {
            String sql = "select * from HoaDonNhapHang "
                    + "where id_details = ?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                hdnh = new HoaDonNhapHang();
                hdnh.setId(rs.getInt("id"));
                hdnh.setIdchukho(rs.getInt("id_chukho"));
                hdnh.setDate(rs.getDate("date"));
                hdnh.setChietkhau(rs.getFloat("ChietKhau"));
                hdnh.setId_details(rs.getInt("id_details"));
                hdnh.setTongtien(rs.getFloat("tongtien"));
                hdnh.setURL(rs.getString("URL"));
                hdnh.setNote(rs.getString("note"));
                hdnh.setSophieu(rs.getInt("sophieu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hdnh;
    }

    public ArrayList<DetailsHDNhap> getDetailsHDNhap(int id) {
        ArrayList<DetailsHDNhap> dhd = new ArrayList<>();
        try {
            String sql = "SELECT d.id,m.name,d.soluong,d.soluong*m.price as total FROM [dbo].[DetailsHDNhap] d\n"
                    + "                    inner join MatHang m\n"
                    + "                    on m.id = d.id_sp\n"
                    + "                      where d.id =?";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                DetailsHDNhap dh = new DetailsHDNhap();
                dh.setName(rs.getString("name"));
                dh.setSoluong(rs.getInt("soluong"));
                dh.setTotal(rs.getFloat("total"));
                dhd.add(dh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dhd;
    }
}
