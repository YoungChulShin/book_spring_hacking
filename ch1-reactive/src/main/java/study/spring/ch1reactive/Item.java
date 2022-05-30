package study.spring.ch1reactive;

import org.springframework.data.annotation.Id;

public class Item {

  @Id
  private String id;
  private String name;
  private double price;

  private Item() {}

  Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

}
