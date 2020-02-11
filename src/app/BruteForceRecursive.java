package app;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Don't use this solution. It's too slow.
 */

class Solution {
  public static Solution best = new Solution();

  private LinkedList<Integer> pizzas;
  private int result = 0;

  public Solution() {
    this(0, new LinkedList<Integer>());
  }

  public Solution(int result, LinkedList<Integer> pizzas) {
    this.result = result;
    this.pizzas = pizzas;
  }

  public LinkedList<Integer> getPizzas() {
    return pizzas;
  }

  public int getResult() {
    return result;
  }

  public void addResult(int add) {
    this.result += add;
  }

  public void updateBest() {
    if (result > best.getResult()) {
      best = new Solution(result, new LinkedList<Integer>(pizzas));
    }
  }
}

public class BruteForceRecursive {

  private static Scanner scanner = new Scanner(System.in);

  public static void compute(int[] pizzas, int index, int max, Solution solution) {
    int indexSlices = pizzas[index];

    if (solution.getResult() + indexSlices <= max) {
      solution.getPizzas().addLast(index);
      solution.addResult(indexSlices);
      solution.updateBest();

      for (int i = index - 1; i >= 0; i--) {
        compute(pizzas, i, max, solution);
      }

      solution.getPizzas().removeLast();
      solution.addResult(-indexSlices);
    }
  }

  public static void main(String[] args) throws Exception {
    int participants = scanner.nextInt();
    int n = scanner.nextInt();

    int[] pizzas = new int[n];

    for (int i = 0; i < n; i++) {
      pizzas[i] = scanner.nextInt();
    }

    Solution solution = new Solution();
    for (int i = n - 1; i >= 0; i--) {
      compute(pizzas, i, participants, solution);
    }

    System.out.println(Solution.best.getResult());
    for (int p : Solution.best.getPizzas()) {
      System.out.print(p);
      System.out.print(" ");
    }

    System.out.println();
  }
}
