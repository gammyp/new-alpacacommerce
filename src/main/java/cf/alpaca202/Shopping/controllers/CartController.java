package cf.alpaca202.Shopping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
  
  @RequestMapping(value = "/cart", method = RequestMethod.GET)
  public String goToCart() {
    return "cart";
  }

}