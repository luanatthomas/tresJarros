public class Jarro {

    private int c;
    private int a;
    private int t;
    private boolean jarroCheio;
    private boolean quantidadeDesejada;

    public Jarro(int c, int a, int t) {
        this.c = c;
        this.a = a;
        this.t = t;
        this.verificaJarroCheio();
        this.verificaQuantidadeDesejada();
    }

    public void verificaJarroCheio() {
        if (a == c) {
            jarroCheio = true;
        } else {
            jarroCheio = false;
        }
    }

    public void verificaQuantidadeDesejada() {
        if (a == t) {
            quantidadeDesejada = true;
        } else {
            quantidadeDesejada = false;
        }
    }

    public int getC() {
        return c;
    }

    public int getA() {
        return a;
    }

    public int getT() {
        return t;
    }

    public void setA(int a) {
        this.a = a;
    }

    public boolean isJarroCheio() {
        return jarroCheio;
    }

    public boolean isQuantidadeDesejada() {
        return quantidadeDesejada;
    }

    public boolean transfere(Jarro destino) {
        if (destino.isJarroCheio()) {
            return false;
        }

        if (this.getA() == 0) {
            return false;
        }

        if (destino.getC() - destino.getA() < this.getA()) {
            int sobra = Math.abs(destino.getC() - destino.getA() - this.getA());
            destino.setA(destino.getA() + this.getA() - sobra);
            this.setA(sobra);

            destino.verificaJarroCheio();
            destino.verificaQuantidadeDesejada();
            this.verificaJarroCheio();
            this.verificaQuantidadeDesejada();

            return true;

        }
        
        if (destino.getC() - destino.getA() >= this.getA()) {
            destino.setA(destino.getA() + this.getA());
            this.setA(0);

            destino.verificaJarroCheio();
            destino.verificaQuantidadeDesejada();
            this.verificaJarroCheio();
            this.verificaQuantidadeDesejada();
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Jarro [c=" + c + ", a=" + a + ", t=" + t + "]";
    }

    
}
