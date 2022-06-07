public class EntradaBase implements Entrada,Comparable<EntradaBase>{
    @Override
    public String getTermo() {
        return null;
    }

    @Override
    public String getDefinicao() {
        return null;
    }

    @Override
    public Entrada clone() {
        return null;
    }

    @Override
    public int compareTo(EntradaBase o) {
        return this.getTermo().compareTo(o.getTermo());
    }
}
