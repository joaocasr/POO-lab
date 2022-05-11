import java.util.Map;

public class Equipa {
    private String clube;
    private Map<String,Jogador> jogadores;
    //...

    public double mediaGolos(String num) throws JogadorNaoExisteException {
        Jogador jog = this.jogadores.get(num);
        if (jog == null) {
            throw new JogadorNaoExisteException(num);
        }
        return jog.mediaGolos();
    }
}
