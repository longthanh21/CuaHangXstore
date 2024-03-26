/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVien;
import Repository.DbConnect;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author KhanhCT
 */
public class QuanLyNhanVien {
    ArrayList<NhanVien> list = new ArrayList<>();
    
    public ArrayList<NhanVien> getAllNhanVien(){
        list.clear();
        try {
            String sql = "select MaNV, TenNV, NgaySinh, GioiTinh, DiaChi, Sdt, VaiTro, MaCL, TrangThai from NhanVien";
            Connection con = DbConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String Ma = rs.getString(1);
                String Ten = rs.getString(2);
                String NgaySinh = rs.getString(3);
                Boolean GioiTinh = rs.getBoolean(4);
                String DiaChi = rs.getString(5);
                String Sdt = rs.getString(6);
                Boolean VaiTro = rs.getBoolean(7);
                String MaCL = rs.getString(8);
                Boolean TrangThai = rs.getBoolean(9);
                list.add(new NhanVien(Ma, Ten, NgaySinh, GioiTinh, DiaChi, Sdt, VaiTro, MaCL, MaCL, TrangThai));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
