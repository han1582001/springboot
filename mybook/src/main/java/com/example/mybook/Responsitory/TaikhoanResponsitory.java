package com.example.mybook.Responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.mybook.entities.taikhoanEntity;

public interface TaikhoanResponsitory extends JpaRepository<taikhoanEntity, Integer> {
	@Query("Select p from taikhoanEntity p where p.tendangnhap=:username")
	List<taikhoanEntity> findByTenDangNhap(@Param("username") String tendangnhap);
@Query("select count(e) from taikhoanEntity e where e.tendangnhap=?1")
long countTendangnhap(String tendangnhap);
@Query("select count(e) from taikhoanEntity e where e.email=?1")
long countEmail(String email);
@Query("select count(e) from taikhoanEntity e where e.sdt=?1")
long countSDT(int sdt);
@Query("select e from taikhoanEntity e where tendangnhap=?1")
List<taikhoanEntity> getPrin(String s);
}
