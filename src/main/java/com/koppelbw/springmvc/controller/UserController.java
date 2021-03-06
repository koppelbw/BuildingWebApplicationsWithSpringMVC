package com.koppelbw.springmvc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.service.CustomerService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(/*value = "/users", */params = "register")
	public String createForm(Model model) {
		model.addAttribute("user", new Customer());
		return "user/register";
	}
	
	@RequestMapping(/*value = "/users", */method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Valid Customer customer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/register";
		}
		
		customerService.saveCustomer(customer);
		
		//return "user/saveSuccess";
		return "redirect:/users/" + customer.getName();
	}
	
	
	@RequestMapping(value = "/{userId}")
	public String getUserProfile(@PathVariable String userId, Map<String, Object> model) {
		
		Customer customer = customerService.findCustomer(userId);
		model.put("user", customer);	// lets JSP use customer
		
		return "user/view";
	}
	
	@RequestMapping(value = "/{userId}/edit")
	public String editUserProfile(@PathVariable("userId") String userId, Map<String, Object> model) {
		Customer customer = customerService.findCustomer(userId);
		model.put("user",  customer);
		return "user/edit";
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") @Valid Customer customer, BindingResult result) {
		if(result.hasErrors()) {
			//return "user/register";  -> VIDEO PROVIDED. DOESNT GO TO RIGHT PLACE
			return "user/edit";
		}
		
		customerService.updateCustomer(customer);
		
		return "redirect:/users/" + customer.getName();
	}
}
