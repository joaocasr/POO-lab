import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Convocatoria {
        private String codJogo;
        private LocalDateTime data;
        private List<Jogador> convocados;


     public void setConvocados(List<Jogador> conv) {
        this.convocados = conv.stream()
                .map(Jogador::clone)
                .collect(Collectors.toList());
     }

    public List<Jogador> getConvocados() {
        List<Jogador> conv = new ArrayList();
        for(Jogador j: this.convocados) {
            conv.add(j.clone());
        }
        return conv;
    }
}
