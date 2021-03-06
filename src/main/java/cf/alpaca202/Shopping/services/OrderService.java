package cf.alpaca202.Shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cf.alpaca202.Shopping.models.Order;

import cf.alpaca202.Shopping.repositories.OrderRepository;

@Service
public class OrderService{

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
        }

}