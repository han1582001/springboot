package com.example.mybook.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybook.entities.taikhoanEntity;

@Repository
@Transactional
public class UserDAO {
	@Autowired
	private EntityManager entityManager;
	public taikhoanEntity findTaiKhoan(String username) {
		try {
			String sql="Select e from "+ taikhoanEntity.class.getName()+"e"+"Where e.username=:username";
			Query query= entityManager.createQuery(sql,taikhoanEntity.class);
			query.setParameter("username", username);
			return (taikhoanEntity) query.getSingleResult();
		}catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}

}
