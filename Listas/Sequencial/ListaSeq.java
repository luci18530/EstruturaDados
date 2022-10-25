public class ListaSeq{
    // Vetor que contém os dados da lista, estrutura do tipo
    private int dados[];
    private int tamAtual;
    private int tamMax;

    // Construtor
    public ListaSeq() {
        tamMax = 100;
        tamAtual = 0;
        dados = new int[tamMax];
    }

// Definição das Operações

/** Verifica se a Lista está vazia */
public boolean vazia() {
    return (tamAtual == 0);
}

/** Verifica se a Lista está cheia */
public boolean cheia() {
    return (tamAtual == tamMax);
}

/**Obtém o tamanho da Lista*/
public int tamanho() {
    return tamAtual;
}

/** Obtém o i-ésimo elemento de uma lista.
Retorna -1 se a posição for inválida. */
public int elemento(int pos) {
    if (pos < 0 || pos >= tamAtual)
        return -1;
    return dados[pos];
}

/** Retorna a posição de um elemento pesquisado.
Retorna -1 caso não seja encontrado */
public int posicao(int elem) {
    for (int i = 0; i < tamAtual; i++)
        if (dados[i] == elem)
            return i;
    return -1;
}

/**Insere um elemento em uma determinada posição.
Retorna true se a insercao funcionar e
false caso contrário. */
public boolean insere(int pos,int elem) {
    if (cheia() || pos < 0 || pos > tamAtual)
        return false;
    for (int i = tamAtual; i > pos; i--)
        dados[i] = dados[i - 1];
    dados[pos] = elem;
    tamAtual++;
    return true;
}

/** Remove um elemento de uma determinada posição
Retorna o valor do elemento removido e
-1 caso a remoção falhe */
public int remove(int pos) {
    if (vazia() || pos < 0 || pos >= tamAtual)
        return -1;
    int elem = dados[pos];
    for (int i = pos; i < tamAtual - 1; i++)
        dados[i] = dados[i + 1];
    tamAtual--;
    return elem;

}
}