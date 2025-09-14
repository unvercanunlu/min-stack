package tr.unvercanunlu.stack.validation.impl;

public class TextValidator extends DefaultValidator<String> {

  @Override
  public boolean isValueValid(String text) {
    return super.isValueValid(text)
        && !text.trim().isEmpty();
  }

}
