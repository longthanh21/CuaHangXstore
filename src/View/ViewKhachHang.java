/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.KhachHang;
import Service.QuanLyKhachHang;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TienBB
 */
public class ViewKhachHang extends javax.swing.JFrame {

    /**
     * Creates new form ViewKhachHang
     */
    DefaultTableModel defaultTableModel;
    QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();

    public ViewKhachHang() {
        initComponents();
        loadDataKhachHang();
        loadDataKhachVip();
    }

    void loadDataKhachHang() {
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        int i = 1;
        for (KhachHang khachHang : quanLyKhachHang.getAllKhachHang()) {
            defaultTableModel.addRow(new Object[]{
                i++,
                khachHang.getMaKH(),
                khachHang.getTenKH(),
                khachHang.getSĐT(),
                khachHang.getNgayTao(),
                khachHang.isGioiTinh() ? "Nam" : "Nữ",
                khachHang.isTrangThai() ? "Khách Vip" : "Khách Thường",
                khachHang.getDiaChi(),});

        }
    }

    void loadSeachKhachHang(String maKH) {
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        int i = 1;
        for (KhachHang khachHang : quanLyKhachHang.loadSeachKhachHang(maKH)) {
            defaultTableModel.addRow(new Object[]{
                i++,
                khachHang.getMaKH(),
                khachHang.getTenKH(),
                khachHang.getSĐT(),
                khachHang.getNgayTao(),
                khachHang.isGioiTinh() ? "Nam" : "Nữ",
                khachHang.isTrangThai() ? "Khách Vip" : "Khách Thường",
                khachHang.getDiaChi(),});

        }
    }

    void loadSeachKhachVip(String maKH) {
        defaultTableModel = (DefaultTableModel) tblKhachVip.getModel();
        defaultTableModel.setRowCount(0);
        int i = 1;
        for (KhachHang khachHang : quanLyKhachHang.loadSeachKhachVip(maKH)) {
            defaultTableModel.addRow(new Object[]{
                i++,
                khachHang.getMaKH(),
                khachHang.getTenKH(),
                khachHang.getSĐT(),
                khachHang.getNgayTao(),
                khachHang.isGioiTinh() ? "Nam" : "Nữ",
                khachHang.isTrangThai() ? "Khách Vip" : "Khách Thường",
                khachHang.getDiaChi(),});

        }
    }

