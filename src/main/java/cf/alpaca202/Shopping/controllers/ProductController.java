package cf.alpaca202.Shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cf.alpaca202.Shopping.models.Product;
import cf.alpaca202.Shopping.services.ProductService;

@Controller
public class ProductController {
  
  @Autowired
  private ProductService productService;
  
  @RequestMapping(value = {"/","/index.html"}, method = RequestMethod.GET)
  public String getAllProducts(Model model) {
    List<Product> productList = productService.getAllProducts();
    model.addAttribute("productlist",productList);
    return "index";
  }

  @RequestMapping(value = "/product/{product_id}", method = RequestMethod.GET)
  public String getProduct(Model model, @PathVariable(name = "product_id") Long productId) {
    Product product = productService.getProductById(productId);
    model.addAttribute("product",product);
    return "productdetail";
  }
}