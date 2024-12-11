package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JFileChooser;

import view.QLSVView;

public class FileModel {
	private String tenFile;
	private QLSVView qlsvView;

	public FileModel(QLSVView qlsvView) {
		this.tenFile="";
		this.qlsvView = qlsvView;
	}


	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public void saveFile(String path) {
	    try {
	        this.setTenFile(path);
	        FileOutputStream fos = new FileOutputStream(path);
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(qlsvView.qlsvModel.getDanhSachSV());
	        oos.writeObject(qlsvView.qlmhModel.getDanhSachMH());
	        oos.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void thucHienSaveFile() {
	    JFileChooser fc = new JFileChooser();
	    if(this.getTenFile().length() > 0) {
	        fc.setSelectedFile(new File(this.getTenFile()));
	    }
	    int returnVal = fc.showSaveDialog(qlsvView);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	        File file = fc.getSelectedFile();
	        saveFile(file.getAbsolutePath());
	        this.setTenFile(file.getAbsolutePath());
	    }
	}


    public void openFile(File file) {
		try {
			this.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
            //đọc danh sách sinh viên và lưu vào qlsvModel
			List<SinhVien> danhSachSV = (List<SinhVien>) ois.readObject();
            qlsvView.qlsvModel.setDanhSachSV(danhSachSV);

            // Đọc danh sách môn học và lưu vào qlmhModel
            List<MonHoc> danhSachMh = (List<MonHoc>) ois.readObject();
            qlsvView.qlmhModel.setDanhSachMh(danhSachMh);
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(qlsvView);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
		} 
	}
	
	
}