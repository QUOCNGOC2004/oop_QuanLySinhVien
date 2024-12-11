package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import view.QLSVView;



public class QLMHModel implements Iterable<MonHoc>,Serializable {
    private List<MonHoc> danhSachMh;
	private QLSVView qlsvView;


    public QLMHModel(QLSVView qlsvView) {
        danhSachMh= new ArrayList<>();
        this.qlsvView= qlsvView;
    }

    //thêm môn học
    public void themMonHoc(MonHoc mh) {
        for (MonHoc mhHienTai : danhSachMh) {
            if (mhHienTai.getMaMh().equals(mh.getMaMh())) {
                JOptionPane.showMessageDialog(null,"Trùng mã môn học,không thể thêm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        danhSachMh.add(mh);
        JOptionPane.showMessageDialog(null,"Thêm môn học thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    // sửa môn học
    public void suaMonHoc(String maMh,MonHoc mhNew){
        for (int i = 0; i < danhSachMh.size(); i++) {
            MonHoc mh = danhSachMh.get(i);
            if (mh.getMaMh().equals(maMh)) {
                danhSachMh.set(i, mhNew);
                JOptionPane.showMessageDialog(null,"Sửa môn học thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
        }
        JOptionPane.showMessageDialog(null,"Sai mã môn học,không thể sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    // xóa môn học

    public void xoaMonHoc(String maMh){
        boolean ktra = danhSachMh.removeIf(mh -> mh.getMaMh().equals(maMh));
        if(!ktra){
        	JOptionPane.showMessageDialog(null,"Không có môn học phù hợp để xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null,"Xóa môn học thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }


    //tim kiem mon hoc
    public MonHoc TimKiemMH(String maMH){
        for(MonHoc i : danhSachMh){
            if(i.getMaMh().equals(maMH)){
                return i;
            }
        }
        return null;
    }
    

    //lay size cua danh sach mon hoc
    public int getSizeDsMh(){
        return danhSachMh.size();
    }

    // phuong thuc tra ve danh sach mon hoc
    @Override
    public Iterator<MonHoc> iterator() {
        return danhSachMh.iterator();
    }
    
    public List<MonHoc> getDanhSachMH() {
        return danhSachMh;
    }
    
    public void setDanhSachMh(List<MonHoc> danhSachMh) {
		this.danhSachMh = danhSachMh;
	}
}
