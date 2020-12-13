package tech.geek.flu.classic.computer.datastructres.linked.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Node<T> {
  private T value;
  private Node<T> next;
  public Node(T val) {
    this.value = val;
  }

  @Override
  public String toString() {
    return "Node{" +
        "value=" + value +
        '}';
  }
}
