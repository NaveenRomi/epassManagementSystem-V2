package com.chainsys.epassmanagementsystem.businesslogic;

import java.time.LocalDate;

public class Logic {
	
	private Logic(){
	}
	
	public static LocalDate getInstanceDate() {
		return java.time.LocalDate.now();
	}

	public static LocalDate getMinusDate() {
		LocalDate date = LocalDate.now();
		return date.minusDays(1);
	}
	
	public static LocalDate getMinusYear() {
		LocalDate date = LocalDate.now();
		return date.minusYears(15);
	}
	
	public static LocalDate getAddDate() {
		LocalDate date = LocalDate.now();
		return date.plusDays(1);
	}
	
}
