import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Fbpost {
    private int identificador;
    private String nome;
    private LocalDateTime data;
    private int likes;
    private List<String> comentarios;

    public Fbpost(){
        LocalDateTime date = LocalDateTime.now();
        this.identificador=10;
        this.nome = "João";
        this.data =  date;
        this.likes = 4;
        this.comentarios = new ArrayList<>();
        this.comentarios.add("Rui: Long time, no see!");
        this.comentarios.add("Leo: Boas companheiro.");
        this.comentarios.add("Mathilda: My precious!");
    }
    public Fbpost(int id, String nome, LocalDateTime date, int lik, ArrayList<String> a){
        this.setIdentificador(id);
        this.setNome(nome);
        this.setData(date);
        this.setLikes(lik);
        this.setComentarios(a);
    }

    public Fbpost(Fbpost fb){
        this.identificador=fb.getIdentificador();
        this.nome = fb.nome;
        this.data =  fb.data;
        this.likes = fb.likes;
        this.setComentarios(fb.getComentarios());
    }


    public ArrayList<String> getComentarios() {
        return new ArrayList<>(this.comentarios);
    }

    public void setComentarios(ArrayList<String> b) {
        this.comentarios = new ArrayList<>(b);
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || this.getClass()!=o.getClass()) return false;
        Fbpost fb = (Fbpost) o;
        if(this.comentarios.size()!=fb.comentarios.size()) return false;
        int i;
        for(i=0; i<this.comentarios.size();i++){
            if(!(fb.comentarios.get(i).equals(this.comentarios.get(i)))) return false;
        }

        return (fb.getNome().equals(this.nome) && fb.getIdentificador()==this.identificador
        && fb.getData().equals(this.data));

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n")
                .append("Id: ").append(this.identificador).append("\n")
                .append("Data: ").append(this.data).append("\n");
                for(String a : this.comentarios){
                    sb.append(a).append(";");
                }
        return sb.toString();
    }


    public Fbpost clone(){
        return new Fbpost(this);
    }

}
