package tr.unvercanunlu.stack.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import tr.unvercanunlu.stack.util.Util;

@Slf4j
@EqualsAndHashCode
@ToString
public class Product implements Comparable<Product> {

  @Getter
  private final String name;

  @Getter
  private final int price;

  public Product(String name, int price) {
    Util.validateName(name);
    Util.validatePrice(price);
    this.name = name;
    this.price = price;
  }

  @Override
  public int compareTo(Product other) throws IllegalArgumentException {
    if (other == null) {
      log.warn("Other product null!");
      throw new IllegalArgumentException("Other product null!");
    }

    return Util.BY_PRICE_ASC.compare(this, other);
  }

}
