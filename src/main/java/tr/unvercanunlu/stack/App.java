package tr.unvercanunlu.stack;

import java.util.List;
import java.util.stream.IntStream;
import tr.unvercanunlu.stack.example.Product;
import tr.unvercanunlu.stack.example.ProductMinMaxStack;
import tr.unvercanunlu.stack.service.impl.BaseMinMaxStack;

public class App {

  public static void main(String[] args) {
    // BaseStack<Integer> integerStack = new IntegerStack();

    BaseMinMaxStack<Product> productMinMaxStack = new ProductMinMaxStack();

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

    products.forEach(productMinMaxStack::push);

    int steps = products.size() + 3;

    IntStream.range(1, steps)
        .forEach(step -> {
          System.out.println("Step " + step + ":");
          System.out.println("Operation 'peek': " + productMinMaxStack.peek());
          System.out.println("Operation 'peek min': " + productMinMaxStack.peekMin());
          System.out.println("Operation 'peek max': " + productMinMaxStack.peekMax());
          System.out.println("Operation 'pop': " + productMinMaxStack.pop());
        });
  }

}
