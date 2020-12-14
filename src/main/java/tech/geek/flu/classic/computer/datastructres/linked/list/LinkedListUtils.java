package tech.geek.flu.classic.computer.datastructres.linked.list;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class LinkedListUtils {
  public static final String TO_STR_TEMPLATE = "|%s|\n";
  private LinkedListUtils() {
  }

  public static <T extends Comparable<T>> LinkedListIfc<T> mergeSortedLists(LinkedListIfc<T> linkedList1, LinkedListIfc<T> linkedList2, T tempValue) {
    if (Objects.isNull(linkedList1) || linkedList1.isEmpty()) {
      return linkedList2;
    }

    if (Objects.isNull(linkedList2) || linkedList2.isEmpty()) {
      return linkedList1;
    }
    Node<T> temp = buildNode(tempValue);
    Node<T> current = temp;
    Node<T> currentL1 = linkedList1.getHead();
    Node<T> currentL2 = linkedList2.getHead();

    while (Objects.nonNull(currentL1) && Objects.nonNull(currentL2)) {
      if(currentL1.getValue().compareTo(currentL2.getValue()) < 0) {
        current.setNext(currentL1);
        current = currentL1;
        currentL1 = currentL1.getNext();
      } else {
        current.setNext(currentL2);
        current = currentL2;
        currentL2 = currentL2.getNext();
      }
    }

    if(Objects.isNull(currentL1)){
      current.setNext(currentL2);
    }

    if(Objects.isNull(currentL2)) {
      current.setNext(currentL1);
    }
    LinkedList<T> newList = new LinkedList<>();
    newList.setHead(temp.getNext());
    return newList;
  }

  public static <T> Node<T> buildNode(T value) {
    return Node.<T>builder()
        .value(value)
        .build();
  }
}
