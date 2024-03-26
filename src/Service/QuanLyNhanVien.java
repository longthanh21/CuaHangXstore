/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDon;
import Model.NhanVien;
import Model.TaiKhoan;
import Repository.DbConnect;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author KhanhCT
 */
public class QuanLyNhanVien {

    ArrayList<NhanVien> list = new ArrayList<>();

    public ArrayList<NhanVien> getAllNhanVien() {
        list.clear();
        try {
            String sql = "select MaNV, TenNV, NgaySinh, GioiTinh, DiaChi, Sdt, VaiTro, MaCL, TrangThai from NhanVien";
            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String Ma = rs.getString(1);
                String Ten = rs.getString(2);
                String NgaySinh = rs.getString(3);
                Boolean GioiTinh = rs.getBoolean(4);
                String DiaChi = rs.getString(5);
                String Sdt = rs.getString(6);
                Boolean VaiTro = rs.getBoolean(7);
                String MaCL = rs.getString(8);
                Boolean TrangThai = rs.getBoolean(9);
                list.add(new NhanVien(Ma, Ten, NgaySinh, GioiTinh, DiaChi, Sdt, VaiTro, MaCL, MaCL, TrangThai));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean AddNhanVien(NhanVien nhanVien) {
        try {
            String sql = "INSERT INTO NhanVien (MaNV, TenNV, NgaySinh, GioiTinh, DiaChi, Sdt, VaiTro, MaCL, TrangThai) VALUES(?, ?, ?, ?, ?, ?,?, ?, ?)";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nhanVien.getMaNV());
            ps.setString(2, nhanVien.getTenNV());
            ps.setString(3, nhanVien.getNgaySinh());
            ps.setBoolean(4, nhanVien.isGioiTinh());
            ps.setString(5, nhanVien.getDiaChi());
            ps.setString(6, nhanVien.getSĐT());
            ps.setBoolean(7, nhanVien.isVaiTro());
            ps.setString(8, nhanVien.getMaCL());
            ps.setBoolean(9, nhanVien.isTrangThai());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNhanVien(String ma) {
        try {
            String sql = "delete from TaiKhoan where MaNV = ?  delete from NhanVien where MaNV = ?";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ps.setString(2, ma);
            ps.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpDateNhanVien(NhanVien nhanVien) {
        try {
            String sql = "update NhanVien set TenNV = ? , NgaySinh=?, GioiTinh=?, DiaChi=?, Sdt=?, VaiTro=?, MaCL=?, TrangThai=? where MaNV = ?";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nhanVien.getTenNV());
            ps.setString(2, nhanVien.getNgaySinh());
            ps.setBoolean(3, nhanVien.isGioiTinh());
            ps.setString(4, nhanVien.getDiaChi());
            ps.setString(5, nhanVien.getSĐT());
            ps.setBoolean(6, nhanVien.isVaiTro());
            ps.setString(7, nhanVien.getMaCL());
            ps.setBoolean(8, nhanVien.isTrangThai());
            ps.setString(9, nhanVien.getMaNV());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//--------------------------------------------Phần Tai Khoan--------------------------------------------------
    ArrayList<TaiKhoan> listTaiKhoan = new ArrayList<>();

    public ArrayList<TaiKhoan> getAllTaiKhoan() {
        listTaiKhoan.clear();
        try {
            String sql = "select MaTK, TenDangNhap,MatKhau,MaNV from TaiKhoan";
            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String ma = rs.getString(1);
                String Ten = rs.getString(2);
                String matKhau = rs.getString(3);
                String maNV = rs.getString(4);
                listTaiKhoan.add(new TaiKhoan(ma, Ten, matKhau, maNV));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTaiKhoan;
    }

    public boolean AddTaiKhoan(TaiKhoan taiKhoan) {
        try {
            String sql = "INSERT INTO TaiKhoan (MaTK, TenDangNhap, MatKhau, MaNV) VALUES(?,?,?,?)";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, taiKhoan.getMaTK());
            ps.setString(2, taiKhoan.getTenDN());
            ps.setString(3, taiKhoan.getMatKhau());
            ps.setString(4, taiKhoan.getMaNV());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
