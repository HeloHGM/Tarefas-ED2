import java.util.ArrayList;
import java.util.List;

public class BuscaBinaria {
    
    public static List<Integer> buscar(int[] lista, int chave) {
        List<Integer> posicoes = new ArrayList<>();
        int low = 0;
        int high = lista.length - 1;

       
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (lista[mid] < chave) {
                low = mid + 1;
            } else if (lista[mid] > chave) {
                high = mid - 1;
            } else {
                // Chave encontrada, armazena a posição
                posicoes.add(mid);

                // Verifica posições à esquerda
                int left = mid - 1;
                while (left >= 0 && lista[left] == chave) {
                    posicoes.add(left);
                    left--;
                }
                // Verifica posições à direita
                int right = mid + 1;
                while (right < lista.length && lista[right] == chave) {
                    posicoes.add(right);
                    right++;
                }
                break; 
            }
        }

        return posicoes; 
}
}