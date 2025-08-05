package tr.unvercanunlu.min_stack.service;

public interface MinStack<T extends Comparable<T>> extends Stack<T> {

  T getMin();

}
