package tr.unvercanunlu.stack.util;

import java.util.Comparator;
import lombok.extern.slf4j.Slf4j;
import tr.unvercanunlu.stack.example.Product;
import tr.unvercanunlu.stack.validation.Validator;
import tr.unvercanunlu.stack.validation.impl.DefaultValidator;
import tr.unvercanunlu.stack.validation.impl.PriceValidator;
import tr.unvercanunlu.stack.validation.impl.TextValidator;

@Slf4j
public class Util {

  // validators
  public static final Validator<String> TEXT_VALIDATOR = new TextValidator();
  public static final Validator<Integer> PRICE_VALIDATOR = PriceValidator.withLowerBound(0);

  // comparators
  public static final Comparator<Product> BY_PRICE_ASC =
      Comparator.comparingInt(Product::getPrice);
  public static final Comparator<Product> BY_PRICE_DESC =
      Comparator.comparingInt(Product::getPrice).reversed();
  public static final Comparator<Product> BY_NAME_ASC =
      Comparator.comparing(Product::getName);

  public static void validatePrice(int price) throws IllegalArgumentException {
    if (!PRICE_VALIDATOR.isValueValid(price)) {
      log.warn("Invalid price!");
      throw new IllegalArgumentException("Invalid price!");
    }
  }

  public static void validateName(String name) throws IllegalArgumentException {
    if (!TEXT_VALIDATOR.isValueValid(name)) {
      log.warn("Invalid name!");
      throw new IllegalArgumentException("Invalid name!");
    }
  }

  public static boolean isProductValid(Product product) {
    return defaultValidator().isValueValid(product)
        && TEXT_VALIDATOR.isValueValid(product.getName())
        && PRICE_VALIDATOR.isValueValid(product.getPrice());
  }

  public static <T> Validator<T> defaultValidator() {
    return new DefaultValidator<>();
  }

}
