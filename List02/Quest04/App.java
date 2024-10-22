package Quest04;

public class App {
   

    /*public static void bubbleSort(int[] vetor){
    //Para cada elemento da lista
    for (int i = 0; i < vetor.length - 1; i++) {
    for (int j = 0; j < vetor.length - i - 1; j++) {
    //Verifica o elemento com seu adjacente
    if (vetor[j] > vetor[j+1]) {//Se o elemento anterior for maior que o posterior
    // Troca os elementos de posição
    int temp = vetor[j];
    vetor[j] = vetor[j+1];
    vetor[j+1] = temp;
    }
    }
    }
    } */

    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        boolean trocou;
        
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j+1]) {
                    // Troca os elementos de posição
                    int temp = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = temp;
                    trocou = true; // Houve troca
                }
            }
            
            if (!trocou) {
                break;
            }
        }
    }
}        