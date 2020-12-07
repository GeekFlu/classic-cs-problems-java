package tech.geek.flu.classic.computer.problems.compress;

import lombok.extern.slf4j.Slf4j;

import java.util.BitSet;
import java.util.Objects;

@Slf4j
public class CompressedGene {
  private BitSet bitSet;
  private int length;

  public CompressedGene(String gene) {
    compress(gene);
  }

  public String decompress() {
    if (Objects.isNull(bitSet)) {
      return "";
    }
    // create a mutable place for characters with right capacity
    StringBuilder builder = new StringBuilder(length / 2);
    for (int i = 0; i < (length * 2); i += 2) {
      final int firstBit = (bitSet.get(i) ? 1 : 0);
      final int secondBit = (bitSet.get(i + 1) ? 1 : 0);
      final int lastBits = firstBit << 1 | secondBit;
      switch (lastBits) {
        case 0b00: // 00 is 'A'
          builder.append('A');
          break;
        case 0b01: // 01 is 'C'
          builder.append('C');
          break;
        case 0b10: // 10 is 'G'
          builder.append('G');
          break;
        case 0b11: // 11 is 'T'
          builder.append('T');
          break;
      }
    }
    return builder.toString();
  }

  private void compress(String gene) {
    length = gene.length();
    // reserve enough capacity for all of the bits
    bitSet = new BitSet(length * 2);
    // convert to upper case for consistency
    final String upperGene = gene.toUpperCase();
    // convert String to bit representation
    for (int i = 0; i < length; i++) {
      final int firstLocation = 2 * i;
      final int secondLocation = 2 * i + 1;
      switch (upperGene.charAt(i)) {
        case 'A': // 00 are next two bits
          bitSet.set(firstLocation, false);
          bitSet.set(secondLocation, false);
          break;
        case 'C': // 01 are next two bits
          bitSet.set(firstLocation, false);
          bitSet.set(secondLocation, true);
          break;
        case 'G': // 10 are next two bits
          bitSet.set(firstLocation, true);
          bitSet.set(secondLocation, false);
          break;
        case 'T': // 11 are next two bits
          bitSet.set(firstLocation, true);
          bitSet.set(secondLocation, true);
          break;
        default:
          throw new IllegalArgumentException("The provided gene String contains characters other than ACGT");
      }
    }
  }
}
