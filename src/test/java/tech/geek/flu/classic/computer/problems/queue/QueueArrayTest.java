package tech.geek.flu.classic.computer.problems.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.queue.QueueArray;
import tech.geek.flu.classic.computer.problems.TestUtils;


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

}
