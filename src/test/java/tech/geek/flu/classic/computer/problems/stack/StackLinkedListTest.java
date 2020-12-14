package tech.geek.flu.classic.computer.problems.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.stack.StackLL;
import tech.geek.flu.classic.computer.problems.TestUtils;

import java.util.List;

@Slf4j
class StackLinkedListTest {

  @Test
  void test_create_stack() {
    StackLL<String> stack = new StackLL<>();
    stack.push("a");
    stack.push("l");
    stack.push("o");
    stack.push("H"); // <-- top of Stack
    Assertions.assertEquals("H", stack.top());

    List<Integer> integerList = TestUtils.getSampleData(30000);
    int last = integerList.get(integerList.size() - 1);
    StackLL<Integer> stackOfInst = new StackLL<>();
    integerList.forEach(stackOfInst::push);
    Assertions.assertEquals(last, stackOfInst.pop());
  }

  @Test
  void test_print_stack() {
    StackLL<String> stringStackLL = new StackLL<>();
    Assertions.assertTrue(stringStackLL.print().contains("EMPTY"));
    stringStackLL.push("mi mama");
    stringStackLL.push("me mima");
    stringStackLL.push("demasiado");
    stringStackLL.print();
  }

  @Test
  void test_is_empty() {
    StackLL<Integer> integerStackLL = new StackLL<>();
    Assertions.assertTrue(integerStackLL.isEmpty());
    integerStackLL.push(1);
    integerStackLL.push(-100);
    Assertions.assertEquals(2, integerStackLL.getSize());
    log.info("{}", integerStackLL.print());

    Assertions.assertEquals(-100, integerStackLL.pop());
    Assertions.assertEquals(1, integerStackLL.getSize());
    log.info("{}", integerStackLL.print());

    Assertions.assertEquals(1, integerStackLL.pop());
    Assertions.assertEquals(0, integerStackLL.getSize());
    Assertions.assertTrue(integerStackLL.isEmpty());
    log.info("{}", integerStackLL.print());
  }
}
