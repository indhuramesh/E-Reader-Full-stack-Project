package com.skcet.ereader.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skcet.ereader.Model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	
}
