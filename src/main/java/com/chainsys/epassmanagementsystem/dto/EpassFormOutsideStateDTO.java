package com.chainsys.epassmanagementsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.epassmanagementsystem.model.EpassForm;
import com.chainsys.epassmanagementsystem.model.OutsideState;
import com.chainsys.epassmanagementsystem.model.Passengers;

public class EpassFormOutsideStateDTO {

	private EpassForm epassForm;
	private OutsideState outsideState;
	
	public EpassForm getEpassForm() {
		return epassForm;
	}
	public void setEpassForm(EpassForm epassForm) {
		this.epassForm = epassForm;
	}
	public OutsideState getOutsideState() {
		return outsideState;
	}
	public void setOutsideState(OutsideState outsideState) {
		this.outsideState = outsideState;
	}
	
	private List<Passengers> passengersList = new ArrayList<>();
	public void addPassengers(Passengers passengers) {
		passengersList.add(passengers);
	}

	public List<Passengers> getPassengers() {
		return passengersList;
	}
	
	public void setPassengers(List<Passengers> passengersList) {
		this.passengersList = passengersList;
	}
}
