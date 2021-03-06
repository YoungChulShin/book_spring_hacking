package study.spring.ch1reactive;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ServerController {

  private final KitchenService kitchen;

  public ServerController(KitchenService kitchen) {
    this.kitchen = kitchen;
  }

  // https://html.spec.whatwg.org/multipage/iana.html#text/event-stream
  @GetMapping(value = "/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  Flux<Dish> serveDishes() {
    return this.kitchen.getDishes();
  }

  @GetMapping(value = "/random-dish", produces = MediaType.APPLICATION_JSON_VALUE)
  Flux<Dish> randomDishes() {
    return this.kitchen.getDish();
  }

  @GetMapping(value = "/preorder-dishes", produces = MediaType.APPLICATION_JSON_VALUE)
  Flux<Dish> preorderDishes() {
    return this.kitchen.getPreOrderDishes();
  }
}
