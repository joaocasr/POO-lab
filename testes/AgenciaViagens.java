import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgenciaViagens implements Serializable {
    private String agencia;
    private Map<String,List<Integer>> agenciaHotel;
             //codigo->lista de NIFS dos clientes

    public AgenciaViagens(){
        this.agencia="";
        this.agenciaHotel = new HashMap<>();
    }

    public void gravarFicheiro(String filename) throws IOException {
            PrintWriter ficheiro = new PrintWriter(filename);
            ficheiro.println(this);
            ficheiro.flush();
            ficheiro.close();
    }

    public AgenciaViagens carregarFicheiro(String filename) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(f);
        AgenciaViagens av = (AgenciaViagens) in.readObject();
        in.close();
        return av;
    }
}
