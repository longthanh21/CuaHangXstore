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
            String sql = " SELECT * FROM CTSP\n"
                    + "                JOIN MauSac on MauSac.IdMauSac = CTSP.IdMauSac\n"
                    + "                JOIN Size on Size.IdSize = CTSP.IdSize\n"
                    + "                JOIN ChatLieu on ChatLieu.IdChatLieu = CTSP.IdChatLieu\n"
                    + "                JOIN Hang on Hang.IdHang = CTSP.IdHang\n"
                    + "				join SanPham on SanPham.MaSP=CTSP.MaSP";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham bh = new SanPham();
                bh.setIdspct(rs.getString("idsp"));
                bh.setMaSanPham(rs.getString("MaSP"));
                bh.setTenSanPham(rs.getString("TenSP"));
                bh.setMauSac(rs.getString("TenMauSac"));
                bh.setSize(rs.getString("TenSize"));
                bh.setChatLieu(rs.getString("TenChatLieu"));
                bh.setHang(rs.getString("TenHang"));
                bh.setSoLuong(rs.getString("SoLuong"));
                bh.setGiaBan(rs.getString("GiaBan"));
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
                    + "where a.MaHD='" + mhd + "'";
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

    public void suaSanPham(String sl, String id) {
        String sql = "UPDATE CTSP\n"
                + "SET SoLuong = ?\n"
                + " FROM CTSP\n"
                + " JOIN SanPham ON SanPham.MaSP = CTSP.MaSP\n"
                + "WHERE IdSP=?";
        try {
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sl);
            ps.setString(2, id);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void suaGioHang(int sl, String id) {
        String sql = "UPDATE CTHD\n"
                + "SET SoLuong = ?\n"
                + " FROM CTHD\n"
                + " JOIN HoaDon ON HoaDon.MaHd = CTHD.MaHD\n"
                + "WHERE IdSP=?";
        try {
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sl);
            ps.setString(2, id);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void themGioHang(HoaDon h) {
        try {
            String sql = "insert into cthd values(?,?,?,?)";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, h.getMaHD());
            ps.setString(2, h.getIdSP());
            ps.setString(3, h.getSoLuong());
            ps.setString(4, h.getGiaBan());

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
