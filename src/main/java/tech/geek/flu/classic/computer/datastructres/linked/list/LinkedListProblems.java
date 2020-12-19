package tech.geek.flu.classic.computer.datastructres.linked.list;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Objects;

@Slf4j
public class LinkedListProblems {
  private LinkedListProblems() {}
  public static void removeDuplicates(LinkedListIfc<Integer> linkedList) {
    if(Objects.isNull(linkedList) || linkedList.isEmpty()) {
      return;
    }
    HashSet<Integer> integers = new HashSet<>();
    Node<Integer> current = linkedList.getHead();
    Node<Integer> prev = null;
    while (Objects.nonNull(current)) {
      if(integers.contains(current.getValue())) {
        if (Objects.nonNull(prev)) {
          prev.setNext(current.getNext());
          current = prev.getNext();
        }
      }else{
        integers.add(current.getValue());
        prev = current;
        current = current.getNext();
      }
    }
  }
}
