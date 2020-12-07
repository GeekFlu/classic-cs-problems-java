package tech.geek.flu.classic.computer.problems.fibonacci;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Fibonacci Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21...
 * fib(n) = fib(n - 1) + fib(n - 2)
 *
 * @author Luis E
 */
@Slf4j
public class Fibonacci {
  int last = 0; // fib(0)
  int next = 1; // fib(1)

  // Map.of() was introduced in Java 9 but returns
  // an immutable Map
  // This creates a map with 0->0 and 1->1
  // Which represent our base cases
  static Map<Integer, Integer> memo = new HashMap<>(Map.of(0, 0, 1, 1));

  private static int fib3(int n) {
    if (!memo.containsKey(n)) {
      // memoization step
      memo.put(n, fib3(n - 1) + fib3(n - 2));
    }
    return memo.get(n);
  }

  private static int fib4(int n) {
    int last = 0; // fib(0)
    int next = 1; // fib(1)
    for (int i = 0; i < n; i++) {
      int oldLast = last;
      last = next;
      next = oldLast + next;
    }
    return last;
  }

  /**
   * Generating Fibonacci numbers with a stream
   * @return Fibonacci Stream
   */
  public IntStream stream() {
    return IntStream.generate(() -> {
      int oldLast = last;
      last = next;
      next = oldLast + next;
      return oldLast;
    });
  }

  public static void main(String[] args) {
    log.info("Fib(5) = {}", fib3(5));
    log.info("Fib(40) = {}", fib3(40));
    log.info("Fib(45) = {}", fib3(45));
    log.info("Fib(45) = {}", fib4(45));

    Fibonacci fibonacci = new Fibonacci();
    fibonacci.stream().limit(41).forEachOrdered(value -> log.info("Fib = {}", value));
  }
}
