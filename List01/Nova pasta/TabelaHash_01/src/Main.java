
public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash();
        tabela.imprimir();
        
        Aluno a1 = new Aluno(1234, "Lolo");
        tabela.put(a1.getMatricula(), a1);
        tabela.imprimir();

        Aluno aRecuperado = tabela.get(a1.getMatricula());
        if (aRecuperado != null) {
            System.out.println("Aluno recuperado: " + aRecuperado.getMatricula() + " - " + aRecuperado.getNome());
        }
    }
}