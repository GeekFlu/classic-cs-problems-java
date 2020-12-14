package tech.geek.flu.classic.computer.datastructres.queue;

public interface QueueIfc<T> {
  T dequeue();
  boolean enqueue(T value);
  int size();
  T front();
  boolean isEmpty();
  String print();
}
