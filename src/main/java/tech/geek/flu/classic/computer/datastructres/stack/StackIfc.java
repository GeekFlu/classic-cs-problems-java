package tech.geek.flu.classic.computer.datastructres.stack;

public interface StackIfc<T> {
  T pop();
  T top();
  boolean push(T value);
  int size();
  boolean isEmpty();
}
