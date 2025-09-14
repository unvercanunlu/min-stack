package tr.unvercanunlu.stack.service;

import java.util.Optional;

@FunctionalInterface
public interface MaxStack<T extends Comparable<T>> {

  Optional<T> peekMax();

}
