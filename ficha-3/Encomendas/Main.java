import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinhaEncomenda linha1 = new LinhaEncomenda("A0347","Óculos amarelos",0.1,5.99,2);
        LinhaEncomenda linha2 = new LinhaEncomenda("A0332","Ananás em calda",0.15,3.99,4);
        LinhaEncomenda linha3 = new LinhaEncomenda("A0334","Urso de peluche",0.12,10.99,5);

        ArrayList<LinhaEncomenda> linhas= new ArrayList<>();

        linhas.add(linha1.clone());
        linhas.add(linha2.clone());
        linhas.add(linha3.clone());
    }
}

