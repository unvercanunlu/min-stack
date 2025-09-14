package tr.unvercanunlu.stack.service;

import java.util.Optional;

public interface Stack<T> {

  Optional<T> pop();

  Optional<T> peek();

  void push(T value);

  void clear();

  int size();

}
