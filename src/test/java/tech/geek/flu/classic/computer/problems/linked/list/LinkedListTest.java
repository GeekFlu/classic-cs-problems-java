package tech.geek.flu.classic.computer.problems.linked.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.linked.list.LinkedList;

import java.util.List;

@Slf4j
class LinkedListTest {

  @Test
  void create_link_list(){
    LinkedList<String> linkedListIfc = new LinkedList<>();
    Assertions.assertTrue(linkedListIfc.append("Hola"));
    Assertions.assertTrue(linkedListIfc.append("Mundo"));
    Assertions.assertTrue(linkedListIfc.append("Cruel!!!!"));
    Assertions.assertNotNull(linkedListIfc.getHead());
    Assertions.assertEquals(3, linkedListIfc.getSize());
  }

  @Test
  void linked_list_to_list(){
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
}
