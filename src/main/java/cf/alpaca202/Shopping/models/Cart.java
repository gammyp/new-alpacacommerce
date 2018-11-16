package cf.alpaca202.Shopping.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;
    private double totalPrice;

    public Cart() {
        this.items = new ArrayList<Item>();
        this.totalPrice = 0.0;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    private void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addCart(Item item) {
        for (Item element: this.items) {
            if (item.getProductVarient().getId() == element.getProductVarient().getId()) {
                element.setCount(element.getCount() + 1);
                break;
            }
        }
        this.items.add(item);

        double totalPrice = 0;
        for (Item element : this.items) {
            totalPrice += element.getCurrentPrice() * element.getCount();
        }
        this.setTotalPrice(totalPrice);
    }

    public int getTotalItems() {
        return this.items.size();
    }
}
