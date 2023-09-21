package edu.cnm.deepdive.shuffle;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

public class Shuffler {

  public static final String EMPTY_ARRAY_MESSAGE = "Array must not be null or empty.";

  private final Random rng;

  public Shuffler() {
    rng = new SecureRandom();
  }

  /**
   * Shuffles the {@code data} array in-place. This method uses the Fisher-Yates shuffle algorithm to
   * shuffle an {@code int[]}.
   *
   * @param data Unshuffled {@code int[]} source.
   * @throws IllegalArgumentException If {@code data} is {@code null} or empty.
   */
  public void shuffle(int[] data) throws IllegalArgumentException {
    if (data == null || data.length == 0) {
      throw new IllegalArgumentException(EMPTY_ARRAY_MESSAGE);
    }
    for (int destPos = data.length - 1; destPos >= 1; destPos--) {
      // Complete the steps to select and swap a random element with element destPos.
      int srcPos = rng.nextInt(destPos + 1);
      if (srcPos != destPos) {
        int temp = data[destPos];
        data[destPos] = data[srcPos];
        data[srcPos] = temp;
      }
    }
  }

}
