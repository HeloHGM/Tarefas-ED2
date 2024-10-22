
class TabelaHash implements ITabelaHash {
    private Aluno[] tabela;

    public TabelaHash() {
        this.tabela = new Aluno[109];
    }

    @Override
    public int hash(int chave) {
        return chave % tabela.length;
    }

    @Override
    public void put(int chave, Aluno elemento) {
        int pos = this.hash(chave);
        while (tabela[pos] != null) {
            pos = (pos + 1) % tabela.length;
        }
        tabela[pos] = elemento;
    }

    @Override
    public Aluno get(int chave) {
        int pos = this.hash(chave);
        while (tabela[pos] != null) {
            if (tabela[pos].getMatricula() == chave) {
                return tabela[pos];
            }
            pos = (pos + 1) % tabela.length;
        }
        return null;
    }

    @Override
    public Aluno remove(int chave) {
        int pos = this.hash(chave);
        while (tabela[pos] != null) {
            if (tabela[pos].getMatricula() == chave) {
                Aluno elemento = tabela[pos];
                tabela[pos] = null;
                return elemento;
            }
            pos = (pos + 1) % tabela.length;
        }
        return null;
    }

    public void imprimir() {
        int i = 0;
        while (i < tabela.length) {
            if (tabela[i] == null) {
                System.out.println("Posição " + i + ": vazia");
            } else {
                System.out.println("Posição " + i + ": " + tabela[i].getMatricula() + " (" + tabela[i].getNome() + ")");
            }
            i++;
        }
    }
}