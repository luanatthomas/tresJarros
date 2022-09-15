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

        int c1 = Integer.parseInt(capacidade.split(" ")[0]);
        int c2 = Integer.parseInt(capacidade.split(" ")[1]);
        int c3 = Integer.parseInt(capacidade.split(" ")[2]);

        int a1 = Integer.parseInt(contido.split(" ")[0]);
        int a2 = Integer.parseInt(contido.split(" ")[1]);
        int a3 = Integer.parseInt(contido.split(" ")[2]);

        int t1 = Integer.parseInt(desejado.split(" ")[0]);
        int t2 = Integer.parseInt(desejado.split(" ")[1]);
        int t3 = Integer.parseInt(desejado.split(" ")[2]);

        int[] capacidades = new int[] { c1, c2, c3 }; 
        int[] valores = new int[] { a1, a2, a3 };
        int[] valoresDesejados = new int[] { t1, t2, t3 };

        int quantOperacoes = -1;
        arvore = new ArvoreSeisNodos((long) 0, valores);

        long posicao = insereNodos((long) 0, valoresDesejados, capacidades);

        quantOperacoes = arvore.nivel(posicao);

        if (quantOperacoes == 0) {
            System.out.println("\nImpossível");
        }else{
            System.out.println("\nQuantidade de operações: " + quantOperacoes);
        }

        sc.close();
    }

    public static long insereNodos(long pai, int[] desejado, int[] capacidade) {
        boolean achou = false;
        Jarro jarro1, jarro2, jarro3;
        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p1 = jarro1jarro2(pai, jarro1, jarro2, jarro3);
        achou = arvore.encontrou(desejado, p1);
        if (achou) {
            return p1;
        }
        
        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p2 = jarro1jarro3(pai, jarro1, jarro2, jarro3);
        achou = arvore.encontrou(desejado, p2);
        if (achou) {
            return p2;
        }

        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p3 = jarro2jarro1(pai, jarro1, jarro2, jarro3);
        achou = arvore.encontrou(desejado, p3);
        if (achou) {
            return p3;
        }

        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p4 = jarro2jarro3(pai, jarro1, jarro2, jarro3);
        achou = arvore.encontrou(desejado, p4);
        if (achou) {
            return p4;
        }

        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p5 = jarro3jarro1(pai, jarro1, jarro2, jarro3);
        achou = arvore.encontrou(desejado, p5);
        if (achou) {
            return p5;
        }

        jarro1 = new Jarro(capacidade[0], arvore.getValores(pai)[0], desejado[0]);
        jarro2 = new Jarro(capacidade[1], arvore.getValores(pai)[1], desejado[1]);
        jarro3 = new Jarro(capacidade[2], arvore.getValores(pai)[2], desejado[2]);
        long p6 = jarro3jarro2(pai, jarro1, jarro2, jarro3);
        achou = arvore.encontrou(desejado, p6);
        if (achou) {
            return p6;
        }

        if(p1 != 0) pais.add(p1);
        if(p2 != 0) pais.add(p2);
        if(p3 != 0) pais.add(p3);
        if(p4 != 0) pais.add(p4);
        if(p5 != 0) pais.add(p5);
        if(p6 != 0) pais.add(p6);

        while (!(achou) && !(pais.isEmpty()) && !(achou)) {
            ArrayList<Long> newPais = new ArrayList<>();
            for (Long i : pais) {
                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p1 = jarro1jarro2(i, jarro1, jarro2, jarro3);
                achou = arvore.encontrou(desejado, p1);
                if (achou) {
                    return p1;
                }

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p2 = jarro1jarro3(i, jarro1, jarro2, jarro3);
                achou = arvore.encontrou(desejado, p2);
                if (achou) {
                    return p2;
                }

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p3 = jarro2jarro1(i, jarro1, jarro2, jarro3);
                achou = arvore.encontrou(desejado, p3);
                if (achou) {
                    return p3;
                }

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p4 = jarro2jarro3(i, jarro1, jarro2, jarro3);
                achou = arvore.encontrou(desejado, p4);
                if (achou) {
                    return p4;
                }

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p5 = jarro3jarro1(i, jarro1, jarro2, jarro3);
                achou = arvore.encontrou(desejado, p5);
                if (achou) {
                    return p5;
                }

                jarro1 = new Jarro(capacidade[0], arvore.getValores(i)[0], desejado[0]);
                jarro2 = new Jarro(capacidade[1], arvore.getValores(i)[1], desejado[1]);
                jarro3 = new Jarro(capacidade[2], arvore.getValores(i)[2], desejado[2]);
                p6 = jarro3jarro2(i, jarro1, jarro2, jarro3);
                achou = arvore.encontrou(desejado, p6);
                if (achou) {
                    return p6;
                }

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

        return 0;
    }

    public static Long jarro1jarro2(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro1.transfere(jarro2)) {
            int[] novosValores = new int[] {jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir1(novosValores, pai);
        }
        return r;
    }

    public static Long jarro1jarro3(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro1.transfere(jarro3)) {
            int[] novosValores = new int[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir2(novosValores, pai);
        }
        return r;
    }

    public static Long jarro2jarro1(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro2.transfere(jarro1)) {
            int[] novosValores = new int[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir3(novosValores, pai);
        }
        return r;
    }

    public static Long jarro2jarro3(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro2.transfere(jarro3)) {
            int[] novosValores = new int[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir4(novosValores, pai);
        }
        return r;
    }

    public static Long jarro3jarro1(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro3.transfere(jarro1)) {
            int[] novosValores = new int[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir5(novosValores, pai);
        }
        return r;
    }

    public static Long jarro3jarro2(Long pai, Jarro jarro1, Jarro jarro2, Jarro jarro3) {
        long r = 0;
        if (jarro3.transfere(jarro2)) {
            int[] novosValores = new int[] { jarro1.getA(), jarro2.getA(), jarro3.getA() };
            r = arvore.inserir6(novosValores, pai);
        }
        return r;
    }
}
