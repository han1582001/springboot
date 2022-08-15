package com.example.mybook.Responsitory;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mybook.entities.sachEntity;

public interface SachResponsitory extends JpaRepository<sachEntity, Integer>{
@Query("select e from sachEntity e")
Page<sachEntity> getListSach(Pageable pageable); 

@Query("select e from sachEntity e where e.tensach LIKE %?1%")
Page<sachEntity> searchByName(Pageable pageable, String search);

@Query("select count(e) from sachEntity e where e.tensach LIKE %?1%")
int countSearchByName(String search);
@Query("select e from sachEntity e where e.theloai=?1 and e.tensach LIKE %?2%")
Page<sachEntity> getSachTheoTheLoai(Pageable pageable, int id, String key);
@Query("select count(e) from sachEntity e where e.theloai=?1 and e.tensach LIKE %?2%")
int countSachByTheLoai(int i, String key);
@Query("select e from sachEntity e where e.tacgia=?1")
Page<sachEntity> getsachTheoTacGia(Pageable pageable, int id);
@Query("select count(e) from sachEntity e where e.theloai=?1")
int countSachByTheLoai(int i);
@Query("select e from sachEntity e where e.theloai=?1")
Page<sachEntity> getsachTheoTheloai(Pageable pageable, int id);
@Query("select e from sachEntity e where e.theloai=?1")
Page<sachEntity> getSachTheoTheLoai(Pageable pageable, int id);
}