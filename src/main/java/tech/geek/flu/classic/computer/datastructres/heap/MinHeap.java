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
public class MinHeap<T extends Number> implements Heap<Number>, Comparator<Number> {
  private Number[] heap;
  private int size;
  private static final int CONSTANT_INCREASE = 10;

  public MinHeap() {
    this.size = 0;
  }

  public void ensureCapacity() {
    if (this.size == this.heap.length) {
      this.heap = Arrays.copyOf(this.heap, this.heap.length + CONSTANT_INCREASE);
    }
  }

  @Override
  public Number remove() {
    if (this.size == 1) {
      this.size--;
      return this.heap[0];
    }else if (this.size == 2) {
      Number removed = this.heap[0];
      this.size--;
      swap(0, 1);
      return removed;
    }else if(this.size > 2) {
      Number removed = this.heap[0];
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
        if (compare(this.heap[leftChild], this.heap[rightChild]) < 0) {
          // left child is lesser
          if (compare(this.heap[index], this.heap[leftChild]) > 0) {
            swap(index, leftChild);
            index = leftChild;
          }
        } else {
          if (compare(this.heap[index], this.heap[rightChild]) > 0) {
            swap(index, rightChild);
            index = rightChild;
          }
        }
      }else {
        if (outOfBounds(leftChild) && !outOfBounds(rightChild) && compare(this.heap[index], this.heap[rightChild]) > 0) {
          swap(index, rightChild);
        }else if(!outOfBounds(leftChild) && outOfBounds(rightChild) && compare(this.heap[index], this.heap[leftChild]) > 0) {
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
  public void insert(Number value) {
    initializeHeap();
    ensureCapacity();
    this.heap[size] = value;
    this.size++;
    int iNserted = this.size - 1;
    heapifyUP(iNserted);
  }

  private void heapifyUP(int index) {
    int parent = parent(index);
    while (parent >= 0 && compare(this.heap[index], this.heap[parent]) < 0) {
      swap(parent, index);
      index = parent;
      parent = parent(index);
    }
  }

  private void swap(int from, int to) {
    T temp = (T) this.heap[from];
    this.heap[from] = this.heap[to];
    this.heap[to] = temp;
  }

  private void initializeHeap() {
    if (Objects.isNull(this.heap)) {
      this.heap = (T[]) Array.newInstance(Number.class, 10);
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
  public int compare(Number o1, Number o2) {
    if (o1 instanceof Integer) {
      return ((Integer) o1).compareTo(o2.intValue());
    } else if (o1 instanceof Float) {
      return ((Float) o1).compareTo(o2.floatValue());
    }
    return 0;
  }
}
