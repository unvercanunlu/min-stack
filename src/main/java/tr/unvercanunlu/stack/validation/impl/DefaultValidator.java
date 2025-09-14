package tr.unvercanunlu.stack.validation.impl;

import tr.unvercanunlu.stack.validation.Validator;

public class DefaultValidator<T> implements Validator<T> {

  @Override
  public boolean isValueValid(T value) {
    return (value != null);
  }

}
