package tech.geek.flu.classic.computer.datastructres.queue;

import lombok.extern.slf4j.Slf4j;
import tech.geek.flu.classic.computer.datastructres.linked.list.Node;

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
    return null;
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
    return 0;
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
    return null;
  }
}
