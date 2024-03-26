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
    ArrayList<SanPham> listThuocTinh = new ArrayList<>();

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

    public String getSoLuongTong(String a) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT SoLuongTong FROM SanPham where MaSP = " + "'" + a + "'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String b = rs.getString("SoLuongTong");
                if(b == null || b.isEmpty()) soLuongTong = "0";
                else soLuongTong = b;
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

    public void TongSoLuongSP(String a) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "UPDATE SANPHAM SET SoLuongTong = (SELECT sum(SoLuong) FROM CTSP WHERE MaSP = ?) WHERE MaSP = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a);
            ps.setString(2, a);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void UpSoLuongTong(String a, String b) {
//        try {
//            Connection conn = DbConnect.getConnection();
//            String sql = "UPDATE SanPham SET SoLuongTong = ? where MaSP = " + "'" + a + "'";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, Integer.valueOf(b));
//            ps.executeUpdate();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public ArrayList<SanPham> getListCTSP() {
        listCTCP.clear();
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

    public ArrayList<SanPham> getListCTSPTheoMaSP(String a) {
        listCTCP.clear();
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT IdSP, CTSP.MaSP, NgayNhap, TenMauSac, TenSize, TenChatLieu, TenHang, SoLuong, GiaNhap, GiaBan FROM CTSP\n"
                    + "JOIN MauSac on MauSac.IdMauSac = CTSP.IdMauSac\n"
                    + "JOIN Size on Size.IdSize = CTSP.IdSize\n"
                    + "JOIN ChatLieu on ChatLieu.IdChatLieu = CTSP.IdChatLieu\n"
                    + "JOIN Hang on Hang.IdHang = CTSP.IdHang\n"
                    + "WHERE CTSP.MaSP = " + "'" + a + "'";

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
        listThuocTinh.clear();
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT TenMauSac FROM MauSac";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMauSac(rs.getString("TenMauSac"));
                listThuocTinh.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listThuocTinh;
    }

    public ArrayList<SanPham> getlistSize() {
        listThuocTinh.clear();
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT TenSize FROM Size";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setSize(rs.getString("TenSize"));
                listThuocTinh.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listThuocTinh;
    }

    public ArrayList<SanPham> getlistChatLieu() {
        listThuocTinh.clear();
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT TenChatLieu FROM ChatLieu";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setChatLieu(rs.getString("TenChatLieu"));
                listThuocTinh.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listThuocTinh;
    }

    public ArrayList<SanPham> getlistHang() {
        listSanPham.clear();
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT TenHang FROM Hang";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setHang(rs.getString("TenHang"));
                listThuocTinh.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listThuocTinh;
    }

    public void AddCTSP(SanPham sp) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "INSERT INTO CTSP (MaSP, NgayNhap, IdMauSac, IdSize, IdChatLieu, IdHang, SoLuong, GiaNhap, GiaBan)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, Integer.valueOf(sp.getIdspct()));
            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, sp.getNgayNhap());
            ps.setInt(3, Integer.valueOf(sp.getMauSac()));
            ps.setInt(4, Integer.valueOf(sp.getSize()));
            ps.setInt(5, Integer.valueOf(sp.getChatLieu()));
            ps.setInt(6, Integer.valueOf(sp.getHang()));
//            ps.setString(4, sp.getSize());
//            ps.setString(5, sp.getChatLieu());
//            ps.setString(6, sp.getHang());
            ps.setInt(7, Integer.valueOf(sp.getSoLuong()));
            ps.setFloat(8, Float.valueOf(sp.getGiaNhap()));
            ps.setFloat(9, Float.valueOf(sp.getGiaBan()));
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateSP(SanPham sp, String a, String slt) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "UPDATE SanPham SET MaSP = ?, TenSP = ?, SoLuongTong = ?, TrangThai = ? WHERE MaSP = " + "'" + a + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, sp.getTenSanPham());
            ps.setInt(3, Integer.valueOf(slt));
            ps.setInt(4, sp.getTrangThai().equals("Còn hàng") ? 1 : 0);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateCTSP(SanPham sp, int a) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "UPDATE CTSP SET MaSP = ?, NgayNhap = ?, IdMauSac = ?, IdSize = ?, IdChatLieu = ?, IdHang = ?,SoLuong = ?, GiaNhap = ?, GiaBan = ? WHERE IdSP = " + a;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, sp.getNgayNhap());
            ps.setInt(3, Integer.valueOf(sp.getMauSac()));
            ps.setInt(4, Integer.valueOf(sp.getSize()));
            ps.setInt(5, Integer.valueOf(sp.getChatLieu()));
            ps.setInt(6, Integer.valueOf(sp.getHang()));
            ps.setInt(7, Integer.valueOf(sp.getSoLuong()));
            ps.setFloat(8, Float.valueOf(sp.getGiaNhap()));
            ps.setFloat(9, Float.valueOf(sp.getGiaBan()));
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dltSP(String a) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "DELETE FROM CTSP \n"
                    + "WHERE MaSP = ?\n"
                    + "DELETE FROM SanPham \n"
                    + "WHERE MaSP = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a);
            ps.setString(2, a);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dltCTSP(String a) {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "DELETE FROM CTSP \n"
                    + "WHERE MaSP = ?\n";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
