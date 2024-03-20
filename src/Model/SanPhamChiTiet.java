/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TienBB
 */
public class SanPhamChiTiet {

    private int idspct;
    private String maSanPham;
    private String tenSanPham;
    private String ngayNhap;
    private int idMauSac;
    private int idSize;
    private int idChatLieu;
    private int idHang;
    private int soLuong;
    private float giaNhap;
    private float giaBan;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int idspct, String maSanPham, String tenSanPham, String ngayNhap, int idMauSac, int idSize, int idChatLieu, int idHang, int soLuong, float giaNhap, float giaBan) {
        this.idspct = idspct;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.ngayNhap = ngayNhap;
        this.idMauSac = idMauSac;
        this.idSize = idSize;
        this.idChatLieu = idChatLieu;
        this.idHang = idHang;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public int getIdspct() {
        return idspct;
    }

    public void setIdspct(int idspct) {
        this.idspct = idspct;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
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

    public int getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public int getIdHang() {
        return idHang;
    }

    public void setIdHang(int idHang) {
        this.idHang = idHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

}
