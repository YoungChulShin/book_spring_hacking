package study.spring.ch1reactive;

public class Dish {

  private final String description;
  private boolean delivered = false;

  public static Dish deliver(Dish dish) {
    Dish deliveredDish = new Dish(dish.description);
    deliveredDish.delivered = true;
    return deliveredDish;
  }

  Dish(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.delivered = delivered;
  }

  public boolean isDelivered() {
    return this.delivered;
  }

  @Override
  public String toString() {
    return "Dish{" +
        "description='" + description + '\'' +
        ", delivered=" + delivered +
        '}';
  }
}
