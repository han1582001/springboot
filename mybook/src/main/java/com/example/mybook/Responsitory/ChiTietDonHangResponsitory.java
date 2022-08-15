package com.example.mybook.Responsitory;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mybook.entities.chitietdonhangEntity;

public interface ChiTietDonHangResponsitory extends JpaRepository<chitietdonhangEntity, Integer> {
	@Query("Select e from chitietdonhangEntity e where e.iddonghang=?1")
	List<chitietdonhangEntity> getChiTietDonHang(int iddonhang);
	
}
