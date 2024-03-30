/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author KhanhCT
 */
public class KhachHang {

    private String maKH;
    private String tenKH;
    private String SĐT;
    private String NgayTao;
    private boolean gioiTinh;
    private boolean trangThai;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String SĐT, String NgayTao, boolean gioiTinh, boolean trangThai, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SĐT = SĐT;
        this.NgayTao = NgayTao;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
        this.diaChi = diaChi;
    }


    
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSĐT() {
        return SĐT;
    }

    public void setSĐT(String SĐT) {
        this.SĐT = SĐT;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    
}
