package com.chainsys.epassmanagementsystem.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chainsys.epassmanagementsystem.model.EpassForm;

@Repository
public interface EpassFormRepository extends CrudRepository<EpassForm, Integer> {

	EpassForm save(EpassForm epassForm);

	List<EpassForm> findAll();

	EpassForm findById(int epassId);
	
	List<EpassForm> findByUserId(String userId);

	void deleteById(int epassId);

	List<EpassForm> findByUserUserId(int userId);

	List<EpassForm> findByApprovalStatus(String status);
}
