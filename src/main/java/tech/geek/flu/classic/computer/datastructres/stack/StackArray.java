package tech.geek.flu.classic.computer.datastructres.stack;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Slf4j
public class StackArray<T> implements StackIfc<T> {
  private T[] arr;
  private int size;
  private int top;
  private int tail;
  private int capacity;
  private static final String TO_STR_TEMPLATE = "|%s|\n";
  private Class<T> classOfT;

  public StackArray(Class<T> clazz) {
    this(clazz, 5);
  }

  public StackArray(Class<T> clazz, int capacity) {
    this.arr = (T[]) Array.newInstance(clazz, capacity);
    this.top = 0;
    this.tail = 0;
    this.capacity = capacity;
    this.classOfT = clazz;
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
    return this.arr[this.top - 1];
  }

  @Override
  public boolean push(T value) {
    if (this.getSize() == this.capacity) {
      // we have to resize the arr
      this.arr = Arrays.copyOf(this.arr, 2 * this.capacity);
      this.capacity = 2 * this.capacity;
    }
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

  @Override
  public String print() {
    if (Objects.isNull(this.arr) || this.getSize() <= 0) {
      return "\n|Empty Stack|";
    }
    int tempTop = this.getTop() - 1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n|top of stack|\n");
    while (tempTop >= 0){
      stringBuilder.append(String.format(TO_STR_TEMPLATE, this.arr[tempTop]));
      tempTop--;
    }
    return stringBuilder.toString();
  }

  @Override
  public void reverse() {
    if(this.isEmpty()){
      return;
    }
    int i = 0;
    int j = this.top - 1;
    while(i < j) {
      T temp = this.arr[i];
      this.arr[i] = this.arr[j];
      this.arr[j] = temp;
      i++;
      j--;
    }
  }
}
