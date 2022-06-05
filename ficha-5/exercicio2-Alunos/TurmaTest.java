import org.junit.jupiter.api.Test;

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
        Aluno b = new Aluno("12323",12,"Luis","LEI");
        Aluno c = new Aluno("45435",14,"Carla","LEI");
        Aluno d = new Aluno("56543",17,"Ana","LEI");
        Aluno e = new Aluno("34534",11,"Jose","LEI");


        Turma turma = new Turma();
        turma.insereAluno(a);
        turma.insereAluno(b);
        turma.insereAluno(c);
        turma.insereAluno(d);
        turma.insereAluno(e);

        //System.out.println(turma.alunosOrdemAlfabetica());
        //System.out.println(turma.alunosOrdemDecrescenteNumero());
        System.out.println(turma.getAlunoMelhorNota());
    }
}