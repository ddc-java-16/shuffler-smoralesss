package edu.cnm.deepdive.shuffle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ShufflerTest {

  @Test
  void shuffle() {
    int[] input = new int[1000];
    Random rng = new Random();
    List<Integer> sortedValuesBefore = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      input[i] = rng.nextInt();
      sortedValuesBefore.add(input[i]);
    }
    Collections.sort(sortedValuesBefore);
    Shuffler shuffler = new Shuffler();
    shuffler.shuffle(input);
    List<Integer> sortedValuesAfter = new ArrayList<>();
    for (int value : input) {
      sortedValuesAfter.add(value);
    }
    Collections.sort(sortedValuesAfter);
    assertEquals(sortedValuesBefore, sortedValuesAfter);
  }

}