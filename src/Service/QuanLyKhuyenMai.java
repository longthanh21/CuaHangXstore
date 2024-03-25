/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

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
        ArrayList<Voucher> listvc = new ArrayList<>();
        try {
            String sql = "SELECT Voucher.MaVC, TenVC, GiamGia, NgayBatDau, NgayKetThuc,MaKH , TrangThai\n"
                    + "FROM Voucher\n"
                    + "LEFT JOIN UuDai ON Voucher.MaVC = UuDai.MaVC";
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
                String maKH = rs.getString("MaKH");
                if (maKH == null || maKH.isEmpty()) {
                    vc.setUuDai("Không có");
                } else {
                    vc.setUuDai("Khách VIP");
                }
                vc.setTrangThai(rs.getString("TrangThai"));
                listvc.add(vc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listvc;
    }
//    String khachVip;
//    public String khachVIP(String ma){
//        try {
//            String sql = "SELECT KhachVip From UuDai WHERE MaVC = ?";
//            PreparedStatement ps = cn.prepareStatement(sql);
//            ps.setString(1, ma);
//            ps.execute();
//            ResultSet rs = ps.getResultSet();
//            while(rs.next()){
//                
//            }
//        } catch (Exception e) {
//        }
//    }

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

}
