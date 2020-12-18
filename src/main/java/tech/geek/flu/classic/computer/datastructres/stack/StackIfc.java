package tech.geek.flu.classic.computer.datastructres.stack;

import java.util.List;

public interface StackIfc<T> {
  T pop();
  T top();
  boolean push(T value);
  int size();
  boolean isEmpty();
  String print();
  void reverse();
  List<T> toList();
}
