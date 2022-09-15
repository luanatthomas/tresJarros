public class Jarro {

    private long c;
    private long a;
    private long t;
    private boolean jarroCheio;
    private boolean quantidadeDesejada;

    public Jarro(long c, long a, long t) {
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

    public long getC() {
        return c;
    }

    public long getA() {
        return a;
    }

    public long getT() {
        return t;
    }

    public void setA(long a) {
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
            long sobra = Math.abs(destino.getC() - destino.getA() - this.getA());
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
