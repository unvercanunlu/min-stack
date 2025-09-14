# Stack

A modular Java stack implementation with support for **min/max in O(1)** time, validators, and
domain-specific extensions.

## Features

* Generic & thread-safe `Stack<T>`
* Core operations: `push`, `pop`, `peek`, `clear`, `size`
* Constant-time **min/max tracking** with `BaseMinMaxStack`
* Domain-specific validation (e.g. `Product` with name/price rules)
* Built-in validators:

    * `DefaultValidator` (non-null)
    * `PriceValidator` (range checks)
    * `TextValidator` (non-empty strings)

## Tech

* Java 21, Maven
* Lombok, SLF4J

## Usage

### Integer stack

```java
IntegerStack stack = new IntegerStack();
stack.push(10);
stack.push(5);

System.out.println(stack.pop().get()); // 5
System.out.println(stack.peek().get()); // 10
```

### Product stack with min/max by price

```java
ProductMinMaxStack productStack = new ProductMinMaxStack();
productStack.push(new Product("Apple", 5));
productStack.push(new Product("Banana", 10));

System.out.println(productStack.peekMin().get()); // Apple
System.out.println(productStack.peekMax().get()); // Banana
```

### Product stack with custom comparator (by name)

```java
ProductMinMaxStack nameStack = new ProductMinMaxStack(Util.BY_NAME_ASC);
nameStack.push(new Product("Zebra", 20));
nameStack.push(new Product("Apple", 15));

System.out.println(nameStack.peekMin().get()); // Apple
```
