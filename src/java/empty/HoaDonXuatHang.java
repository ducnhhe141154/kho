/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empty;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class HoaDonXuatHang {
    private int id;
    private int id_details;
    private Date date;
    private Float tongtien;
    private String URL;
    private String note;

    public HoaDonXuatHang() {
    }

    public HoaDonXuatHang(int id_details, Date date, Float tongtien, String URL, String note) {
        this.id_details = id_details;
        this.date = date;
        this.tongtien = tongtien;
        this.URL = URL;
        this.note = note;
    }

    public HoaDonXuatHang(int id, int id_details, Date date, Float tongtien, String URL, String note) {
        this.id = id;
        this.id_details = id_details;
        this.date = date;
        this.tongtien = tongtien;
        this.URL = URL;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_details() {
        return id_details;
    }

    public void setId_details(int id_details) {
        this.id_details = id_details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTongtien() {
        return tongtien;
    }

    public void setTongtien(Float tongtien) {
        this.tongtien = tongtien;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
