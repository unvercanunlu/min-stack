package tr.unvercanunlu.stack;

import java.util.List;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import tr.unvercanunlu.stack.example.IntegerStack;
import tr.unvercanunlu.stack.example.Product;
import tr.unvercanunlu.stack.example.ProductMinMaxStack;
import tr.unvercanunlu.stack.service.impl.BaseMinMaxStack;
import tr.unvercanunlu.stack.service.impl.BaseStack;

@Slf4j
public class App {

  private static void basicExample() {
    BaseStack<Integer> stack = new IntegerStack();

    stack.push(1);
    log.info("Operation 'peek': {}", stack.peek());

    log.info("Operation 'pop': {}", stack.pop());
    log.info("Operation 'pop': {}", stack.pop());

    stack.push(2);
    stack.push(3);
    log.info("Operation 'pop': {}", stack.pop());

    stack.clear();
    log.info("Operation 'peek': {}", stack.peek());
    log.info("Operation 'size': {}", stack.size());
  }

  private static void minMaxExample() {
    BaseMinMaxStack<Product> minMaxStack = new ProductMinMaxStack();

    List<Product> products = List.of(
        new Product("product-1", 5),
        new Product("product-2", 2),
        new Product("product-3", 1),
        new Product("product-4", 8),
        new Product("product-5", 3),
        new Product("product-6", 6),
        new Product("product-7", 7),
        new Product("product-8", 4)
    );

    products.forEach(minMaxStack::push);

    int steps = products.size() + 3;

    IntStream.range(1, steps)
        .forEach(step -> {
          log.info("Step {}:", step);
          log.info("Operation 'peek': {}", minMaxStack.peek());
          log.info("Operation 'peek min': {}", minMaxStack.peekMin());
          log.info("Operation 'peek max': {}", minMaxStack.peekMax());
          log.info("Operation 'pop': {}", minMaxStack.pop());
        });
  }

  public static void main(String[] args) {
    basicExample();
    minMaxExample();
  }

}
