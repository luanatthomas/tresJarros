import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class ArvoreSeisNodos {

    private Dictionary<Long, int[]> nodos;

    public ArvoreSeisNodos(Long nodoInicial, int[] valores) {
        nodos = new Hashtable<Long, int[]>();
        nodos.put(nodoInicial, valores);
    }

    //filhos de i
    private Long nodo1(Long i) {return (6 * i) + 1;}
    private Long nodo2(Long i) {return (6 * i) + 2;}
    private Long nodo3(Long i) {return (6 * i) + 3;}
    private Long nodo4(Long i) {return (6 * i) + 4;}
    private Long nodo5(Long i) {return (6 * i) + 5;}
    private Long nodo6(Long i) {return (6 * i) + 6;}

    //pai de i
    private Long parent(Long i) {return (long) Math.floor((i - 1) / 6);}

    public long inserir1(int[] novoValor, Long pai) {
        if (procura(novoValor)) {
            return 0;
        }

        Long posicao = nodo1(pai);
        nodos.put(posicao, novoValor);
        return posicao;
    }

    public long inserir2(int[] novoValor, Long pai) {
        if (procura(novoValor)) {
            return 0;
        }
        Long posicao = nodo2(pai);
        nodos.put(posicao, novoValor);
        return posicao;
    }

    public long inserir3(int[] novoValor, Long pai) {
        if (procura(novoValor)) {
            return 0;
        }
        Long posicao = nodo3(pai);
        nodos.put(posicao, novoValor);
        return posicao;
    }

    public long inserir4(int[] novoValor, Long pai) {
        if (procura(novoValor)) {
            return 0;
        }
        Long posicao = nodo4(pai);
        nodos.put(posicao, novoValor);
        return posicao;
    }

    public long inserir5(int[] novoValor, Long pai) {
        if (procura(novoValor)) {
            return 0;
        }
        Long posicao = nodo5(pai);
        nodos.put(posicao, novoValor);
        return posicao;
    }

    public long inserir6(int[] novoValor, Long pai) {
        if (procura(novoValor)) {
            return 0;
        }
        Long posicao = nodo6(pai);
        nodos.put(posicao, novoValor);
        return posicao;
    }

    public int nivel(long posicao) {
        int cont = 0;
        long i = posicao;
        while(i > 0){
            i = parent(i);
            cont++;
        }
        return cont;
    }

    public boolean encontrou(int[] quantDesejada, long i){
        int[] aux = nodos.get(i);
        if (aux[0] == quantDesejada[0] && aux[1] == quantDesejada[1] && aux[2] == quantDesejada[2]) {
            return true;
        }
        return false;
    }

    public boolean procura(int[] novoValor) {
        Enumeration<Long> chaves = nodos.keys();
        while (chaves.hasMoreElements()){
            Long chave = chaves.nextElement();
            int[] a = nodos.get(chave);
            if (a[0] == novoValor[0] && a[1] == novoValor[1] && a[2] == novoValor[2]) {
                return true;
            }
        }
        return false;       
    }

    public int[] getValores(Long i){
        return nodos.get(i);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('[');
        Enumeration<Long> chaves = nodos.keys();
        while (chaves.hasMoreElements()){
            Long chave = chaves.nextElement();
            s.append(chave + " ");
        }
        s.append(']');
        return s.toString();
    }
}