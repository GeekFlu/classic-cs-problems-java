package tech.geek.flu.classic.computer.problems.fibonacci;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * Fibonacci Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21...
 * fib(n) = fib(n - 1) + fib(n - 2)
 *
 * @author Luis E
 */
@Slf4j
public class Fibonacci {
  long last = 0; // fib(0)
  long next = 1; // fib(1)

  // Map.of() was introduced in Java 9 but returns
  // an immutable Map
  // This creates a map with 0->0 and 1->1
  // Which represent our base cases
  static Map<Long, Long> memo = new HashMap<>(Map.of(0L, 0L, 1L, 1L));

  public static long fib1(long n) {
    if (n < 2) {
      return n;
    }
    return fib1(n - 1) + fib1(n - 2);
  }

  public static long fib3(long n) {
    if (!memo.containsKey(n)) {
      // memoization step
      memo.put(n, fib3(n - 1) + fib3(n - 2));
    }
    return memo.get(n);
  }

  public static long fib4(long n) {
    long last = 0; // fib(0)
    long next = 1; // fib(1)
    for (int i = 0; i < n; i++) {
      long oldLast = last;
      last = next;
      next = oldLast + next;
    }
    return last;
  }

  /**
   * Generating Fibonacci numbers with a stream
   *
   * @return Fibonacci Stream
   */
  public LongStream stream() {
    return LongStream.generate(() -> {
      long oldLast = last;
      last = next;
      next = oldLast + next;
      return oldLast;
    });
  }

  public static void main(String[] args) {
    log.info("Fib(5) = {}", fib3(5));
    log.info("Fib(40) = {}", fib3(40));
    log.info("Fib(45) = {}", fib3(45));
    log.info("Fib(45) = {}", fib4(49));

    Fibonacci fibonacci = new Fibonacci();
    fibonacci.stream().limit(55).forEachOrdered(value -> log.info("Fib = {}", value));
  }
}
