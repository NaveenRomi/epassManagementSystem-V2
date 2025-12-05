package com.chainsys.epassmanagementsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chainsys.epassmanagementsystem.model.Admin;
import com.chainsys.epassmanagementsystem.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Transactional
	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

	public List<Admin> getRequests() {
		return adminRepository.findAll();
	}

	public Admin findById(String adminid) {
		return adminRepository.findByAdminId(adminid);
	}

	@Transactional
	public void deleteById(String adminid) {
		adminRepository.deleteByAdminId(adminid);
	}
	
	public Admin getAdminByIdAndPassword(String adminId, String adminPassword) {
		return adminRepository.findByAdminIdAndAdminPassword(adminId,adminPassword);
	}

}
