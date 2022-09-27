package com.FinalStoreDatabase.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FinalStoreDatabase.entity.Customer;
import com.FinalStoreDatabase.entity.Product;
import com.FinalStoreDatabase.service.CustomerService;
import com.FinalStoreDatabase.service.ProductService;

@Controller
@RequestMapping("/main")
public class ServiceController {

	private CustomerService customerService;

	private ProductService productService;

	public ServiceController(CustomerService theCustomerService, ProductService theProductService) {
		customerService = theCustomerService;
		productService = theProductService;
	}

	@GetMapping("/list")
	public String listServices(Model model) {
		List<Customer> theCustomer = customerService.findAll();
		model.addAttribute("customer", theCustomer);
		List<Product> theProduct = productService.findAll();
		model.addAttribute("product", theProduct);
		return "main/main";
	}

	@GetMapping("/search")
	public String search(Product theProduct, Customer theCustomer, Model model, String keyword) {
		if (keyword != null) {
			List<Product> plist = productService.getByKeyword(keyword);
			model.addAttribute("plist", plist);
		} else {
			List<Product> plist = productService.findAll();
			model.addAttribute("plist", plist);
		}
		if (keyword != null) {
			List<Customer> clist = customerService.getByKeyword(keyword);
			model.addAttribute("clist", clist);
		} else {
			List<Customer> clist = customerService.findAll();
			model.addAttribute("clist", clist);
		}
		return "main/search";
	}
}
