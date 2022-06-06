public abstract class Parque implements IParque {
    public void entra(String cartao, String matricula) throws SemPermissaoException {
    }

    /**
     * public double qtsKmsTotal(){
     *     Iterator<Empregado> it = this.empregados.values().iterator();
     *     double total = 0;
     *     while(it.hasNext()){
     *         Empregado e = it.next();
     *         if(e instanceof Motorista){
     *             total+=((Motorista) e.getNKms());
     *         }
     *     }
     *     return total;
     * }
     *
     * */
}