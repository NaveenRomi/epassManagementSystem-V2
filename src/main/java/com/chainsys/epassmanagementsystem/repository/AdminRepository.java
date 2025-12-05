package com.chainsys.epassmanagementsystem.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chainsys.epassmanagementsystem.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {
	Admin save(Admin admin);

	void deleteByAdminId(String adminId);

	List<Admin> findAll();

	Admin findByAdminId(String adminId);

	Admin findByAdminIdAndAdminPassword(String adminId, String adminPassword);
}
