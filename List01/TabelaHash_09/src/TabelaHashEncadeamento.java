import java.util.ArrayList;

public class TabelaHashEncadeamento implements ITabelaHash {
    private ArrayList<Aluno>[] tabela;

    @SuppressWarnings("unchecked")// pra para de aparece avido
    public TabelaHashEncadeamento() {
        this.tabela = new ArrayList[8];
        for (int i = 0; i < tabela.length; i++) {
            // Inicializa as listas em cada posição
            tabela[i] = new ArrayList<>(); 
        }
    }

    @Override
    public int hash(int chave) {
        return chave % tabela.length; 
    }

    @Override
    public void put(int chave, Aluno elemento) {
        // Calcula a posição pela função hash
        int pos = hash(chave);
         
         // add o aluno na lista
        tabela[pos].add(elemento);
         
        imprimir(); 
    }

    @Override
    public Aluno get(int chave) {
        // Calcula a posição pela função hash
        int pos = hash(chave); 
        //procura o aluno
        for (Aluno a : tabela[pos]) { 
            if (a.getMatricula() == chave) {
                return a; 
            }
        }
        return null; 
    }

    @Override
    public Aluno remove(int chave) {
        // Calcula a posição pela função hash
        int pos = hash(chave);
        //procura o aluno e remove caso acha
        for (Aluno a : tabela[pos]) { 
            if (a.getMatricula() == chave) {
                tabela[pos].remove(a); 
                return a; 
            }
        }
        return null; // Retorna null se não encontrar
    }

    public void imprimir() {
        System.out.println("===== tabela Hash =====");
        for (int i = 0; i < tabela.length; i++) {
            System.out.print("Posição " + i + ": ");
            if (tabela[i].isEmpty()) {
                System.out.println("pos vazia");
            } else {
                for (Aluno a : tabela[i]) {
                    System.out.print(a.getMatricula() + " (" + a.getNome() + ") ");
                }
                System.out.println();
            }
        }
    }}