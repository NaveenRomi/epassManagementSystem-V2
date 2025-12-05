package com.chainsys.epassmanagementsystem.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.chainsys.epassmanagementsystem.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	User save(User user);

	Optional<User> findById(String userid);

	void deleteById(String userId);

	List<User> findAll();

	User findByEmailAndUserPassword(String email, String userPassword);

	User findByUserIdAndEmail(String userId, String email);

	User findByEmail(String email);

	User findByUserId(String userId);
	
}
