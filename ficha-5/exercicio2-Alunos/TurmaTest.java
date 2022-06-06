import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class TurmaTest {
    public TurmaTest()
    {}

    @org.junit.jupiter.api.BeforeEach
    public void setUp()
    {}

    @org.junit.jupiter.api.AfterEach
    public void tearDown()
    {}

    @Test
    public void test1(){

        Aluno a = new Aluno("34323",13,"Joao","LEI");
        Aluno b = new Aluno("12323",9,"Luis","LEI");
        Aluno c = new Aluno("45435",14,"Carla","LEI");
        Aluno d = new Aluno("56543",7,"Ana","LEI");
        Aluno e = new Aluno("34534",11,"Jose","LEI");


        Turma turma = new Turma();
        turma.insereAluno(a);
        turma.insereAluno(b);
        turma.insereAluno(c);
        turma.insereAluno(d);
        turma.insereAluno(e);

        System.out.println(turma.alunosOrdemAlfabetica());
        System.out.println(turma.alunosOrdemDecrescenteNumero());
        System.out.println(turma.getAlunoMelhorNota());


        Consumer<Aluno> desvalorizacao = x->x.setNota(x.getNota()-1);//consumer ->associado a um foreach(processamento de todos os objetos)
        System.out.println(turma.diminuiValor(desvalorizacao));

        //exemplo de aplicacao de predicate(isto permite-nos definir varios predicate diferentes imprimePredicate vai ser uma generalizacao)
        Predicate<Aluno> positivas = x->x.getNota()>10; //predicate-> associado com filter
        System.out.println(turma.imprimePredicate(positivas));

        Function<Aluno,String> todosNumeros = x->x.getNumero();//funcao que converte Aluno para String (map)
        System.out.println(turma.imprimeFunction(todosNumeros));

    }
}