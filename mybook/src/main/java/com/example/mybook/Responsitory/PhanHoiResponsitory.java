package com.example.mybook.Responsitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mybook.entities.phanhoiEntity;

public interface PhanHoiResponsitory extends JpaRepository<phanhoiEntity, Integer> {
	@Query("select e from phanhoiEntity e")
	Page<phanhoiEntity> getMessages(Pageable pageable);

}
