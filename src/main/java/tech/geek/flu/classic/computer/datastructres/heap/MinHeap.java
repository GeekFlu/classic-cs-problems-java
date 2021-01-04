package tech.geek.flu.classic.computer.datastructres.heap;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Reference https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
 *
 * @param <T>
 */

@Slf4j
public class MinHeap<T> implements Heap<T>, Comparator<T> {
  private T[] heap;
  private int size;
  private static final int CONSTANT_INCREASE = 10;
  private Class<T> tClass;
  private Comparator<T> comparator;

  public MinHeap(Class<T> tClass, Comparator<T> tComparator) {
    this.size = 0;
    this.tClass = tClass;
    this.comparator = tComparator;
  }

  public void ensureCapacity() {
    if (this.size == this.heap.length) {
      this.heap = Arrays.copyOf(this.heap, this.heap.length + CONSTANT_INCREASE);
    }
  }

  @Override
  public T remove() {
    if (this.size == 1) {
      this.size--;
      return this.heap[0];
    }else if (this.size == 2) {
      T removed = this.heap[0];
      this.size--;
      swap(0, 1);
      return removed;
    }else if(this.size > 2) {
      T removed = this.heap[0];
      swap(0, this.size - 1);
      this.size--;
      heapifyDown(0);
      return removed;
    }else {
      return null;
    }
  }

  private void heapifyDown(int index) {
    while (!isLeaf(index)) {
      int leftChild = leftChild(index);
      int rightChild = rightChild(index);
      if (!outOfBounds(leftChild) && !outOfBounds(rightChild)) {
        if (comparison(this.heap[leftChild], this.heap[rightChild]) < 0) {
          // left child is lesser
          if (comparison(this.heap[index], this.heap[leftChild]) > 0) {
            swap(index, leftChild);
            index = leftChild;
          }
        } else {
          if (comparison(this.heap[index], this.heap[rightChild]) > 0) {
            swap(index, rightChild);
            index = rightChild;
          }
        }
      }else {
        if (outOfBounds(leftChild) && !outOfBounds(rightChild) && comparison(this.heap[index], this.heap[rightChild]) > 0) {
          swap(index, rightChild);
        }else if(!outOfBounds(leftChild) && outOfBounds(rightChild) && comparison(this.heap[index], this.heap[leftChild]) > 0) {
          swap(index, leftChild);
        }
        break;
      }
    }
  }

  private boolean outOfBounds(int index) {
    return index > (this.size - 1);
  }

  @Override
  public void insert(T value) {
    initializeHeap();
    ensureCapacity();
    this.heap[size] = value;
    this.size++;
    int iNserted = this.size - 1;
    heapifyUP(iNserted);
  }

  private void heapifyUP(int index) {
    int parent = parent(index);
    while (parent >= 0 && comparison(this.heap[index], this.heap[parent]) < 0) {
      swap(parent, index);
      index = parent;
      parent = parent(index);
    }
  }

  private void swap(int from, int to) {
    T temp = this.heap[from];
    this.heap[from] = this.heap[to];
    this.heap[to] = temp;
  }

  private void initializeHeap() {
    if (Objects.isNull(this.heap)) {
      this.heap = (T[]) Array.newInstance(tClass, 10);
    }
  }

  @Override
  public boolean isLeaf(int index) {
    return leftChild(index) > this.size && rightChild(index) > this.size;
  }

  @Override
  public int leftChild(int index) {
    return (2 * index) + 1;
  }

  @Override
  public int rightChild(int index) {
    return (2 * index) + 2;
  }

  @Override
  public int parent(int index) {
    return (index - 1) / 2;
  }

  @Override
  public int compare(T o1, T o2) {
    if (o1 instanceof Integer) {
      return ((Integer) o1).compareTo((Integer) o2);
    } else if (o1 instanceof Float) {
      return ((Float) o1).compareTo((Float) o2);
    }
    return 0;
  }

  public int comparison(T o1, T o2) {
    return this.comparator.compare(o1, o2);
  }

  public void setComparator(Comparator<T> theComparator) {
    this.comparator = theComparator;
  }
}
