import java.util.ArrayList;
import java.util.List;

public class BuscaSequencial {
    
    public static List<Integer> buscar(int[] lista, int chave) {
        List<Integer> posicoes = new ArrayList<>();
        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == chave) {
                posicoes.add(i);
            }
        }
        
        return posicoes; // Retorna as posições onde a chave foi encontrada
    }
}
