public interface IParque{
public void entra(String cartao , String matricula ) throws SemPermissaoException();
public void sai(String matricula) throws VeıculoNaoExisteException;
public boolean noParque(String matricula);
public boolean equals();

}
