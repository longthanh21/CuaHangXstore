/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.DbConnect;
import java.sql.*;

/**
 *
 * @author TienBB
 */
public class DangNhapService {

    private Connection cn;

    public DangNhapService() {
        try {
            cn = DbConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
        try {
            String query = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            return rs.next();// trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
