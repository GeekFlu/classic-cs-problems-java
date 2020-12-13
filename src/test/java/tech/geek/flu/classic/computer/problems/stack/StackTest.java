package tech.geek.flu.classic.computer.problems.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.stack.StackArray;

@Slf4j
class StackTest {

  @Test
  void stack_array_creation(){
    StackArray<String> stack = new StackArray<>(String.class);
    Assertions.assertNotNull(stack);

    stack.push("a");
    stack.push("l");
    stack.push("o");
    stack.push("H");

    log.info("Popped data = {}", stack.pop());
    log.info("Popped data = {}", stack.pop());
    log.info("Popped data = {}", stack.pop());
    log.info("Popped data = {}", stack.pop());
    log.info("Popped data = {}", stack.pop());

  }

}
