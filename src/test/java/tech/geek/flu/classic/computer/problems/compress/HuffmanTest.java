package tech.geek.flu.classic.computer.problems.compress;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.tree.HuffmanNode;
import tech.geek.flu.classic.computer.exception.HuffmanException;

@Slf4j
class HuffmanTest {

  @SneakyThrows
  @Test
  void test_huffman_encode() {
    Huffman huffman = Huffman.builder()
        .textToEncode("AAAAAAABBBCCCCCCCDDEEEEEE")
        .build();
    ImmutablePair<String, HuffmanNode<Character>> immutablePair = huffman.encode();
    log.info("Huffman root tree = {}", immutablePair.right);
    Assertions.assertNotNull(immutablePair);
    Assertions.assertEquals("1010101010101000100100111111111111111000000010101010101", immutablePair.left);

    String textToEncodeBig = "Una familia, compuesta por dos pequeños y sus padres, viajaban por carretera hacia [....] cuando el coche se les averió. Los padres salieron a buscar ayuda y, para que los niños no se aburrieran, les dejaron con la radio encendida. Cayó la noche y los padres seguían sin volver cuando escucharon una inquietante noticia en la radio: un asesino muy peligroso se había escapado de un centro penitenciario cercano a [....] y pedían que se extremaran las precauciones.";
    huffman.setTextToEncode(textToEncodeBig);
    immutablePair = huffman.encode();
    Assertions.assertEquals(textToEncodeBig, huffman.decode());
  }

  @Test
  void test_huffman_encode_with_exception() {
    Huffman huffman = Huffman.builder().build();
    Exception exception = Assertions.assertThrows(HuffmanException.class, huffman::encode);
    Assertions.assertTrue(exception.getMessage().contains("Text to encode is null"));
  }

  @Test
  void test_huffman_encode_blank_with_exception() {
    Huffman huffman = Huffman.builder()
        .textToEncode("")
        .build();
    Exception exception = Assertions.assertThrows(HuffmanException.class, huffman::encode);
    Assertions.assertTrue(exception.getMessage().contains("Text to encode is null"));
  }

}
