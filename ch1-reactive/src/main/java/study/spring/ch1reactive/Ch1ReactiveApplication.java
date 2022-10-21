package study.spring.ch1reactive;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch1ReactiveApplication {

  public static void main(String[] args) {

    List<String> a = new ArrayList<>();
    a.add("1");

    String join = String.join(", ", a);

    List<String> b = new ArrayList<>();
    b.add("1");
    b.add("2");
    String join2 = String.join(", ", b);

    SpringApplication.run(Ch1ReactiveApplication.class, args);
  }

}
