package tech.geek.flu.classic.computer.problems.heap;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.heap.MinHeap;
import tech.geek.flu.classic.computer.datastructres.tree.HuffmanNode;
import tech.geek.flu.classic.computer.problems.TestUtils;

import java.util.Comparator;
import java.util.List;

@Slf4j
class MinHeapTest {

  @Test
  void test_min_heap_creation() {
    MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, Integer::compareTo);
    Assertions.assertNull(minHeap.remove());
    for (Integer i: TestUtils.getSampleData(9)) {
      minHeap.insert(i);
    }
    minHeap.insert(-1);
    minHeap.insert(-2);
    Assertions.assertNotNull(minHeap);
  }

  @Test
  void test_min_heap_remove() {
    MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, Integer::compareTo);
    minHeap.insert(-1);
    minHeap.insert(-2);
    minHeap.insert(-4);
    minHeap.insert(4);
    minHeap.insert(2);
    minHeap.insert(1);
    Assertions.assertEquals(-4, minHeap.remove());
    Assertions.assertEquals(-2, minHeap.remove());
    Assertions.assertEquals(-1, minHeap.remove());
    Assertions.assertEquals(1, minHeap.remove());
    Assertions.assertEquals(2, minHeap.remove());
    Assertions.assertEquals(4, minHeap.remove());
    Assertions.assertNull(minHeap.remove());
    Assertions.assertNotNull(minHeap);
  }

  @Test
  void test_min_heap_remove_big_test() {
    MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, Integer::compareTo);
    Assertions.assertNotNull(minHeap);
    List<Integer> ll = TestUtils.getSampleData(1_00_000, 10_000_000);
    for (Integer i : ll) {
      minHeap.insert(i);
    }
    ll.sort(Integer::compareTo);
    Assertions.assertEquals(ll.get(0), minHeap.remove());
  }

  @Test
  void test_min_heap_creation_custom_object() {
    Comparator<HuffmanNode<Character>> tComp = Comparator.comparing(HuffmanNode::getFrequency);
    MinHeap<HuffmanNode<Character>> minHeap = new MinHeap(HuffmanNode.class, tComp);

    Assertions.assertNull(minHeap.remove());

    List<HuffmanNode<Character>> huffmanNodeList = TestUtils.getHuffmanNodes(100);
    for (HuffmanNode<Character> node: huffmanNodeList) {
      minHeap.insert(node);
    }

    huffmanNodeList.sort(tComp);
    Assertions.assertNotNull(minHeap);
    Assertions.assertEquals(huffmanNodeList.get(0), minHeap.remove());
    Assertions.assertEquals(huffmanNodeList.get(1).getFrequency(), minHeap.remove().getFrequency());
    HuffmanNode<Character> hn = minHeap.remove();
    while (hn != null) {
      log.info("Frequency = {}, character = {}", hn.getFrequency(), hn.getValue());
      hn = minHeap.remove();
    }
    // No element should be in the min heap
    Assertions.assertNull(minHeap.remove());
    Assertions.assertTrue(minHeap.isEmpty());
  }

}
