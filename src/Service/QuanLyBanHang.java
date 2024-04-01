/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDon;
import Model.SanPham;
import Model.Voucher;
import Model.KhachHang;
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
            String sql = "select * from HoaDon  order by CAST(SUBSTRING(MaHD, 3, LEN(MaHD)) AS INT) asc";
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
            String sql = "SELECT CTSP.idsp,ctsp.MaSP,TenSP,TenMauSac,TenSize,TenChatLieu,TenHang,SoLuong,Gia.GiaBan,PhamTram,coupon.TrangThai FROM CTSP \n"
                    + "     JOIN MauSac  on MauSac.IdMauSac = CTSP.IdMauSac\n"
                    + "     JOIN Size  on Size.IdSize = CTSP.IdSize\n"
                    + "     JOIN ChatLieu  on ChatLieu.IdChatLieu = CTSP.IdChatLieu\n"
                    + "     JOIN Hang  on  Hang.IdHang = CTSP.IdHang\n"
                    + "     join SanPham  on SanPham.MaSP=CTSP.MaSP\n"
                    + "     JOIN (\n"
                    + "		SELECT g.IdSP, g.GiaBan, g.NgayBatDau FROM Gia AS g WHERE g.NgayBatDau <= GETDATE() AND g.IdSP IN (\n"
                    + "			SELECT g2.IdSP FROM Gia AS g2 WHERE g2.NgayBatDau <= GETDATE() GROUP BY g2.IdSP HAVING MAX(g2.NgayBatDau) = g.NgayBatDau)\n"
                    + ") AS Gia ON Gia.IdSP = CTSP.IdSP\n"
                    + "	left join GiamGiaSP  on CTSP.idsp=GiamGiaSP.idsp\n"
                    + "	left join  Coupon  on Coupon.macp=GiamGiaSP.macp\n"
                    + "ORDER BY CTSP.IdSP asc";
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
                String phamTram = rs.getString("PhamTram");
                if (phamTram == null || phamTram.isEmpty()) {
                    bh.setPhanTram("0");
                } else {
                    bh.setPhanTram(phamTram);
                }

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
            String sql = " select c.IdSP,d.MaSP,TenSP,a.SoLuong,a.GiaBan,PhamTram from CTHD a\n"
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
                bh.setIdSP(rs.getString("idsp"));

                bh.setMaSP(rs.getString("MaSP"));
                bh.setTenSP(rs.getString("TenSp"));
                bh.setSoLuong(rs.getString("SoLuong"));
                bh.setGiaBan(rs.getString("GiaBan"));
                String phamTram = rs.getString("PhamTram");
                if (phamTram == null || phamTram.isEmpty()) {
                    bh.setPhanTram("0");
                } else {
                    bh.setPhanTram(phamTram);
                }
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

    public void suaGioHang(String sl, String id, String mhd) {
        String sql = "UPDATE CTHD\n"
                + "SET SoLuong = ?\n"
                + " FROM CTHD\n"
                + " JOIN HoaDon ON HoaDon.MaHd = CTHD.MaHD\n"
                + "WHERE IdSP=? and HoaDon.MaHD=?";
        try {
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sl);
            ps.setString(2, id);
            ps.setString(3, mhd);

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

    public void xoaGioHang(String idsp, String maHD) {
        String sql = "delete CTHD where IdSP=? and MaHD=?";
        try {
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idsp);
            ps.setString(2, maHD);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Boolean huyHoaDon(String mhd) {
        try {
            String sql = "update HoaDon set Trangthai=N'Đã hủy' where mahd='" + mhd + "'";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Boolean ThanhToan(HoaDon h) {
        try {
            String sql = "update HoaDon set Trangthai=N'Đã thanh toán' "
                    + ", makh=?,mavc=?,tongtien=? where mahd=?";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, h.getMaKH());
            ps.setString(2, h.getMaVC());
            ps.setString(3, h.getTongTien());
            ps.setString(4, h.getMaHD());

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Voucher> getListV() {
        ArrayList<Voucher> listV = new ArrayList<Voucher>();

        try {
            String sql = "SELECT a.MaKH, a.TrangThai, c.MaVC, TenVC, GiamGia,DieuKien \n"
                    + "FROM KhachHang a\n"
                    + "JOIN UuDai b ON a.MaKH = b.MaKH\n"
                    + "RIGHT JOIN Voucher c ON b.MaVC = c.MaVC\n"
                    + "WHERE c.TrangThai = 1 AND a.MaKH IS NULL;";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Voucher v = new Voucher();
                v.setMaVC(rs.getString("mavc"));
                v.setTenVC(rs.getString("TenVC"));
                v.setGiamGia(rs.getString("GiamGia"));
                v.setDieuKien(rs.getString("DieuKien"));
                listV.add(v);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listV;
    }

    public ArrayList<Voucher> getListVV(String mkh) {
        ArrayList<Voucher> listVV = new ArrayList<Voucher>();

        try {
            String sql = "SELECT a.MaKH, a.TrangThai, c.MaVC, TenVC, GiamGia,DieuKien \n"
                    + "FROM KhachHang a\n"
                    + "JOIN UuDai b ON a.MaKH = b.MaKH\n"
                    + "RIGHT JOIN Voucher c ON b.MaVC = c.MaVC\n"
                    + "WHERE c.TrangThai = 1 AND a.MaKH ='" + mkh + "'";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Voucher v = new Voucher();
                v.setMaVC(rs.getString("mavc"));
                v.setTenVC(rs.getString("TenVC"));
                v.setGiamGia(rs.getString("GiamGia"));
                v.setDieuKien(rs.getString("DieuKien"));
                listVV.add(v);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listVV;
    }

    public ArrayList<KhachHang> getKhachHang() {
        ArrayList<KhachHang> listK = new ArrayList<KhachHang>();

        try {
            String sql = "select * from khachhang";
            Connection con = DbConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang k = new KhachHang();
                k.setMaKH(rs.getString("makh"));
                if (rs.getString("trangthai").equals("1")) {
                    k.setTrangThai(true);
                } else {
                    k.setTrangThai(false);
                }

                listK.add(k);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listK;
    }

}
