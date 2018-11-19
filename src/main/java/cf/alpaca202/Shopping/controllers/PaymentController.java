package cf.alpaca202.Shopping.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cf.alpaca202.Shopping.models.Account;
import cf.alpaca202.Shopping.models.Address;
import cf.alpaca202.Shopping.models.Cart;
import cf.alpaca202.Shopping.models.Customer;
import cf.alpaca202.Shopping.models.Item;
import cf.alpaca202.Shopping.models.Order;
import cf.alpaca202.Shopping.services.AccountService;
import cf.alpaca202.Shopping.services.AddressService;
import cf.alpaca202.Shopping.services.CustomerService;
import cf.alpaca202.Shopping.services.ItemService;
import cf.alpaca202.Shopping.services.OmiseService;
import cf.alpaca202.Shopping.services.OrderService;

@Controller
public class PaymentController {
    @Value("${omise.key.public}")
    private String omisePublicKey;
    
    @Autowired
    private OmiseService omiseService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String goToPay(HttpSession session, Model model) {
        if (session.getAttribute("cart") == null) {
            return "redirect:/";
        }

        model.addAttribute("omisePublicKey", omisePublicKey);

        return "payment";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String payment(
        HttpSession session,
        @RequestParam Map<String, String> body
    ) {
        Cart cart = (Cart)session.getAttribute("cart");

        Account account = new Account(body.get("firstname"), body.get("lastname"), body.get("tel"));
        account = this.accountService.createAccount(account);

        Address address = new Address(0, body.get("address"), account, null, null);
        address = this.addressService.createAddress(address);

        Customer customer = new Customer(0, account, null, null);
        customer = this.customerService.createCustomer(customer);

        Order order = new Order(true, 50, 0, null, customer, null, null);
        order = this.orderService.createOrder(order);

        List<Item> items = cart.getItems();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            item.setOrder(order);
            this.itemService.createItem(item);
        }

        try {
            this.omiseService.chargeCreditCard(body.get("omiseToken"), cart.getTotalPrice() + 50);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        session.removeAttribute("cart");
        
        return "redirect:/";
    }
}
