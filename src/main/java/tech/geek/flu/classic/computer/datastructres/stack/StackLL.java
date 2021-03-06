package tech.geek.flu.classic.computer.datastructres.stack;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import tech.geek.flu.classic.computer.datastructres.linked.list.LinkedListUtils;
import tech.geek.flu.classic.computer.datastructres.linked.list.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@Getter
@Setter
public class StackLL<T> implements StackIfc<T> {
  private Node<T> top;
  private int size;

  @Override
  public T pop() {
    if (this.isEmpty()) {
      return null;
    }
    T value = this.top.getValue();
    this.top = this.top.getNext();
    this.size--;
    return value;
  }

  @Override
  public T top() {
    if (Objects.isNull(this.top))
      return null;
    return this.top.getValue();
  }

  @Override
  public boolean push(T value) {
    Node<T> node = new Node<>(value);
    if (!Objects.isNull(this.top)) {
      node.setNext(this.getTop());
    }
    this.top = node;
    this.size++;
    return true;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size <= 0;
  }

  @Override
  public String print() {
    if (this.isEmpty()) {
      return "\n<EMPTY STACK>";
    }
    Node<T> current = this.top;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n|top of stack|\n");
    int counter = 0;
    while (counter < 25 && Objects.nonNull(current)) {
      stringBuilder.append(String.format(LinkedListUtils.TO_STR_TEMPLATE, current.getValue()));
      current = current.getNext();
      counter++;
    }
    return stringBuilder.toString();
  }

  @Override
  public void reverse() {
    if (top == null) {
      return;
    }
    Node<T> prev = null;
    Node<T> current = this.top;
    while (Objects.nonNull(current)) {
      Node<T> next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
    }
    this.top = prev;
  }

  @Override
  public List<T> toList() {
    if (isEmpty()) {
      return Collections.emptyList();
    }
    List<T> list = new ArrayList<>();
    Node<T> current = this.top;
    while (Objects.nonNull(current)) {
      list.add(current.getValue());
      current = current.getNext();
    }
    return list;
  }
}
