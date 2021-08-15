/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empty;

/**
 *
 * @author Admin
 */
public class DetailsHDNhap {
    String name;
    int soluong;
    float dongia;
    float total;

    public DetailsHDNhap() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DetailsHDNhap( int soluong, float dongia, float total) {
        this.soluong = soluong;
        this.dongia = dongia;
        this.total = total;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