    void loadDataKhachVip() {
        defaultTableModel = (DefaultTableModel) tblKhachVip.getModel();
        defaultTableModel.setRowCount(0);
        int i = 1;
        for (KhachHang khachHang : quanLyKhachHang.getAllKhachVip()) {
            defaultTableModel.addRow(new Object[]{
                i++,
                khachHang.getMaKH(),
                khachHang.getTenKH(),
                khachHang.getSĐT(),
                khachHang.getNgayTao(),
                khachHang.isGioiTinh() ? "Nam" : "Nữ",
                khachHang.isTrangThai() ? "Khách Vip" : "Khách Thường",
                khachHang.getDiaChi(),});

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnKhachHang = new javax.swing.JPanel();
        pnKhachVip = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachVip = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDienThoai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        rdKhachThuong = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        rdKhachVip = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpDate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSeachKHang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnKhachHang.setPreferredSize(new java.awt.Dimension(1200, 700));

        pnKhachVip.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null), "Khách VIP"));

        tblKhachVip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Stt", "MaKH", "Tên KH", "SĐT", "Ngày Tạo", "Giới Tính", "Trạng Thái", "Địa Chỉ"
            }
        ));
        tblKhachVip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachVipMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachVip);

        javax.swing.GroupLayout pnKhachVipLayout = new javax.swing.GroupLayout(pnKhachVip);
        pnKhachVip.setLayout(pnKhachVipLayout);
        pnKhachVipLayout.setHorizontalGroup(
            pnKhachVipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachVipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnKhachVipLayout.setVerticalGroup(
            pnKhachVipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachVipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel1.setText("Mã KH:");

        jLabel2.setText("Tên Khách Hàng:");

        txtTenKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenKHKeyReleased(evt);
            }
        });

        jLabel3.setText("Số điện thoại:");

        jLabel4.setText("Địa chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane3.setViewportView(txtDiaChi);

        jLabel6.setText("Trạng Thái: ");

        buttonGroup1.add(rdKhachThuong);
        rdKhachThuong.setText("Khách Thường");

        jLabel7.setText("Giới Tính:");

        buttonGroup2.add(rdNam);
        rdNam.setText("Nam");

        buttonGroup2.add(rdNu);
        rdNu.setText("Nữ");

        buttonGroup1.add(rdKhachVip);
        rdKhachVip.setText("Khách Vip");

        jLabel8.setText("Ngày Tạo: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(52, 52, 52)
                        .addComponent(rdKhachThuong))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTenKH))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDienThoai)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rdNam)
                                    .addGap(68, 68, 68)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rdKhachVip, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rdNu))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdNam)
                    .addComponent(rdNu)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdKhachThuong)
                        .addComponent(rdKhachVip)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách hàng gần đây"));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Stt", "MaKH", "Tên KH", "SĐT", "Ngày Tạo", "Giới Tính", "Trạng Thái", "Địa Chỉ"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAdd.setText("Add");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnUpDate.setText("Update");
        btnUpDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpDateMouseClicked(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        jButton4.setText("New");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jLabel5.setText("Tìm Theo Mã KH");

        txtSeachKHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSeachKHangKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addComponent(txtSeachKHang, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSeachKHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnKhachVip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnKhachVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        String ma = txtMaKH.getText();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Mã Khách Hàng ");
            return;
        }
        for (KhachHang khachHang : quanLyKhachHang.getAllKhachHang()) {
            if (khachHang.getMaKH().equals(ma)) {
                JOptionPane.showMessageDialog(this, "Không Trùng Mã Khách Hàng ");
                return;
            }
        }
        String ten = txtTenKH.getText();
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Tên");
            return;
        }

        Boolean gioiTinh;
        if (rdNam.isSelected()) {
            gioiTinh = true;
        } else if (rdNu.isSelected()) {
            gioiTinh = false;
        } else {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Giới Tính");
            return;
        }
        String diaChi = txtDiaChi.getText();
        if (diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Địa Chỉ");
            return;
        }
        String sdt = txtDienThoai.getText();
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Số Diện Thoại");
            return;
        }
        if (sdt.length()!=10) {
            JOptionPane.showMessageDialog(this, "Số Điện Thoại Phải Là 10 số");
            return;
        }
        String regex = "^0\\d{9}&";
        Pattern pattern = Pattern.compile(regex);
        Matcher  matcher = pattern.matcher(sdt);
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Số Điện Thoại Bắt Đầu Bằng số 0");
            return;
        }
        Date NgayTao = txtNgayTao.getDate();
        if (txtNgayTao.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Ngay Tao");
            return;
        }
        SimpleDateFormat dateNgayTao = new SimpleDateFormat("yyyy-MM-dd");
        String strNgayTao = dateNgayTao.format(NgayTao);

        Boolean trangThai;
        if (rdKhachVip.isSelected()) {
            trangThai = true;
        } else if (rdKhachThuong.isSelected()) {
            trangThai = false;
        } else {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Trạng Thái");
            return;
        }
        KhachHang khachHang = new KhachHang(ma, ten, sdt, strNgayTao, gioiTinh, trangThai, diaChi);
        quanLyKhachHang.ADDKhachHang(khachHang);
        loadDataKhachHang();
        loadDataKhachVip();
    }//GEN-LAST:event_btnAddMouseClicked

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int i = tblKhachHang.getSelectedRow();
        String ma = (String) tblKhachHang.getValueAt(i, 1);
        txtMaKH.setText(ma);
        String ten = (String) tblKhachHang.getValueAt(i, 2);
        txtTenKH.setText(ten);
        String sdt = (String) tblKhachHang.getValueAt(i, 3);
        txtDienThoai.setText(sdt);
        String NgayTao = (String) tblKhachHang.getValueAt(i, 4);
        if (NgayTao==null) {
            txtNgayTao.setDate(null);
        }else{
        SimpleDateFormat dateNgayTao = new SimpleDateFormat("yyyy-MM-dd");
        Date startNgayTao = null;
        try {
            startNgayTao = dateNgayTao.parse(NgayTao);
        } catch (ParseException e) {
            startNgayTao = null;
            e.printStackTrace();
        }
        txtNgayTao.setDate(startNgayTao);
       }
        String gioiTinh = (String) tblKhachHang.getValueAt(i, 5);
        if (gioiTinh.equals("Nam")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        String trangThai = (String) tblKhachHang.getValueAt(i, 6);
        if (trangThai.equals("Khách Thường")) {
            rdKhachThuong.setSelected(true);
        } else {
            rdKhachVip.setSelected(true);
        }
        String diaChi = (String) tblKhachHang.getValueAt(i, 7);
        txtDiaChi.setText(diaChi);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void tblKhachVipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachVipMouseClicked
        // TODO add your handling code here:
        int i = tblKhachVip.getSelectedRow();
        String ma = (String) tblKhachVip.getValueAt(i, 1);
        txtMaKH.setText(ma);
        String ten = (String) tblKhachVip.getValueAt(i, 2);
        txtTenKH.setText(ten);
        String sdt = (String) tblKhachVip.getValueAt(i, 3);
        txtDienThoai.setText(sdt);
        String NgayTao = (String) tblKhachVip.getValueAt(i, 4);
        if (NgayTao==null) {
            txtNgayTao.setDate(null);
        }else{
        SimpleDateFormat dateNgayTao = new SimpleDateFormat("yyyy-MM-dd");
        Date startNgayTao = null;
        try {
            startNgayTao = dateNgayTao.parse(NgayTao);
        } catch (ParseException e) {
            startNgayTao = null;
            e.printStackTrace();
        }
        txtNgayTao.setDate(startNgayTao);
       }
        String gioiTinh = (String) tblKhachVip.getValueAt(i, 5);
        if (gioiTinh.equals("Nam")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        String trangThai = (String) tblKhachVip.getValueAt(i, 6);
        if (trangThai.equals("Khách Thường")) {
            rdKhachThuong.setSelected(true);
        } else {
            rdKhachVip.setSelected(true);
        }
        String diaChi = (String) tblKhachVip.getValueAt(i, 7);
        txtDiaChi.setText(diaChi);
    }//GEN-LAST:event_tblKhachVipMouseClicked

    private void btnUpDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpDateMouseClicked
        // TODO add your handling code here:
        String ma = txtMaKH.getText();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Mã Khách Hàng ");
            return;
        }
        String ten = txtTenKH.getText();
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Tên");
            return;
        }

        Boolean gioiTinh;
        if (rdNam.isSelected()) {
            gioiTinh = true;
        } else if (rdNu.isSelected()) {
            gioiTinh = false;
        } else {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Giới Tính");
            return;
        }
        Date NgayTao = txtNgayTao.getDate();
        if (txtNgayTao.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Ngay Tao");
            return;
        }
        SimpleDateFormat dateNgayTao = new SimpleDateFormat("yyyy-MM-dd");
        String strNgayTao = dateNgayTao.format(NgayTao);

        String diaChi = txtDiaChi.getText();
        if (diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Địa Chỉ");
            return;
        }
        String sdt = txtDienThoai.getText();
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Số Diện Thoại");
            return;
        }
        Boolean trangThai;
        if (rdKhachVip.isSelected()) {
            trangThai = true;
        } else if (rdKhachThuong.isSelected()) {
            trangThai = false;
        } else {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Trạng Thái");
            return;
        }
        KhachHang khachHang = new KhachHang(ma, ten, sdt, strNgayTao, gioiTinh, trangThai, diaChi);
        quanLyKhachHang.upDate(khachHang);
        loadDataKhachHang();
        loadDataKhachVip();
    }//GEN-LAST:event_btnUpDateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        String ma = txtMaKH.getText();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Mã Khách Hàng ");
            return;
        }
        quanLyKhachHang.deleteKhachHang(ma);
        loadDataKhachHang();
        loadDataKhachVip();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        txtDiaChi.setText("");
        txtDienThoai.setText("");
        txtTenKH.setText("");
        txtMaKH.setText("");
        txtNgayTao.setDate(null);
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_jButton4MouseClicked

    private void txtSeachKHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeachKHangKeyReleased
        // TODO add your handling code here:

        String maKH = txtSeachKHang.getText();
        if (maKH.trim().isEmpty()) {
            loadDataKhachHang();
            loadDataKhachVip();
        } else {
            quanLyKhachHang.loadSeachKhachHang(maKH);
            loadSeachKhachHang(maKH);
            loadSeachKhachVip(maKH);
        }


    }//GEN-LAST:event_txtSeachKHangKeyReleased

    private void txtTenKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKHKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHKeyReleased

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
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpDate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnKhachVip;
    private javax.swing.JRadioButton rdKhachThuong;
    private javax.swing.JRadioButton rdKhachVip;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblKhachVip;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtMaKH;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private javax.swing.JTextField txtSeachKHang;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
