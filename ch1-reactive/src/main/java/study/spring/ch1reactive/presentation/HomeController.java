package study.spring.ch1reactive.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;
import study.spring.ch1reactive.domain.Cart;
import study.spring.ch1reactive.domain.CartRepository;
import study.spring.ch1reactive.domain.ItemRepository;

@Controller
public class HomeController {

  private final ItemRepository itemRepository;
  private final CartRepository cartRepository;

  public HomeController(ItemRepository itemRepository, CartRepository cartRepository) {
    this.itemRepository = itemRepository;
    this.cartRepository = cartRepository;
  }

  @GetMapping
  Mono<Rendering> home() {
    //return Mono.just("home");

    return Mono.just(Rendering.view("home.html")
      .modelAttribute("items", this.itemRepository.findAll())
      .modelAttribute("cart", this.cartRepository.findById("My Cart").defaultIfEmpty(new Cart("My Cart")))
      .build());
  }
}
