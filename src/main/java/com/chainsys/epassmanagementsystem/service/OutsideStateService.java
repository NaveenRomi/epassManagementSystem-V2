package com.chainsys.epassmanagementsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chainsys.epassmanagementsystem.model.OutsideState;
import com.chainsys.epassmanagementsystem.repository.OutsideStateRepository;

@Service
public class OutsideStateService {

	@Autowired
	private OutsideStateRepository outsideStateRepository;
	
	public OutsideState findById(int id) {
		return outsideStateRepository.findById(id);
	}
	
	public List<OutsideState> getAllOutsideState() {
		return outsideStateRepository.findAll();
	}
	
	@Transactional
	public OutsideState save(OutsideState outsideState) {
		return outsideStateRepository.save(outsideState);
	}
	
}