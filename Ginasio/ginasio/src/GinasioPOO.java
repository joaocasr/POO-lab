import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class GinasioPOO implements Serializable {
    private Map<String, Cliente> clientes;

    public double valorTotalCaloriasGastas(String codCliente) throws ClienteInexistenteException {
        if (!this.clientes.containsKey(codCliente))
            throw new ClienteInexistenteException("Cliente " + codCliente + " não existe.");
        return this.clientes.get(codCliente).getMeusExercicios().values()
                .stream()
                .flatMap(List::stream)
                .map(Exercicio::getActividade)
                .mapToDouble(Actividade::caloriasGastas)
                .sum();
    }

    public double totalKmsCliente(String codCliente, LocalDate dataExercicio)
            throws ClienteInexistenteException, ExercicioInexistenteException {
        if (!this.clientes.containsKey(codCliente))
            throw new ClienteInexistenteException("Cliente " + codCliente + " não existe.");
        if (!this.clientes.get(codCliente).getMeusExercicios().containsKey(dataExercicio))
            throw new ExercicioInexistenteException("Exercicio Inexistente");
        return this.clientes.get(codCliente).getMeusExercicios().get(dataExercicio)
                .stream().map(Exercicio::getActividade)
                .filter(x -> x instanceof Corrida || x instanceof Eliptica)
                .mapToDouble(x -> ((ComDistancia) x).getKmsPercorridos())
                .sum();
    }

    public boolean existeProfessor(String prof) {
        boolean exists=false;
        for(Cliente c: this.clientes.values()){
            for(List<Exercicio> l : c.getMeusExercicios().values()){
                for(Exercicio e: l){
                    if (e.getProfessor().equals(prof)) {
                        exists = true;
                        break;
                    }
                }
            }
        }
        return exists;
    }

    /**total calorias gastas por um professor*/
    public double totalProfessor(String professor){
        double totalProfessor=0.0;
        for(Cliente c: this.clientes.values()) {
            for (Exercicio e : c.exerciciosPorProf().get(professor)){
                totalProfessor += e.getActividade().caloriasGastas();
            }
        }
        return totalProfessor;
    }

    public String professorMaisExigente(){
        double max=0.0;
        String maisExigente="";
        for(Cliente c: this.clientes.values()) {
            for(String professor: c.exerciciosPorProf().keySet()){
                if(max<totalProfessor(professor)){
                    max=totalProfessor(professor);
                    maisExigente= professor;
                }
            }
        }
        return maisExigente;
    }

}
