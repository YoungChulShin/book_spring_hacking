package study.spring.ch1reactive;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class KitchenService {

  public Flux<Dish> getDishes() {
    return Flux.<Dish> generate(sink -> sink.next(randomDish()))
        .delayElements(Duration.ofMillis(250));
  }

  public Flux<Dish> getDish() {
    return Flux.just(randomDish());
  }

  public Flux<Dish> getPreOrderDishes() {
    return Flux.just(
        menu.get(0),
        menu.get(1),
        menu.get(2));
  }

  private Dish randomDish() {
    return menu.get(picker.nextInt(menu.size()));
  }

  private List<Dish> menu = Arrays.asList(
      new Dish("Sesame chicken"),
      new Dish("Lo mein noodles"),
      new Dish("Sweet & sour beef"));

  private Random picker = new Random();
}
