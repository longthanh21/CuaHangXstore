/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDon;
import Model.SanPham;
import Repository.DbConnect;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author KhanhCT
 */
public class QuanLyBanHang {

    ArrayList<HoaDon> listHoaDon = new ArrayList<>();
    ArrayList<SanPham> listSanPham = new ArrayList<>();
    // ArrayList<BanHang> listGioHang = new ArrayList<>();

    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon.clear();

        try {
            String sql = "select * from HoaDon";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon bh = new HoaDon();
                bh.setMaHD(rs.getString("MaHD"));
                bh.setNgayTao(rs.getString("NgayTao"));
                bh.setMaNV(rs.getString("MaNV"));
                bh.setTrangThai(rs.getString("TrangThai"));
                listHoaDon.add(bh);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<SanPham> getListSanPham() {
        listSanPham.clear();

        try {
            String sql = "select * from SanPham";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaHD"));
                sp.setTenSanPham(rs.getString("NgayTao"));
                sp.setIdMauSac(rs.getInt("MaNV"));
                sp.setIdSize(rs.getInt("TrangThai"));
                sp.setIdChatLieu(rs.getInt("TrangThai"));

                sp.setIdHang(rs.getInt("TrangThai"));
                sp.setGiaBan(rs.getInt("TrangThai"));

                listSanPham.add(sp);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
}
