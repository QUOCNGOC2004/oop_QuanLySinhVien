package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class SinhVien implements Serializable{
    private String maSV;
    private String tenSV;
    private String lopHoc;
    private double diemTb;
    private String SinhNhat;
    private Boolean GioiTinh;
    private String queQuan;
    private List<MonHoc> mhDaDangKi;
   

	// Constructor
    public SinhVien(String maSV, String tenSV, String lopHoc,double diemTb,String SinhNhat,Boolean GioiTinh,String queQuan) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.lopHoc = lopHoc;
        this.diemTb= diemTb;
        this.SinhNhat=SinhNhat;
        this.GioiTinh=GioiTinh;
        this.queQuan= queQuan;
        this.mhDaDangKi = new ArrayList<>();

    }
// Getters và Setters
    public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public void setDiemTb(double diemTb){
        this.diemTb=diemTb;
    }

    public double getDiemTb(){
        return diemTb;
    }

    public String getSinhNhat(){
        return SinhNhat;
    }

    public void setSinhNhat(String SinhNhat){
        this.SinhNhat=SinhNhat;
    }

    public Boolean getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	
	 public List<MonHoc> getDanhSachMHdaDagKi() {
	        return mhDaDangKi;
	    }
	 
	 public void setMhDaDangKi(List<MonHoc> mhDaDangKi) {
			this.mhDaDangKi = mhDaDangKi;
		}
	
	 
	 
    //lay size danh sach mon hoc da dang ki
    public int getSizeMhDaDki(){
        return mhDaDangKi.size();
    }

    
	//dang ki hoc cho sinh vien
    public int DangKiMonHoc(MonHoc mh){
        for(MonHoc i : mhDaDangKi){
            if(i.getMaMh().equals(mh.getMaMh())){
                return 0;
            }
        }
        MonHoc  mhNew = new MonHoc(mh.getTenMh(),mh.getMaMh(),mh.getDiemMh(),mh.getSoTc(),mh.getGiaMH());
        mhDaDangKi.add(mhNew);
        return 1;
    }

    // nhap diem cho mon hoc da dang ki
    public int nhapDiem(String maMh,double diem){
        for(MonHoc i: mhDaDangKi){
            if(i.getMaMh().equals(maMh)){
                i.setDiemMh(diem);
                return 0;
            }
        }
        return 1;
    }
    
    
    // xóa môn học da dang ki

    public int xoaMonHoc(String maMh){
        boolean ktra = mhDaDangKi.removeIf(mh -> mh.getMaMh().equals(maMh));
        
        if(!ktra){
            return 1;
        }
        else{
            return 0;
        }
    }


    // sửa môn học da dang ki
    public void suaMonHoc(String maMh,MonHoc mhNew){
        for (int i = 0; i < mhDaDangKi.size(); i++) {
            MonHoc mh = mhDaDangKi.get(i);
            if (mh.getMaMh().equals(maMh)) {
                mhDaDangKi.set(i, mhNew);
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"Sai mã môn học,Không thể sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    //kiem tra  1 mon hoc da dang ki chưa 
    public boolean ktraMh(String maMh){
        for(MonHoc i: mhDaDangKi){
            if(i.getMaMh().equals(maMh)){
                return true;
            }
        }
        return false;
    }
    
    //tinh tong gia mon hoc da dang ki
    public double tongGiaMH() {
    	double dem=0;
    	for(MonHoc i : mhDaDangKi) {
    		dem+=i.getGiaMH();
    	}
    	return dem;
    }
    
   
}
