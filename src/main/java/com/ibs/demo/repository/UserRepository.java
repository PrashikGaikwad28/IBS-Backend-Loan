package com.ibs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibs.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM user WHERE email_id = :emailId", nativeQuery = true)
	public User findByEmailId(@Param("emailId") String emailId);
	
	@Query(value = "SELECT * FROM user WHERE user_name = :userName", nativeQuery = true)
	public User findByUserName(@Param("userName") String userName);
}
