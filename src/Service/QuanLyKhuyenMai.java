/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Coupon;
import Model.KhachHang;
import Model.SanPham;
import Model.Voucher;
import Repository.DbConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KhanhCT
 */
public class QuanLyKhuyenMai {

    private Connection cn;

    public QuanLyKhuyenMai() {
        try {
            cn = DbConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Voucher> getAllVC() {
        List<Voucher> listvc = new ArrayList<>();
        try {
            String sql = "SELECT Voucher.MaVC, TenVC, GiamGia, NgayBatDau, NgayKetThuc, DieuKien,KhachHang.MaKH,KhachHang.TrangThai, Voucher.TrangThai FROM Voucher\n"
                    + "left join UuDai on UuDai.MaVC = Voucher.MaVC\n"
                    + "right join KhachHang on KhachHang.MaKH = UuDai.MaKH\n"
                    + "group by Voucher.MaVC, TenVC, GiamGia, NgayBatDau, NgayKetThuc, DieuKien, KhachHang.MaKH,KhachHang.TrangThai, Voucher.TrangThai";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Voucher vc = new Voucher();
                vc.setMaVC(rs.getString("MaVC"));
                vc.setTenVC(rs.getString("TenVC"));
                vc.setGiamGia(rs.getString("GiamGia"));
                vc.setNgayBatDau(rs.getString("NgayBatDau"));
                vc.setNgayKetThuc(rs.getString("NgayKetThuc"));
//                String makh = rs.getString("KhachHang.MaKH");
//                String ttKH = rs.getString("KhachHang.TrangThai");
                vc.setDieuKien(rs.getString("DieuKien"));
                vc.setTrangThai(rs.getString("TrangThai"));
                listvc.add(vc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listvc;
    }

    public void getKhachVIP(String maVC) {
        try {
            String sql = "EXEC InsertUuDai ?, 'Khách VIP'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, maVC);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void themVoucher(Voucher vc) {
        try {
            String sql = "INSERT INTO Voucher(MaVC, TenVC, GiamGia, NgayBatDau, NgayKetThuc, TrangThai)" + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, vc.getMaVC());
            ps.setString(2, vc.getTenVC());
            ps.setString(3, vc.getGiamGia());
            ps.setString(4, vc.getNgayBatDau());
            ps.setString(5, vc.getNgayKetThuc());
            ps.setInt(6, vc.getTrangThai().equals("Hoạt động") ? 1 : 0);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void suaVoucher(Voucher vc) {
        try {
            String sql = "UPDATE Voucher SET TenVC = ?, GiamGia = ?, NgayBatDau = ?, NgayKetThuc = ?, TrangThai = ? WHERE MaVC = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, vc.getTenVC());
            ps.setString(2, vc.getGiamGia());
            ps.setDate(3, java.sql.Date.valueOf(vc.getNgayBatDau()));
            ps.setDate(4, java.sql.Date.valueOf(vc.getNgayKetThuc()));
            ps.setInt(5, vc.getTrangThai().equals("Hoạt động") ? 1 : 0);
            ps.setString(6, vc.getMaVC());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//===============================Coupon===================

    public List<Coupon> getAllCP() {
        List<Coupon> listcp = new ArrayList<>();
        try {
            String sql = "Select Coupon.MaCP, TenCP,GiamGiaSP.IdSP , Coupon.PhamTram, NgayBatDau, NgayKetThuc, TrangThai FROM Coupon\n"
                    + "LEFT JOIN GiamGiaSP ON GiamGiaSP.MaCP = Coupon.MaCP";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Coupon cp = new Coupon();
                cp.setMaCP(rs.getString("MaCP"));
                cp.setTenCP(rs.getString("TenCP"));
                cp.setIdSP(rs.getString("IdSP"));
                cp.setPhanTram(rs.getString("PhamTram"));
                cp.setNgayBatDau(rs.getString("NgayBatDau"));
                cp.setNgayKetThuc(rs.getString("NgayKetThuc"));
                cp.setTrangThai(rs.getString("TrangThai"));
                listcp.add(cp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listcp;
    }

    public List<SanPham> getAllSP() {
        List<SanPham> listsp = new ArrayList<>();
        try {
            String sql = "Select  CTSP.IdSP, SanPham.MaSP,SanPham.TenSP, SanPham.SoLuongTong,CTSP.GiaBan FROM SanPham\n"
                    + "LEFT JOIN CTSP ON CTSP.MaSP = SanPham.MaSP";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdspct(rs.getString("IdSP"));
                sp.setMaSanPham(rs.getString("MaSP"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setSoLuong(rs.getString("SoLuongTong"));
                sp.setGiaBan(rs.getString("GiaBan"));
                listsp.add(sp);
            }
        } catch (Exception e) {
        }
        return listsp;
    }
}
