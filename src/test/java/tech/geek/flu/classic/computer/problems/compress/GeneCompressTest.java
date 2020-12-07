package tech.geek.flu.classic.computer.problems.compress;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class GeneCompressTest {

  @Test
  void compress_test(){
    final String original = "TAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATATAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATA";
    CompressedGene compressed = new CompressedGene(original);
    final String decompressed = compressed.decompress();
    log.info("Decompressed = {}", decompressed);
    Assertions.assertEquals(original, decompressed);
  }
}
