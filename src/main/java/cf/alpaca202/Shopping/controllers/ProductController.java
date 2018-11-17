package cf.alpaca202.Shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cf.alpaca202.Shopping.models.Product;
import cf.alpaca202.Shopping.models.ProductVarient;
import cf.alpaca202.Shopping.services.ProductService;
import cf.alpaca202.Shopping.services.ProductVarientService;

@Controller
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @Autowired
  private ProductVarientService productVarientService;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getAllProducts(Model model) {
    List<Product> products = productService.getAllProducts();
    model.addAttribute("products", products);
    return "index";
  }

  @RequestMapping(value = "/product/{product_id}/{product_varient_id}", method = RequestMethod.GET)
  public String getProduct(
    Model model,
    @PathVariable(name = "product_id") Long productId,
    @PathVariable(name = "product_varient_id") Long productVarientId
  ) {
    Product product = productService.getProductById(productId);
    ProductVarient productVarient = productVarientService.getProductVarientById(productVarientId);
    model.addAttribute("product", product);
    model.addAttribute("productVarient", productVarient);
    return "productdetail";
  }
}