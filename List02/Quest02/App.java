import java.util.Arrays;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        int size = 100000;
        int[] array = new int[size];
        Random rand = new Random();
 
        long[][] executionTimes = new long[10][6]; 

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < size; j++) {
                array[j] = rand.nextInt(100000);
            }

            // Faz uma cópia para garantir que todos os algoritmos operem sobre o mesmo array original
            int[] arrayCopy = Arrays.copyOf(array, array.length);

            //bubbleSort
            long startTime = System.nanoTime();
            bubbleSort(arrayCopy);
            long endTime = System.nanoTime();
            executionTimes[i][0] = endTime - startTime;

            //insertionSort
            arrayCopy = Arrays.copyOf(array, array.length);
            startTime = System.nanoTime();
            insertionSort(arrayCopy);
            endTime = System.nanoTime();
            executionTimes[i][1] = endTime - startTime;

            //selectionSort
            arrayCopy = Arrays.copyOf(array, array.length);
            startTime = System.nanoTime();
            selectionSort(arrayCopy);
            endTime = System.nanoTime();
            executionTimes[i][2] = endTime - startTime;

            //sheellSort
            arrayCopy = Arrays.copyOf(array, array.length);
            startTime = System.nanoTime();
            shellSort(arrayCopy);
            endTime = System.nanoTime();
            executionTimes[i][3] = endTime - startTime;

            //mergeSort
            arrayCopy = Arrays.copyOf(array, array.length);
            startTime = System.nanoTime();
            mergeSort(arrayCopy, 0, arrayCopy.length - 1);
            endTime = System.nanoTime();
            executionTimes[i][4] = endTime - startTime;

            //quickSort
            arrayCopy = Arrays.copyOf(array, array.length);
            startTime = System.nanoTime();
            quickSort(arrayCopy, 0, arrayCopy.length - 1);
            endTime = System.nanoTime();
            executionTimes[i][5] = endTime - startTime;
        }

        System.out.println("Tabela (em nanosegundos):");//arruma os espaços ainda

        System.out.println("Execução |bubbleSort   |InsertionSort |SelectionSort |ShellSort    |MergeSort    | QuickSort");
        for (int i = 0; i < 10; i++) {
            System.out.printf("   %2d     | %12d | %12d  | %12d  | %12d  | %12d  | %12d%n",
                    (i + 1),
                    executionTimes[i][0],
                    executionTimes[i][1],
                    executionTimes[i][2],
                    executionTimes[i][3],
                    executionTimes[i][4],
                    executionTimes[i][5]) ;
        }
    }


    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean troca;
        for (int i = 0; i < n - 1; i++) {
            troca = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    troca = true;
                }
            }
            if (!troca) break;
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int chave = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = chave;
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static void shellSort(int[] array) {
        int n = array.length;
        for (int buraco = n / 2; buraco > 0; buraco /= 2) {
            for (int i = buraco; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= buraco && array[j - buraco] > temp; j -= buraco) {
                    array[j] = array[j - buraco];
                }
                array[j] = temp;
            }
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int meio = (left + right) / 2;

            mergeSort(array, left, meio);
            mergeSort(array, meio + 1, right);

            merge(array, left, meio, right);
        }
    }

    public static void merge(int[] array, int left, int meio, int right) {
        int n1 = meio - left + 1;
        int n2 = right - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, meio + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
