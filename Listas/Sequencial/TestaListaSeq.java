
// testando a classe ListaSeq
public class TestaListaSeq extends ListaSeq {
    public static void main(String[] args) {
        ListaSeq lista = new ListaSeq();
        System.out.println("Lista vazia? " + lista.vazia());
        System.out.println("Lista cheia? " + lista.cheia());
        System.out.println("Tamanho da lista: " + lista.tamanho());
        System.out.println("Elemento na posicao 0: " + lista.elemento(0));
        System.out.println("Posicao do elemento 10: " + lista.posicao(10));
        System.out.println("Inserindo elemento 10 na posicao 0: " + lista.insere(0, 10));
        System.out.println("Inserindo elemento 20 na posicao 1: " + lista.insere(1, 20));
        System.out.println("Inserindo elemento 30 na posicao 2: " + lista.insere(2, 30));
        System.out.println("Inserindo elemento 40 na posicao 3: " + lista.insere(3, 40));
        System.out.println("Inserindo elemento 50 na posicao 4: " + lista.insere(4, 50));
        System.out.println("Inserindo elemento 60 na posicao 5: " + lista.insere(5, 60));
        System.out.println("Inserindo elemento 70 na posicao 6: " + lista.insere(6, 70));
        System.out.println("Inserindo elemento 80 na posicao 7: " + lista.insere(7, 80));
        System.out.println("Inserindo elemento 90 na posicao 8: " + lista.insere(8, 90));
        System.out.println("Inserindo elemento 100 na posicao 9: " + lista.insere(9, 100));
        System.out.println("Inserindo elemento 110 na posicao 10: " + lista.insere(10, 110));
        System.out.println("Inserindo elemento 120 na posicao 11: " + lista.insere(11, 120));
        System.out.println("Inserindo elemento 130 na posicao 12: " + lista.insere(12, 130));
        System.out.println("Inserindo elemento 140 na posicao 13: " + lista.insere(13, 140));

        // imprime a lista
        System.out.println("Lista: ");
        for (int i = 0; i < lista.tamanho(); i++)
            System.out.print(lista.elemento(i) + " ");
         System.out.println();

        // remover ultimo elemento
        System.out.println("Removendo o ultimo elemento: " + lista.remove(lista.tamanho() - 1));

        // imprime a lista
        System.out.println("Lista: ");
        for (int i = 0; i < lista.tamanho(); i++)
            System.out.print(lista.elemento(i) + " ");  

    }
}