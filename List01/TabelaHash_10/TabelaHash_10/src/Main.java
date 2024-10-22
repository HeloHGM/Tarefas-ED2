
public class Main{
    public static void main(String[] args) {
        TabelaHashEnderecamentoAberto tabela = new TabelaHashEnderecamentoAberto();

        // a
        tabela.put(52, new Aluno(52, "Aluno52"));
        tabela.put(45, new Aluno(45, "Aluno45"));
        tabela.put(64, new Aluno(64, "Aluno64"));
        tabela.put(34, new Aluno(34, "Aluno34"));
        tabela.put(69, new Aluno(69, "Aluno69"));
        tabela.put(11, new Aluno(11, "Aluno11"));
        tabela.put(10, new Aluno(10, "Aluno10"));
        tabela.put(3, new Aluno(3, "Aluno03"));
        tabela.put(6, new Aluno(6, "Aluno06"));
        tabela.put(2, new Aluno(2, "Aluno02"));

        // b) bbusca 45
        Aluno aluno = tabela.get(45);
        if (aluno != null) {
            System.out.println("Aluno encontrado: " + aluno.getMatricula() + " - " + aluno.getNome());
        } else{
            
            System.out.println("Aluno com matrícula 45 não encontrado.");
        }

        // c) busca 75 q n tem
        aluno = tabela.get(75);
        if (aluno != null) {
            System.out.println("Aluno encontrado: " + aluno.getMatricula() + " - " + aluno.getNome());
        } else {
            System.out.println("Aluno com matrícula 75 não encontrado.");
        }

        // d) remove e imprimi
        Aluno removido = tabela.remove(11);
        if (removido != null) {
            System.out.println("Aluno removido: " + removido.getMatricula() + " - " + removido.getNome());
        }
        tabela.imprimir();
    }

}