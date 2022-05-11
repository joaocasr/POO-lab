public class Video {
    private String codigo;

    public Video(Video v){
        this.codigo = v.getCodigo();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Video clone(){
        return new Video(this);
    }
}
