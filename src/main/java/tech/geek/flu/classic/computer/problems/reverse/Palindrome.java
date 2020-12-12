package tech.geek.flu.classic.computer.problems.reverse;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.Objects;

@Slf4j
public class Palindrome {
  public static boolean isPalindrome(String inputSrt){
    if(Objects.isNull(inputSrt) || inputSrt.length() <= 0) {
      return false;
    }else {
      // We can reverse the string and then compare it with the original string - Iterative solution

      char[] cad = inputSrt.toLowerCase(Locale.ROOT).replace(" ","").toCharArray();
      int i = 0;
      int j = cad.length - 1;
      while (i < j){
        char temp = cad[i];
        cad[i] = cad[j];
        cad[j] = temp;
        i++;
        j--;
      }
      String reversed = new String(cad);
      return reversed.equals(inputSrt);
    }
  }
  public static void main(String[] args) {
    if(isPalindrome("anitalavalatina")){
      log.info("Es palindrome");
    }
  }
}
