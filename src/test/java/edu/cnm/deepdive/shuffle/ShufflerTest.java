package edu.cnm.deepdive.shuffle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class ShufflerTest {

  @Test
  void shuffle() {

    Random rng = new Random();

    int[] input = IntStream.generate(rng::nextInt)
        .limit(1000)
        .toArray();
//    int[] input = new int[1000];
//
//    for (int i = 0; i < input.length; i++) {
//      input[i] = rng.nextInt();
//
//    }

    int[] sortedValuesBefore = copySorted(input);

//    int[] sortedValuesBefore = Arrays.copyOf(input, input.length);
//    Arrays.sort(sortedValuesBefore);

    Shuffler shuffler = new Shuffler();
    shuffler.shuffle(input);

    int[] sortedValuesAfter = copySorted(input);

//    int[] sortedValuesAfter = Arrays.copyOf(input, input.length);
//    Arrays.sort(sortedValuesAfter);

    assertArrayEquals(sortedValuesBefore, sortedValuesAfter);
  }

  private static int[] copySorted(int[] input) {
    return IntStream.of(input)
        .sorted()
        .toArray();
  }

}