package cf.alpaca202.Shopping.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cf.alpaca202.Shopping.models.Cart;
import cf.alpaca202.Shopping.models.Item;
import cf.alpaca202.Shopping.models.ProductVarient;
import cf.alpaca202.Shopping.services.ProductVarientService;

@Controller
public class CartController {

  @Autowired
  private ProductVarientService productVarientService;
  
  @RequestMapping(value = "/cart", method = RequestMethod.GET)
  public String goToCart() {
    return "cart";
  }

  @RequestMapping(value = "/cart", method = RequestMethod.POST)
  public String addCart(
    HttpSession session,
    @RequestParam Map<String, String> body
  ) {
    if (session.getAttribute("cart") == null) {
      session.setAttribute("cart", new Cart());
    }
    Cart cart = (Cart)session.getAttribute("cart");
    long productVarientId = Long.parseLong(body.get("productVarientId"));
    ProductVarient productVarient = this.productVarientService.getProductVarientById(productVarientId);
    Item item = new Item(productVarient, 1, productVarient.getPrice());
    cart.addCart(item);

    String redirect = body.get("redirect");
    return "redirect:"+ redirect;
  }
}
