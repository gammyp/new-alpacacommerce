package cf.alpaca202.Shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cf.alpaca202.Shopping.models.Product;
import cf.alpaca202.Shopping.services.ProductService;

@Controller
public class ProductController {
  
  @Autowired
  private ProductService productService;
  
  @RequestMapping(name = "/", method = RequestMethod.GET)
  public String getAllProducts(Model model) {
    List<Product> listProduct = productService.getAllProducts();
    model.addAttribute("product",listProduct);
    return "index";
  }
}