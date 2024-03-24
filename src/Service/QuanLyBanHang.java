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
    ArrayList<HoaDon> listGioHang = new ArrayList<>();

    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon.clear();

        try {
            String sql = "select * from HoaDon where TrangThai=N'chờ thanh toán' order by CAST(SUBSTRING(MaHD, 3, LEN(MaHD)) AS INT) asc";
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
                bh.setMauSac(rs.getString("IdMauSac"));
                bh.setSize(rs.getString("IdSize"));
                bh.setChatLieu(rs.getString("IdChatLieu"));
                bh.setHang(rs.getString("IdHang"));
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
            ps.setString(3, null);
            ps.setString(4, h.getMaNV());
            ps.setString(5, null);
            ps.setString(6, null);
            ps.setString(7, h.getTrangThai());

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

    public ArrayList<HoaDon> getListGioHang(String mhd) {
        listGioHang.clear();
        try {
            String sql = "select * from CTHD a\n"
                    + "join HoaDon b on a.MaHD=b.MaHD \n"
                    + "join CTSP c on c.IdSP=a.IdSP\n"
                    + "join SanPham d on d.MaSP=c.MaSP\n"
                    + "where a.MaHD='" + mhd + "'" ;
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon bh = new HoaDon();
                bh.setMaSP(rs.getString("MaSP"));
                bh.setTenSP(rs.getString("TenSp"));
                bh.setSoLuong(rs.getString("SoLuong"));
                bh.setGiaBan(rs.getString("GiaBan"));

                listGioHang.add(bh);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGioHang;
    }

}
