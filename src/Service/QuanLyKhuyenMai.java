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
            String sql = "SELECT * FROM Voucher";
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
                vc.setTrangThai(rs.getString("TrangThai"));
                listvc.add(vc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listvc;
    }

    public void themVoucher(Voucher vc) {
        try {
            String sql = "INSERT INTO Voucher" + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, vc.getMaVC());
            ps.setString(2, vc.getTenVC());
            ps.setString(3, vc.getGiamGia());
            ps.setString(4, vc.getNgayBatDau());
            ps.setString(5, vc.getNgayKetThuc());
            ps.setString(6, vc.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
