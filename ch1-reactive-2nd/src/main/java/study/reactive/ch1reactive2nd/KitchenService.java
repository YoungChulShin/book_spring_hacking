package study.reactive.ch1reactive2nd;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class KitchenService {

  private final List<Dish> menu = Arrays.asList(
      new Dish("pizza"),
      new Dish("chicken"),
      new Dish("noodle"));

  private final Random picker = new Random();

  Flux<Dish> getDishes() {
    return Flux
        .<Dish>generate(sink -> sink.next(randomDish())).log()
        .delayElements(Duration.ofMillis(250));
  }

  private Dish randomDish() {
    return menu.get(picker.nextInt(menu.size()));
  }
}
