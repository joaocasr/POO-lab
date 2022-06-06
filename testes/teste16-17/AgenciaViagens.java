import java.io.*;
import java.util.List;
import java.util.Map;

public class AgenciaViagens implements Serializable {
    private Map<String,Hotel> allHotels;
    private Map<String, List<String>> allNifs;

    public void gravaFicheiro(Class<? extends Hotel> type,String fich) throws IOException{
        PrintWriter pw = new PrintWriter(fich);
        for(String hotel: this.allNifs.keySet()){
            if(type.isInstance(this.allHotels.get(hotel)) && this.allNifs.get(hotel).size()>0){
                pw.println(this.allHotels.get(hotel));
            }
        }
        pw.flush();
        pw.close();
    }

    public void carregaFicheiro(String fich) throws ClassNotFoundException,IOException{
        FileInputStream fis = new FileInputStream(fich);
        ObjectInputStream ois = new ObjectInputStream(fis);
        AgenciaViagens a = (AgenciaViagens) ois.readObject();
        ois.close();
    }

}
