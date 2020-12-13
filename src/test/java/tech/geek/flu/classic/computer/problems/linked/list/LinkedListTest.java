package tech.geek.flu.classic.computer.problems.linked.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.linked.list.LinkedList;
import tech.geek.flu.classic.computer.datastructres.linked.list.LinkedListIfc;
import tech.geek.flu.classic.computer.datastructres.linked.list.LinkedListUtils;
import tech.geek.flu.classic.computer.datastructres.linked.list.Node;
import tech.geek.flu.classic.computer.exception.LinkedListException;

import java.util.List;

@Slf4j
class LinkedListTest {

  @Test
  void create_link_list() {
    LinkedList<String> linkedListIfc = new LinkedList<>();
    Assertions.assertTrue(linkedListIfc.append("Hola"));
    Assertions.assertTrue(linkedListIfc.append("Mundo"));
    Assertions.assertTrue(linkedListIfc.append("Cruel!!!!"));
    Assertions.assertNotNull(linkedListIfc.getHead());
    Assertions.assertEquals(3, linkedListIfc.getSize());
  }

  @Test
  void linked_list_to_list() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    Assertions.assertEquals(0, linkedList.toList().size());

    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(4);
    linkedList.append(5);
    List<Integer> list = linkedList.toList();
    List<Integer> ints = List.of(1, 2, 3, 4, 5);
    Assertions.assertEquals(ints, list);
  }

  @Test
  void linked_list_test_prepend() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.prepend("a");
    linkedList.prepend("l");
    linkedList.prepend("o");
    linkedList.prepend("H");
    List<String> lst = linkedList.toList();
    List<String> expected = List.of("H", "o", "l", "a");

    Assertions.assertEquals(expected, lst);

  }

  @Test
  void search_strings() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.prepend("a");
    linkedList.prepend("l");
    linkedList.prepend("o");
    linkedList.prepend("H");
    Node<String> node = linkedList.search("l");
    Assertions.assertNotNull(node);
    Assertions.assertEquals("l", node.getValue());
  }

  @Test
  void search_ints() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.prepend(1);
    linkedList.append(45);
    linkedList.append(88);
    linkedList.append(-1234);
    linkedList.append(-124);
    linkedList.append(-1223434);
    linkedList.prepend(0);

    Node<Integer> node = linkedList.search(-124);
    Assertions.assertNotNull(node);
    Assertions.assertEquals(-124, node.getValue());

    Node<Integer> nNull = linkedList.search(6789);
    Assertions.assertNull(nNull);
  }

  @Test
  void remove_element() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.prepend(1);
    linkedList.append(45);
    linkedList.append(88);
    linkedList.append(-1234);
    linkedList.append(-124);
    linkedList.append(-1223434);
    linkedList.prepend(0);

    log.info("Before removing = {}, final linked list = {}", 88, linkedList.print());
    Assertions.assertTrue(linkedList.remove(88));
    Assertions.assertTrue(linkedList.remove(-1223434));
    Assertions.assertFalse(linkedList.remove(-510));
    log.info("After removing = {}, final linked list = {}", 88, linkedList.print());

  }

  @Test
  void linked_list() throws LinkedListException {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.prepend("a");
    linkedList.prepend("l");
    linkedList.prepend("o");
    linkedList.prepend("H");
    log.info("Before reverse: {}", linkedList.print());
    linkedList.reverse();
    log.info("After reverse: {}", linkedList.print());
    Assertions.assertEquals(List.of("a", "l", "o", "H"), linkedList.toList());

    LinkedList<Integer> linkedList1 = new LinkedList<>();
    linkedList1.append(110);
    linkedList1.append(210);
    linkedList1.append(310);
    linkedList1.append(410);
    log.info("Before reverse list = {}", linkedList1.print());
    linkedList1.reverse();
    log.info("After reverse list = {}", linkedList1.print());
    Assertions.assertEquals(List.of(410, 310, 210, 110), linkedList1.toList());
  }

  @Test()
  void test_linked_list_exception() {
    LinkedList<String> ll = new LinkedList<>();
    Exception exception = Assertions.assertThrows(LinkedListException.class, ll::reverse);
    Assertions.assertTrue(exception.getMessage().contains("Cannot reverse a linked list"));
  }

  @Test
  void test_merge() {
    LinkedList<Integer> linkedList1 = new LinkedList<>();
    linkedList1.append(110);
    linkedList1.append(210);
    linkedList1.append(310);
    linkedList1.append(410);

    LinkedList<Integer> linkedList2 = new LinkedList<>();
    linkedList2.append(120);
    linkedList2.append(220);
    linkedList2.append(320);
    linkedList2.append(520);
    log.info("Merging linked list = {} and linked list = {}", linkedList1.print(), linkedList2.print());
    LinkedListIfc<Integer> mergedList = LinkedListUtils.mergeSortedLists(linkedList1, linkedList2, 3);
    log.info("Merged Linked List = {}", mergedList.print());
    List<Integer> expected = List.of(110, 120, 210, 220, 310, 320, 410, 520);
    Assertions.assertEquals(expected, mergedList.toList());

  }

}
