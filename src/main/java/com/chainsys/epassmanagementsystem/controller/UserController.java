package com.chainsys.epassmanagementsystem.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.chainsys.epassmanagementsystem.commonutil.InvalidInputDataException;
import com.chainsys.epassmanagementsystem.model.EpassForm;
import com.chainsys.epassmanagementsystem.model.User;
import com.chainsys.epassmanagementsystem.service.EpassFormService;
import com.chainsys.epassmanagementsystem.service.UserService;

@Controller
@RequestMapping("/home")
public class UserController {

	public static final String LOGIN="user-login";
	public static final String ADDUSER="add-user-form";
	public static final String USERID="userId";
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
	public UserService userService;
	@Autowired
	public EpassFormService epassFormService;

//	home page
	@GetMapping("/index")
	public String home() {
		return "home";
	}

//	user add form
	@GetMapping("/adduserform")
	public String showRegisterForm(Model model) {
		User user = new User();
		model.addAttribute("adduser", user);
		return ADDUSER;
	}

	@PostMapping("/adduser")
	public String addUserValidation(@ModelAttribute("adduser") User user,Model model) {
		User user1=userService.getByUserId(user.getUserId());
		try {
			if (user1 != null) {
				throw new InvalidInputDataException("* Username already exists");
			}
		}catch (InvalidInputDataException exception) {
				model.addAttribute("error", exception.getMessage());
				model.addAttribute("message", "Try different username");
				return ADDUSER;
			} 
		userService.save(user);
		return "user-registered";
	}

//	 user update
	@GetMapping("/updateuserform")
	public String showUpdateForm(Model model){
        model.addAttribute("updateuser", new User());
		return "update-user-form";
	}

	@PostMapping("/updateuser")
	public String updateUser(@ModelAttribute("updateuser") User user) {
		userService.save(user);
		return "redirect:/home/userloggedin";
	}

//	user login
	@GetMapping("/userloginform")
	public String userLoginForm(Model model) {
		model.addAttribute("userlogin", new User());
		return LOGIN;
	}

	@GetMapping("/userloggedin")
	public String userLoggedIn(Model model) {
        if (!model.containsAttribute(GlobalModelAttributes.USERID))
            return "home";
        return "user-logged-in";
    }
	
	@PostMapping("/userlogin")
	public String userLogin(@ModelAttribute("userlogin") User user,Model model, HttpServletRequest request) {
		User user1 = userService.getUserByIdAndPassword(user.getEmail(), user.getUserPassword());
        try {
		    if (user1 == null)
			    throw new InvalidInputDataException("No matching data found");
		}
		catch (InvalidInputDataException exception) {
			model.addAttribute("error", exception.getMessage());
			model.addAttribute("message", "Email or Password is incorrect");
            log.error("Error fetching for userid", user.getEmail(), exception.getMessage());
            return LOGIN;
		}

        HttpSession old = request.getSession(false);
        if (old != null) old.invalidate();
        HttpSession session = request.getSession(true);
        log.info("User login {} ",user1);
        session.setAttribute("userId", user1.getUserId());
        session.setAttribute("username", user1.getFirstName()+" "+user1.getLastName()); // if available
        session.setAttribute("email", user1.getEmail());
        return "redirect:/home/userloggedin";
	}

	@GetMapping("/epassapplicationstatus")
	public String userApplicationStatus(Model model) {
        Integer userIdInt = (Integer) model.getAttribute(GlobalModelAttributes.USERID);
        String userId = (userIdInt != null) ? String.valueOf(userIdInt) : null;
        List<EpassForm> epassForm = (userId != null)
                ? epassFormService.findByUserId(userId)
                : Collections.emptyList();
        model.addAttribute("epassForm", epassForm);
		return "user-application-status";
	}

	@GetMapping("/logout")
	 public String logout(HttpSession httpSession){
         httpSession.invalidate();
         return "redirect:/home/index";
     }
}