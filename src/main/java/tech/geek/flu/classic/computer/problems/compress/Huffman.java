package tech.geek.flu.classic.computer.problems.compress;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import tech.geek.flu.classic.computer.datastructres.heap.MinHeap;
import tech.geek.flu.classic.computer.datastructres.tree.HuffmanNode;
import tech.geek.flu.classic.computer.exception.HuffmanException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Builder
public class Huffman {
  @Setter
  @Getter
  private String textToEncode;
  @Getter
  private String textEncoded;
  @Getter
  private HuffmanNode<?> huffmanTree;

  public ImmutablePair<String, HuffmanNode<Character>> encode() throws HuffmanException {
    if (Objects.isNull(textToEncode) || this.textToEncode.length() <= 0) {
      throw new HuffmanException("Text to encode is null");
    }
    Map<Character, Integer> frequencies = getFrequencyTable();
    Comparator<HuffmanNode<Character>> tComp = Comparator.comparing(HuffmanNode::getFrequency);
    MinHeap<HuffmanNode<Character>> minHeap = new MinHeap(HuffmanNode.class, tComp);

    frequencies.keySet().forEach(ch -> {
      HuffmanNode<Character> huffmanNode = new HuffmanNode<>();
      huffmanNode.setFrequency(frequencies.get(ch));
      huffmanNode.setLetter(ch);
      minHeap.insert(huffmanNode);
    });

    while (minHeap.size() > 1) {
      HuffmanNode<Character> h1 = minHeap.remove();
      HuffmanNode<Character> h2 = minHeap.remove();

      if (h2.getFrequency() <= h1.getFrequency()) {
        HuffmanNode<Character> temp = h2;
        h2 = h1;
        h1 = temp;
      }

      HuffmanNode<Character> internal = new HuffmanNode<>();
      internal.setFrequency(h1.getFrequency() + h2.getFrequency());
      internal.setLeft(h1);
      internal.setRight(h2);
      internal.setInternal(true);
      minHeap.insert(internal);
    }
    this.huffmanTree = minHeap.remove();
    HashMap<Character, String> stringHashMap = new HashMap<>();
    encodeHuffmanTree(this.huffmanTree,"", stringHashMap);
    generateEncodedText(stringHashMap);

    return new ImmutablePair(this.textEncoded, this.huffmanTree);
  }

  public String decode() {
    HuffmanNode<?> current = this.huffmanTree;
    StringBuilder decodedString = new StringBuilder();
    for (Character bitChar : textEncoded.toCharArray()) {
      if (bitChar == '0' && current.hasLeft()) {
        current = current.getLeft();
      }else if(current.hasRight()) {
        current = current.getRight();
      }

      if (current.isLeaf()) {
        decodedString.append(current.getLetter());
        current = this.huffmanTree;
      }
    }
    return decodedString.toString();
  }

  private void generateEncodedText(HashMap<Character, String> stringHashMap) {
    StringBuilder builder = new StringBuilder();
    for (Character character : this.textToEncode.toCharArray()) {
      builder.append(stringHashMap.get(character));
    }
    this.textEncoded = builder.toString();
  }

  private void encodeHuffmanTree(HuffmanNode<?> huffmanNode, String code, Map<Character, String> table) {
    if (huffmanNode != null) {
      // we try to ignore internal nodes
      if (!huffmanNode.isInternal()) {
        table.put((Character) huffmanNode.getLetter(), code);
      }
      encodeHuffmanTree(huffmanNode.getLeft(), code + "0", table);
      encodeHuffmanTree(huffmanNode.getRight(), code + "1", table);
    }
  }

  private Map<Character, Integer> getFrequencyTable() {
    Map<Character, Integer> frequencies = new HashMap<>();
    for (char ch : textToEncode.toCharArray()) {
      if (frequencies.containsKey(ch)) {
        frequencies.put(ch, frequencies.get(ch) + 1);
      } else {
        frequencies.put(ch, 1);
      }
    }
    return frequencies;
  }
}
