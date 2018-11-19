package cf.alpaca202.Shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.alpaca202.Shopping.models.Item;
import cf.alpaca202.Shopping.repositories.ItemRepository;

@Service
public class ItemService {
  @Autowired
  private ItemRepository itemRepository;

  public Item createItem(Item item) {
    return this.itemRepository.save(item);
  }
}