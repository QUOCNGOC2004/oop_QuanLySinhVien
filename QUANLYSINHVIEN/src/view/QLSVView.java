package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.QLMHModel;
import model.QLSVModel;
import model.SinhVien;
import model.FileModel;
import model.MonHoc;


import javax.swing.ButtonGroup;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import javax.swing.JRadioButton;
import javax.swing.JComboBox;



public class QLSVView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public QLSVModel qlsvModel;
	public QLMHModel qlmhModel;
	public FileModel fileModel;
	
	public JTextField textField_dTb;
	public JTextField textField_MSV1;
	public JTextField textField_MSV2;
	public JTextField textField_HvT;
	public JTextField textField_NS;
	public JTextField textField_LH;
	public JTextField textField_ĐTb;
	public ButtonGroup btg_gioiTinh;
	public JRadioButton RdbtNam;
	public JRadioButton rdbtNu;
	public JTable tableSV;
	public JTable tableMH1;
	public JTable tableMH2;
	public JTextField textField_TTSV;
	public JTextField textField_maMHQLSV;
	public JTextField textField_NhapDiem;
	public JTextField textField_TongTien;
	public JTable tableMH3;
	public JTextField textField_maMH1;
	public JTextField textField_tenMH;
	public JTextField textField_maMH2;
	public JTextField textField_sTc;
	public JTextField textField_giaMH;
	private JTextField textField_TenDagNhap;
	private JTextField textField_MatKhau;
	public JComboBox<String> comboBox;
	
	private CardLayout cardLayout;
	private JPanel contentPane;
	private String tenDangNhap="NguyenQuocNgoc";
	private String matkhau ="0000";

	/**
	 * Launch the application.
	 */

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		qlsvModel = new QLSVModel(this);
		qlmhModel = new QLMHModel(this);
		fileModel = new FileModel(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1247,673);          // 1280x720
		
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu F = new JMenu("File");
		menuBar.add(F);
		
		//xu ly su kien chuyen sang card mon hoc
		JMenuItem MonHocItem = new JMenuItem("Môn Học");
		F.add(MonHocItem);
		MonHocItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane,"Môn Học");
				}
		});
		
		
		//xu ly su kien chuyen sang card sinh vien
		JMenuItem SinhVienItem = new JMenuItem("Sinh Viên");
		F.add(SinhVienItem);
		SinhVienItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane,"Sinh Viên");
			}
		});
		
		JSeparator separator = new JSeparator();
		F.add(separator);
		
	    //xu ly sự kiện mở file
		JMenuItem OpenFile = new JMenuItem("Open");
		F.add(OpenFile);
		OpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileModel.thucHienOpenFile();
			}
		});
		
		//xu ly su kien save file
		JMenuItem SaveFile = new JMenuItem("Save");
		F.add(SaveFile);
		SaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileModel.thucHienSaveFile();
			}
		});
		
		
		
		cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// card quan ly sinh vien
		JPanel JPSinhVien = new JPanel();
		JPSinhVien.setBounds(0, 0, 1280, 720);
		//JPSinhVien.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPSinhVien.setLayout(null);
		contentPane.add(JPSinhVien,"Sinh Viên");
		
		
		// card quan ly mon hoc
		JPanel JPMonHoc = new JPanel();
		JPMonHoc.setBounds(0, 0, 1280, 720);
		//JPMonHoc.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPMonHoc.setLayout(null);
		contentPane.add(JPMonHoc,"Môn Học");
		
	    
		//xu ly su kien chuyen sang card quan ly 1 sinh vien
		JButton btnNewButton_3 = new JButton("Quản Lý");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String maSV = textField_MSV1.getText();
				 if(qlsvModel.TimKiemSV(maSV)!=null) {
					 textField_TTSV.setText("Quản lý Sinh viên: " + qlsvModel.TimKiemSV(maSV).getTenSV());
			         cardLayout.show(contentPane,"QL1SV");
				 }else {
					 JOptionPane.showMessageDialog(null,"Không tìm thấy sinh viên có mã: "+ maSV, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				 }
			}
		});
		btnNewButton_3.setBounds(940, 14, 114, 23);
		JPSinhVien.add(btnNewButton_3);
		
		
		// card quan ly 1 sinh vien
		JPanel QLSV = new JPanel();
		QLSV.setBounds(0, 0, 1280, 720);
		//JPMonHoc.setBorder(new EmptyBorder(5, 5, 5, 5));
		QLSV.setLayout(null);
		contentPane.add(QLSV,"QL1SV");
		
		//xu ly su kien quay lai card sinh vien
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setBounds(940, 14, 114, 23);
		btnQuayLai.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 capNhapBangTrong();
             cardLayout.show(contentPane, "Sinh Viên");
	         }
		});
        QLSV.add(btnQuayLai);
        
        
        
		JLabel lblNewLabel = new JLabel("Nhập điểm trung bình :");
		lblNewLabel.setBounds(242, 11, 155, 30);
		JPSinhVien.add(lblNewLabel);
		
		textField_dTb = new JTextField();
		textField_dTb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_dTb.setBounds(385, 14, 69, 25);
		JPSinhVien.add(textField_dTb);
		textField_dTb.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Mã Sinh Viên:");
		lblNewLabel_1.setBounds(610, 15, 144, 22);
		JPSinhVien.add(lblNewLabel_1);
		
		textField_MSV1 = new JTextField();
		textField_MSV1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_MSV1.setBounds(694, 14, 114, 25);
		JPSinhVien.add(textField_MSV1);
		textField_MSV1.setColumns(10);
		
		//xu ly su kien tim kiem diem trung binh
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Double dtb = Double.valueOf(textField_dTb.getText());
			        qlsvModel.locDiemTb(dtb);
			   }
			    catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(null,"Chỉ được nhập số", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			    }
		    }  
		});
		btnNewButton_1.setBounds(476, 14, 62, 23);
		JPSinhVien.add(btnNewButton_1);
		
		
		// xu ly su kien hien danh sach sinh vien
		JButton btDsSv = new JButton("Danh sách sinh viên");
		btDsSv.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(qlsvModel.getSizeDsSv()==0) {
				JOptionPane.showMessageDialog(null,"Chưa thêm sinh viên nào", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				capNhatBangSV();
			}else {
		       capNhatBangSV();
		          }
		   }
		});
		btDsSv.setBounds(21, 11, 170, 30);
		JPSinhVien.add(btDsSv);
		
		
		//xu ly su kien tim kiem 1 sinh vien
		JButton btnNewButton_2 = new JButton("Tìm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     String maSV  = textField_MSV1.getText();
			     capNhapBangCo1SinhVien(qlsvModel.TimKiemSV(maSV));
			}
		});
		btnNewButton_2.setBounds(829, 14, 69, 23);
		JPSinhVien.add(btnNewButton_2);
		
		
	
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 57, 1280, 2);
		JPSinhVien.add(separator_1);
		
		JLabel lblThngTin = new JLabel("Thông Tin:");
		lblThngTin.setBounds(21, 96, 170, 30);
		JPSinhVien.add(lblThngTin);
		
		tableSV = new JTable();
		tableSV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 Sinh Vi\u00EAn", "H\u1ECD T\u00EAn ", "L\u1EDBp H\u1ECDc", "\u0110i\u1EC3m Trung B\u00ECnh","Quê quán", "Ng\u00E0y Sinh", "Gi\u1EDBi T\u00EDnh"
			}
		));
		JScrollPane scrollPane = new JScrollPane(tableSV);
		scrollPane.setBounds(21, 130, 1252, 190);
		JPSinhVien.add(scrollPane);
		
		
		
		tableMH1 = new JTable();
		tableMH1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT ", "Môn Học", "Mã Môn Học", "Điểm ","Số tín chỉ","Giá Môn Học"
			}
		));
		JScrollPane scrollPane1 = new JScrollPane(tableMH1);
		scrollPane1.setBounds(596, 182, 662, 190);
		QLSV.add(scrollPane1);
		
		
		
		
		tableMH2 = new JTable();
		tableMH2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT" ,"Môn Học", "Mã Môn Học","Số tín chỉ","Giá Môn Học"
			}
		));
		JScrollPane scrollPane1_1 = new JScrollPane(tableMH2);
		scrollPane1_1.setBounds(0, 182, 573, 190);
		QLSV.add(scrollPane1_1);
		
		
		
		
		tableMH3 = new JTable();
		tableMH3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"STT" ,"Môn Học", "Mã Môn Học","Số tín chỉ","Giá Môn Học"
			}
		));
		JScrollPane scrollPane1_MH = new JScrollPane(tableMH3);
		scrollPane1_MH.setBounds(10, 112, 1252, 214);
		JPMonHoc.add(scrollPane1_MH);
		
		//xu ly su kien them mon hoc
		JButton btn_themMH = new JButton("Thêm");
		btn_themMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maMh = textField_maMH2.getText();
				String tenMH = textField_tenMH.getText();
				if(maMh.equals("") || tenMH.equals("")) {
					JOptionPane.showMessageDialog(null,"Không được để trống thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
				    try {
				    	int soTc = Integer.parseInt(textField_sTc.getText());
						double giaMH = Double.valueOf(textField_giaMH.getText());
				        MonHoc mh = new MonHoc(tenMH, maMh, soTc, giaMH);
				        qlmhModel.themMonHoc(mh);
				    } catch (NumberFormatException ex) {
				        JOptionPane.showMessageDialog(null,"Chỉ được nhập số", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				    }
				}
			}
		});
		btn_themMH.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_themMH.setBounds(57, 518, 155, 62);
		JPMonHoc.add(btn_themMH);
		
		//xu ly su kien xoa mon hoc
		JButton btn_xoaMH = new JButton("Xóa");
		btn_xoaMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maMH = textField_maMH2.getText();
				qlmhModel.xoaMonHoc(maMH);
			}
		});
		btn_xoaMH.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_xoaMH.setBounds(313, 518, 155, 62);
		JPMonHoc.add(btn_xoaMH);
		
		//xu ly su kien sua mon hoc
		JButton btn_suaMH = new JButton("Sửa");
		btn_suaMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonHoc mh = qlmhModel.TimKiemMH(textField_maMH2.getText());
				if(mh!= null) {
					textField_tenMH.setText(mh.getTenMh());
					textField_giaMH.setText(mh.getGiaMH()+"");
					textField_sTc.setText(mh.getSoTc()+"");
				}else {
					JOptionPane.showMessageDialog(null,"Không tìm thấy môn học có mã: "+ textField_maMH2.getText(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btn_suaMH.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_suaMH.setBounds(581, 518, 155, 62);
		JPMonHoc.add(btn_suaMH);
		
		
		//xu ly su kien luu mon hoc
		JButton btn_luuMH = new JButton("Lưu");
		btn_luuMH.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_luuMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maMH = textField_maMH2.getText();
				String tenMH = textField_tenMH.getText();
				if(maMH.equals("") || tenMH.equals("")) {
				    JOptionPane.showMessageDialog(null,"Không được để trống thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
				    try {
				        int stc = Integer.parseInt(textField_sTc.getText());
				        double giaMH = Double.valueOf(textField_giaMH.getText());
				        MonHoc mh = new MonHoc(tenMH, maMH, stc, giaMH);
				        qlmhModel.suaMonHoc(maMH, mh);
				    } catch (NumberFormatException ex) {
				        JOptionPane.showMessageDialog(null,"Chỉ được nhập số cho giá và tín chỉ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				        
				    }
				}
			}
		});
		btn_luuMH.setBounds(841, 518, 155, 62);
		JPMonHoc.add(btn_luuMH);
		
		//xu ly su kien xoa form mon hoc
		JButton btnResetMH = new JButton("Reset");
		btnResetMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaForm1();
			}
		});
		btnResetMH.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnResetMH.setBounds(1086, 518, 155, 62);
		JPMonHoc.add(btnResetMH);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 351, 1280, 2);
		JPMonHoc.add(separator_4);
		
		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setBounds(0, 99, 1280, 2);
		JPMonHoc.add(separator_4_1);
		
		//xu ly su kien in danh sach mon hoc
		JButton btnDanhSchMn = new JButton("Danh sách môn học");
		btnDanhSchMn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(qlmhModel.getSizeDsMh()==0) {
					JOptionPane.showMessageDialog(null,"Chưa thêm môn học nào", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					capNhatBangMH();
				}else {
				    capNhatBangMH();
				}
			}
		});
		btnDanhSchMn.setBounds(70, 11, 170, 30);
		JPMonHoc.add(btnDanhSchMn);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mã Môn Học:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(768, 11, 95, 37);
		JPMonHoc.add(lblNewLabel_3_1);
		
		textField_maMH1 = new JTextField();
		textField_maMH1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_maMH1.setBounds(873, 11, 155, 30);
		JPMonHoc.add(textField_maMH1);
		textField_maMH1.setColumns(10);
		
		//xu ly su kien tim kiem 1 mon hoc
		JButton btn_timMH = new JButton("Tìm");
		btn_timMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maMh = textField_maMH1.getText();
    			capNhapBangCo1MonHoc(qlmhModel.TimKiemMH(maMh));
			}
		});
		btn_timMH.setBounds(1050, 15, 77, 23);
		JPMonHoc.add(btn_timMH);
		
		JSeparator separator_4_2 = new JSeparator();
		separator_4_2.setBounds(0, 505, 1280, 2);
		JPMonHoc.add(separator_4_2);
		
		JLabel lblNewLabel_5 = new JLabel("Quản Lý Môn Học:");
		lblNewLabel_5.setBounds(10, 359, 127, 30);
		JPMonHoc.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tên môn học :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(159, 388, 155, 37);
		JPMonHoc.add(lblNewLabel_6);
		
		textField_tenMH = new JTextField();
		textField_tenMH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_tenMH.setBounds(324, 388, 155, 37);
		JPMonHoc.add(textField_tenMH);
		textField_tenMH.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Mã môn học :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6_1.setBounds(159, 457, 155, 37);
		JPMonHoc.add(lblNewLabel_6_1);
		
		textField_maMH2 = new JTextField();
		textField_maMH2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_maMH2.setColumns(10);
		textField_maMH2.setBounds(324, 457, 155, 37);
		JPMonHoc.add(textField_maMH2);
		
		JLabel lblNewLabel_6_2 = new JLabel("Số tín chỉ :");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6_2.setBounds(726, 388, 155, 37);
		JPMonHoc.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("Giá môn học :");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6_3.setBounds(726, 457, 155, 37);
		JPMonHoc.add(lblNewLabel_6_3);
		
		textField_sTc = new JTextField();
		textField_sTc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_sTc.setColumns(10);
		textField_sTc.setBounds(841, 388, 112, 37);
		JPMonHoc.add(textField_sTc);
		
		textField_giaMH = new JTextField();
		textField_giaMH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_giaMH.setColumns(10);
		textField_giaMH.setBounds(862, 457, 155, 37);
		JPMonHoc.add(textField_giaMH);
		
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 131, 1280, 5);
		QLSV.add(separator_3);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(0, 419, 1280, 5);
		QLSV.add(separator_3_1);
		
		textField_TTSV = new JTextField();
		textField_TTSV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_TTSV.setBounds(10, 7, 373, 36);
		QLSV.add(textField_TTSV);
		textField_TTSV.setColumns(10);
		
		//xu ly su kien hien danh sach cac mon hoc dang mo
		JButton btMHDag_Mo = new JButton("Các môn học hiện đang mở:");
		btMHDag_Mo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(qlmhModel.getSizeDsMh() == 0) {
				JOptionPane.showMessageDialog(null,"Chưa có môn học nào đang mở", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				capNhatBangMHHienDagMo();
				}else {
					capNhatBangMHHienDagMo();
				}
			}
		});
		btMHDag_Mo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btMHDag_Mo.setBounds(121, 144, 262, 27);
		QLSV.add(btMHDag_Mo);
		
		
		//xu ly su kien hien cac mon học da dang ki len bang 
		JButton btnHin = new JButton("Các môn học đã đăng kí:");
		btnHin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinhVien sv = qlsvModel.TimKiemSV(textField_MSV1.getText());
				if(sv.getDanhSachMHdaDagKi().size()==0) {
					JOptionPane.showMessageDialog(null,"Chưa đăng kí môn học nào", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					capNhatBangMHDaDagKi();
					textField_TongTien.setText("0 VND");
				}else {
					capNhatBangMHDaDagKi();
					textField_TongTien.setText(sv.tongGiaMH()+" VND");
				}
				
			}
		});
		btnHin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHin.setBounds(766, 144, 262, 27);
		QLSV.add(btnHin);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Môn Học :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(33, 435, 131, 36);
		QLSV.add(lblNewLabel_2);
		
		textField_maMHQLSV = new JTextField();
		textField_maMHQLSV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_maMHQLSV.setBounds(132, 435, 154, 36);
		QLSV.add(textField_maMHQLSV);
		textField_maMHQLSV.setColumns(10);
		
		
		//xu ly su kien dăng ki hoc cho 1 sinh vien
		JButton btnDagKyHoc = new JButton("Đăng kí học");
		btnDagKyHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinhVien sv = qlsvModel.TimKiemSV(textField_MSV1.getText());
				MonHoc mh = qlmhModel.TimKiemMH(textField_maMHQLSV.getText());
				if(mh==null) {
					JOptionPane.showMessageDialog(null,"Không có môn học này đang mở", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(sv.DangKiMonHoc(mh)==1) {
						JOptionPane.showMessageDialog(null,"Đăng kí môn học thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}else if(sv.DangKiMonHoc(mh)==0){
					    JOptionPane.showMessageDialog(null,"Đã đăng kí môn học này rồi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		btnDagKyHoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDagKyHoc.setBounds(338, 437, 177, 36);
		QLSV.add(btnDagKyHoc);
		
		
		// xu ly su kien xoa mon hoc da dang kí
		JButton btnXoaMH = new JButton("Xóa Môn Học");
		btnXoaMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinhVien sv = qlsvModel.TimKiemSV(textField_MSV1.getText());
				if(sv.xoaMonHoc(textField_maMHQLSV.getText())==0) {
					JOptionPane.showMessageDialog(null,"Đã xóa môn học có mã: "+ textField_maMHQLSV.getText(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}else if(sv.xoaMonHoc(textField_maMHQLSV.getText())==1) {
					JOptionPane.showMessageDialog(null,"Không trùng mã môn học,không thể xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnXoaMH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaMH.setBounds(338, 521, 177, 36);
		QLSV.add(btnXoaMH);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nhập điểm :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(656, 435, 106, 36);
		QLSV.add(lblNewLabel_2_1);
		
		textField_NhapDiem = new JTextField();
		textField_NhapDiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_NhapDiem.setColumns(10);
		textField_NhapDiem.setBounds(766, 435, 96, 36);
		QLSV.add(textField_NhapDiem);
		
		
		//xu ly nhap diem cho mon hoc cua sinh vien
		JButton btnLuuDiemchoMH = new JButton("Lưu");
		btnLuuDiemchoMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinhVien sv = qlsvModel.TimKiemSV(textField_MSV1.getText());
				String maMH = textField_maMHQLSV.getText();
				try {
			        double diem = Double.valueOf(textField_NhapDiem.getText());
			        if(sv.nhapDiem(maMH, diem)==0) {
					    JOptionPane.showMessageDialog(null,"Nhập điểm cho môn học thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					    capNhatBangMHDaDagKi();
				    }else if(sv.nhapDiem(maMH, diem)==1) {
					    JOptionPane.showMessageDialog(null,"Không thể nhập điểm vì không tìm thấy môn học mà sinh viên đăng kí", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				    }
			    } catch (NumberFormatException ex) {
			    	JOptionPane.showMessageDialog(null,"Nhập điểm không hợp lệ,chỉ được nhập số", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			    }
			}
		});
		btnLuuDiemchoMH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLuuDiemchoMH.setBounds(888, 435, 96, 36);
		QLSV.add(btnLuuDiemchoMH);
		
		//xu ly su kien xoa form cho quan ly 1 sinh vien
		JButton btnResetQLSV = new JButton("Reset");
		btnResetQLSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_NhapDiem.setText("");
				textField_maMHQLSV.setText("");
			}
		});
		btnResetQLSV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnResetQLSV.setBounds(888, 521, 96, 36);
		QLSV.add(btnResetQLSV);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tổng tiền :");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(922, 383, 106, 36);
		QLSV.add(lblNewLabel_2_1_1);
		
		textField_TongTien = new JTextField();
		textField_TongTien.setColumns(10);
		textField_TongTien.setBounds(1005, 383, 192, 31);
		QLSV.add(textField_TongTien);
		
		JLabel lblQunLSinh = new JLabel("Quản Lý Sinh Viên:");
		lblQunLSinh.setBounds(21, 344, 170, 30);
		JPSinhVien.add(lblQunLSinh);
		
		JLabel lblMSinhVin = new JLabel("Mã Sinh Viên:");
		lblMSinhVin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMSinhVin.setBounds(57, 385, 160, 30);
		JPSinhVien.add(lblMSinhVin);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 331, 1280, 2);
		JPSinhVien.add(separator_1_1);
		
		textField_MSV2 = new JTextField();
		textField_MSV2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_MSV2.setColumns(10);
		textField_MSV2.setBounds(200, 385, 114, 25);
		JPSinhVien.add(textField_MSV2);
		
		JLabel lblHVTn = new JLabel("Họ và Tên:");
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHVTn.setBounds(385, 385, 160, 30);
		JPSinhVien.add(lblHVTn);
		
		textField_HvT = new JTextField();
		textField_HvT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_HvT.setColumns(10);
		textField_HvT.setBounds(515, 385, 168, 25);
		JPSinhVien.add(textField_HvT);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiiTnh.setBounds(729, 385, 160, 30);
		JPSinhVien.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgySinh.setBounds(57, 426, 160, 30);
		JPSinhVien.add(lblNgySinh);
		
		textField_NS = new JTextField();
		textField_NS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_NS.setColumns(10);
		textField_NS.setBounds(200, 426, 114, 25);
		JPSinhVien.add(textField_NS);
		
		JLabel lblHVTn_1 = new JLabel("Lớp Học:");
		lblHVTn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHVTn_1.setBounds(385, 426, 160, 30);
		JPSinhVien.add(lblHVTn_1);
		
		textField_LH = new JTextField();
		textField_LH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_LH.setColumns(10);
		textField_LH.setBounds(515, 426, 69, 25);
		JPSinhVien.add(textField_LH);
		
		JLabel lblHVTn_1_1 = new JLabel("Điểm Trung Bình:");
		lblHVTn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHVTn_1_1.setBounds(729, 426, 160, 30);
		JPSinhVien.add(lblHVTn_1_1);
		
		textField_ĐTb = new JTextField();
		textField_ĐTb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_ĐTb.setColumns(10);
		textField_ĐTb.setBounds(911, 426, 69, 25);
		JPSinhVien.add(textField_ĐTb);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 467, 1280, 2);
		JPSinhVien.add(separator_1_1_1);
		
		// xu ly su kien them sinh vien
		JButton btnNewButton_4 = new JButton("Thêm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msv = textField_MSV2.getText();
				String HvT =textField_HvT.getText();
				String NS = textField_NS.getText();
				String LH = textField_LH.getText();
				Boolean gt;
				String queQuan = (String)comboBox.getSelectedItem();
				if (RdbtNam.isSelected()) {
				    gt= true;
				} else if (rdbtNu.isSelected()) {
				    gt= false;
				}else {
					gt= null;
				}
				if(msv.equals("") || HvT.equals("") || NS.equals("") || LH.equals("") || textField_ĐTb.getText().equals("") || gt == null || queQuan.equals("")) {
				    JOptionPane.showMessageDialog(null,"Không được để trống thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
				    try {
				        Double dtb = Double.valueOf(textField_ĐTb.getText());
				        SinhVien sv = new SinhVien(msv, HvT, LH, dtb, NS, gt,queQuan);
				        qlsvModel.themSinhVien(sv);
				    } catch (NumberFormatException ex) {
				        JOptionPane.showMessageDialog(null,"Nhập điểm không hợp lệ,chỉ được nhập số", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				    }
				}

			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_4.setBounds(57, 518, 155, 62);
		JPSinhVien.add(btnNewButton_4);
		
		
		//xu ly su kien xoa sinh vien
		JButton btnNewButton_4_1 = new JButton("Xóa");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qlsvModel.xoaSinhVien(textField_MSV2.getText());
			}
		});
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_4_1.setBounds(323, 518, 155, 62);
		JPSinhVien.add(btnNewButton_4_1);
		
		
		//xu ly su kien sua sinh vien
		JButton btnNewButton_4_2 = new JButton("Sửa");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinhVien sv = qlsvModel.TimKiemSV(textField_MSV2.getText());
				if(sv!=null) {
					//hien thi thong tin sinh vien lên textField
					textField_HvT.setText(sv.getTenSV());
					textField_NS.setText(sv.getSinhNhat());
					textField_LH.setText(sv.getLopHoc());
					textField_ĐTb.setText(String.valueOf(sv.getDiemTb()));
					RdbtNam.setSelected(sv.getGioiTinh());
					rdbtNu.setSelected(!sv.getGioiTinh());
					comboBox.setSelectedItem(sv.getQueQuan());
				}else {
					JOptionPane.showMessageDialog(null,"Không tìm thấy sinh viên có mã: "+ textField_MSV2.getText(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_4_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_4_2.setBounds(581, 518, 155, 62);
		JPSinhVien.add(btnNewButton_4_2);
		
		
		//xu ly su kien reset
		JButton btnNewButton_4_3 = new JButton("Reset");
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaForm();   
			}
		});
		btnNewButton_4_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_4_3.setBounds(1087, 518, 155, 62);
		JPSinhVien.add(btnNewButton_4_3);
		
		
		// xu ly su kien luu cho nut sua sinh vien
		JButton btnNewButton_4_4 = new JButton("Lưu");
		btnNewButton_4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSV = textField_MSV2.getText();
				String HvT =textField_HvT.getText();
				String NS = textField_NS.getText();
				String LH = textField_LH.getText();
				String queQuan = (String) comboBox.getSelectedItem();

				Boolean gt;
				if (RdbtNam.isSelected()) {
				    gt= true;
				} else if (rdbtNu.isSelected()) {
				    gt= false;
				}else {
					gt= null;
				}
				if(maSV.equals("") || HvT.equals("") || NS.equals("") || LH.equals("") || textField_ĐTb.getText().equals("") || gt == null || queQuan.equals("")) {
				    JOptionPane.showMessageDialog(null,"Không được để trống thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
				    try {
				        Double dtb = Double.valueOf(textField_ĐTb.getText());
				        SinhVien sv = new SinhVien(maSV, HvT, LH, dtb, NS, gt,queQuan);
				        qlsvModel.suaSinhVien(maSV, sv);
				    } catch (NumberFormatException ex) {
				        JOptionPane.showMessageDialog(null,"Nhập điểm không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				    }
				}
			}
		});
		btnNewButton_4_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_4_4.setBounds(841, 518, 155, 62);
		JPSinhVien.add(btnNewButton_4_4);
		
	    RdbtNam = new JRadioButton("Nam");
		RdbtNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		RdbtNam.setBounds(833, 385, 88, 23);
		JPSinhVien.add(RdbtNam);
		
		rdbtNu = new JRadioButton("Nữ");
		rdbtNu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtNu.setBounds(923, 385, 78, 23);
		JPSinhVien.add(rdbtNu);
		
		btg_gioiTinh = new ButtonGroup();
		btg_gioiTinh.add(RdbtNam);
		btg_gioiTinh.add(rdbtNu);
		
		String[] arr_tenTinh = {"","An Giang",
				"Bà Rịa – Vũng Tàu",
				"Bạc Liêu",
				"Bắc Giang",
				"Bắc Kạn",
				"Bắc Ninh",
				"Bến Tre",
				"Bình Dương",
				"Bình Định",
				"Bình Phước",
				"Bình Thuận",
				"Cà Mau",
				"Cao Bằng",
				"Cần Thơ",
				"Đà Nẵng",
				"Đắk Lắk",
				"Đắk Nông",
				"Điện Biên",
				"Đồng Nai",
				"Đồng Tháp",
				"Gia Lai",
				"Hà Giang",
				"Hà Nam",
				"Hà Nội",
				"Hà Tĩnh",
				"Hải Dương",
				"Hải Phòng",
				"Hậu Giang",
				"Hòa Bình",
				"Thành phố Hồ Chí Minh",
				"Hưng Yên",
				"Khánh Hòa",
				"Kiên Giang",
				"Kon Tum",
				"Lai Châu",
				"Lạng Sơn",
				"Lào Cai",
				"Lâm Đồng",
				"Long An",
				"Nam Định",
				"Nghệ An",
				"Ninh Bình",
				"Ninh Thuận",
				"Phú Thọ",
				"Phú Yên",
				"Quảng Bình",
				"Quảng Nam",
				"Quảng Ngãi",
				"Quảng Ninh",
				"Quảng Trị",
				"Sóc Trăng",
				"Sơn La",
				"Tây Ninh",
				"Thái Bình",
				"Thái Nguyên",
				"Thanh Hóa",
				"Thừa Thiên Huế",
				"Tiền Giang",
				"Trà Vinh",
				"Tuyên Quang",
				"Vĩnh Long",
				"Vĩnh Phúc",
				"Yên Bái"};
		comboBox = new JComboBox<>(arr_tenTinh);
		comboBox.setBounds(1138, 385, 120, 25);
		JPSinhVien.add(comboBox);
		
		JLabel lblQuQun = new JLabel("Quê quán:");
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuQun.setBounds(1022, 385, 160, 30);
		JPSinhVien.add(lblQuQun);
		
		
		// màn hình đăng nhập hiển thị đầu tiên
		JPanel MhDagNhap = new JPanel();
		contentPane.add(MhDagNhap, "Đăng nhập");
		MhDagNhap.setBounds(0, 0, 1280, 720);
		//MhDagNhap.setBorder(new EmptyBorder(5, 5, 5, 5));
		MhDagNhap.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Đăng nhập quản lý sinh viên");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_7.setBounds(333, 127, 760, 111);
		MhDagNhap.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tên Đăng Nhập :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(418, 266, 171, 50);
		MhDagNhap.add(lblNewLabel_8);
		
		textField_TenDagNhap = new JTextField();
		textField_TenDagNhap.setBounds(609, 266, 241, 43);
		MhDagNhap.add(textField_TenDagNhap);
		textField_TenDagNhap.setColumns(10);
		
		JLabel lblNewLabel_8_1 = new JLabel("Mật Khẩu :");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8_1.setBounds(418, 343, 171, 50);
		MhDagNhap.add(lblNewLabel_8_1);
		
		textField_MatKhau = new JTextField();
		textField_MatKhau.setColumns(10);
		textField_MatKhau.setBounds(609, 350, 241, 43);
		MhDagNhap.add(textField_MatKhau);
		
		// xu ly su kien dang nhap
		JButton btnDagNhap = new JButton("Đăng Nhập  ");
		btnDagNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenDN = textField_TenDagNhap.getText();
				String mk = textField_MatKhau.getText();
				if(tenDN.equals(getTenDangNhap()) && mk.equals(getMatkhau())) {
					cardLayout.show(contentPane,"Sinh Viên");
					setJMenuBar(null);
					setJMenuBar(menuBar);
				}else {
					JOptionPane.showMessageDialog(MhDagNhap, "Tên đăng nhập hoặc mật khẩu không chính xác!", "Lỗi Đăng Nhập", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnDagNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDagNhap.setBounds(560, 417, 165, 43);
		MhDagNhap.add(btnDagNhap);
		cardLayout.show(contentPane,"Đăng nhập");
		
		
	}

	//xoa textField sinh vien
	public void xoaForm() {
		textField_MSV1.setText("");
		textField_dTb.setText("");
		textField_MSV2.setText("");
		textField_HvT.setText("");
		textField_NS.setText("");
		textField_LH.setText("");
		textField_ĐTb.setText("");
		btg_gioiTinh.clearSelection();
		comboBox.setSelectedItem("");
		
	}
	
	// xoa textField mon hoc
	public void xoaForm1() {
		textField_maMH1.setText("");
	    textField_maMH2.setText("");
	    textField_tenMH.setText("");
	    textField_giaMH.setText("");
	    textField_sTc.setText("");
	}
	
	// hien thi danh sach mon hoc len bang
	public void capNhatBangMH() {
	    DefaultTableModel model = (DefaultTableModel) tableMH3.getModel();
	    model.setRowCount(0); // Xóa tất cả các hàng hiện có
        
	    int stt = 1;
	    for (MonHoc mh : qlmhModel.getDanhSachMH()) {
	        model.addRow(new Object[]{
	            stt++,
	            mh.getTenMh(),
	            mh.getMaMh(),
	            mh.getSoTc(),
	            mh.getGiaMH() +" VND"
	        });
	    }
	}
	
	// hien thi danh sach mon hoc len bang cac mon hoc hien dang mo
		public void capNhatBangMHHienDagMo() {
		    DefaultTableModel model = (DefaultTableModel) tableMH2.getModel();
		    model.setRowCount(0); // Xóa tất cả các hàng hiện có
	        
		    int stt = 1;
		    for (MonHoc mh : qlmhModel.getDanhSachMH()) {
		        model.addRow(new Object[]{
		            stt++,
		            mh.getTenMh(),
		            mh.getMaMh(),
		            mh.getSoTc(),
		            mh.getGiaMH() +" VND"
		        });
		    }
		}
		
	//hien thi danh sach mon hoc da dang ki len bang
		public void capNhatBangMHDaDagKi() {
		    DefaultTableModel model = (DefaultTableModel) tableMH1.getModel();
		    model.setRowCount(0); // Xóa tất cả các hàng hiện có
	        
		    SinhVien sv = qlsvModel.TimKiemSV(textField_MSV1.getText());
		    int stt = 1;
		    for (MonHoc mh : sv.getDanhSachMHdaDagKi()) {
		    	String diem = (mh.getDiemMh()<=-1 || mh.getDiemMh()>10) ? ("Chưa có") : (mh.getDiemMh()+"");
		        model.addRow(new Object[]{
		            stt++,
		            mh.getTenMh(),
		            mh.getMaMh(),
		            diem,
		            mh.getSoTc(),
		            mh.getGiaMH() +" VND"
		        });
		    }
		}
		
	//hien thi bảng về trống thông tin
	public void capNhapBangTrong() {
		DefaultTableModel model1 = (DefaultTableModel) tableMH1.getModel();
		model1.setRowCount(0);
		
		DefaultTableModel model2 = (DefaultTableModel) tableMH2.getModel();
		model2.setRowCount(0);
	}
	
	// hien thi 1 mon học len bang
	public void capNhapBangCo1MonHoc(MonHoc mh) {
		 DefaultTableModel model = (DefaultTableModel) tableMH3.getModel();
		    model.setRowCount(0); // Xóa tất cả các hàng hiện có
		       if(mh!=null) {
		        model.addRow(new Object[]{
		            1,
		            mh.getTenMh(),
		            mh.getMaMh(),
		            mh.getSoTc(),
		            mh.getGiaMH()
		        });
		    } else {
		    	model.setRowCount(0); // Xóa tất cả các hàng hiện có
		        JOptionPane.showMessageDialog(null,"Không tìm thấy môn học có mã: " + textField_maMH1.getText(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		    }
	}
	
	// hien thi danh sach sinh vien len bang
		public void capNhatBangSV() {
		    DefaultTableModel model = (DefaultTableModel) tableSV.getModel();
		    model.setRowCount(0); // Xóa tất cả các hàng hiện có

		    int stt = 1;
		    for (SinhVien sv : qlsvModel.getDanhSachSV()) {
		    	String gioiTinh = sv.getGioiTinh() ? "Nam" : "Nữ";
		        model.addRow(new Object[]{
		            stt++,
		            sv.getMaSV(),
		            sv.getTenSV(),
		            sv.getLopHoc(),
		            sv.getDiemTb(),
		            sv.getQueQuan(),
		            sv.getSinhNhat(),
		            gioiTinh
		        });
		    }
		}
	
	//hien thi 1 sinh vien len bang
	public void capNhapBangCo1SinhVien(SinhVien sv) {
	    DefaultTableModel model = (DefaultTableModel) tableSV.getModel();
	    model.setRowCount(0); // Xóa tất cả các hàng hiện có

	    if (sv != null) {
	        String gioiTinh = sv.getGioiTinh() ? "Nam" : "Nữ";
	        
	        model.addRow(new Object[]{
	            1,
	            sv.getMaSV(),
	            sv.getTenSV(),
	            sv.getLopHoc(),
	            sv.getDiemTb(),
	            sv.getQueQuan(),
	            sv.getSinhNhat(),
	            gioiTinh
	        });
	    } else {
	    	model.setRowCount(0); // Xóa tất cả các hàng hiện có
	        JOptionPane.showMessageDialog(null,"Không tìm thấy sinh viên có mã: " + textField_MSV1.getText(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        
	    }
	}
	
	
	
	
	
}
