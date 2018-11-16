package cf.alpaca202.Shopping.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
  public void addCart(HttpSession session, @RequestBody long productVarientId) {
    Cart cart = (Cart)session.getAttribute("cart");
    if (cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }
    ProductVarient productVarient = this.productVarientService.getProductVarientById(productVarientId);
    Item item = new Item(productVarient, 1, productVarient.getPrice());
    cart.addCart(item);
  }
}
