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
public class ChuKho {
    private int id;
    private String name;
    private String address;
    private String sdt;

    public ChuKho() {
    }

    public ChuKho(int id, String name, String address, String sdt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
