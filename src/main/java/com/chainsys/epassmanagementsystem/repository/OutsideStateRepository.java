package com.chainsys.epassmanagementsystem.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chainsys.epassmanagementsystem.model.OutsideState;

@Repository
public interface OutsideStateRepository extends CrudRepository<OutsideState, Integer>{

	OutsideState save(OutsideState user);
	OutsideState findById(int districtId);
	List<OutsideState> findOutsideStateByEpassId(int id);
	List<OutsideState> findAll();
}
