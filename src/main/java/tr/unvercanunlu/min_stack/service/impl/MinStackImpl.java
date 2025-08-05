package tr.unvercanunlu.min_stack.service.impl;

import java.util.NoSuchElementException;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;
import tr.unvercanunlu.min_stack.service.MinStack;

@Slf4j
public abstract class MinStackImpl<T extends Comparable<T>> implements MinStack<T> {

  private final Stack<T> stack = new Stack<>();
  private final Stack<T> minStack = new Stack<>();

  @Override
  public T getMin() {
    if (stack.isEmpty()) {
      log.error("Stack is empty!");
      throw new NoSuchElementException("Stack empty!");
    }

    T min = minStack.peek();

    log.info("Minimum element '{}' is retrieved from stack.", min);

    return min;
  }

  @Override
  public T peek() {
    if (stack.isEmpty()) {
      log.error("Stack is empty!");
      throw new NoSuchElementException("Stack empty!");
    }

    T last = stack.peek();

    log.info("Last element '{}' is retrieved from stack.", last);

    return last;
  }

  @Override
  public T pop() {
    if (stack.isEmpty()) {
      log.error("Stack is empty!");
      throw new NoSuchElementException("Stack empty!");
    }

    T popped = stack.pop();

    if (!minStack.isEmpty() && minStack.peek().equals(popped)) {
      minStack.pop();
    }

    log.info("Last element '{}' is removed from stack.", popped);

    return popped;
  }

  @Override
  public void push(T value) {
    if (minStack.isEmpty() || minStack.peek().compareTo(value) >= 0) {
      minStack.push(value);
    }

    stack.push(value);

    log.info("New element '{}' is added to stack.", value);
  }

  @Override
  public void clear() {
    stack.clear();
    minStack.clear();

    log.info("Stack is cleared.");
  }

  @Override
  public int size() {
    int size = stack.size();

    log.info("Stack contains '{}' elements.", size);

    return size;
  }

}
