/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author TienBB
 */
public class DangKyService {

    private Connection cn;

    public DangKyService() {
        try {
            cn = DbConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean add(String tenDangNhap, String matKhau) {
        try {
            String sql = "INSERT INTO TaiKhoan (TenDangNhap,MatKhau)" + "VALUES(?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
