package study.reactive.ch1reactive2nd;

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

  // 개발자가 Flux를 응답으로 전달하면, 스프링 웹플러스가 이를 구독한다
  @GetMapping(value = "/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  Flux<Dish> serveDishes() {
    return this.kitchen.getDishes();
  }

  @GetMapping(value = "/served-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  Flux<Dish> deliverDishes() {
    return this.kitchen.getDishes()
        .map(dish -> dish.deliver(dish))
        .log();
  }
}
