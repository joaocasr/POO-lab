public interface IParque{
public void entra(String cartao , String matricula ) throws SemPermissaoException();
public void sai(String matricula) throws Ve─▒culoNaoExisteException;
public boolean noParque(String matricula);
public boolean equals();

}
