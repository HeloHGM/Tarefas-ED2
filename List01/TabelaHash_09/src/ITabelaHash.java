interface ITabelaHash {
    int hash(int chave);
    void put(int chave, Aluno elemento);
    Aluno get(int chave);
    Aluno remove(int chave);
}