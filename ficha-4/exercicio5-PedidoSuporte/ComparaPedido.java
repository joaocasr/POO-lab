import java.util.Comparator;

public class ComparaPedido implements Comparator<PedidodeSuporte> {
    public int compare(PedidodeSuporte p1, PedidodeSuporte p2){ //decrescente
        return (p2.getDataConclusao().getMinute()-p2.getDataSubmissao().getMinute())
                - (p1.getDataConclusao().getMinute()-p1.getDataSubmissao().getMinute());
    }
}
