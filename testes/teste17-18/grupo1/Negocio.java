import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Negocio {
    private Map<String,Contribuinte> contribuintes;

    public void printFamiliasNumerosas(String nomeFich) throws IOException {
        PrintWriter pw = new PrintWriter(nomeFich);
        for(String s: this.contribuintes.keySet()){
            if(this.contribuintes.get(s) instanceof Bonificado){
                pw.println("NIF: "+this.contribuintes.get(s).getNif()
                        +" Nome: "+this.contribuintes.get(s).getName()
                        +" Redução: "+((Bonificado) this.contribuintes.get(s)).reducaoImposto());
            }
        }
        pw.flush();
        pw.close();
    }
}
