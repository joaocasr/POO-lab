import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {
    private List<SmartDevice> allDevices;
    private Map<String,List<String>> devicesRoom;

    public CasaInteligente(Collection<SmartDevice> devices){
        setallDevices(devices);
    }

    public CasaInteligente(CasaInteligente ci){
        setallDevices(ci.getallDevices());
        setdevicesRoom(ci.getdevicesRoom());
    }


    public void remove(String id) throws dispositivoInexistenteException{ // perguntar se esta +/-
        if(!this.devicesRoom.values().stream().flatMap(List::stream).collect(Collectors.toList()).remove(id))
            throw new dispositivoInexistenteException("O device "+id+" que digitou não existe!");
        if(!this.allDevices.stream().map(SmartDevice::getID).filter(a -> a.equals(id)).toList().contains(id))
            throw new dispositivoInexistenteException("O device "+id+" que digitou não existe!");
        this.allDevices.stream().map(SmartDevice::clone).filter(a->a.getID().equals(id)).forEach(a->allDevices.remove(a));
    }


    public Iterator<SmartDevice> devicesPorConsumoCrescente(){ // perguntar iterator
        Iterator<SmartDevice> it = this.allDevices.stream().map(SmartDevice::clone).sorted(new CompareConsumo()).collect(Collectors.toList()).iterator();
        return it;
    }

    public boolean apenasNumaDivisao(){
        boolean r=false;
        List<String> lista = this.devicesRoom.values().stream().flatMap(List::stream).collect(Collectors.toList());
        if(lista.stream().distinct().count()==lista.size()) r=true;
        return r;
    }

    public SmartDevice getDevice(String id){
        Iterator<SmartDevice> it = allDevices.iterator();
        boolean found=false;
        while(it.hasNext() && !found){
            SmartDevice sd = it.next();
            if(sd.getID().equals(id)){
                found=true;
                return sd.clone();
            }
        }
        return null;
    }

    public String divisaoMaisEconomica(){
        double total=0.0;
        double max= 0.0; String room="";
        for(String divisao : devicesRoom.keySet()){
            for(String id: this.devicesRoom.get(divisao)){
                total += getDevice(id).getConsumoPorHora();
            }
            if(total>max){
                max = total;
                room = divisao;
            }
        }
        return room;
    }

    public void gravaEmFichObjectos(String fich) throws FileNotFoundException, IOException{ //perguntar boolean
        FileOutputStream f = new FileOutputStream(fich);
        ObjectOutputStream oos = new ObjectOutputStream(f);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public void setallDevices(Collection<SmartDevice> list){
        this.allDevices = list.stream().map(SmartDevice::clone).collect(Collectors.toList());
    }

    public List<SmartDevice> getallDevices(){
        return this.allDevices.stream().map(SmartDevice::clone).collect(Collectors.toList());
    }

    public void setdevicesRoom(Map<String,List<String>> devicesDivisao){
        this.devicesRoom = new HashMap<>(devicesDivisao.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)));
    }

    public Map<String,List<String>> getdevicesRoom(){
        return this.devicesRoom.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }


}
