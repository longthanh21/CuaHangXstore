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
    
    public ArrayList<SanPham> getListSanPham(){
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
                sp.setTrangThai(rs.getString("TrangThai"));
                listSanPham.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSanPham;
    }
    
    int soLuongTong;
    public int SoLuongTong(){
        listCTCP.clear();
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT SoLuongTong FROM SanPham" ;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                soLuongTong = rs.getInt("SoLuongTong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soLuongTong;
    }
    
    public ArrayList<SanPham> getListCTSP(){
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT * FROM CTSP";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                SanPham sp = new SanPham();
                sp.setIdspct(rs.getString("IdSP"));
                sp.setMaSanPham(rs.getString("MaSP"));
                sp.setNgayNhap(rs.getString("NgayNhap"));
                sp.setIdMauSac(rs.getString("IdMauSac"));
                sp.setIdSize(rs.getString("IdSize"));
                sp.setIdChatLieu(rs.getString("IdChatLieu"));
                sp.setIdHang(rs.getString("IdHang"));
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
}
