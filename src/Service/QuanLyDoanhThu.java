/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.DbConnect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LongThank
 */
public class QuanLyDoanhThu {

    int i = 0;

    public Integer HDToday() {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT COUNT(MaHD) AS SoHoaDon FROM HoaDon WHERE CONVERT(date, NgayTao) = CONVERT(date, GETDATE()) AND TrangThai LIKE N'Đã thanh toán'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                i = Integer.valueOf(rs.getString("SoHoaDon")) == null ? 0 : Integer.valueOf(rs.getString("SoHoaDon"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    float j = 0;

    public Float DoanhThuToday() {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT sum(TongTien) AS TongTien FROM HoaDon WHERE CONVERT(date, NgayTao) = CONVERT(date, GETDATE()) AND TrangThai LIKE N'Đã thanh toán'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String a = rs.getString("TongTien");
                if (a == null && a.isEmpty()) {
                    j = 0;
                } else {
                    j = Float.valueOf(a);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return j;
    }
    float k = 0;

    public Float loiNhuan() {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT (sum(TongTien) - (SELECT sum(GiaNhap*CTHD.SoLuong) FROM CTHD JOIN CTSP ON CTSP.IdSP = CTHD.IdSP)) AS LoiNhuan FROM HoaDon";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String a = rs.getString("LoiNhuan");
                if (a == null && a.isEmpty()) {
                    k = 0;
                } else {
                    k = Float.valueOf(a);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }
    float h = 0;

    public Float laiToDay() {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT (sum(TongTien) - (SELECT sum(GiaNhap*CTHD.SoLuong) FROM CTHD JOIN CTSP ON CTSP.IdSP = CTHD.IdSP JOIN HoaDon ON HoaDon.MaHD = CTHD.MaHD \n"
                    + "						WHERE CONVERT(date, NgayTao) = CONVERT(date, GETDATE()) AND TrangThai LIKE N'Đã thanh toán'\n"
                    + "						)) AS Lai FROM HoaDon\n"
                    + "WHERE CONVERT(date, NgayTao) = CONVERT(date, GETDATE()) AND TrangThai LIKE N'Đã thanh toán'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String a = rs.getString("Lai");
                if (a == null && a.isEmpty()) {
                    h = 0;
                } else {
                    h = Float.valueOf(a);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return h;
    }
    float T = 0;

    public Float TongDoanhThu() {
        try {
            Connection conn = DbConnect.getConnection();
            String sql = "SELECT sum(TongTien) AS TongDoanhThu FROM HoaDon WHERE TrangThai LIKE N'Đã thanh toán'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String a = rs.getString("TongDoanhThu");
                if (a == null && a.isEmpty()) {
                    T = 0;
                } else {
                    T = Float.valueOf(a);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return T;
    }
}
