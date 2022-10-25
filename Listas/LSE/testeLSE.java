public class testeLSE {
    public static void main(String[] args) {
        LSE lista = new LSE();
        int dado;
        System.out.println("Lista vazia? " + lista.vazia());
        System.out.println("Tamanho da lista: " + lista.tamanho());
        lista.insere(0,10);
        lista.insere(1,20);
        lista.insere(2,30);
        // printa a lista
        lista.imprime();
        System.out.println("Tamanho da lista: " + lista.tamanho());
        // remove o elemento 20
        lista.remove(1);
        // printa a lista
        lista.imprime();
    }
}