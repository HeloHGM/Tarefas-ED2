package Quest05;

import java.util.Arrays;
import java.util.Random;
public class App {

    public static void main(String[] args) {
        int size = 100000;
        int[] array = new int[size];
        Random rand = new Random();

        long[] tempExecucao = new long[10];

        for (int i = 0; i < 10; i++) {
             for (int j = 0; j < size; j++) {
                array[j] = rand.nextInt(100000);
            }

            int[] arrayCopy = Arrays.copyOf(array, array.length);

            long comeca = System.nanoTime();
            pivotqiuck(arrayCopy, 0, arrayCopy.length - 1);
            long endTime = System.nanoTime();
            tempExecucao[i] = endTime - comeca;
        }

        

        System.out.println("Tabela de tempos de execução (em nanosegundos):");
        System.out.println("Execução | Dual-Pivot Quicksort");
        for (int i = 0; i < 10; i++) {
            System.out.printf("   %2d     | %12d%n", (i + 1), tempExecucao[i]);
        }
    }

    public static void pivotqiuck(int[] array, int low, int high) {
        if (low < high) {
            //pivôs retornados pela partição
            int[] pivots = partition(array, low, high);

            //recursivamente aplica Dual-Pivot Quicksort nas três partes
            pivotqiuck(array, low, pivots[0] - 1);
            pivotqiuck(array, pivots[0] + 1, pivots[1] - 1);
            pivotqiuck(array, pivots[1] + 1, high);
        }
    }

    //divide o array em três partes usando dois pivôs
    public static int[] partition(int[] array, int low, int high) {
        if (array[low] > array[high]) {
            troca(array, low, high);
        }

        int p1 = array[low];
        int p2 = array[high];
        int lt = low + 1;
        int gt = high - 1;
        int i = low + 1;

        while (i <= gt) {
            if (array[i] < p1) {
                troca(array, i, lt);
                lt++;
            } else if (array[i] > p2) {
                troca(array, i, gt);
                gt--;
                i--;
            }
            i++;
        }

        lt--;
        gt++;

        troca(array, low, lt);
        troca(array, high, gt);

        return new int[]{lt, gt};
    }

    private static void troca(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
