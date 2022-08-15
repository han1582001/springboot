package com.example.mybook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mybook.Responsitory.SachResponsitory;
import com.example.mybook.Responsitory.TacgiaResponsitory;
import com.example.mybook.Responsitory.TaikhoanResponsitory;
import com.example.mybook.Responsitory.TheloaiResponsitory;
import com.example.mybook.entities.sachEntity;
import com.example.mybook.entities.tacgiaEntity;
import com.example.mybook.entities.taikhoanEntity;
import com.example.mybook.entities.theloaiEntity;
import com.example.mybook.model.SachInfo;

public class SachService {
	@Autowired
private static SachResponsitory sachResponsitory;
	@Autowired
private static TheloaiResponsitory theloaiResponsitory;
	@Autowired
private static TacgiaResponsitory tacgiaResponsitory;
	@Autowired
private static TaikhoanResponsitory taikhoanResponsitory;
	public static SachInfo layThongTinSachTheoID(int id) {
		Optional<sachEntity> sachEn=sachResponsitory.findById(id);
		SachInfo sachInfo=new SachInfo();
		if(sachEn.isPresent()) {
			Optional<tacgiaEntity> tg=tacgiaResponsitory.findById(sachEn.get().getTacgia());
			if(tg.isPresent()) {
				Optional<theloaiEntity> tl=theloaiResponsitory.findById(sachEn.get().getTheloai());
				if(tl.isPresent()) {
					Optional<taikhoanEntity> tk2=taikhoanResponsitory.findById(sachEn.get().getNguoidang());
					if(tk2.isPresent()) {
					
			sachInfo.setId(sachEn.get().getId());
			sachInfo.setTacgia(tg.get().getTentacgia());
			sachInfo.setNxb(sachEn.get().getNxb());
			sachInfo.setTheloai(tl.get().getTentheloai());
			sachInfo.setGia(sachEn.get().getGia());
			sachInfo.setNoidung(sachEn.get().getNoidung());
			sachInfo.setSoluong(sachEn.get().getSoluong());
			sachInfo.setNguoidang(tk2.get().getHovaten());
			sachInfo.setThoigiandang(sachEn.get().getThoigiandang());
			sachInfo.setAnh(sachEn.get().getAnh());
			
					}
				}
			
			}
		
			return sachInfo;
		}
		return sachInfo;
	}

}
