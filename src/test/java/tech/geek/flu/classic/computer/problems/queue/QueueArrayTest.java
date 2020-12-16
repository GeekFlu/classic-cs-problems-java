package tech.geek.flu.classic.computer.problems.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.queue.QueueArray;
import tech.geek.flu.classic.computer.problems.TestUtils;

import java.util.List;


@Slf4j
class QueueArrayTest {

  @Test
  void test_queue_creation() {
    QueueArray<String> queueArray = new QueueArray<>(String.class);
    Assertions.assertEquals(0, queueArray.size());
    Assertions.assertTrue(queueArray.isEmpty());
  }

  @Test
  void test_enqueue() {
    QueueArray<String> queueArray = new QueueArray<>(String.class);
    queueArray.enqueue("Persona 1");
    queueArray.enqueue("Persona 2");
    Assertions.assertEquals("Persona 1", queueArray.front());
    log.info("{}", queueArray.print());
  }

  @Test
  void test_increase_capacity() {
    QueueArray<Integer> queueArray = new QueueArray<>(Integer.class);
    TestUtils.getSampleData(250)
        .forEach(queueArray::enqueue);
    Assertions.assertEquals(250, queueArray.size());
    log.info("{}", queueArray.print());
    while (!queueArray.isEmpty()) {
      queueArray.dequeue();
    }
    Assertions.assertEquals(0, queueArray.size());
  }

  @Test
  void test_reverse() {
    QueueArray<Integer> integerQueueLL = new QueueArray<>(Integer.class);
    List<Integer> sampleData = TestUtils.getSampleData(10000);
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
