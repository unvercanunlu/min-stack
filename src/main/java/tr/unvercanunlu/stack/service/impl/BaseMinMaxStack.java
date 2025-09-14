package tr.unvercanunlu.stack.service.impl;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import tr.unvercanunlu.stack.service.MaxStack;
import tr.unvercanunlu.stack.service.MinStack;

@Slf4j
public abstract class BaseMinMaxStack<T extends Comparable<T>>
    extends BaseStack<T>
    implements MinStack<T>, MaxStack<T> {

  // helper storage
  private final Deque<T> minStack = new ArrayDeque<>();
  private final Deque<T> maxStack = new ArrayDeque<>();

  // order
  private final Comparator<T> order;

  // with default order (ascending)
  protected BaseMinMaxStack() {
    this.order = Comparable::compareTo;
  }

  // with custom order
  protected BaseMinMaxStack(Comparator<T> order) {
    this.order = Objects.requireNonNull(order, "Invalid order!");
  }

  // time complexity: O(1)
  // space complexity: O(1)
  @Override
  public synchronized Optional<T> peekMax() {
    if (stack.isEmpty() && maxStack.isEmpty()) {
      log.warn("Empty stack!");
      return Optional.empty();
    }

    return Optional.ofNullable(maxStack.peek());
  }

  // time complexity: O(1)
  // space complexity: O(1)
  @Override
  public synchronized Optional<T> peekMin() {
    if (stack.isEmpty() && minStack.isEmpty()) {
      log.warn("Empty stack!");
      return Optional.empty();
    }

    return Optional.ofNullable(minStack.peek());
  }

  @Override
  protected void postOperationPush(T pushed) {
    if (minStack.isEmpty() || ((minStack.peek() != null)
        && (order.compare(minStack.peek(), pushed) >= 0))) {
      minStack.push(pushed);
    }

    if (maxStack.isEmpty() || ((maxStack.peek() != null)
        && (order.compare(maxStack.peek(), pushed) <= 0))) {
      maxStack.push(pushed);
    }
  }

  @Override
  protected void postOperationPop(T popped) {
    if (!minStack.isEmpty() && (minStack.peek() != null) && minStack.peek().equals(popped)) {
      minStack.pop();
    }

    if (!maxStack.isEmpty() && (maxStack.peek() != null) && maxStack.peek().equals(popped)) {
      maxStack.pop();
    }
  }

  @Override
  protected void postOperationClear() {
    minStack.clear();
    maxStack.clear();
  }

}
