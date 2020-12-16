package tech.geek.flu.classic.computer.datastructres.queue;

public interface QueueIfc<T> {
  T dequeue();
  boolean enqueue(T value);
  int size();
  T front();
  T tail();
  boolean isEmpty();
  String print();
  void reverse();
}
