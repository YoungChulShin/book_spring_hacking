package study.spring.ch1reactive;

public class CartItem {

  private Item item;
  private int quantity;

  private CartItem() {}

  CartItem(Item item) {
    this.item = item;
    this.quantity = 1;
  }
}
