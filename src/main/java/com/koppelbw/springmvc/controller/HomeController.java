package com.koppelbw.springmvc.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.packtpub.springmvc.chocolatestore.model.Category;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryService;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale/*, Model model*/) {
/*		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
	
		
		List<Product> featuredProducts = productService.getFeaturedProducts();
		
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("productList", featuredProducts);
		*/
		
		
		//List<Category> allCategories = categoryService.getAllCategories();
		//ModelAndView modelAndView =  new ModelAndView("home", "featuredProducts", productService.getFeaturedProducts());
		//modelAndView.addObject("allCategories", allCategories);
		//return modelAndView;
		
		return  new ModelAndView("home", "featuredProducts", productService.getFeaturedProducts());
	}

	
	@ModelAttribute("allCategories")
	public List<Category> fetchAllCategories() {
		return categoryService.getAllCategories();
	}
	
}
