package tr.unvercanunlu.stack.service.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import tr.unvercanunlu.stack.service.Stack;

@Slf4j
public abstract class BaseStack<T> implements Stack<T> {

  // storage
  protected final Deque<T> stack = new ArrayDeque<>();

  // time complexity: O(1)
  // space complexity: O(1)
  @Override
  public synchronized Optional<T> pop() {
    if (stack.isEmpty()) {
      log.warn("Empty stack!");
      return Optional.empty();
    }

    T popped = stack.pop();

    // additional operation
    postOperationPop(popped);

    return Optional.ofNullable(popped);
  }

  // time complexity: O(1)
  // space complexity: O(1)
  @Override
  public synchronized Optional<T> peek() {
    if (stack.isEmpty()) {
      log.warn("Empty stack!");
      return Optional.empty();
    }

    return Optional.ofNullable(stack.peek());
  }

  // time complexity: O(1)
  // space complexity: O(1)
  @Override
  public synchronized void push(T value) {
    validateInput(value);
    stack.push(value);

    // additional operation
    postOperationPush(value);
  }

  // time complexity: O(1)
  // space complexity: O(1)
  @Override
  public synchronized int size() {
    return stack.size();
  }

  // time complexity: O(1)
  // space complexity: O(1)
  @Override
  public synchronized void clear() {
    stack.clear();

    // additional operation
    postOperationClear();
  }

  private void validateInput(T value) throws IllegalArgumentException {
    if (!isValueValid(value)) {
      log.warn("Invalid input!");
      throw new IllegalArgumentException("Invalid input!");
    }
  }

  protected abstract boolean isValueValid(T value);

  protected abstract void postOperationPush(T pushed);

  protected abstract void postOperationPop(T popped);

  protected abstract void postOperationClear();

}
