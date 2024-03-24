/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author KhanhCT
 */
public class HoaDon {
    private String maHD,ngayTao,maKH,maNV,maVC,tongTien,trangThai,maSP,tenSP,soLuong,giaBan;

    public HoaDon() {
    }

    public HoaDon(String maHD, String ngayTao, String maKH, String maNV, String maVC, String tongTien, String trangThai, String maSP, String tenSP, String soLuong, String giaBan) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.maKH = maKH;
        this.maNV = maNV;
        this.maVC = maVC;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaVC() {
        return maVC;
    }

    public void setMaVC(String maVC) {
        this.maVC = maVC;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }
public Integer thanhTien(Integer soLuong, Integer giaBan){
        return soLuong*giaBan;
                }
   
}
