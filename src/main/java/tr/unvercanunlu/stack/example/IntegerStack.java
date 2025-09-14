package tr.unvercanunlu.stack.example;

import lombok.extern.slf4j.Slf4j;
import tr.unvercanunlu.stack.service.impl.BaseStack;
import tr.unvercanunlu.stack.util.Util;

@Slf4j
public class IntegerStack extends BaseStack<Integer> {

  @Override
  protected boolean isValueValid(Integer value) {
    return Util.defaultValidator()
        .isValueValid(value);
  }

  @Override
  protected void postOperationPush(Integer pushed) {
    log.debug("{} pushed into stack.", pushed);
  }

  @Override
  protected void postOperationPop(Integer popped) {
    log.debug("{} popped from stack.", popped);
  }

  @Override
  protected void postOperationClear() {
    log.debug("Stack cleared!");
  }

}
