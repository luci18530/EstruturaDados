public class LSE {
    private No cabeca;
    private int tamanho;

    public LSE(){
        cabeca = null;
        tamanho = 0;
    }

    /** Verifica se a Lista está vazia */
    public boolean vazia() {
        return (tamanho == 0);
    }

    /**Obtém o tamanho da Lista*/
    public int tamanho() {
        No aux = cabeca;
        int cont = 0;
        while (aux != null) {
            cont++;
            aux = aux.getProx();
        }
        return cont;
    }

    /** Obtém o i-ésimo elemento de uma lista
	    Retorna o valor encontrado. */
    public int elemento(int pos) {
        if (vazia() || pos < 0 || pos >= tamanho())
            return -1;
        No aux = cabeca;
        for (int i = 0; i < pos; i++)
            aux = aux.getProx();
        return aux.getConteudo();
    }

    /**Retorna a posição de um elemento pesquisado.
	    Retorna -1 caso não seja encontrado */
    public int posicao(int elem) {
        if (vazia())
            return -1;
        No aux = cabeca;
        int cont = 0;
        while (aux != null) {
            if (aux.getConteudo() == elem)
                return cont;
            cont++;
            aux = aux.getProx();
        }
        return -1;
    }

    /** Insere nó em lista vazia */
    public void insereInicio(int elem) {
        No novo = new No();
        novo.setConteudo(elem);
        novo.setProx(cabeca);
        cabeca = novo;
        tamanho++;   
    }

 	/** Insere nó no meio da lista */
     private boolean insereMeioLista(int pos, int valor){
        // Aloca memoria para novo no
	    No novoNo = new No();
        novoNo.setConteudo(valor);

        // Encontra o no anterior a posicao de insercao
        No aux = cabeca;
        for (int i = 0; i < pos - 1; i++)
            aux = aux.getProx();
        
        // Insere o novo no na lista
        novoNo.setProx(aux.getProx());
        aux.setProx(novoNo);
        tamanho++;
        return true;
     }

    /** Insere nó no fim da lista */
        private boolean insereFimLista(int valor){
        // Aloca memoria para novo no
        No novoNo = new No();
        novoNo.setConteudo(valor);
        // Encontra o ultimo no da lista
        No aux = cabeca;
        while (aux.getProx() != null)
            aux = aux.getProx();
        // Insere o novo no na lista
        novoNo.setProx(null);
        aux.setProx(novoNo);
        tamanho++;
        return true;
        }

    /**Insere um elemento em uma determinada posição
	 Retorna true se conseguir inserir e 
	false caso contrario */
    public boolean insere(int pos, int valor) {
        if (pos < 0 || pos > tamanho())
            return false;
        if (pos == 0)
            insereInicio(valor);
        else if (pos == tamanho())
            insereFimLista(valor);
        else
            insereMeioLista(pos, valor);
        return true;
    }

    /** Remove o primeiro elemento da lista */
    public boolean removeInicio() {
        if (vazia())
            return false;
        cabeca = cabeca.getProx();
        tamanho--;
        return true;
    }

    /** Remove o último elemento da lista */
    public boolean removeFim() {
        if (vazia())
            return false;
        No aux = cabeca;
        while (aux.getProx().getProx() != null)
            aux = aux.getProx();
        aux.setProx(null);
        tamanho--;
        return true;
    }

    /** Remove elemento no meio da lista */
    private boolean removeMeioLista(int pos){
        // Encontra o no anterior a posicao de remocao
        No aux = cabeca;
        
        for (int i = 0; i < pos - 1; i++)
            aux = aux.getProx();

        No atual = aux.getProx();
        // Remove o no da lista
        aux.setProx(aux.getProx().getProx());
        tamanho--;
        atual = null;
        return true;
    }

    /** Remove um elemento de uma determinada posição
        Retorna true se conseguir remover e 
        false caso contrario */

    public boolean remove(int pos) {
        if (vazia() || pos < 0 || pos >= tamanho())
            return false;
        if (pos == 0)
            removeInicio();
        else if (pos == tamanho() - 1)
            removeFim();
        else
            removeMeioLista(pos);
        return true;
    }

    // Imprime a lista
    public void imprime() {
        No aux = cabeca;
        while (aux != null) {
            System.out.print(aux.getConteudo() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

        
}
