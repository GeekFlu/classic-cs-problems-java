package tech.geek.flu.classic.computer.datastructres.heap;

public interface Heap<T> {
  T remove();
  void insert(T value);
  boolean isLeaf(int i);
  int leftChild(int i);
  int rightChild(int i);
  int parent(int i);
}
