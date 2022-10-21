package study.reactive.ch1reactive2nd;

import lombok.Getter;

@Getter
public class Dish {

  private String description;
  private boolean delivered = false;

  public Dish(String description) {
    this.description = description;
  }

  public Dish deliver(Dish dish) {
    Dish deliveredDish = new Dish(dish.description);
    deliveredDish.delivered = true;
    return deliveredDish;
  }

  @Override
  public String toString() {
    return "Dish{" +
        "description='" + description + '\'' +
        ", delivered=" + delivered +
        '}';
  }
}
