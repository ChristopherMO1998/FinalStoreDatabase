package com.FinalStoreDatabase.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FinalStoreDatabase.entity.Customer;
import com.FinalStoreDatabase.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}

	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> theCustomer = customerService.findAll();
		model.addAttribute("customer", theCustomer);
		return "customers/list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer theCustomer = new Customer();
		model.addAttribute("customer", theCustomer);
		return "customers/customer-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
		Customer theCustomer = customerService.findById(theId);
		model.addAttribute("customer", theCustomer);
		return "customers/customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.save(theCustomer);
		return "redirect:/customers/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		customerService.deleteById(theId);
		return "redirect:/customers/list";
	}

	@GetMapping("/search")
	public String search(Customer theCustomer, Model model, String keyword) {
		if (keyword != null) {
			List<Customer> list = customerService.getByKeyword(keyword);
			model.addAttribute("list", list);
		} else {
			List<Customer> list = customerService.findAll();
			model.addAttribute("list", list);
		}
		return "customers/search";
	}
}
