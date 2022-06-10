import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MsgMap {
    private TreeMap<String,ArrayList<Mensagem>> msgBox;

    public MsgMap(){
        this.msgBox = new TreeMap<>();
    }

    public MsgMap(MsgMap m){
        setAllMsgBox(m.getAllMsgBox());
    }

    public int tamanho(){
        return this.msgBox.values().stream().mapToInt(ArrayList::size).sum();
    }

    public int quantosDe(String remetente){
        return (int) (this.msgBox.values().stream().flatMap(List::stream).filter(x->x.getRemetente().equals(remetente)).count());
    }

    public void antiSpam(String palavra){
        for(String s : this.msgBox.keySet()){
            this.msgBox.get(s).removeIf(m -> m.getAssunto().equals(palavra));
        }
    }

    public Map<String, List<Mensagem>> msgDeRemetente(){
        return this.msgBox.values().stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(Mensagem::getRemetente,TreeMap::new,Collectors.mapping(Mensagem::clone,Collectors.toList())));
    }

    /**************************** GETTERS E SETTERS ********************************************/
    public TreeMap<String,ArrayList<Mensagem>> getAllMsgBox(){
        TreeMap<String,ArrayList<Mensagem>> aux = new TreeMap<>();
        for(String s: this.msgBox.keySet()){
            List<Mensagem> l = this.msgBox.get(s).stream().map(Mensagem::clone).collect(Collectors.toList());
            aux.put(s, (ArrayList<Mensagem>) l);
        }
        return aux;
    }

    public void setAllMsgBox(TreeMap<String,ArrayList<Mensagem>> m){
        this.msgBox = new TreeMap<>();
        for(String s: m.keySet()){
            List<Mensagem> l = this.msgBox.get(s).stream().map(Mensagem::clone).collect(Collectors.toList());
            this.msgBox.put(s, (ArrayList<Mensagem>) l);
        }
    }
    /*********************************************+********************************************/

    /** Destinatario recebe a mensagem */
    public void addMsg(Mensagem m){
        if(this.msgBox.containsKey(m.getDestinatario())){
            this.msgBox.get(m.getDestinatario()).add(m.clone());
        }else{
            ArrayList<Mensagem> l = new ArrayList<>();
            l.add(m.clone());
            this.msgBox.put(m.getDestinatario(),l);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        this.msgBox.entrySet().forEach(x->sb.append(x.getKey()).append(x.getValue()));

        return sb.toString();
    }

    public MsgMap clone(){
        return new MsgMap(this);
    }

}
