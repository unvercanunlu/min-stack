package tr.unvercanunlu.stack.example;

import java.util.Comparator;
import lombok.extern.slf4j.Slf4j;
import tr.unvercanunlu.stack.service.impl.BaseMinMaxStack;
import tr.unvercanunlu.stack.util.Utils;

@Slf4j
public class ProductMinMaxStack extends BaseMinMaxStack<Product> {

  // with default comparator
  public ProductMinMaxStack() {
    super(Utils.BY_PRICE_ASC);
  }

  // with custom comparator
  public ProductMinMaxStack(Comparator<Product> comparator) {
    super(comparator);
  }

  @Override
  protected boolean isValueValid(Product product) {
    return Utils.isProductValid(product);
  }

}
