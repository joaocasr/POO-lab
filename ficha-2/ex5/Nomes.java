public class Nomes {
    private int size;
    private String [] nomes;
    private int capacity;

    public Nomes(int x){
        this.nomes= new String[x];
        this.size = 0;
        this.capacity = x;
    }

    public String getNome(int key){
        return this.nomes[key];
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getSize(){
        return this.size;
    }

    public int existeNome(String nome){
        int tam = this.size;
        int i;
        for(i=0;i<tam;i++){
            if((this.nomes[i].equals(nome))) return 1;
        }
        return 0;
    }
    public void insereNome(String nome){
        if(existeNome(nome)==0){
            this.nomes[this.size]=nome;
            this.size++;
        }
    }
    public void print() {
        int i;
        for (i = 0; i < this.size; i++) {
            System.out.print(this.nomes[i] + " ");
        }
        System.out.print("\n");
    }
    public String getmaiorString(){
        int i;
        int key=0;
        int max=0;
        for(i=0;i<this.size;i++){
            if((this.nomes[i]).length()>max){
                max = (this.nomes[i]).length();
                key=i;
            }
        }
        return getNome(key);
    }
    public int getFrequencia(String nome) {
        int c=1;
        for(int i=0;i<this.size;i++){
            if((this.nomes[i].equals(nome))) c++;
        }
        return c;
    }

}

