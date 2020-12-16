package tech.geek.flu.classic.computer.datastructres.queue;

import lombok.extern.slf4j.Slf4j;
import tech.geek.flu.classic.computer.datastructres.linked.list.LinkedListUtils;
import tech.geek.flu.classic.computer.datastructres.linked.list.Node;

import java.util.Objects;

@Slf4j
public class QueueLL<T> implements QueueIfc<T> {
  private int size;
  private Node<T> front;
  private Node<T> tail;
  private Class<T> tClass;

  public QueueLL(Class<T> clazz) {
    this.size = 0;
    this.tClass = clazz;
  }

  @Override
  public T dequeue() {
    if (this.size() <= 0) {
      return null;
    }
    Node<T> node = this.front;
    T value = node.getValue();
    this.front = front.getNext();
    this.size--;
    return value;
  }

  @Override
  public boolean enqueue(T value) {
    Node<T> node = new Node<>(value);
    if (this.isEmpty()) {
      this.tail = node;
      this.front = node;
    } else {
      this.tail.setNext(node);
      this.tail = node;
    }
    this.size++;
    return true;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public T front() {
    if (this.isEmpty())
      return null;
    return this.front.getValue();
  }

  @Override
  public boolean isEmpty() {
    return this.size <= 0;
  }

  @Override
  public String print() {
    if (this.size() <= 0) {
      return "<QUEUE is EMPTY!>";
    }
    StringBuilder stringBuilder = new StringBuilder();
    Node<T> current = this.front;
    stringBuilder.append("\n|Front of Queue|\n");
    int counter = 0;
    while (counter < 25 && Objects.nonNull(current)) {
      stringBuilder.append(String.format(LinkedListUtils.TO_STR_TEMPLATE, current.getValue()));
      current = current.getNext();
      counter++;
    }

    if (counter >= 25) {
      stringBuilder.append("| showing 25 first elements... |");
    }

    return stringBuilder.toString();
  }

  @Override
  public void reverse() {
    if (this.size() <= 0) {
      return;
    }
    Node<T> prev = null;
    Node<T> current = this.front;
    while (Objects.nonNull(current)) {
      Node<T> next = current.getNext();
    }
  }
}
