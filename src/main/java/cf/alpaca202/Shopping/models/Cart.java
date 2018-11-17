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
        boolean duplicateItem = false;

        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getProductVarient().getId() == item.getProductVarient().getId()) {
                this.items.get(i).setCount(this.items.get(i).getCount() + 1);
                duplicateItem = true;
                break;
            }
        }

        if (!duplicateItem) {
            this.items.add(item);                        
        }
        
        if (this.items.size() == 0) {
            this.items.add(item);            
        }

        double totalPrice = 0;
        for (Item element : this.items) {
            totalPrice += element.getCurrentPrice() * element.getCount();
        }
        this.setTotalPrice(totalPrice);
    }

    public void deleteItem(int index) {
        items.remove(index);
    }
}
