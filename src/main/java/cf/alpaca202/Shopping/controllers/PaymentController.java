package cf.alpaca202.Shopping.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



public class PaymentController {

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String goToPay() {
        return "payment";
    }
}
