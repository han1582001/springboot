package com.example.mybook.Responsitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mybook.entities.donhangEntity;

public interface DonHangResponsitory extends JpaRepository<donhangEntity, Integer>{
	
	@Query("select e from donhangEntity e where e.idkhachhang=?1 and e.trangthai=0")
	List<donhangEntity> DonHangCho(int id);
	
	@Query("select e from donhangEntity e where e.idkhachhang=?1 and e.trangthai=1")
	List<donhangEntity> DonHangDaGiao(int id);
	@Query("select e from donhangEntity e where e.idkhachhang=?1")
	List<donhangEntity> LichSu(int id);
}
