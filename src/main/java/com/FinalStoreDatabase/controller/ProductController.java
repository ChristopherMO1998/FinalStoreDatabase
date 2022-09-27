package com.FinalStoreDatabase.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FinalStoreDatabase.entity.Product;
import com.FinalStoreDatabase.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService theProductService) {
		productService = theProductService;
	}

	@GetMapping("/list")
	public String listProducts(Model model) {
		List<Product> theProduct = productService.findAll();
		model.addAttribute("product", theProduct);
		return "products/list-products";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Product theProduct = new Product();
		model.addAttribute("product", theProduct);
		return "products/product-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdat(@RequestParam("productId") int theId, Model model) {
		Product theProduct = productService.findById(theId);
		model.addAttribute("product", theProduct);
		return "products/product-form";
	}

	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		productService.save(theProduct);
		return "redirect:/products/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("productId") int theId) {
		productService.deleteById(theId);
		return "redirect:/products/list";
	}

	@GetMapping("/search")
	public String search(Product theProduct, Model model, String keyword) {
		if (keyword != null) {
			List<Product> list = productService.getByKeyword(keyword);
			model.addAttribute("list", list);
		} else {
			List<Product> list = productService.findAll();
			model.addAttribute("list", list);
		}
		return "products/search";
	}

}
