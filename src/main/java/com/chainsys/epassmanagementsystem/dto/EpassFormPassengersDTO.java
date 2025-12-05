package com.chainsys.epassmanagementsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.epassmanagementsystem.model.EpassForm;
import com.chainsys.epassmanagementsystem.model.Passengers;

public class EpassFormPassengersDTO {

	private EpassForm epassForm;
	private List<Passengers> passengersList = new ArrayList<>();

	public EpassForm getEpassForm() {
		return epassForm;
	}

	public void setEpassForm(EpassForm epassForm) {
		this.epassForm = epassForm;
	}

	public void addPassengers(Passengers passengers) {
		passengersList.add(passengers);
	}

	public List<Passengers> getPassengers() {
		return passengersList;
	}
	
	public void setPassengers(List<Passengers> passengersList) {
		this.passengersList = passengersList;
	}
	

	private List<EpassForm> epassList;
	
	public List<EpassForm> getEpassList() {
		return epassList;
	}

	public void setEpassList(List<EpassForm> epassList) {
		this.epassList = epassList;
	}

}