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
public class DetailsHDXuat {
    String name;
    int soluong;
    float dongia;
    float total;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "DetailsHDXuat{" + "name=" + name + ", soluong=" + soluong + ", dongia=" + dongia + ", total=" + total + '}';
    }
    
}
