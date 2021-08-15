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
public class HoaDonNhapHang {
    private int id;
    private int idchukho;
    private int id_details;
    private Date date;
    private float chietkhau;
    private Float tongtien;
    private String URL;
    private String note;
    private int sophieu;

    public HoaDonNhapHang() {
    }

    public HoaDonNhapHang(int idchukho, int id_details, Date date, float chietkhau, Float tongtien, String URL, String note, int sophieu) {
        this.idchukho = idchukho;
        this.id_details = id_details;
        this.date = date;
        this.chietkhau = chietkhau;
        this.tongtien = tongtien;
        this.URL = URL;
        this.note = note;
        this.sophieu = sophieu;
    }

    public HoaDonNhapHang(int id, int idchukho, int id_details, Date date, float chietkhau, Float tongtien, String URL, String note, int sophieu) {
        this.id = id;
        this.idchukho = idchukho;
        this.id_details = id_details;
        this.date = date;
        this.chietkhau = chietkhau;
        this.tongtien = tongtien;
        this.URL = URL;
        this.note = note;
        this.sophieu = sophieu;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdchukho() {
        return idchukho;
    }

    public void setIdchukho(int idchukho) {
        this.idchukho = idchukho;
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

    public float getChietkhau() {
        return chietkhau;
    }

    public void setChietkhau(float chietkhau) {
        this.chietkhau = chietkhau;
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

    public int getSophieu() {
        return sophieu;
    }

    public void setSophieu(int sophieu) {
        this.sophieu = sophieu;
    }
    
}
