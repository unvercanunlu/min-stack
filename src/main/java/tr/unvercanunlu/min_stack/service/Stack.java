package tr.unvercanunlu.min_stack.service;

public interface Stack<T> {

  T peek();

  T pop();

  void push(T value);

  void clear();

  int size();

}
