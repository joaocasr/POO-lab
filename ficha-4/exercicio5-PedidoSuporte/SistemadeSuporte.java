import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class SistemadeSuporte {
    List<PedidodeSuporte> allPedidos;

    public SistemadeSuporte(SistemadeSuporte s) {
        setAllPedidos(s.getAllPedidos());
    }

    public List<PedidodeSuporte> getAllPedidos() {
        return this.allPedidos.stream().map(PedidodeSuporte::clone)
                .collect(Collectors.toList());
    }

    public void setAllPedidos(List<PedidodeSuporte> l) {
        this.allPedidos = l.stream().map(PedidodeSuporte::clone)
                .collect(Collectors.toList());
    }

    public void inserePedido(PedidodeSuporte pedido) {
        if (!this.allPedidos.contains(pedido))
            this.allPedidos.add(pedido.clone());
    }

    public PedidodeSuporte procuraPedido(String user, LocalDateTime data) {
        return this.allPedidos.stream().map(PedidodeSuporte::clone)
                .filter(x -> x.getCliente().equals(user) &&
                        x.getDataSubmissao().equals(data)).findFirst().orElse(null);
    }

    public void resolvePedido(PedidodeSuporte pedido,
                              String tecnico, LocalDateTime date) {
        PedidodeSuporte p = this.allPedidos.stream().map(PedidodeSuporte::clone)
                .filter(x -> x.equals(pedido))
                .findFirst()
                .orElse(null);
        if (p != null) {
            p.setFuncionario(tecnico);
            p.setDataConclusao(date);
        }
    }

    //iteradores externos
    public List<PedidodeSuporte> resolvidos2() {
        List<PedidodeSuporte> aux = new ArrayList<>();
        Iterator<PedidodeSuporte> it = this.allPedidos.iterator();
        while (it.hasNext()) {
            PedidodeSuporte p = it.next();
            if (p.getDataSubmissao() != null) {
                aux.add(p.clone());
            }
        }
        return aux;
    }

    //iteradores internos
    public List<PedidodeSuporte> resolvidos() {
        return this.allPedidos.stream().map(PedidodeSuporte::clone)
                .filter(x -> x.getDataSubmissao() != null).collect(Collectors.toList());
    }

    //iteradores internos
    public String colaboradorTop() {
        Map<String, List<PedidodeSuporte>> m = this.allPedidos.stream()
                .collect(Collectors.groupingBy(PedidodeSuporte::getFuncionario));
        return m.entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue().size()))
                .stream()
                .findFirst().get().getKey();
    }

    //iterador externo
    public String colaboradorTop2() {
        Map<String, List<PedidodeSuporte>> m = this.allPedidos.stream()
                .collect(Collectors.groupingBy(PedidodeSuporte::getFuncionario));
        String top = "";
        int max = 0;
        for (String s : m.keySet()) {
            if (max < m.get(s).size()) {
                max = m.get(s).size();
                top = s;
            }
        }
        return top;
    }

    public List<PedidodeSuporte> resolvidos(LocalDateTime inicio, LocalDateTime fim) {
        return this.allPedidos.stream().map(PedidodeSuporte::clone)
                .filter(x -> (x.getDataConclusao().isAfter(inicio)
                        && x.getDataConclusao().isBefore(fim)))
                .collect(Collectors.toList());
    }

    public double tempoMedioResolucao() {
        int t = this.allPedidos.stream()
                .mapToInt(x -> x.getDataSubmissao().getMinute() - x.getDataConclusao().getMinute())
                .sum();
        return t * 1.0 / this.allPedidos.size();
    }

    public double tempoMedioResolucao(LocalDateTime
                                              inicio, LocalDateTime fim) {
        List<PedidodeSuporte> l = resolvidos(inicio, fim);
        int t = l.stream()
                .mapToInt(x -> x.getDataSubmissao().getMinute() - x.getDataConclusao().getMinute())
                .sum();
        return t * 1.0 / l.size();
    }

    public PedidodeSuporte pedidoMaisLongo(){
        return this.allPedidos.stream().map(PedidodeSuporte::clone)
                         .sorted(new ComparaPedido()).findFirst().get();
    }

    public PedidodeSuporte pedidoMaisCurto(LocalDateTime
                                                   inicio, LocalDateTime fim){
        List<PedidodeSuporte> l= this.allPedidos.stream().map(PedidodeSuporte::clone)
                .filter(x->x.getDataConclusao().isAfter(inicio) && x.getDataConclusao().isBefore(fim))
                .sorted(new ComparaPedido()).collect(Collectors.toList());
        return l.get(l.size()-1);
    }

    public SistemadeSuporte clone(){
        return new SistemadeSuporte(this);
    }
}
