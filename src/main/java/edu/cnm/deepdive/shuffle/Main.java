package edu.cnm.deepdive.shuffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    try {
      int[] data = parseStandardInput();
      System.out.println(Arrays.toString(data));
      Shuffler shuffler = new Shuffler();
      shuffler.shuffle(data);
      System.out.println(Arrays.toString(data));
    } catch (IOException | IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  private static int[] parseCommandLine(String[] args) {
    int[] data = new int[args.length];
    int i = 0;
    try {
      for ( ; i < args.length; i++) {
        data[i] = Integer.parseInt(args[i]);
      }
    } catch (NumberFormatException e) {
      System.err.printf("Parsing failed! %s%n", e.getMessage());
    }
    data = Arrays.copyOf(data, i);
    return data;
  }

  private static int[] parseStandardInput() throws IOException {
    List<Integer> data = new LinkedList<>();
    Reader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    String input;
    try {
      while ((input = buffer.readLine()) != null) {
        data.add(Integer.parseInt(input.strip()));
      }
    } catch (NumberFormatException e) {
      System.err.printf("Parsing failed! %s%n", e.getMessage());
    }
    int[] result = new int[data.size()];
    int position = 0;
    for (int value : data) {
      result[position] = value;
      position++;
    }
    return result;
//    for (String input = buffer.readLine(); input != null; input = buffer.readLine()) {
//
//    }
  }
}
