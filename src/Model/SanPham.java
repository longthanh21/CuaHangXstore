/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author KhanhCT
 */
public class SanPham {
    private String maSanPham;
    private String idspct;
    private String tenSanPham;
    private String ngayNhap;
    private String MauSac;
    private String Size;
    private String ChatLieu;
    private String Hang;
    private String soLuong;
    private String giaNhap;
    private String giaBan;
    private String trangThai;

    public SanPham() {
    }

    public SanPham(String maSanPham, String idspct, String tenSanPham, String ngayNhap, String MauSac, String Size, String ChatLieu, String Hang, String soLuong, String giaNhap, String giaBan, String trangThai) {
        this.maSanPham = maSanPham;
        this.idspct = idspct;
        this.tenSanPham = tenSanPham;
        this.ngayNhap = ngayNhap;
        this.MauSac = MauSac;
        this.Size = Size;
        this.ChatLieu = ChatLieu;
        this.Hang = Hang;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getIdspct() {
        return idspct;
    }

    public void setIdspct(String idspct) {
        this.idspct = idspct;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
}
