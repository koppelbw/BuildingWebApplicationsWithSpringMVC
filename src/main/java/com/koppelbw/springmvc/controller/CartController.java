package com.koppelbw.springmvc.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koppelbw.springmvc.beans.Cart;
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;


@Controller
public class CartController {

	
	@Autowired
	ProductService productService;
	@Autowired
	private Cart cart;
	
	@RequestMapping(value = "cart/add/{productId}")
	public String addToCart(@PathVariable("productId") Long productId, @RequestHeader("referer") String referedFrom) {
		Product product = productService.findProduct(productId);
		cart.addProduct(product, 1);
		
		return "redirect:" + referedFrom;
	}
}
