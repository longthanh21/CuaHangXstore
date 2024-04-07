/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.HoaDon;
import Service.QuanLyDoanhThu;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LongThank
 */
public class ViewDoanhThu extends javax.swing.JFrame {

    /**
     * Creates new form ViewDoanhThu
     */
    QuanLyDoanhThu ql = new QuanLyDoanhThu();
    DefaultTableModel defau;
    public ViewDoanhThu() {
        initComponents();
        loadToday();
        this.revalidate();
        this.repaint();
        loadHD();
    }
    void loadToday(){
        lbSoHoaDon.setText(ql.HDToday().toString());
        lbDoanhThu.setText(ql.DoanhThuToday().toString() + " VND");
        lbLoiThuan.setText(ql.loiNhuan().toString()+ " VND");
        lbTienLai.setText(ql.laiToDay().toString() + " VND");
        lbTongDoanhThu.setText(ql.TongDoanhThu().toString() + " VND");
        lbLaiXuat.setText(ql.laiXuat().toString() + " %");
        txtThang.setText(ql.TongDoanhThuThang().toString() +"VND");
    }
    
    void loadHD(){
        defau = (DefaultTableModel) tblHoaDon.getModel();
        defau.setRowCount(0);
        int stt = 1;
        for (HoaDon hd : ql.getListHD()) {
            defau.addRow(new Object[]{
                stt++,hd.getMaHD(),hd.getNgayTao(),hd.getTongTien()
            });
        }
    }
    
    void loadHDTK(String NgayBD,String NgayKT){
        defau = (DefaultTableModel) tblHoaDon.getModel();
        defau.setRowCount(0);
        int stt = 1;
        for (HoaDon hd : ql.getListHDTK(NgayBD, NgayKT)) {
            defau.addRow(new Object[]{
                stt++,hd.getMaHD(),hd.getNgayTao(),hd.getTongTien()
            });
        }
    }
    
