import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Turma {
    private String nome;
    private String codigo;
    private Map<String, Aluno> alunos;


    public Turma() {
        this.nome = "Turma-A";
        this.codigo = "AX1";
        this.alunos = new HashMap<>();
    }

    public Turma(String nome, String codigo, Map <String, Aluno> alunos) {
        this.nome = nome;
        this.codigo = codigo;
        setAlunos(alunos);
    }

    public Turma(Turma turma) {
        this.nome = turma.getNome();
        this.codigo = turma.getCodigo();
        this.alunos = turma.getAlunos();
    }

    public void insereAluno (Aluno a) {
        alunos.put(a.getNumero(), a.clone());
    }

    public void removeAluno (String codAluno) {
        alunos.remove(codAluno);
    }

    public Set<String> todosOsCodigos () {
        return alunos.keySet();
    }

    public int qtsAlunos () {
        return alunos.size();
    }

    /**
     *  metodos para testagem das interfaces funcionais
     */
    public Collection<Aluno> diminuiValor (Consumer<Aluno> c) {
        this.alunos.values().forEach(x->c.accept(x));
        return this.alunos.values().stream().map(Aluno::clone).collect(Collectors.toList());
    }

    public Collection<Aluno> imprimePredicate (Predicate<Aluno> c) {
       return this.alunos.values().stream().map(Aluno::clone).filter(x->c.test(x)).collect(Collectors.toList());
    }

    public Collection<String> imprimeFunction (Function<Aluno,String> c) {
        return this.alunos.values().stream().map(x->c.apply(x)).collect(Collectors.toList());
    }
    /***********/

    public Collection<Aluno> alunosOrdemAlfabetica () {
        Comparator<Aluno> c =(c1,c2)->c1.compareTo(c2);
        return this.alunos.values().stream().sorted(c).map(Aluno::clone).collect(Collectors.toList());
    }


    public Set<Aluno> alunosOrdemDecrescenteNumero () {
        return this.alunos.values().stream().map(Aluno::clone).collect(Collectors.toCollection(()->new TreeSet<>(new ComparaNumero())));
    }

    public Aluno getAluno(String codAluno) {
        return alunos.get(codAluno).clone();
    }

    public Aluno getAlunoMelhorNota() {
        Comparator<Aluno> c = (c1,c2)->c2.getNota()-c1.getNota();
        return this.alunos.values().stream().sorted(c).map(Aluno::clone).findFirst().get();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Map<String, Aluno> getAlunos() {
        return alunos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public void setAlunos(Map<String, Aluno> alunos) {
        this.alunos = alunos.entrySet().stream().collect((Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone())));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma: ").append(this.nome).append(";")
                .append("Codigo: ").append(this.codigo).append(";")
                .append("Alunos: ").append(this.alunos).append("\n");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma that = (Turma) o;
        return nome.equals(that.nome) &&
                codigo.equals(that.codigo) &&
                alunos.equals(that.alunos);
    }

}