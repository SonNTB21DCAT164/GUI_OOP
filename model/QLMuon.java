package model;

import java.io.Serializable;

public class QLMuon implements Serializable{
    private BanDoc bandoc;
    private Sach sach;
    private int soLuong;
    private String tinhTrang;

    public QLMuon() {
    }

    public QLMuon(BanDoc bandoc, Sach sach, int soLuong, String tinhTrang) {
        this.bandoc = bandoc;
        this.sach = sach;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public BanDoc getBandoc() {
        return bandoc;
    }

    public void setBandoc(BanDoc bandoc) {
        this.bandoc = bandoc;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    public Object[] toObjects(){
        return new Object[]{
           bandoc.getMa(), bandoc.getTen(),
            sach.getMa(), sach.getTen(), soLuong, tinhTrang
        };
    }
    
    public String getMavaTen(){
        return bandoc.getMa()+"\t"+bandoc.getTen();
    }
}
