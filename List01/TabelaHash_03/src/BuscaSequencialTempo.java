import java.util.Random;
import java.util.Scanner;

public class BuscaSequencialTempo {

    public static void main(String[] args) {
        int tamanho = 100_000;
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(10_001); 
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um valor para buscar (entre 0 e 10.000): ");
        int valorBuscado = scanner.nextInt();

        
        long tempoInicio = System.nanoTime(); // tempo inicial
        int posicao = buscaSequencial(vetor, valorBuscado);
        long tempoFim = System.nanoTime(); //tempo final

        

        double tempoTotal = (tempoFim - tempoInicio) / 1_000_000.0;

    
        
        if (posicao != -1) {
            System.out.println("Valor " + valorBuscado + " encontrado na posição: " + posicao);
        } else {
            System.out.println("Valor " + valorBuscado + " não encontrado no vetor.");
        }

        System.out.printf("Tempo de busca sequencial: %.6f ms\n", tempoTotal);

        scanner.close();
    }

   
    public static int buscaSequencial(int[] vetor, int chave) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                return i; 
            }
        }
        return -1;
    }
}
