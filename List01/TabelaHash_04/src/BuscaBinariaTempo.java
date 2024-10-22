import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscaBinariaTempo {

    public static void main(String[] args) {
        int tamanho = 100_000;
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(10_001);
              }

    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um valor para buscar (entre 0 e 10.000): ");
        int valor = scanner.nextInt();

        long timeOrdI = System.nanoTime(); 
        Arrays.sort(vetor); // Ordena o vetor
        long timeOrdF = System.nanoTime();
        double ord = (timeOrdF - timeOrdI) / 1_000_000.0; 

         long tempoInicioBusca = System.nanoTime(); 
        int posicaoOrdenada = buscaBinaria(vetor, valor);  
        long tempoFimBusca = System.nanoTime();  
        double busca = (tempoFimBusca - tempoInicioBusca) / 1_000_000.0; 

        
        long inicioBuscSO = System.nanoTime();  
        int posicaoNaoOrdenada = buscaBinaria(vetor, valor); 
        long tempoFimNOrd = System.nanoTime();  
        double tempoBuscaSemOrdenacao = (tempoFimNOrd - inicioBuscSO) / 1_000_000.0; 

        System.out.println("=== Resultados da Busca Binária ===");
        if (posicaoOrdenada != -1) {
            System.out.println("Valor " + valor + " encontrado na posição (ordenado): " + posicaoOrdenada);
        } else {
            System.out.println("Valor " + valor + " não encontrado no vetor ordenado.");
        }
        System.out.printf("Tempo de ordenação: %.6f ms\n", ord);
        System.out.printf("Tempo de busca binária (com ordenação): %.6f ms\n", busca);

        if (posicaoNaoOrdenada != -1) {
            System.out.println("Valor " + valor + " encontrado na posição (sem ordenação): " + posicaoNaoOrdenada);
        } else {
            System.out.println("Valor " + valor + " não encontrado no vetor.");
        }
        System.out.printf("Tempo de busca binária (sem ordenação): %.6f ms\n", tempoBuscaSemOrdenacao);

        scanner.close(); 
    }

    
    public static int buscaBinaria(int[] vetor, int chave) {
        int low = 0;
        int high = vetor.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (vetor[mid] < chave) {
                low = mid + 1;
            } else if (vetor[mid] > chave) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1; 
    }
}
