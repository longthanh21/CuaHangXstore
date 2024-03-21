/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.BanHang;
import Repository.DbConnect;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author KhanhCT
 */
public class QuanLyBanHang {

    ArrayList<BanHang> listHoaDon = new ArrayList<>();
    ArrayList<BanHang> listSanPham = new ArrayList<>();
    ArrayList<BanHang> listGioHang = new ArrayList<>();

    ArrayList<BanHang> getListHoaDon() {
        try {
            Connection con = DbConnect.getConnection();
            String sql = "select * from HoaDon";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BanHang b = new BanHang();
                b.setMaHD(rs.getString("MaHD"));
                b.setNgay(rs.getString("NgayTao"));
                b.setMaNV(rs.getString("MaNV"));
                b.setTrang(rs.getString("TrangThai"));
                listHoaDon.add(b);
            }
            con.close();
        } catch (Exception e) {
        }
        return listHoaDon;
    }
}
