/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;
import Repository.DbConnect;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author KhanhCT
 */
public class QuanLyKhachHang {

    ArrayList<KhachHang> list = new ArrayList<>();
    ArrayList<KhachHang> listKhachVip = new ArrayList<>();

    public ArrayList<KhachHang> getAllKhachHang() {
        list.clear();
        try {
            String sql = "select MaKH,TenKH,Sdt,gioiTinh,TrangThai,DiaChi from KhachHang";
            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String sdt = rs.getString(3);
                Boolean gioiTinh = rs.getBoolean(4);
                Boolean trangThai = rs.getBoolean(5);
                String diaChi = rs.getString(6);
                list.add(new KhachHang(ma, ten, sdt, gioiTinh, trangThai, diaChi));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<KhachHang> getAllKhachVip() {
        listKhachVip.clear();
        try {
            String sql = "select MaKH,TenKH,Sdt,gioiTinh,TrangThai,DiaChi from KhachHang where TrangThai= 1";

            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
//                KhachHang kh = new KhachHang();
//                kh.setMaKH(rs.getString("MaKH"));
//                kh.setTenKH(rs.getString("TenKH"));
//                kh.setSĐT(rs.getString("Sdt"));
//                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
//                kh.setTrangThai(rs.getBoolean("TrangThai"));
//                kh.setDiaChi(rs.getString("DiaChi"));
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String sdt = rs.getString(3);
                Boolean gioiTinh = rs.getBoolean(4);
                Boolean trangThai = rs.getBoolean(5);
                String diaChi = rs.getString(6);

                listKhachVip.add(new KhachHang(ma, ten, sdt, gioiTinh, trangThai, diaChi));
//                listKhachVip.add(kh);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachVip;
    }

    public boolean ADDKhachHang(KhachHang khachHang) {
        try {
            String sql = "insert into KhachHang(MaKH,TenKH,Sdt,gioiTinh,TrangThai,DiaChi)\n"
                    + "values (?,?,?,?,?,?);";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, khachHang.getMaKH());
            ps.setString(2, khachHang.getTenKH());
            ps.setString(3, khachHang.getSĐT());
            ps.setBoolean(4, khachHang.isGioiTinh());
            ps.setBoolean(5, khachHang.isTrangThai());
            ps.setString(6, khachHang.getDiaChi());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteKhachHang(String maKh) {
        try {
            String sql = "delete from KhachHang where MaKH = '?'";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maKh);
            ps.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean upDate(KhachHang khachHang) {
        try {
            String sql = "update from KhachHang set TenKH='?' , Sdt='?' , gioiTinh= ? , TrangThai= ? , DiaChi='?'\n"
                    + "where MaKH = '?'";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, khachHang.getTenKH());
            ps.setString(2, khachHang.getSĐT());
            ps.setBoolean(3, khachHang.isGioiTinh());
            ps.setBoolean(4, khachHang.isTrangThai());
            ps.setString(5, khachHang.getDiaChi());
            ps.setString(6, khachHang.getMaKH());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
