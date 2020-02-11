package app;

import java.util.LinkedList;
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int participants = scanner.nextInt();
        int n = scanner.nextInt();
        int[] pizzas = new int[n];

        for (int i = 0; i < n; i++) {
            pizzas[i] = scanner.nextInt();
        }

        int veryBest = 0;
        LinkedList<Integer> veryBestPizzas = new LinkedList<Integer>();

        for (int j = n - 1; j >= 0; j--) {
            int best = 0;
            LinkedList<Integer> bestPizzas = new LinkedList<Integer>();

            for (int i = j; i >= 0; i--) {
                int currentPizzaSlices = pizzas[i];
                if (best + currentPizzaSlices <= participants) {
                    best += currentPizzaSlices;
                    bestPizzas.addFirst(i);
                }
            }

            if (best > veryBest) {
                veryBest = best;
                veryBestPizzas = bestPizzas;
            }
        }

        // Print the solution
        System.out.println(veryBestPizzas.size());
        for (int p : veryBestPizzas) {
            System.out.print(p);
            System.out.print(" ");
        }
        System.out.println();
    }
}
