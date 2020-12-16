package tech.geek.flu.classic.computer.problems.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.queue.QueueLL;
import tech.geek.flu.classic.computer.problems.TestUtils;

import java.util.List;

/**
 * Test class for Queue implemented using a Linked list
 */
@Slf4j
class QueueLinkedLLTest {

  @Test
  void test_queue_ll_creation(){
    QueueLL<String> queueLL = new QueueLL<>(String.class);
    Assertions.assertNotNull(queueLL);
    Assertions.assertTrue(queueLL.isEmpty());
    Assertions.assertEquals(0, queueLL.size());
  }

  @Test
  void test_queue_ll_enqueue_dequeue() {
    QueueLL<String> queueLL = new QueueLL<>(String.class);
    queueLL.enqueue("Hola");
    queueLL.enqueue("****");
    queueLL.enqueue("mundo");
    queueLL.enqueue("!");
    Assertions.assertEquals(4, queueLL.size());

    Assertions.assertEquals("Hola", queueLL.front());
    Assertions.assertEquals(4, queueLL.size());

    Assertions.assertEquals("Hola", queueLL.dequeue());
    Assertions.assertEquals(3, queueLL.size());

    queueLL.dequeue();
    Assertions.assertEquals(2, queueLL.size());

    queueLL.dequeue();
    Assertions.assertEquals(1, queueLL.size());

    Assertions.assertEquals("!", queueLL.dequeue());
    Assertions.assertEquals(0, queueLL.size());

    Assertions.assertNull(queueLL.dequeue());

  }

  @Test
  void print_test() {
    QueueLL<Integer> integerQueueLL = new QueueLL<>(Integer.class);
    Assertions.assertTrue(integerQueueLL.print().contains("QUEUE is EMPTY"));
    for (int i = 0; i < 25; i++) {
      integerQueueLL.enqueue(i);
    }
    log.info("Queue = {}", integerQueueLL.print());
    Assertions.assertTrue(integerQueueLL.print().contains("Front of Queue"));
    integerQueueLL.enqueue(44);
    integerQueueLL.enqueue(33);
    integerQueueLL.print();
    Assertions.assertTrue(integerQueueLL.print().contains("showing 25"));
  }

  @Test
  void test_reverse() {
    QueueLL<Integer> integerQueueLL = new QueueLL<>(Integer.class);
    List<Integer> sampleData = TestUtils.getSampleData(10);
    int first = sampleData.get(0);
    int last = sampleData.get(sampleData.size() - 1);
    for(Integer i : sampleData) {
      integerQueueLL.enqueue(i);
    }
    log.info("Before REversing Queue = {}", integerQueueLL.print());
    integerQueueLL.reverse();
    log.info("After REversing Queue = {}", integerQueueLL.print());
    Assertions.assertEquals(last, integerQueueLL.front());
    Assertions.assertEquals(first, integerQueueLL.tail());
  }

}
