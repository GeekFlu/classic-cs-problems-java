package tech.geek.flu.classic.computer.problems.fibonacci;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class FibonacciTest {

  @Test
  void test_fibonacci_recursively(){
    long start = System.currentTimeMillis();
    long result = Fibonacci.fib1(45);
    log.info("Fib 45 = {}, execution time = {}", result, System.currentTimeMillis() - start);
    Assertions.assertEquals(1134903170, result);
  }

  @Test
  void test_fibonacci_memoization(){
    long start = System.currentTimeMillis();
    long result = Fibonacci.fib3(55);
    log.info("Fib 55 = {}, execution time = {}", result, System.currentTimeMillis() - start);
    Assertions.assertEquals(139583862445L, result);
  }

  @Test
  void test_fibonacci_keep_it_simple(){
    long start = System.currentTimeMillis();
    long result = Fibonacci.fib4(55);
    log.info("Fib 55 = {}, execution time = {}", result, System.currentTimeMillis() - start);
    Assertions.assertEquals(139583862445L, result);
  }


}
