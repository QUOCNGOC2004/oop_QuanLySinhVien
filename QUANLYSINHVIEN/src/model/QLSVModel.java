package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.QLSVView;

import java.util.Iterator;
public class QLSVModel implements Iterable<SinhVien>,Serializable {
    private List<SinhVien> danhSachSV;
    private QLSVView qlsvView;

    public QLSVModel(QLSVView qlsvView) {
        danhSachSV = new ArrayList<>();
        this.qlsvView= qlsvView;
    }
    
    
    // Thêm sinh viên
    public void themSinhVien(SinhVien sv) {
        for (SinhVien sinhVienHienTai : danhSachSV) {
            if (sinhVienHienTai.getMaSV().equals(sv.getMaSV())) {
                JOptionPane.showMessageDialog(null, "Không thể thêm sinh viên do trùng mã sinh viên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return ;
            }
        }
        danhSachSV.add(sv);
        JOptionPane.showMessageDialog(null, "Thêm sinh viên thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    

    // Sửa thông tin sinh viên
    public void suaSinhVien(String maSV, SinhVien svMoi) {
        for (int i = 0; i < danhSachSV.size(); i++) {
            SinhVien sv = danhSachSV.get(i);
            if (sv.getMaSV().equals(maSV)) {
                danhSachSV.set(i, svMoi);
                JOptionPane.showMessageDialog(null, "Đã sửa sinh viên có mã : "+ maSV, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Sai mã sinh viên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    

    // Xóa sinh viên
    public void xoaSinhVien(String maSV) {
        for(int i=0;i<danhSachSV.size();i++){
            SinhVien sv = danhSachSV.get(i);
            if(sv.getMaSV().equals(maSV)){
                danhSachSV.remove(i);
                JOptionPane.showMessageDialog(null,"Đã xóa sinh viên có mã: " + maSV, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
             
        }
        JOptionPane.showMessageDialog(null,"Mã sinh viên không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
      }

    
    //Loc sinh vien co diem trung binh >n
 	public void locDiemTb(double n) {
 	    DefaultTableModel model = (DefaultTableModel) qlsvView.tableSV.getModel();
 	    model.setRowCount(0); // Xóa tất cả các hàng hiện có

 	    int stt = 1;
 	    for (SinhVien sv : getDanhSachSV()) {
 	    	if(sv.getDiemTb()>n) {
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
 	    if(stt==1) JOptionPane.showMessageDialog(null,"Không có sinh viên nào có điểm trung bình lớn hơn: "+n, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
 	}

    //tim kiem sinh vien
    public SinhVien TimKiemSV(String maSV){
        for(SinhVien i : danhSachSV){
            if(i.getMaSV().equals(maSV)){
                return i;
            }
        }
        return null;
    }

    // phuong thuc tra ve danh sach sinh vien
    @Override
    public Iterator<SinhVien> iterator() {
        return danhSachSV.iterator();
    }
    
    public List<SinhVien> getDanhSachSV() {
        return danhSachSV;
    }

    public void setDanhSachSV(List<SinhVien> danhSachSV) {
		this.danhSachSV = danhSachSV;
	}


	// lay size danh sach sinh vien
    public int getSizeDsSv(){
        return danhSachSV.size();
    }

    
}