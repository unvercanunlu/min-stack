package tr.unvercanunlu.stack.service;

import java.util.Optional;

@FunctionalInterface
public interface MinStack<T extends Comparable<T>> {

  Optional<T> peekMin();

}
