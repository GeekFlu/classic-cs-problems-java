package tech.geek.flu.classic.computer.datastructres.stack;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import tech.geek.flu.classic.computer.datastructres.linked.list.Node;

@Slf4j
@Getter
@Setter
public class StackLL<T> implements StackIfc<T> {
  private Node<T> head;
  private int size;

  @Override
  public T pop() {
    return null;
  }

  @Override
  public T top() {
    return null;
  }

  @Override
  public boolean push(T value) {
    return false;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
