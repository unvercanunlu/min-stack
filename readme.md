# MinStack

A minimal Java stack that supports `getMin()` in **O(1)** time.

## Features

- Generic & thread-safe
- `push`, `pop`, `peek`, `clear`, `getMin()`
- Constant-time min tracking
- No frameworks required

## Tech

- Java 21, Maven
- Lombok, SLF4J
- JUnit 5, Mockito, JaCoCo

## Usage

```java
MinStack<Integer> stack = new MyMinStackImpl(); // your subclass
stack.push(5);
stack.push(3);
int min = stack.getMin(); // 3
````

## Test & Coverage

```bash
mvn test        # Run tests
mvn verify      # Generate coverage report
```
