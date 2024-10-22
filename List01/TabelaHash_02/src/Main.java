import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5, 3, 6, 3, 7, 8};
        
        // Busca sequencial
        List<Integer> posicoesSequencial = BuscaSequencial.buscar(lista, 3);
        System.out.println("Posições encontradas (Busca Sequencial): " + posicoesSequencial);
        
        // Busca binária
        int[] listaOrdenada = {1, 2, 3, 3, 3, 4, 5, 6, 7, 8};
        List<Integer> posicoesBinaria = BuscaBinaria.buscar(listaOrdenada, 3);
        System.out.println("Posições encontradas (Busca Binária): " + posicoesBinaria);
    }
}
