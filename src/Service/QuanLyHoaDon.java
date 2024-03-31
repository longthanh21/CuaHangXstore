/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDon;
import Repository.DbConnect;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author KhanhCT
 */
public class QuanLyHoaDon {

    ArrayList<HoaDon> listHD = new ArrayList<>();
    ArrayList<HoaDon> listHDCT = new ArrayList<>();

    public ArrayList<HoaDon> loadSeachMaHoaDon(String maHD) {
        listHD.clear();
        try {
            String sql = "SELECT MaHD,MaNV,MaKH,MaVC,NgayTao,TongTien,TrangThai FROM HoaDon WHERE MaHD =? ";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaHD = rs.getString(1);
                String MaNV = rs.getString(2);
                String MaKH = rs.getString(3);
                String MaVC = rs.getString(4);
                String NgayTao = rs.getString(5);
                String TongTien = rs.getString(6);
                String TrangThai = rs.getString(7);
                listHD.add(new HoaDon(MaHD, NgayTao, MaKH, MaNV, MaVC, TongTien, TrangThai, null, null, null, null, null, null));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }
    public ArrayList<HoaDon> loadSeachNgayBD(String NgayTaoo) {
        listHD.clear();
        try {
                String sql = "SELECT MaHD,MaNV,MaKH,MaVC,NgayTao,TongTien,TrangThai FROM HoaDon WHERE NgayTao >= ? ";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, NgayTaoo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaHD = rs.getString(1);
                String MaNV = rs.getString(2);
                String MaKH = rs.getString(3);
                String MaVC = rs.getString(4);
                String NgayTao = rs.getString(5);
                String TongTien = rs.getString(6);
                String TrangThai = rs.getString(7);
                listHD.add(new HoaDon(MaHD, NgayTao, MaKH, MaNV, MaVC, TongTien, TrangThai, null, null, null, null, null, null));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public ArrayList<HoaDon> loadSeachMaNhanVien(String maNV) {
        listHD.clear();
        try {
            String sql = "SELECT MaHD,MaNV,MaKH,MaVC,NgayTao,TongTien,TrangThai FROM HoaDon WHERE MaNV =? ";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaHD = rs.getString(1);
                String MaNV = rs.getString(2);
                String MaKH = rs.getString(3);
                String MaVC = rs.getString(4);
                String NgayTao = rs.getString(5);
                String TongTien = rs.getString(6);
                String TrangThai = rs.getString(7);
                listHD.add(new HoaDon(MaHD, NgayTao, MaKH, MaNV, MaVC, TongTien, TrangThai, null, null, null, null, null, null));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public ArrayList<HoaDon> loadSeachDaThanhToan() {
        listHD.clear();
        try {
            String sql = "SELECT MaHD,MaNV,MaKH,MaVC,NgayTao,TongTien,TrangThai FROM HoaDon WHERE TrangThai = N'Đã Thành Toán' ";
            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String MaHD = rs.getString(1);
                String MaNV = rs.getString(2);
                String MaKH = rs.getString(3);
                String MaVC = rs.getString(4);
                String NgayTao = rs.getString(5);
                String TongTien = rs.getString(6);
                String TrangThai = rs.getString(7);
                listHD.add(new HoaDon(MaHD, NgayTao, MaKH, MaNV, MaVC, TongTien, TrangThai, null, null, null, null, null, null));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public ArrayList<HoaDon> loadSeachDaHuy() {
        listHD.clear();
        try {
            String sql = "SELECT MaHD,MaNV,MaKH,MaVC,NgayTao,TongTien,TrangThai FROM HoaDon WHERE TrangThai = N'Đã hủy' ";
            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String MaHD = rs.getString(1);
                String MaNV = rs.getString(2);
                String MaKH = rs.getString(3);
                String MaVC = rs.getString(4);
                String NgayTao = rs.getString(5);
                String TongTien = rs.getString(6);
                String TrangThai = rs.getString(7);
                listHD.add(new HoaDon(MaHD, NgayTao, MaKH, MaNV, MaVC, TongTien, TrangThai, null, null, null, null, null, null));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public ArrayList<HoaDon> loadSeachChoThanhToan() {
        listHD.clear();
        try {
            String sql = "SELECT MaHD,MaNV,MaKH,MaVC,NgayTao,TongTien,TrangThai FROM HoaDon WHERE TrangThai = N'Chờ thanh toán' ";
            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String MaHD = rs.getString(1);
                String MaNV = rs.getString(2);
                String MaKH = rs.getString(3);
                String MaVC = rs.getString(4);
                String NgayTao = rs.getString(5);
                String TongTien = rs.getString(6);
                String TrangThai = rs.getString(7);
                listHD.add(new HoaDon(MaHD, NgayTao, MaKH, MaNV, MaVC, TongTien, TrangThai, null, null, null, null, null, null));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public ArrayList<HoaDon> loadMaHoaDon() {
        listHD.clear();
        try {
            String sql = "SELECT MaHD,MaNV,MaKH,MaVC,NgayTao,TongTien,TrangThai FROM HoaDon ";
            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String MaHD = rs.getString(1);
                String MaNV = rs.getString(2);
                String MaKH = rs.getString(3);
                String MaVC = rs.getString(4);
                String NgayTao = rs.getString(5);
                String TongTien = rs.getString(6);
                String TrangThai = rs.getString(7);
                listHD.add(new HoaDon(MaHD, NgayTao, MaKH, MaNV, MaVC, TongTien, TrangThai, null, null, null, null, null, null));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public ArrayList<HoaDon> loadHoaDonChiTiet() {
        listHDCT.clear();
        listHD.clear();
        try {
            String sql = " select a.MaHD,d.MaSP,TenSP,a.SoLuong,a.GiaBan,PhamTram,TongTien from CTHD a\n"
                    + "        join HoaDon b on a.MaHD=b.MaHD \n"
                    + "        join CTSP c on c.IdSP=a.IdSP\n"
                    + "        join SanPham d on d.MaSP=c.MaSP\n"
                    + "	left join GiamGiaSP e on a.idsp=e.idsp\n"
                    + "	left join  Coupon f on f.macp=e.macp\n";

            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon bh = new HoaDon();
                bh.setMaHD(rs.getString("MaHD"));
                bh.setMaSP(rs.getString("MaSP"));
                bh.setTenSP(rs.getString("TenSp"));
                bh.setSoLuong(rs.getString("SoLuong"));
                bh.setGiaBan(rs.getString("GiaBan"));
                String phamTram = rs.getString("PhamTram");
                bh.setTongTien(rs.getString("TongTien"));
                if (phamTram == null || phamTram.isEmpty()) {
                    bh.setPhanTram("0");
                } else {
                    bh.setPhanTram(phamTram);
                }
                listHDCT.add(bh);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    public ArrayList<HoaDon> loadMaHDSeachHDCT(String mhd) {
        listHDCT.clear();
        listHD.clear();
        try {
            String sql = " select a.MaHD,d.MaSP,TenSP,a.SoLuong,a.GiaBan,PhamTram, TongTien from CTHD a\n"
                    + "        join HoaDon b on a.MaHD=b.MaHD \n"
                    + "        join CTSP c on c.IdSP=a.IdSP\n"
                    + "        join SanPham d on d.MaSP=c.MaSP\n"
                    + "	left join GiamGiaSP e on a.idsp=e.idsp\n"
                    + "	left join  Coupon f on f.macp=e.macp\n"
                    + "where a.MaHD='" + mhd + "'";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon bh = new HoaDon();
                bh.setMaHD(rs.getString("MaHD"));
                bh.setMaSP(rs.getString("MaSP"));
                bh.setTenSP(rs.getString("TenSp"));
                bh.setSoLuong(rs.getString("SoLuong"));
                bh.setGiaBan(rs.getString("GiaBan"));
                String phamTram = rs.getString("PhamTram");
                bh.setTongTien(rs.getString("TongTien"));
                if (phamTram == null || phamTram.isEmpty()) {
                    bh.setPhanTram("0");
                } else {
                    bh.setPhanTram(phamTram);
                }
                listHD.add(bh);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }
    public ArrayList<HoaDon> loadMaSPSeachHDCT(String maSP) {
        listHDCT.clear();
        listHD.clear();
        try {
            String sql = " select a.MaHD,d.MaSP,TenSP,a.SoLuong,a.GiaBan,PhamTram, TongTien from CTHD a\n"
                    + "        join HoaDon b on a.MaHD=b.MaHD \n"
                    + "        join CTSP c on c.IdSP=a.IdSP\n"
                    + "        join SanPham d on d.MaSP=c.MaSP\n"
                    + "	left join GiamGiaSP e on a.idsp=e.idsp\n"
                    + "	left join  Coupon f on f.macp=e.macp\n"
                    + "where d.MaSP='" + maSP + "'";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon bh = new HoaDon();
                bh.setMaHD(rs.getString("MaHD"));
                bh.setMaSP(rs.getString("MaSP"));
                bh.setTenSP(rs.getString("TenSp"));
                bh.setSoLuong(rs.getString("SoLuong"));
                bh.setGiaBan(rs.getString("GiaBan"));
                String phamTram = rs.getString("PhamTram");
                bh.setTongTien(rs.getString("TongTien"));
                if (phamTram == null || phamTram.isEmpty()) {
                    bh.setPhanTram("0");
                } else {
                    bh.setPhanTram(phamTram);
                }
                listHD.add(bh);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }
}
