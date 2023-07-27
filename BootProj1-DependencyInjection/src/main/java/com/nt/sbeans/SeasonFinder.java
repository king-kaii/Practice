package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Spring Bean Class
@Component("sf")
public class SeasonFinder {

	// DependencyInjection
	// Bean Properties
	@Autowired
	private LocalDate ldt;

	// b.logic
	public String seasonFinder() {

		// Get the Current Month Number
		int month = ldt.getMonthValue();

		if (month > 3 && month < 7) {
			return "Summer Season";
		}

		else if (month > 7 && month < 10) {
			return "Rainy Season";
		} else {
			return "Winter Season";
		}
	}//b.logic close
}//main close
