/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SanPham;
import Repository.DbConnect;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KhanhCT
 */
public class QuanLySanPham {

    ArrayList<SanPham> listSanPham = new ArrayList<>();
    ArrayList<SanPham> listCTCP = new ArrayList<>();
    ArrayList<SanPham> listMauSac = new ArrayList<>();

    public ArrayList<SanPham> getListSanPham() {
        listSanPham.clear();
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT * FROM SanPham";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSP"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setTrangThai(rs.getInt("TrangThai") == 1 ? "Còn hàng" : "Hết hàng");
                listSanPham.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSanPham;
    }

    String soLuongTong;

    public String SoLuongTong(String a) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT SoLuongTong FROM SanPham where MaSP = " + "'" + a + "'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                soLuongTong = rs.getString("SoLuongTong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soLuongTong;
    }

    public void AddSP(SanPham sp) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "INSERT INTO SanPham (MaSP, TenSP, SoLuongTong, TrangThai) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, sp.getTenSanPham());
            ps.setInt(3, 0);
            ps.setInt(4, Integer.valueOf(sp.getTrangThai().equals("Còn hàng") ? "1" : "0"));
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpSoLuongTong(String a, String b) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "UPDATE SanPham SET SoLuongTong = ? where MaSP = " + "'" + a + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(b));
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<SanPham> getListCTSP() {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT IdSP, MaSP, NgayNhap, TenMauSac, TenSize, TenChatLieu, TenHang, SoLuong, GiaNhap, GiaBan FROM CTSP\n"
                    + "JOIN MauSac on MauSac.IdMauSac = CTSP.IdMauSac\n"
                    + "JOIN Size on Size.IdSize = CTSP.IdSize\n"
                    + "JOIN ChatLieu on ChatLieu.IdChatLieu = CTSP.IdChatLieu\n"
                    + "JOIN Hang on Hang.IdHang = CTSP.IdHang";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdspct(rs.getString("IdSP"));
                sp.setMaSanPham(rs.getString("MaSP"));
                sp.setNgayNhap(rs.getString("NgayNhap"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setSize(rs.getString("TenSize"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setHang(rs.getString("TenHang"));
                sp.setGiaNhap(rs.getString("GiaNhap"));
                sp.setGiaBan(rs.getString("GiaBan"));
                sp.setSoLuong(rs.getString("SoLuong"));
                listCTCP.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCTCP;
    }

    public ArrayList<SanPham> getlistMauSac() {
        listSanPham.clear();
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT * FROM MauSac";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMauSac(rs.getString("IdMauSac"));
                listMauSac.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMauSac;
    }
}
