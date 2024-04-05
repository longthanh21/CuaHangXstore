/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Coupon;
import Model.KhachHang;
import Model.SanPham;
import Model.Voucher;
import Service.QuanLyKhuyenMai;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TienBB
 */
public class ViewKhuyenMai extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    List<Voucher> listVC = new ArrayList<>();
    QuanLyKhuyenMai qlKM = new QuanLyKhuyenMai();

    private Timer timer = new Timer();

    List<Coupon> listCP = new ArrayList<>();
    List<SanPham> listSP = new ArrayList<>();

    public ViewKhuyenMai() {
        initComponents();
        LoadDataTable();
        LoadDataCoupon();
        LoadDataSanPham();
        timer.scheduleAtFixedRate(new UpdateHetHan(), 0, 24 * 60 * 60 * 1000); // Kiểm tra mỗi 24 giờ
    }

    public void LoadDataTable() {
        dtm = (DefaultTableModel) tbVoucher.getModel();
        listVC = qlKM.getAllVC();
        dtm.setRowCount(0);
        for (Voucher e : listVC) {
            String trangThai = e.getTrangThai().equalsIgnoreCase("0") ? "Hết hạn" : "Hoạt động";
            dtm.addRow(new Object[]{
                e.getMaVC(),
                e.getTenVC(),
                e.getGiamGia(),
                e.getNgayBatDau(),
                e.getNgayKetThuc(),
                e.getDieuKien(),
                e.getUuDai(),
                trangThai
            });
        }
    }

    public void LoadDataTableTheoMa(String ma) {
        dtm = (DefaultTableModel) tbVoucher.getModel();
        listVC = qlKM.getAllVC();
        dtm.setRowCount(0);
        for (Voucher e : listVC) {
            String trangThai = e.getTrangThai().equalsIgnoreCase("0") ? "Hết hạn" : "Hoạt động";
            dtm.addRow(new Object[]{
                e.getMaVC(),
                e.getTenVC(),
                e.getGiamGia(),
                e.getNgayBatDau(),
                e.getNgayKetThuc(),
                e.getDieuKien(),
                e.getUuDai(),
                trangThai
            });
        }
    }

    public void detail() {
        int i = tbVoucher.getSelectedRow();
        txtMaVC.setText(String.valueOf(tbVoucher.getValueAt(i, 0)));
        txtTenVC.setText(String.valueOf(tbVoucher.getValueAt(i, 1)));
        txtGiamGiaVC.setText(String.valueOf(tbVoucher.getValueAt(i, 2)));
        String dateBatDau = String.valueOf(tbVoucher.getValueAt(i, 3));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = dateFormat.parse(dateBatDau);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dcBatDau.setDate(startDate);
        String dateKetThuc = String.valueOf(tbVoucher.getValueAt(i, 4)); // Chỉ số 4 nếu ngày kết thúc được lưu trong cột khác
        Date endDate = null;
        try {
            endDate = dateFormat.parse(dateKetThuc);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dcHetHan.setDate(endDate);
        txtDieuKien.setText(String.valueOf(tbVoucher.getValueAt(i, 5)));
        String ttKH = String.valueOf(tbVoucher.getValueAt(i, 6));
        if (ttKH.equalsIgnoreCase("Khách VIP")) {
            cbKhachVip.setSelected(true);
        } else {
            cbKhachVip.setSelected(false);
        }
        String tt = String.valueOf(tbVoucher.getValueAt(i, 7));
        if (tt.equalsIgnoreCase("Hoạt động")) {
            rbHoatDong.setSelected(true);
        } else if (tt.equalsIgnoreCase("Hết hạn")) {
            rbHetHan.setSelected(true);
        } else {
            //none
        }
    }

    public Voucher getFormVoucher() {
        Voucher vc = new Voucher();
        vc.setMaVC(txtMaVC.getText());
        vc.setTenVC(txtTenVC.getText());
        vc.setGiamGia(txtGiamGiaVC.getText());

        //Khỏi tạo simple dateFormat để ép kiểu từ table thành kiểu date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //Ngày bắt đầu
        Date ngayBatDau = dcBatDau.getDate();
        String strNgayBatDau = dateFormat.format(ngayBatDau);
        vc.setNgayBatDau(strNgayBatDau);
        //Ngày kết thúc
        Date ngayKetThuc = dcHetHan.getDate();
        String strNgayKetThuc = dateFormat.format(ngayKetThuc);
        vc.setNgayKetThuc(strNgayKetThuc);
        vc.setDieuKien(txtDieuKien.getText());
        if (rbHoatDong.isSelected()) {
            vc.setTrangThai("Hoạt động");
        } else {
            vc.setTrangThai("Hết hạn");
        }
        return vc;
    }

    public boolean checkVC() {
        String mavc = txtMaVC.getText().trim();
        String tenvc = txtTenVC.getText().trim();
        String giamGia = txtGiamGiaVC.getText().trim();
        Date batDau = dcBatDau.getDate();
        Date hetHan = dcHetHan.getDate();
        String dieukien = txtDieuKien.getText().trim();
        if (mavc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã voucher không được để trống");
            return false;
        }
        for (Voucher vc : listVC) {
            if (vc.getMaVC().equals(mavc)) {
                JOptionPane.showMessageDialog(this, "Mã voucher không được trùng nhau!");
                return false;
            }
        }
        if (tenvc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên voucher không được để trống");
            return false;
        }
        if (giamGia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giảm giá voucher không được để trống");
            return false;
        }
        try {
            double giaGiam = Double.parseDouble(giamGia);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giảm giá voucher phải là số");
            return false;
        }

        if (batDau == null) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được để trống");
            return false;
        }
        if (hetHan == null) {
            JOptionPane.showMessageDialog(this, "Ngày hết hạn không được để trống");
            return false;
        }
        if (dieukien.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điều kiện không được để trống");
            return false;
        }
        try {
            double dK = Double.parseDouble(dieukien);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điều kiện phải là số");
            return false;
        }
        if (hetHan.before(batDau)) {
            JOptionPane.showMessageDialog(this, "Ngày hết hạn không được để trước ngày bắt đầu");
            return false;
        }
        return true;
    }

    public boolean checkTonTaiMa(String maMoi) {
        for (Voucher vc : listVC) {
            if (!vc.getMaVC().equals(txtMaVC.getText().trim()) && vc.getMaVC().equals(maMoi)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUpdateVC() {
        String mavc = txtMaVC.getText().trim();
        String tenvc = txtTenVC.getText().trim();
        String giamGia = txtGiamGiaVC.getText().trim();
        Date batDau = dcBatDau.getDate();
        Date hetHan = dcHetHan.getDate();
        String dieukien = txtDieuKien.getText().trim();

        if (tenvc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên voucher không được để trống");
            return false;
        }

        if (giamGia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giảm giá voucher không được để trống");
            return false;
        }

        // Kiểm tra nếu giá trị giamGia không phải là số
        try {
            double giaGiam = Double.parseDouble(giamGia);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giảm giá voucher phải là một số");
            return false;
        }

        if (batDau == null) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được để trống");
            return false;
        }

        if (hetHan == null) {
            JOptionPane.showMessageDialog(this, "Ngày hết hạn không được để trống");
            return false;
        }

        if (dieukien.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điều kiện không được để trống");
            return false;
        }
        try {
            double dK = Double.parseDouble(dieukien);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điều kiện phải là số");
            return false;
        }

        if (hetHan.before(batDau)) {
            JOptionPane.showMessageDialog(this, "Ngày hết hạn không được để trước ngày bắt đầu");
            return false;
        }

        if (checkTonTaiMa(mavc)) {
            JOptionPane.showMessageDialog(this, "Mã voucher đã tồn tại");
            return false;
        }

        return true;
    }

    public void addVC() {
        if (checkVC()) {
            try {
                qlKM.themVoucher(getFormVoucher());
                String maVC = txtMaVC.getText();
                if (cbKhachVip.isSelected()) {
                    qlKM.addKhachVIP(maVC);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateVC() {
        if (checkUpdateVC()) {
            try {
                int i = tbVoucher.getSelectedRow();
                if (i != -1) { // Kiểm tra xem có hàng được chọn không
                    String maVC = txtMaVC.getText();
                    String trangThai = (String) tbVoucher.getValueAt(i, 6);
                    if (cbKhachVip.isSelected() && !trangThai.equals("Khách VIP")) {
                        qlKM.addKhachVIP(maVC);
                    } else if (cbKhachVip.isSelected() && trangThai.equals("Khách VIP")) {
                        System.out.println("Mã đã áp dụng cho khách VIP");
                    } else {
                        qlKM.dltKhachVIP(maVC);
                    }
                    qlKM.suaVoucher(getFormVoucher());
                    JOptionPane.showMessageDialog(this, "Sửa thành công Voucher!");
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn một Voucher!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    ===========================COUPON==========================================

    public void LoadDataCoupon() {
        dtm = (DefaultTableModel) tbCoupon.getModel();
        listCP = qlKM.getAllCP();
        dtm.setRowCount(0);
        for (Coupon e : listCP) {
            String tt = e.getTrangThai().equalsIgnoreCase("0") ? "Hết hạn" : "Hoạt động";
            dtm.addRow(new Object[]{
                e.getMaCP(),
                e.getTenCP(),
                e.getIdSP(),
                e.getPhanTram(),
                e.getNgayBatDau(),
                e.getNgayKetThuc(),
                tt
            });
        }
    }

    public void LoadDataCouponTheoMa(String ma) {
        dtm = (DefaultTableModel) tbCoupon.getModel();
        listCP = qlKM.getAllCP();
        dtm.setRowCount(0);
        for (Coupon e : listCP) {
            String tt = e.getTrangThai().equalsIgnoreCase("0") ? "Hết hạn" : "Hoạt động";
            dtm.addRow(new Object[]{
                e.getMaCP(),
                e.getTenCP(),
                e.getIdSP(),
                e.getPhanTram(),
                e.getNgayBatDau(),
                e.getNgayKetThuc(),
                tt
            });
        }
    }

    public void DetailCouPon() {
        int i = tbCoupon.getSelectedRow();
        txtMaCP.setText(String.valueOf(tbCoupon.getValueAt(i, 0)));
        txtTenCP.setText(String.valueOf(tbCoupon.getValueAt(i, 1)));

        try {
            String idSP = String.valueOf(tbCoupon.getValueAt(i, 2));
            if (!idSP.isEmpty() && !idSP.equals("null")) {
                int id = Integer.parseInt(idSP);
                List<SanPham> spList = qlKM.selectSPbyID(id);
                String maSP = "";
                String tenSP = "";
                String soLuong = "";
                String giaBan = "";

                for (SanPham sp : spList) {
                    maSP = sp.getMaSanPham();
                    tenSP = sp.getTenSanPham();
                    soLuong = sp.getSoLuong();
                    giaBan = sp.getGiaBan();
                }
                txtIDSanPham.setText(idSP);
                txtMaSP.setText(maSP);
                txtTenSP.setText(tenSP);
                txtSoLuong.setText(soLuong);
                txtGiaBan.setText(giaBan);
            } else {
                // Xử lý khi mà idSP trống
                txtIDSanPham.setText("");
                txtMaSP.setText("");
                txtTenSP.setText("");
                txtSoLuong.setText("");
                txtGiaBan.setText("");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid idSP format");
            e.printStackTrace();
        }

        txtGiamGiaCP.setText(String.valueOf(tbCoupon.getValueAt(i, 3)));

        //Khỏi tạo simple dateFormat để ép kiểu từ table thành kiểu date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // detail ngày bắt đầu
        String dateBatDau = String.valueOf(tbCoupon.getValueAt(i, 4));
        Date startDate = null;
        try {
            startDate = dateFormat.parse(dateBatDau);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dcNgayDatBau.setDate(startDate);
        // detail ngày kết thúc
        String dateKetThuc = String.valueOf(tbCoupon.getValueAt(i, 5));
        Date endDate = null;
        try {
            endDate = dateFormat.parse(dateKetThuc);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dcNgayKetThuc.setDate(endDate);

        String tt = String.valueOf(tbCoupon.getValueAt(i, 6));
        if (tt.equalsIgnoreCase("Hoạt động")) {
            rbCPHoatDong.setSelected(true);
        } else if (tt.equalsIgnoreCase("Hết hạn")) {
            rbCPHetHan.setSelected(true);
        } else {

        }
    }

    public boolean checkCP() {
        String macp = txtMaCP.getText().trim();
        String tencp = txtTenCP.getText().trim();
        String giamGiaStr = txtGiamGiaCP.getText().trim();
        // Kiểm tra xem ngày bắt đầu và ngày kết thúc có null không
        Date batDau = dcNgayDatBau.getDate();
        Date hetHan = dcNgayKetThuc.getDate();
        // Kiểm tra xem ngày bắt đầu và ngày kết thúc có null không
        if (macp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã coupon");
            return false;
        }
        for (Coupon cp : listCP) {
            if (cp.getMaCP().equals(macp)) {
                JOptionPane.showMessageDialog(this, "Không được trùng mã coupon");
                return false;
            }
        }
        if (tencp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên coupon");
            return false;
        }
        if (giamGiaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống giảm giá coupon");
            return false;
        }
        if (batDau == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày bắt đầu");
            return false;
        }
        if (hetHan == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày kết thúc");
            return false;
        }
        // Kiểm tra ngày kết thúc phải lớn hơn ngày bắt đầu
        if (hetHan.before(batDau)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày bắt đầu");
            return false;
        }

        return true;
    }

    public Coupon getFormCoupon() {
        Coupon cp = new Coupon();
        cp.setMaCP(txtMaCP.getText());
        cp.setTenCP(txtTenCP.getText());
        cp.setPhanTram(txtGiamGiaCP.getText());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date ngayBatDau = dcNgayDatBau.getDate();
        String strNgayBatDau = dateFormat.format(ngayBatDau);
        cp.setNgayBatDau(strNgayBatDau);

        Date ngayKetThuc = dcNgayKetThuc.getDate();
        String strNgayKetThuc = dateFormat.format(ngayKetThuc);
        cp.setNgayKetThuc(strNgayKetThuc);

        if (rbCPHoatDong.isSelected()) {
            cp.setTrangThai("Hoạt động");
        } else {
            cp.setTrangThai("Hết hạn");
        }
        return cp;
    }

    public void addCoupon() {
        qlKM.addCP(getFormCoupon());
    }

    public void apDungSanPhamToCoupon() {
        String ma = txtMaCP.getText();
        int id = Integer.valueOf(txtIDSanPham.getText());

        // Kiểm tra sản phẩm đã áp dụng coupon chưa
        if (qlKM.checkCouponAppliedToProduct(id)) {
            JOptionPane.showMessageDialog(this, "Sản phẩm đã áp dụng coupon!");
        } else {
            qlKM.addCoupontoSP(ma, id);
            JOptionPane.showMessageDialog(this, "Áp dụng thành công coupon!");
        }
    }

    public void huyCP() {
        int id = Integer.valueOf(txtIDSanPham.getText());
        qlKM.huyCoupon(id);
    }
//    ============================SANPHAM========================================

    public void LoadDataSanPham() {
        dtm = (DefaultTableModel) tbSanPham.getModel();
        listSP = qlKM.getAllSP();
        dtm.setRowCount(0);
        for (SanPham e : listSP) {
            dtm.addRow(new Object[]{
                e.getIdspct(),
                e.getMaSanPham(),
                e.getTenSanPham(),
                e.getSoLuong(),
                e.getGiaBan()
            });
        }
    }

    public void DetailSanPham() {
        int i = tbSanPham.getSelectedRow();
        txtIDSanPham.setText(String.valueOf(tbSanPham.getValueAt(i, 0)));
        txtMaSP.setText(String.valueOf(tbSanPham.getValueAt(i, 1)));
        txtTenSP.setText(String.valueOf(tbSanPham.getValueAt(i, 2)));
        txtSoLuong.setText(String.valueOf(tbSanPham.getValueAt(i, 3)));
        txtGiaBan.setText(String.valueOf(tbSanPham.getValueAt(i, 4)));
    }
//=====================Kiểm tra thời gian=================================

    private class UpdateHetHan extends TimerTask {

        @Override
        public void run() {
            TrangThaiThoiGianVoucher();
            TrangThaiThoiGianCoupon();
        }
    }

    // Phương thức để cập nhật trạng thái khi hết hạn
    public void TrangThaiThoiGianVoucher() {
        Date batDau = dcBatDau.getDate();
        Date hetHan = dcHetHan.getDate();
        if (hetHan != null) { // Kiểm tra xem hetHan có null không
            for (Voucher e : listVC) {
                if (hetHan.before(batDau)) {
                    rbHetHan.setSelected(true);
                    e.setTrangThai("Hết hạn");
                } else {
                    rbHoatDong.setSelected(true);
                    e.setTrangThai("Hoạt động");
                }
            }
            LoadDataTable(); // Cập nhật lại bảng hiển thị thông tin voucher
        }
    }

    public void TrangThaiThoiGianCoupon() {
        Date batDau = dcNgayDatBau.getDate();
        Date hetHan = dcNgayKetThuc.getDate();
        if (hetHan != null) { // Kiểm tra xem hetHan có null không
            for (Voucher e : listVC) {
                if (hetHan.before(batDau)) {
                    rbCPHetHan.setSelected(true);
                    e.setTrangThai("Hết hạn");
                } else {
                    rbCPHoatDong.setSelected(true);
                    e.setTrangThai("Hoạt động");
                }
            }
            LoadDataCoupon(); // Cập nhật lại bảng hiển thị thông tin voucher
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnKhuyenMai = new javax.swing.JTabbedPane();
        Voucher = new javax.swing.JPanel();
        btnAdd = new javax.swing.JToggleButton();
        btnUpdate = new javax.swing.JToggleButton();
        btnRefresh = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaVC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenVC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiamGiaVC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbHoatDong = new javax.swing.JRadioButton();
        rbHetHan = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        cbKhachVip = new javax.swing.JCheckBox();
        dcBatDau = new com.toedter.calendar.JDateChooser();
        dcHetHan = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        txtDieuKien = new javax.swing.JTextField();
        danhSachVC = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVoucher = new javax.swing.JTable();
        Coupon = new javax.swing.JPanel();
        pnThongTin = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtIDSanPham = new javax.swing.JTextField();
        txtMaSP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnGiamGia = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtGiamGiaCP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dcNgayDatBau = new com.toedter.calendar.JDateChooser();
        dcNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        txtMaCP = new javax.swing.JTextField();
        txtTenCP = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rbCPHoatDong = new javax.swing.JRadioButton();
        rbCPHetHan = new javax.swing.JRadioButton();
        pnCoupon = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCoupon = new javax.swing.JTable();
        pnSanPham = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        btnApDung = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnAddCoupon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnKhuyenMai.setForeground(new java.awt.Color(255, 0, 0));
        pnKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pnKhuyenMai.setPreferredSize(new java.awt.Dimension(1200, 700));

        Voucher.setPreferredSize(new java.awt.Dimension(1200, 700));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Mã Voucher:");

        jLabel2.setText("Tên Voucher:");

        jLabel3.setText("Giảm giá:");

        jLabel4.setText("Ngày bắt đầu:");

        jLabel5.setText("Ngày kết  thúc:");

        jLabel6.setText("Trạng thái:");

        buttonGroup1.add(rbHoatDong);
        rbHoatDong.setSelected(true);
        rbHoatDong.setText("Hoạt động");

        buttonGroup1.add(rbHetHan);
        rbHetHan.setText("Hết hạn");

        jLabel15.setText("Ưu đãi riêng:");

        cbKhachVip.setText("Khách VIP");

        dcBatDau.setDateFormatString("yyyy-MM-dd");

        dcHetHan.setDateFormatString("yyyy-MM-dd");

        jLabel19.setText("Điều kiện");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dcHetHan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dcBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenVC, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaVC, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGiamGiaVC, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbKhachVip, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rbHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDieuKien)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGiamGiaVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4))
                    .addComponent(dcBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(dcHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbHoatDong)
                    .addComponent(rbHetHan))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbKhachVip))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        danhSachVC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách Voucher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã voucher", "Tên voucher", "Giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Điều kiện", "Trạng thái KH", "Trạng thái"
            }
        ));
        tbVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVoucher);

        javax.swing.GroupLayout danhSachVCLayout = new javax.swing.GroupLayout(danhSachVC);
        danhSachVC.setLayout(danhSachVCLayout);
        danhSachVCLayout.setHorizontalGroup(
            danhSachVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhSachVCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
        );
        danhSachVCLayout.setVerticalGroup(
            danhSachVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhSachVCLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout VoucherLayout = new javax.swing.GroupLayout(Voucher);
        Voucher.setLayout(VoucherLayout);
        VoucherLayout.setHorizontalGroup(
            VoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VoucherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VoucherLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(danhSachVC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        VoucherLayout.setVerticalGroup(
            VoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VoucherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(danhSachVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VoucherLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(VoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jPanel5.getAccessibleContext().setAccessibleName("Thông Tin");

        pnKhuyenMai.addTab("Voucher", Voucher);

        Coupon.setPreferredSize(new java.awt.Dimension(1200, 700));

        pnThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel7.setText("ID SP:");

        txtIDSanPham.setEditable(false);

        txtMaSP.setEditable(false);

        jLabel8.setText("Mã SP:");

        txtTenSP.setEditable(false);

        jLabel9.setText("Tên SP:");

        txtSoLuong.setEditable(false);

        txtGiaBan.setEditable(false);

        jLabel13.setText("Giá bán:");

        jLabel14.setText("Số lượng:");

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIDSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIDSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnGiamGia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Coupon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel10.setText("Giảm giá:");

        jLabel11.setText("Ngày bắt đầu:");

        jLabel12.setText("Ngày kết thúc:");

        dcNgayDatBau.setDateFormatString("yyyy-MM-dd");

        dcNgayKetThuc.setDateFormatString("yyyy-MM-dd");

        jLabel16.setText("Mã Coupon");

        jLabel17.setText("Tên Coupon");

        jLabel18.setText("Trạng thái");

        buttonGroup2.add(rbCPHoatDong);
        rbCPHoatDong.setSelected(true);
        rbCPHoatDong.setText("Hoạt động");

        buttonGroup2.add(rbCPHetHan);
        rbCPHetHan.setText("Hết hạn");

        javax.swing.GroupLayout pnGiamGiaLayout = new javax.swing.GroupLayout(pnGiamGia);
        pnGiamGia.setLayout(pnGiamGiaLayout);
        pnGiamGiaLayout.setHorizontalGroup(
            pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGiamGiaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGiamGiaCP, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txtMaCP))
                .addGap(44, 44, 44)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcNgayDatBau, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txtTenCP))
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGiamGiaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(dcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnGiamGiaLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rbCPHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(rbCPHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        pnGiamGiaLayout.setVerticalGroup(
            pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGiamGiaLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMaCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(txtTenCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbCPHoatDong)
                    .addComponent(rbCPHetHan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcNgayDatBau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtGiamGiaCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)))
                .addGap(17, 17, 17))
        );

        pnCoupon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COUPON", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbCoupon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Coupon", "Tên Coupon", "ID SP", "Giảm giá ", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ));
        tbCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCouponMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCoupon);

        javax.swing.GroupLayout pnCouponLayout = new javax.swing.GroupLayout(pnCoupon);
        pnCoupon.setLayout(pnCouponLayout);
        pnCouponLayout.setHorizontalGroup(
            pnCouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCouponLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCouponLayout.setVerticalGroup(
            pnCouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCouponLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDSP", "Mã SP", "Tên sản phẩm", "Số lượng", "Giá bán"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSanPham);

        javax.swing.GroupLayout pnSanPhamLayout = new javax.swing.GroupLayout(pnSanPham);
        pnSanPham.setLayout(pnSanPhamLayout);
        pnSanPhamLayout.setHorizontalGroup(
            pnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        pnSanPhamLayout.setVerticalGroup(
            pnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSanPhamLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnApDung.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnApDung.setText("Áp dụng");
        btnApDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApDungActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnAddCoupon.setText("New Coupon");
        btnAddCoupon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCouponActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CouponLayout = new javax.swing.GroupLayout(Coupon);
        Coupon.setLayout(CouponLayout);
        CouponLayout.setHorizontalGroup(
            CouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CouponLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnGiamGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CouponLayout.createSequentialGroup()
                        .addComponent(pnCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CouponLayout.createSequentialGroup()
                        .addComponent(btnApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 672, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CouponLayout.setVerticalGroup(
            CouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CouponLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(CouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CouponLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(CouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(pnCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CouponLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pnKhuyenMai.addTab("Coupon", Coupon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVoucherMouseClicked
        int i = tbVoucher.getSelectedRow();
        detail();
//        LoadDataTableTheoMa(String.valueOf(tbVoucher.getValueAt(i, 0)));
    }//GEN-LAST:event_tbVoucherMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addVC();
        LoadDataTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        LoadDataTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateVC();
        LoadDataTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCouponMouseClicked
        try {
            int i = tbCoupon.getSelectedRow();
            DetailCouPon();
//            LoadDataCouponTheoMa(String.valueOf(tbCoupon.getValueAt(i, 0)));
        } catch (Exception e) {
            System.out.println("loi");
        }
    }//GEN-LAST:event_tbCouponMouseClicked

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int i = tbSanPham.getSelectedRow();
        DetailSanPham();
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void btnAddCouponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCouponActionPerformed
        try {
            if (checkCP()) {
                addCoupon();
                LoadDataCoupon();
                JOptionPane.showMessageDialog(this, "Thêm mới coupon thành công!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm mới coupon không thành công!");
        }
    }//GEN-LAST:event_btnAddCouponActionPerformed

    private void btnApDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApDungActionPerformed
        try {
            apDungSanPhamToCoupon();
            LoadDataCoupon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không được để trống sản phẩm hoặc coupon");
        }
    }//GEN-LAST:event_btnApDungActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        try {
            huyCP();
            LoadDataCoupon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không thể hủy khi chưa chọn sản phẩm hoặc coupon");
        }

    }//GEN-LAST:event_btnHuyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Coupon;
    private javax.swing.JPanel Voucher;
    private javax.swing.JToggleButton btnAdd;
    private javax.swing.JButton btnAddCoupon;
    private javax.swing.JButton btnApDung;
    private javax.swing.JButton btnHuy;
    private javax.swing.JToggleButton btnRefresh;
    private javax.swing.JToggleButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbKhachVip;
    private javax.swing.JPanel danhSachVC;
    private com.toedter.calendar.JDateChooser dcBatDau;
    private com.toedter.calendar.JDateChooser dcHetHan;
    private com.toedter.calendar.JDateChooser dcNgayDatBau;
    private com.toedter.calendar.JDateChooser dcNgayKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnCoupon;
    private javax.swing.JPanel pnGiamGia;
    private javax.swing.JTabbedPane pnKhuyenMai;
    private javax.swing.JPanel pnSanPham;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JRadioButton rbCPHetHan;
    private javax.swing.JRadioButton rbCPHoatDong;
    private javax.swing.JRadioButton rbHetHan;
    private javax.swing.JRadioButton rbHoatDong;
    private javax.swing.JTable tbCoupon;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTable tbVoucher;
    private javax.swing.JTextField txtDieuKien;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiamGiaCP;
    private javax.swing.JTextField txtGiamGiaVC;
    private javax.swing.JTextField txtIDSanPham;
    private javax.swing.JTextField txtMaCP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaVC;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenCP;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenVC;
    // End of variables declaration//GEN-END:variables
}