    void loadHDTHang(String Thang){
        defau = (DefaultTableModel) tblHoaDon.getModel();
        defau.setRowCount(0);
        int stt = 1;
        for (HoaDon hd : ql.getListHDThaang(Thang)) {
            defau.addRow(new Object[]{
                stt++,hd.getMaHD(),hd.getNgayTao(),hd.getTongTien()
            });
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiemThang = new com.toedter.calendar.JMonthChooser();
        btnTimKiemThang = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbSoHoaDon = new javax.swing.JLabel();
        lbTienLai = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbDoanhThu = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbLoiThuan = new javax.swing.JLabel();
        lbLoiThuan1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbTongDoanhThu = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lbLaiXuat = new javax.swing.JLabel();
        lbLaiXuatTk = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        lbDoanHThuTK = new javax.swing.JLabel();
        txtDoanhThuThang = new javax.swing.JPanel();
        txtThang = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnTimKiemThang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiemThang.setText("Tìm Kiếm");
        btnTimKiemThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemThangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtTimKiemThang, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnTimKiemThang)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiemThang)
                    .addComponent(txtTimKiemThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hôm Nay", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel11.setText("Tổng doanh thu");

        jLabel12.setText("Hóa Đơn đã thanh toán");

        lbSoHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSoHoaDon.setForeground(new java.awt.Color(51, 51, 255));
        lbSoHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSoHoaDon.setText("0");

        lbTienLai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTienLai.setForeground(new java.awt.Color(51, 51, 255));
        lbTienLai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTienLai.setText("0");

        jLabel17.setText("Tiền lãi");

        lbDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDoanhThu.setForeground(new java.awt.Color(51, 51, 255));
        lbDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThu.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTienLai, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel12)
                .addGap(141, 141, 141)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(88, 88, 88))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTienLai)
                    .addComponent(lbSoHoaDon)
                    .addComponent(lbDoanhThu))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Lợi Nhuận", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lbLoiThuan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbLoiThuan.setForeground(new java.awt.Color(255, 51, 51));
        lbLoiThuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbLoiThuan1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbLoiThuan1.setForeground(new java.awt.Color(255, 51, 51));
        lbLoiThuan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLoiThuan, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbLoiThuan1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbLoiThuan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(lbLoiThuan1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Ngày Tạo", "Thành Tiền"
            }
        ));
        jScrollPane3.setViewportView(tblHoaDon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tổng Doanh Thu:");

        lbTongDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTongDoanhThu.setForeground(new java.awt.Color(255, 51, 51));
        lbTongDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTongDoanhThu.setText("0");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Lãi xuất", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lbLaiXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbLaiXuat.setForeground(new java.awt.Color(255, 51, 51));
        lbLaiXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbLaiXuatTk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbLaiXuatTk.setForeground(new java.awt.Color(255, 51, 51));
        lbLaiXuatTk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLaiXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbLaiXuatTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbLaiXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(lbLaiXuatTk, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(54, Short.MAX_VALUE)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtNgayKT.setDateFormatString("yyyy-MM-dd");

        txtNgayBD.setDateFormatString("yyyy-MM-dd");

        jLabel9.setText("Thời gian:");

        jLabel10.setText("đến");

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTimKiem)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Doanh Thu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lbDoanHThuTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDoanHThuTK.setForeground(new java.awt.Color(255, 51, 51));
        lbDoanHThuTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanHThuTK.setText("0.0 VND");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDoanHThuTK, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbDoanHThuTK, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        txtDoanhThuThang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doanh Thu Tháng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        txtThang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtThang.setForeground(new java.awt.Color(255, 0, 0));
        txtThang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtThang.setText("0.0 VND");

        javax.swing.GroupLayout txtDoanhThuThangLayout = new javax.swing.GroupLayout(txtDoanhThuThang);
        txtDoanhThuThang.setLayout(txtDoanhThuThangLayout);
        txtDoanhThuThangLayout.setHorizontalGroup(
            txtDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtDoanhThuThangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txtDoanhThuThangLayout.setVerticalGroup(
            txtDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtDoanhThuThangLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("New");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(lbTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDoanhThuThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
        Date ngayBD = txtNgayBD.getDate();
        if (ngayBD == null) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Ngày Bắt Đầu");
            return;
        }
         SimpleDateFormat dateNgayBD = new SimpleDateFormat("yyyy-MM-dd");
        String strNgayBD = dateNgayBD.format(ngayBD);
        
        Date ngayKT = txtNgayKT.getDate();
         if (ngayKT == null) {
            JOptionPane.showMessageDialog(this, "Không Bỏ Trống Ngày Bắt Đầu");
            return;
        }
         SimpleDateFormat dateNgayKT = new SimpleDateFormat("yyyy-MM-dd");
        String strNgayKT = dateNgayKT.format(ngayKT);
        for (HoaDon hoaDon : ql.getListHD()) {
            
        }
        ql.TongDoanhThuTimKiem(strNgayBD, strNgayKT);
        lbDoanHThuTK.setText(ql.TongDoanhThuTimKiem(strNgayBD, strNgayKT).toString() + " VND");
        loadHDTK(strNgayBD, strNgayKT);
        lbLoiThuan1.setText(ql.loiNhuanTK(strNgayBD, strNgayKT).toString() + " VND");
        lbLoiThuan.setText("");
        lbLaiXuatTk.setText(ql.laiXuatTK(strNgayBD, strNgayKT).toString() + " %");
        lbLaiXuat.setText("");
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnTimKiemThangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemThangMouseClicked
        // TODO add your handling code here:
        
          int selectedMonth = txtTimKiemThang.getMonth() + 1; 
            String strSelectedMonth = String.format("%02d", selectedMonth); 
            System.out.println("Selected Month: " + strSelectedMonth);
            txtThang.setText(ql.TimKiemTongDoanhThuThang(strSelectedMonth).toString() + " VND");
            lbLaiXuatTk.setText(ql.laiXuatTKThang(strSelectedMonth).toString() +"%");
            lbLaiXuat.setText("");
            lbLoiThuan1.setText(ql.loiNhuanTKThang(strSelectedMonth).toString() +" VND");
            lbLoiThuan.setText("");
            loadHDTHang(strSelectedMonth);
            
    }//GEN-LAST:event_btnTimKiemThangMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        loadHD();
        lbDoanHThuTK.setText("0.0 VND");
        lbDoanhThu.setText("0.0 VND");
        lbLoiThuan.setText("");
        lbLoiThuan1.setText("0.0 VND");
        lbSoHoaDon.setText("0.0 VND");
        lbTienLai.setText("0.0 VND");
        lbLaiXuat.setText("0.0 %");
        lbLaiXuatTk.setText("0.0 %");
        txtThang.setText("0.0 VND");
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(ViewDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDoanhThu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiemThang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbDoanHThuTK;
    private javax.swing.JLabel lbDoanhThu;
    private javax.swing.JLabel lbLaiXuat;
    private javax.swing.JLabel lbLaiXuatTk;
    private javax.swing.JLabel lbLoiThuan;
    private javax.swing.JLabel lbLoiThuan1;
    private javax.swing.JLabel lbSoHoaDon;
    private javax.swing.JLabel lbTienLai;
    private javax.swing.JLabel lbTongDoanhThu;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JPanel txtDoanhThuThang;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JLabel txtThang;
    private com.toedter.calendar.JMonthChooser txtTimKiemThang;
    // End of variables declaration//GEN-END:variables
}
