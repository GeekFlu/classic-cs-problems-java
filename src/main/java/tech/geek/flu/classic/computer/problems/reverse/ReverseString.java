package tech.geek.flu.classic.computer.problems.reverse;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class ReverseString {
  public static String reverse(String inputStr) {
    if (Objects.isNull(inputStr) || inputStr.length() == 0) {
      return null;
    } else {
      int i = 0;
      int j = inputStr.length() - 1;
      char[] cad = inputStr.toCharArray();
      while (i < j){
        char temp = cad[i];
        cad[i] = cad[j];
        cad[j] = temp;
        i++;
        j--;
      }
      return new String(cad);
    }
  }

  public static void main(String[] args) {
    String inputStr = "Luis";
    log.info(reverse(inputStr));
    log.info(reverse("anitalavalatina"));
    log.info(reverse("abcdefghijk"));
  }
}
