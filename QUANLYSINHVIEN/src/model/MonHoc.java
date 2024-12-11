package model;

import java.io.Serializable;

public class MonHoc implements Serializable {
    private String tenMh;
    private String maMh;
    private double diemMh=-1;
    private int soTc;
    private double giaMH;
    
    // Constructor
    public MonHoc(String tenMh,String maMh,int soTc,double giaMH){
        this.tenMh=tenMh;
        this.maMh=maMh;
        this.soTc=soTc;
        this.giaMH=giaMH;
    }
    public MonHoc(String tenMh,String maMh,double diemMh,int soTc,double giaMH){
        this.tenMh=tenMh;
        this.maMh=maMh;
        this.diemMh=diemMh;
        this.soTc=soTc;
        this.giaMH=giaMH;
    }

    // Getters va Setters
    public int getSoTc() {
		return soTc;
	}
	public void setSoTc(int soTc) {
		this.soTc = soTc;
	}
	public double getGiaMH() {
		return giaMH;
	}
	public void setGiaMH(double giaMH) {
		this.giaMH = giaMH;
	}
	
    public void setTenMh(String tenMh){
        this.tenMh=tenMh;
    }
    public String getTenMh(){
        return tenMh;
    }

    public void setMaMh(String maMh){
        this.maMh=maMh;
    }
    public String getMaMh(){
        return maMh;
    }

    public void setDiemMh(double diemMh){
        this.diemMh=diemMh;
    }
    public double getDiemMh(){
        return diemMh;
    }

}
