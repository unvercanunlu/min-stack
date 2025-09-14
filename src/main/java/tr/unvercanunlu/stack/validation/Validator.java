package tr.unvercanunlu.stack.validation;

@FunctionalInterface
public interface Validator<T> {

  boolean isValueValid(T value);

}
