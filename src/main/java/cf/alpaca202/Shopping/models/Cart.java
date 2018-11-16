package cf.alpaca202.Shopping.models;

import java.util.List;

public class Cart {
    private List<Item> items;
    private double totalPrice;

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
    }
}
