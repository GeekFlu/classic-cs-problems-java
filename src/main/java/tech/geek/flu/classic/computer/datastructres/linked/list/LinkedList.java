package tech.geek.flu.classic.computer.datastructres.linked.list;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@Getter
public class LinkedList<T> implements LinkedListIfc<T> {
  private Node<T> head;
  private int size;

  @Override
  public boolean append(T value) {
    if (Objects.isNull(this.head)) {
      this.head = new Node<>(value);
    } else {
      Node<T> n = Node.<T>builder()
          .value(value)
          .build();
      Node<T> current = this.head;
      while (Objects.nonNull(current.getNext())){
        current = current.getNext();
      }
      current.setNext(n);
    }
    this.size++;
    return true;
  }

  @Override
  public List<T> toList() {
    if(Objects.isNull(this.head)){
      return Collections.emptyList();
    }
    List<T> arr = new ArrayList<>();
    Node<T> current = this.head;
    while(Objects.nonNull(current)){
      arr.add(current.getValue());
      current = current.getNext();
    }
    return arr;
  }

  @Override
  public boolean prepend(T value) {

    return false;
  }

  @Override
  public Node<T> search(T value) {
    return null;
  }

  @Override
  public boolean remove(T value) {
    return false;
  }

  @Override
  public void reverse() {
    throw new UnsupportedOperationException();
  }
}
