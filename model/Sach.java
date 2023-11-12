package model;

import java.io.Serializable;

public class Sach implements Serializable{
    private int ma;
    private String ten;
    private String tgia;
    private String chuyenNganh;
    private int soLuong;
    private static int sMa=10000;

    public Sach() {
        ma=sMa++;
    }

    public Sach(int ma, String ten, String tgia, String chuyenNganh, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.tgia = tgia;
        this.chuyenNganh = chuyenNganh;
        this.soLuong = soLuong;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTgia() {
        return tgia;
    }

    public void setTgia(String tgia) {
        this.tgia = tgia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public static int getSma() {
        return sMa;
    }

    public static void setSma(int sMa) {
        Sach.sMa = sMa;
    }
    // viet Sach vao 1 dong cua bang => cho sach thanh doi tuong
    public Object[] toObjects(){
        return new Object[]{
            ma, ten, tgia, chuyenNganh, soLuong // moi thuoc tinh la 1 cot trong bang
        };
    }
    
        
}
