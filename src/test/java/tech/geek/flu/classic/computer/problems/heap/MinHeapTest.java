package tech.geek.flu.classic.computer.problems.heap;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.heap.MinHeap;
import tech.geek.flu.classic.computer.problems.TestUtils;

@Slf4j
class MinHeapTest {

  @Test
  void test_min_heap_creation() {
    MinHeap<Integer> minHeap = new MinHeap<>();
    for (Integer i: TestUtils.getSampleData(9)) {
      minHeap.insert(i);
    }
    minHeap.insert(-1);
    minHeap.insert(-2);
    Assertions.assertNotNull(minHeap);
  }
}
