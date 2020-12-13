package tech.geek.flu.classic.computer.datastructres.linked.list;

import java.util.List;

public interface LinkedListIfc<T> {
  boolean append(T value);
  List<T> toList();
  boolean prepend(T value);
  Node<T> search(T value);
  boolean remove(T value);
  void reverse();
}
