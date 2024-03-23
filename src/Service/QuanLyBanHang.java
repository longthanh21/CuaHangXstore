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
            String sql = "select * from SanPham a join ctsp b on a.MaSP=b.MaSP";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham bh = new SanPham();
                bh.setIdspct(rs.getString("idsp"));
                bh.setMaSanPham(rs.getString("MaSP"));
                bh.setTenSanPham(rs.getString("TenSP"));
                bh.setIdMauSac(rs.getString("IdMauSac"));
                bh.setIdSize(rs.getString("IdSize"));
                bh.setIdChatLieu(rs.getString("IdChatLieu"));
                bh.setIdHang(rs.getString("IdHang"));
                bh.setSoLuong(rs.getString("SoLuong"));

                listSanPham.add(bh);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public void themHoaDon(HoaDon h) {
        try {
            String sql = "insert into HoaDon values(?,?,?,?,?,?,?)";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, h.getMaHD());
            ps.setString(2, h.getNgayTao());
            //ps.setString(3,);
            ps.setString(4, h.getMaNV());
            //  ps.setString(5,);
            ps.setString(6, h.getTrangThai());

        } catch (Exception e) {
        } finally {
        }

    }
}
