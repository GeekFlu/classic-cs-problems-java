package tech.geek.flu.classic.computer.datastructres.linked.list;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import tech.geek.flu.classic.computer.exception.LinkedListException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
      Node<T> n = LinkedListUtils.buildNode(value);
      Node<T> current = this.head;
      while (Objects.nonNull(current.getNext())) {
        current = current.getNext();
      }
      current.setNext(n);
    }
    this.size++;
    return true;
  }

  @Override
  public List<T> toList() {
    if (Objects.isNull(this.head)) {
      return Collections.emptyList();
    }
    List<T> arr = new ArrayList<>();
    Node<T> current = this.head;
    while (Objects.nonNull(current)) {
      arr.add(current.getValue());
      current = current.getNext();
    }
    return arr;
  }

  @Override
  public boolean prepend(T value) {
    if (Objects.isNull(this.head)) {
      this.head = new Node<>(value);
    } else {
      Node<T> n = LinkedListUtils.buildNode(value);
      n.setNext(this.head);
      this.head = n;
    }
    this.size++;
    return true;
  }

  @Override
  public Node<T> search(T value) {
    if (Objects.isNull(this.head)) {
      return null;
    }
    Node<T> current = this.head;
    while (Objects.nonNull(current)) {
      if (current.getValue() instanceof Number) {
        if (current.getValue() == value) {
          return current;
        }
      } else {
        if (current.getValue().equals(value)) {
          return current;
        }
      }
      current = current.getNext();
    }
    return null;
  }

  @Override
  public boolean remove(T value) {
    if (Objects.isNull(this.head)) {
      return false;
    }
    Node<T> current = this.head;
    Node<T> prev = null;
    while (Objects.nonNull(current)) {
      if ((current.getValue() instanceof Number && current.getValue() == value) ||
          ( current.getValue().equals(value) )){
        if (Objects.nonNull(prev)) {
          prev.setNext(current.getNext());
        }else {
          this.head = current.getNext();
        }
        return true;
      }
      prev = current;
      current = current.getNext();
    }
    return false;
  }

  @Override
  public void reverse() throws LinkedListException {
    if (this.head == null || this.getSize() <= 0) {
      throw new LinkedListException("Cannot reverse a linked list with head = null");
    }
    Node<T> prev = null;
    Node<T> current = this.head;
    while (Objects.nonNull(current)) {
      Node<T> nextNode = current.getNext();
      current.setNext(prev);
      prev = current;
      current = nextNode;
    }
    this.head = prev;
  }

  @Override
  public boolean isEmpty() {
    return this.size <= 0;
  }

  @Override
  public String print() {
    return this.toList().stream()
        .map(String::valueOf)
        .collect(Collectors.joining(" -> "));
  }

  @Override
  public void setHead(Node<T> head) {
    this.head = head;
  }
}
