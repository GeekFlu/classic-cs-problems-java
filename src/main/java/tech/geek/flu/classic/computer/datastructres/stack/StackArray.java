package tech.geek.flu.classic.computer.datastructres.stack;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;

@Getter
@Slf4j
public class StackArray<T> implements StackIfc<T> {
  private T[] arr;
  private int size;
  private int top;
  private int tail;
  private int capacity;

  public StackArray(Class<T> clazz) {
    this.arr = (T[]) Array.newInstance(clazz, 15);
    this.top = 0;
    this.tail = 0;
    this.capacity = 15;
  }

  @Override
  public T pop() {
    if (this.isEmpty()) {
      return null;
    }
    T topValue = this.arr[this.top - 1];
    this.top--;
    this.size--;
    return topValue;
  }

  @Override
  public T top() {
    if(this.isEmpty()){
      return null;
    }
    return this.arr[this.top];
  }

  @Override
  public boolean push(T value) {
    this.arr[this.top] = value;
    this.size++;
    this.tail++;
    this.top++;
    return true;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size <= 0;
  }
}
