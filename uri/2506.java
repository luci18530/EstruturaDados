// import scanner
import java.util.Scanner;

public class uri2506 {

    static public class No {
        private int conteudo;
        private No prox;
        
        public No(){
            setProx(null);
        }
    
        public int getConteudo() {
            return conteudo;
        }
    
        public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
        }
    
        public No getProx() {
            return prox;
        }
    
        public void setProx(No prox) {
            this.prox = prox;
        }
    }

    static public class FilaEnc {
        private No inicio;  // aponta para o inicio da fila 
        private No fim;    	// aponta para o fim da fila  
        private int nElementos;
        
        /** Cria uma Fila  */
        public FilaEnc() {
            inicio = null;
            fim = null;
            nElementos = 0;
        }
    
        /**Verifica se a Fila está vazia */
        public boolean vazia () {
            if (nElementos == 0)
                return true;
            else
                return false;
        }
    
        /** Obtém o tamanho da Fila */
        public int tamanho () {
            return nElementos;
        }
    
        /** Consulta o elemento do início da fila
            Retorna -1 se a fila estiver vazia */
        public int primeiro () {
            if (vazia())
                return -1; // Erro: Fila vazia 
    
            return inicio.getConteudo();
        }
    
        /** Insere um elemento no fim de uma fila
            Retorna false se a mem. for insuficiente, true caso contrário*/
        public boolean insere (int valor) {
            No novoNo = new No();
            novoNo.setConteudo(valor);
            novoNo.setProx(null);
    
            if (vazia()){    /*Inserção em fila vazia */
                inicio = novoNo;
            }
            else {
                fim.setProx(novoNo); /* liga com a fila */
            }
            fim = novoNo; // atualiza o novo fim 
            nElementos++;
            return true;
        }
    
        /**Retira o elemento do início da fila e retorna o seu valor
            Retorna -1 se a fila estiver vazia. */
        public int remove() {
            if (vazia()) {
                return -1; // Erro: Fila vazia 
            }
    
            No aux = inicio;
            int valor = inicio.getConteudo();
                    
            //if (inicio == fim){ // Fila com 1 elemento 
            if (tamanho() == 1){ // Fila com 1 elemento 
                fim = null;
            }	
    
            inicio = aux.getProx();
            
            // sugere ao garbage collector que libere a memoria
            //  da regiao apontada por p
            aux = null;
    
            nElementos--;
            return valor;
        }

        // get the value of the element at the given position
        public int getvalor(int pos) {
            if (vazia()) {
                return -1; // Erro: Fila vazia 
            }
            No aux = inicio;
            int i = 0;
            while (i < pos) {
                aux = aux.getProx();
                i++;
            }
            return aux.getConteudo();
        }
    }
    
    
    public static void main(String[] args) {
        //Patients who arrive in the SUS queue undergo a triage immediately and go to the service queue. In triage, the nurse notes the patient's entry time and how many minutes he has until his health condition becomes critical. It is known that patients are seen every 30 minutes (always at full or half-hours) when in the service queue. Triage and care start at 7:00 am, if there is no patient being treated and the queue is empty, the first patient is seen the moment they arrive at the triage. The doctor attends to the last patient in line. The concern is whether any patient has reached a critical condition while not being treated. Therefore, you were invited to check in the queue how many patients reach the critical condition.
        //The input contains several test cases. Each test case starts with a line with the integer N, 0 < N < 25; the number of patients arriving at triage. Next are N lines with the integer values H, M and C, with 7 < H < 19, and 0 ≤ M < 60, the hour and minute that the patient arrives at triage. The patient on line i always arrives before, and at most together with, the patient on line i + 1. E 0 ≤C ≤ 720 the number of minutes before the patient reaches critical health.
        //For each test case, the number of patients who reached the critical condition still in the queue is printed on a single line.
        
        
        FilaEnc filaenc = new FilaEnc();
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int hora, minuto, tempocritico;
        int horaatual = 420; // em minutos ou seja 7*60 = 420
        int horapaciente = 0;
        int horacritico = 0;
        // número de pacientes que atingiram a condição crítica ainda na fila de atendimento. 
        int pacientescriticos = 0;
        for (int i = 0; i < n; i++) {
            hora = input.nextInt();
            minuto = input.nextInt();
            tempocritico = input.nextInt();
            horapaciente = hora*60 + minuto;
            horacritico = horapaciente + tempocritico;
            filaenc.insere(horapaciente);
            // check if the patient is critical
            for (int j = 0; j < filaenc.tamanho(); j++) {
                if (filaenc.getvalor(j) <= horacritico && horacritico <= horaatual) {
                    pacientescriticos++;
                }
            }
            
        }
        // close java util scanner
        input.close();
        // print the number of patients who reached the critical condition still in the queue of attendance.
        System.out.println(pacientescriticos);

    }
}
