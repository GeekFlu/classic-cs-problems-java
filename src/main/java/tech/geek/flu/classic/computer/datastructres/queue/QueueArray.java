package tech.geek.flu.classic.computer.datastructres.queue;

import lombok.extern.slf4j.Slf4j;
import tech.geek.flu.classic.computer.datastructres.linked.list.LinkedListUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

@Slf4j
public class QueueArray<T> implements QueueIfc<T> {
  private T[] arr;
  private int size;
  private int front;
  private int tail;
  private Class<T> typeOfT;
  private int capacity;

  public QueueArray(Class<T> tClass){
    this(tClass, 15);
  }

  public QueueArray(Class<T> tClass, int capacity) {
    this.size = 0;
    this.front = 0;
    this.tail = 0;
    this.typeOfT = tClass;
    this.capacity = capacity;
    this.arr = (T[]) Array.newInstance(tClass, capacity);
  }

  @Override
  public T dequeue() {
    if (this.isEmpty()){
      return null;
    }
    T val = this.arr[this.front];
    this.arr[this.front] = null;
    this.front++;
    this.size--;
    return val;
  }

  @Override
  public boolean enqueue(T value) {
    if (this.size >= capacity) {
      int newCapacity = 2 * this.capacity;
      this.arr = Arrays.copyOf(this.arr, newCapacity);
      this.capacity = newCapacity;
    }
    this.arr[this.tail] = value;
    this.tail++;
    this.size++;
    return true;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public T front() {
    if (this.isEmpty()) {
      return null;
    }
    return this.arr[this.front];
  }

  @Override
  public T tail() {
    return this.arr[this.tail - 1];
  }

  @Override
  public boolean isEmpty() {
    return this.size <= 0;
  }

  @Override
  public String print() {
    if(this.isEmpty()){
      return "\n<QUEUE IS EMPTY>";
    }
    StringBuilder stringBuilder = new StringBuilder();
    int front = this.front;
    stringBuilder.append("\n|Front of QUEUE|\n");
    int counter = 0;
    while (counter < 10 && front < this.tail) {
      stringBuilder.append(String.format(LinkedListUtils.TO_STR_TEMPLATE, this.arr[front]));
      counter++;
      front++;
    }
    return stringBuilder.toString();
  }

  @Override
  public void reverse() {
    if (this.isEmpty()) {
      return;
    }
    int i = this.front;
    int j = this.tail - 1;
    while (i < j) {
      T temp = this.arr[i];
      this.arr[i] = this.arr[j];
      this.arr[j] = temp;
      i++;
      j--;
    }
  }
}
