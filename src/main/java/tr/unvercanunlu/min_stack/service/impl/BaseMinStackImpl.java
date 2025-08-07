package tr.unvercanunlu.min_stack.service.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import tr.unvercanunlu.min_stack.service.MinStack;

@Slf4j
public abstract class BaseMinStackImpl<T extends Comparable<T>> implements MinStack<T> {

  private final Deque<T> stack = new ArrayDeque<>();
  private final Deque<T> minStack = new ArrayDeque<>();

  @Override
  public synchronized T getMin() {
    ensureStackNotEmpty();

    T min = minStack.peek();

    log.info("Minimum element '{}' is retrieved from stack.", min);

    return min;
  }

  @Override
  public synchronized T peek() {
    ensureStackNotEmpty();

    T last = stack.peek();

    log.info("Last element '{}' is retrieved from stack.", last);

    return last;
  }

  @Override
  public synchronized T pop() {
    ensureStackNotEmpty();

    T popped = stack.pop();

    if (!minStack.isEmpty() && minStack.peek().equals(popped)) {
      minStack.pop();
    }

    log.info("Last element '{}' is removed from stack.", popped);

    return popped;
  }

  @Override
  public synchronized void push(T value) {
    if (minStack.isEmpty() || minStack.peek().compareTo(value) >= 0) {
      minStack.push(value);
    }

    stack.push(value);

    log.info("New element '{}' is added to stack.", value);
  }

  @Override
  public synchronized void clear() {
    stack.clear();
    minStack.clear();

    log.info("Stack is cleared.");
  }

  @Override
  public synchronized int size() {
    int size = stack.size();

    log.info("Stack contains '{}' elements.", size);

    return size;
  }

  private void ensureStackNotEmpty() throws NoSuchElementException {
    if (stack.isEmpty()) {
      log.error("Stack is empty!");

      throw new NoSuchElementException("Stack empty!");
    }
  }

}
