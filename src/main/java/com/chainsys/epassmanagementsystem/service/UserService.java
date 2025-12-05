package com.chainsys.epassmanagementsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chainsys.epassmanagementsystem.model.User;
import com.chainsys.epassmanagementsystem.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	public User getByUserIdAndEmail(String userId,String email) {
		return userRepository.findByUserIdAndEmail(userId,email);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUserByIdAndPassword(String userId, String userPassword) {
		return userRepository.findByEmailAndUserPassword(userId, userPassword);
	}
	
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User getByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
}