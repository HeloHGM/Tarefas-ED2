
public class TabelaHashEnderecamentoAberto {
    private Aluno[] tabela;
    private int tamanho;
    private final double fatRecg = 0.75;

    public TabelaHashEnderecamentoAberto() {
        this.tabela = new Aluno[8]; 
        this.tamanho = 0;
    }

    // Função hash
    private int hash(int chave) {
        return chave % tabela.length;
    }

    // se exceder dobra e muda
    private void verifica() {
        if (tamanho >= tabela.length * fatRecg) {
            resize();
        }
    }

    // Redimensiona a tabela
    private void resize() {
        Aluno[] tabelaAntiga = tabela;
        tabela = new Aluno[tabelaAntiga.length * 2]; // Dobra 
        tamanho = 0; // reinsere

        // Reinsere
        for (Aluno aluno : tabelaAntiga) {
            if (aluno != null) {
                put(aluno.getMatricula(), aluno);
            }
        }
    }

    // Insere 
    public void put(int chave, Aluno elemento) {
        verifica();
        int pos = hash(chave);

        // se ocupado vai pro prox
        while (tabela[pos] != null) {
            pos = (pos + 1) % tabela.length;
        }

        tabela[pos] = elemento;
        tamanho++;
        imprimir();
    }

    // Busca
    public Aluno get(int chave) {
        int pos = hash(chave);

        // Probing encontrar a chave
        while (tabela[pos] != null) {
            if (tabela[pos].getMatricula() == chave) {
                return tabela[pos];
            }
            pos = (pos + 1) % tabela.length;
        }

        return null;
    }


    public Aluno remove(int chave) {
        int pos = hash(chave);

        while (tabela[pos] != null) {
            if (tabela[pos].getMatricula() == chave) {
                Aluno removido = tabela[pos];
                tabela[pos] = null;
                tamanho--;

                // Rearranja os elementos para corrigir colisões após a remoção
                pos = (pos + 1) % tabela.length;
                while (tabela[pos] != null) {
                    Aluno temp = tabela[pos];
                    tabela[pos] = null;
                    tamanho--;
                    put(temp.getMatricula(), temp); // Reinsere o elemento
                    pos = (pos + 1) % tabela.length;
                }

                return removido;
            }
            pos = (pos + 1) % tabela.length;
        }

        return null; 
    }

    public void imprimir() {
        System.out.println("===== tabela Hash =====");
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] == null) {
                System.out.println("Posição " + i + ": vazia");
            } else {
                System.out.println("Posição " +i +": " + tabela[i].getMatricula() +" (" + tabela[i].getNome() + ")");
            }
        }
    }}