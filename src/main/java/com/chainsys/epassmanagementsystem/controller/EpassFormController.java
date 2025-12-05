package com.chainsys.epassmanagementsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.epassmanagementsystem.model.EpassForm;
import com.chainsys.epassmanagementsystem.model.OutsideState;
import com.chainsys.epassmanagementsystem.model.Passengers;
import com.chainsys.epassmanagementsystem.service.EpassFormService;
import com.chainsys.epassmanagementsystem.service.OutsideStateService;
import com.chainsys.epassmanagementsystem.service.PassengersService;

import javax.servlet.http.HttpSession;

import static com.chainsys.epassmanagementsystem.controller.GlobalModelAttributes.EPASSID;

@Controller
@RequestMapping("/epass")
public class EpassFormController {

	private static final String ADD = "redirect:/epass/noOfpassengers";
    private static final Logger log = LoggerFactory.getLogger(EpassFormController.class);

    @Autowired
	public EpassFormService epassFormService;

	@Autowired
	public PassengersService passengersService;

	@Autowired
	public OutsideStateService outsideStateService;

	@GetMapping("/epassformtype")
	public String epassFormType() {
        return "epass-form-type";
	}

//  within district
	@GetMapping("/epassformwithindistrict")
	public String epassFormWithinDistrict(Model model) {
		EpassForm epassForm = new EpassForm();
		model.addAttribute("epasswithindistrict", epassForm);
		return "epass-form-within-district";
	}

	@PostMapping("/epassformwithinregistered")
	public String epassFormWithinDistrict( @ModelAttribute("epasswithindistrict") EpassForm epassForm,
			Model model,HttpSession session) {
		epassFormService.save(epassForm);
        session.setAttribute("epassId",epassForm.getEpassId());
		return ADD;
	}
	
// across district
	@GetMapping("/epassformacrossdistrict")
	public String epassFormAcrossDistrict(Model model) {
		EpassForm epassForm = new EpassForm();
		model.addAttribute("epassacrossdistrict", epassForm);
		return "epass-form-across-district";
	}
	@PostMapping("/epassformacrossregistered")
	public String epassFormAcrossDistrict( @ModelAttribute("epassacrossdistrict") EpassForm epassForm, Model model,
                                           HttpSession session) {
		epassFormService.save(epassForm);
        session.setAttribute("epassId",epassForm.getEpassId());
		return  ADD;
	}

//	outside state
	@GetMapping("/epassformoutsidestate")
	public String epassFormOutsideState(Model model) {
		EpassForm epassForm = new EpassForm();
		model.addAttribute("epassoutsidestate", epassForm);
		return "epass-form-outside-state";
	}

	@PostMapping("/epassformoutsidestateregistered")
	public String epassFormOutsideState( @ModelAttribute("epassoutsidestate") 
		EpassForm epassForm, Model model,HttpSession session) {
		epassFormService.save(epassForm);
		OutsideState outsideState = new OutsideState();
        session.setAttribute("epassId",epassForm.getEpassId());
		model.addAttribute("outsidestatedetails", outsideState);
		return "epass-form-outside-state-details";
	}
	@PostMapping("/epassoutsidestate")
	public String addEpasssOutSideState(@ModelAttribute("outsidestatedetails")OutsideState outsideState,Model model,
                                        HttpSession session) {
		outsideStateService.save(outsideState);
        session.setAttribute("epassId",outsideState.getEpassId());
		return  ADD;
	}
//	number of passengers
	@GetMapping("/noOfpassengers")
	public String getpassengersDetails(Model model) {
		Passengers passengers = new Passengers();
		model.addAttribute("epasspassengers", passengers);
		List<Passengers> passengerList=passengersService.getPassengersByEpassid
                ((Integer) model.getAttribute(EPASSID));
		model.addAttribute("passengersList", passengerList);
		return "epass-passengers";
	}

	@PostMapping("/epassregistered")
	public String passengersWithinDistrict(@ModelAttribute("passengerswithindistrict") Passengers passengers,Model model) {
		passengersService.save(passengers);
		List<Passengers>passengerList=passengersService.getPassengersByEpassid
                ((Integer) model.getAttribute(EPASSID));
		model.addAttribute("passengersList", passengerList);
		return  ADD;
	}
	
	@GetMapping("/getResult")
	public String getResult() {
        return "epass-registered";
	}
	
	@GetMapping("/getallpassengers")
	public String getAllPassengers(Model model) {
		List<Passengers> passengersList = passengersService.getPassengers();
		model.addAttribute("allpassengers", passengersList);

        log.info("Fetching passengers for epassId={}", passengersList);
        log.warn("User {} attempted to access unauthorized page {}"," ");
        log.error("Failed to save form: {}", " ");

        return "list-all-passengers";
	}
}