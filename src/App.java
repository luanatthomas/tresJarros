import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static ArvoreSeisNodos arvore;
    public static ArrayList<Long> pais = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String capacidade = sc.nextLine();
        String contido = sc.nextLine();
        String desejado = sc.nextLine();

        Long c1 = Long.parseLong(capacidade.split(" ")[0]);
        Long c2 = Long.parseLong(capacidade.split(" ")[1]);
        Long c3 = Long.parseLong(capacidade.split(" ")[2]);

        Long a1 = Long.parseLong(contido.split(" ")[0]);
        Long a2 = Long.parseLong(contido.split(" ")[1]);
        Long a3 = Long.parseLong(contido.split(" ")[2]);

        Long t1 = Long.parseLong(desejado.split(" ")[0]);
        Long t2 = Long.parseLong(desejado.split(" ")[1]);
        Long t3 = Long.parseLong(desejado.split(" ")[2]);

        Long[] capacidades = new Long[] { c1, c2, c3 }; 
        Long[] valores = new Long[] { a1, a2, a3 };
        Long[] valoresDesejados = new Long[] { t1, t2, t3 };

        long quantOperacoes = -1;
        arvore = new ArvoreSeisNodos((long) 0, valores);

        insereNodos(0, valoresDesejados, capacidades);

        quantOperacoes = arvore.encontraQuantidadeAguaDesejada(valoresDesejados);

        if (quantOperacoes == 0) {
            System.out.println("\nNão é possível calcular pois excedeu o tamanho do long");
        }else if(quantOperacoes == -1){
            System.out.println("\nImpossível");
        }else{
            System.out.println("\nQuantidade de operações: " + quantOperacoes);
        }

        sc.close();
    }

    public static void insereNodos(long pai, Long[] desejado, Long[] capacidade) {
        Jarro jarro1, jarro2, jarro3;
        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p1 = jarro1jarro2(pai, jarro1, jarro2, jarro3);

        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p2 = jarro1jarro3(pai, jarro1, jarro2, jarro3);

        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p3 = jarro2jarro1(pai, jarro1, jarro2, jarro3);

        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p4 = jarro2jarro3(pai, jarro1, jarro2, jarro3);

        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p5 = jarro3jarro1(pai, jarro1, jarro2, jarro3);

        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p6 = jarro3jarro2(pai, jarro1, jarro2, jarro3);

        if(p1 != 0) pais.add(p1);
        if(p2 != 0) pais.add(p2);
        if(p3 != 0) pais.add(p3);
        if(p4 != 0) pais.add(p4);
        if(p5 != 0) pais.add(p5);
        if(p6 != 0) pais.add(p6);

        while (!(arvore.encontrou(desejado)) && !(pais.isEmpty())) {
            ArrayList<Long> newPais = new ArrayList<>();
            for (Long i : pais) {
                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p1 = jarro1jarro2(i, jarro1, jarro2, jarro3);

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p2 = jarro1jarro3(i, jarro1, jarro2, jarro3);

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p3 = jarro2jarro1(i, jarro1, jarro2, jarro3);

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p4 = jarro2jarro3(i, jarro1, jarro2, jarro3);

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p5 = jarro3jarro1(i, jarro1, jarro2, jarro3);

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p6 = jarro3jarro2(i, jarro1, jarro2, jarro3);

                if(p1 != 0) newPais.add(p1);
                if(p2 != 0) newPais.add(p2);
                if(p3 != 0) newPais.add(p3);
                if(p4 != 0) newPais.add(p4);
                if(p5 != 0) newPais.add(p5);
                if(p6 != 0) newPais.add(p6);
            }

            pais.clear();
            for (Long i : newPais) {
                pais.add(i);
            }
            
        }

    }

    public static Long jarro1jarro2(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro1.transfere(jarro2)) {
            Long[] novosValores = new Long[] {jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir1(novosValores, pai);
        }
        return r;
    }

    public static Long jarro1jarro3(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro1.transfere(jarro3)) {
            Long[] novosValores = new Long[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir2(novosValores, pai);
        }
        return r;
    }

    public static Long jarro2jarro1(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro2.transfere(jarro1)) {
            Long[] novosValores = new Long[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir3(novosValores, pai);
        }
        return r;
    }

    public static Long jarro2jarro3(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro2.transfere(jarro3)) {
            Long[] novosValores = new Long[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir4(novosValores, pai);
        }
        return r;
    }

    public static Long jarro3jarro1(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro3.transfere(jarro1)) {
            Long[] novosValores = new Long[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir5(novosValores, pai);
        }
        return r;
    }

    public static Long jarro3jarro2(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro3.transfere(jarro2)) {
            Long[] novosValores = new Long[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir6(novosValores, pai);
        }
        return r;
    }
}
