package tech.geek.flu.classic.computer.problems.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.stack.StackArray;
import tech.geek.flu.classic.computer.problems.TestUtils;

import java.util.List;

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

    log.info("{}", stack.print());

    log.info("Popped data = {}", stack.pop());
    log.info("{}", stack.print());

    log.info("Popped data = {}", stack.pop());
    log.info("{}", stack.print());

    log.info("Popped data = {}", stack.pop());
    log.info("{}", stack.print());

    log.info("Popped data = {}", stack.pop());
    log.info("{}", stack.print());

    stack.push("la");
    stack.push("barco");
    stack.push("camion");
    stack.push("demon slayer");
    stack.push("esquivel finel");
    stack.push("final fantasy XVI");
    stack.push("mmm mamacita");

    log.info("{}", stack.print());


  }

  @Test
  void test_stack_overflow(){
    StackArray<Integer> stack = new StackArray<>(Integer.class, 10);
    for(Integer i : TestUtils.getSampleData(19)) {
      stack.push(i);
      log.info("{}", stack.print());
    }
    stack.push(45);
    log.info("{}", stack.print());
    Assertions.assertEquals(20, stack.getSize());
  }

  @Test
  void test_reverse_stack() {
    StackArray<String> stackArray = new StackArray<>(String.class);
    stackArray.push("a");
    stackArray.push("l");
    stackArray.push("o");
    stackArray.push("H");
    Assertions.assertEquals("H", stackArray.top());
    log.info("Before reversing Stack {}", stackArray.print());
    stackArray.reverse();
    log.info("After reversing Stack {}", stackArray.print());
    Assertions.assertEquals("a", stackArray.top());

    StackArray<Integer> integerStackArray = new StackArray<>(Integer.class, 20);
    List<Integer> integerList = TestUtils.getSampleData(30000);
    int first = integerList.get(0);
    int last = integerList.get(integerList.size() - 1);

    for (Integer num : integerList) {
      integerStackArray.push(num);
    }

    Assertions.assertEquals(last, integerStackArray.top());
    integerStackArray.reverse();
    Assertions.assertEquals(first, integerStackArray.top());

  }

}
