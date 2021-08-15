/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import empty.MatHang;
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
public class UserDao extends DBContext{
     public boolean Check(String username,String password) {
        try {
            String sql = "SELECT username,password From Account"
                    + "         Where username = ? and password =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,username);
            stm.setString(2,password);
            ResultSet rs = stm.executeQuery();
            stm.setString(1,username);
            stm.setString(2,password);
            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      public ArrayList<MatHang> getMatHang()
    {
        ArrayList<MatHang> mh = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MatHang";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                MatHang m = new MatHang();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setPrice(rs.getFloat("price"));
                mh.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mh;
    }
}