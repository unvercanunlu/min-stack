package tr.unvercanunlu.stack.validation.impl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PriceValidator extends DefaultValidator<Integer> {

  @Getter
  private final int lowerBound;

  @Getter
  private final int upperBound;

  public PriceValidator(int lowerBound, int upperBound) {
    if (lowerBound > upperBound) {
      throw new IllegalArgumentException("Invalid bounds!");
    }

    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  public static PriceValidator withLowerBound(int lowerBound) {
    return new PriceValidator(lowerBound, Integer.MAX_VALUE);
  }

  public static PriceValidator withUpperBound(int upperBound) {
    return new PriceValidator(Integer.MIN_VALUE, upperBound);
  }

  public static PriceValidator withDefault() {
    return new PriceValidator(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  @Override
  public boolean isValueValid(Integer price) {
    return super.isValueValid(price)
        && (price >= lowerBound)
        && (price <= upperBound);
  }

}
