package tech.geek.flu.classic.computer.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class HuffmanException extends Exception{

  public HuffmanException(){
    super();
  }
  public HuffmanException(String message) {
    super(message);
  }
}
