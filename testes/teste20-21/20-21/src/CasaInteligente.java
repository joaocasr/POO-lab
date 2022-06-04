import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {
    private String idCasa;
    private Map<String,SmartDevice> alldevices;
    private Map<String,List<SmartDevice>> allrooms;

    //ex1
    public CasaInteligente(Collection<SmartDevice> devices){
        this.alldevices = new HashMap<>();
        devices.forEach((sd)->alldevices.put(sd.getId(), sd.clone()));
    }
    //ex2
    public void remove(String id) throws DeviceNotExistsException{
        if(alldevices.get(id)==null) throw new DeviceNotExistsException("Device não existe na casa.");
        else alldevices.remove(id);
    }
    //ex3
    public Iterator<SmartDevice> devicesPorConsumoCrescente(){
        Comparator<SmartDevice> c = (c1,c2)-> c1.compareTo(c2);
        return this.alldevices.values().stream().map(SmartDevice::clone).sorted(c).iterator();
        //return this.alldevices.values().stream().map(SmartDevice::clone).sorted(new CompareConsumo()).iterator();
        //return this.alldevices.values().stream().map(SmartDevice::clone).collect(Collectors.toCollection(()->new TreeSet<>(new CompareConsumo()))).iterator();
    }

    //ex4
    public double consumoDivisao(String divisao){
        return allrooms.get(divisao).stream().mapToDouble(sd->sd.getConsumoPorHora()).sum();
    }

    //ex5
    public String divisaoMaisEconomica(){
        Comparator<String> c = (c1,c2)-> (consumoDivisao(c1) - consumoDivisao(c2)==0) ? c1.compareTo(c2) : (int) (consumoDivisao(c1) - consumoDivisao(c2));
        return this.allrooms.keySet().stream().sorted(c).collect(Collectors.toList()).get(0);
    }

    public boolean apenasNumaDivisao(){
        boolean r=false;
        int divisoes = this.allrooms.values().stream().mapToInt(List::size).filter(x->x==0).sum();
        if (divisoes>1) r=true;
        return r;
    }

    public boolean gravaEmFichObjectos(String fich) throws FileNotFoundException, IOException{
        FileOutputStream file = new FileOutputStream(fich);
        ObjectOutputStream os = new ObjectOutputStream(file);
        this.alldevices.values().stream().filter(x->x instanceof SmartSpeaker).map(x->
        {
            try {
                os.writeObject(x);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        });
        os.flush();
        os.close();
        return true;
    }


}
