public class Aluno implements Comparable<Aluno>{

    private String numero;
    private int nota;
    private String nome;
    private String curso;


    public Aluno(String numero, int nota, String nome, String curso) {
        this.numero = numero;
        this.nota = nota;
        this.nome = nome;
        this.curso = curso;
    }

    public Aluno(Aluno umAluno) {
        this.numero = umAluno.getNumero();
        this.nota = umAluno.getNota();
        this.nome = umAluno.getNome();
        this.curso = umAluno.getCurso();
    }


    public String getNumero() {
        return this.numero;
    }


    public int getNota() {
        return this.nota;
    }


    public String getNome() {
        return this.nome;
    }


    public String getCurso() {
        return this.curso;
    }


    public void setNota(int novaNota) {
        this.nota = novaNota;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    public String toString() {
        StringBuffer sb= new StringBuffer();

        sb.append("Numero: ").append(this.numero).append(";");
        sb.append("Nome: ").append(this.nome).append(";");
        sb.append("Curso: ").append(this.curso).append(";");
        sb.append("Nota: ").append(this.nota).append("\n");
        return sb.toString();
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        Aluno umAluno = (Aluno) o;
        return(this.nome.equals(umAluno.getNome()) && this.nota == umAluno.getNota()
                && this.numero.equals(umAluno.getNumero())
                && this.curso.equals(umAluno.getCurso()));
    }


    public Aluno clone() {
        return new Aluno(this);
    }


    public int compareTo(Aluno outroAluno) {
        return this.nome.compareTo(outroAluno.getNome());
    }


}