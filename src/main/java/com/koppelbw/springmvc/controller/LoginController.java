package com.koppelbw.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.service.CustomerService;

@Controller
public class LoginController {

	@Autowired
	private CustomerService customerServices;

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userId,
			@RequestParam String password, HttpSession session, Model model) {
		
		
		Customer customer = customerServices.loginCustomer(userId, password);
		if (customer == null) {
			model.addAttribute("loginError", "Error logging in. Please try again");
			return "login";
		} else {
			session.setAttribute("loggedInUser", customer);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "home";
	}
}
