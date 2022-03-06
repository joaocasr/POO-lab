public class Numeros {
    private int [] Mnums;
    private int Mnumssize;
    private int Mnumcap;
    private int [] Mest;
    private int Mestcap;
    private int Mestsize;
    private  int [] Hnums;
    private int Hnumscap;
    private int Hnumssize;
    private int [] Hest;
    private int Hestcap;
    private int Hestsize;

    public Numeros(){
        this.Mnums= new int[5];
        this.Mnumssize=0;
        this.Mnumcap=5;
        this.Mest = new int [2];
        this.Mestsize=0;
        this.Mestcap=2;
        this.Hnums = new int[5];
        this.Hestsize=0;
        this.Hnumscap=5;
        this.Hest =new int[2];
        this.Hnumssize=0;
        this.Hestcap=2;
    }
/********Capacidade*************/
    public int getCapEstM(){
        return this.Mestcap;
    }
    public int getCapEstH(){
        return this.Hestcap;
    }
    public int getCapNumsM(){
        return this.Mnumcap;
    }
    public int getCapNumsH(){
        return this.Hnumscap;
    }
/***************Size***********/
    public int getSizeestM(){
       return this.Mestsize;
    }
    public int getSizeestH(){
        return this.Hestsize;
    }
    public int getSizenumsM(){
        return this.Mnumssize;
    }
    public int getSizenumsH(){
        return this.Hnumssize;
    }



/******Consulta dos numeros******/
    public int getNumsM(int x){
        return this.Mnums[x];
    }
    public int getNumsH(int x){
        return this.Hnums[x];
    }




/**************verifica se existe numeros repetidos*************/
    public int existeNumM(int num){
        int tam = this.Mnumssize;
        int i;
        for(i=0;i<tam;i++){
            if(this.Mnums[i]==num) return 1;
        }
        return 0;
    }

    public int existeNumH(int num){
        int tam = this.Hnumssize;
        int i;
        for(i=0;i<tam;i++){
            if(this.Hnums[i]==num) return 1;
        }
        return 0;
    }
/****************verifica se existe estrelas repetidas**********************/
    public int existeEstM(int num){
        int tam = this.Mestsize;
        int i;
        for(i=0;i<tam;i++){
            if(this.Mest[i]==num) return 1;
        }
        return 0;
    }

    public int existeEestH(int num){
        int tam = this.Hestsize;
        int i;
        for(i=0;i<tam;i++){
            if(this.Hest[i]==num) return 1;
        }
        return 0;
    }
/********ARMAZENAR OS NUMEROS DA MAQUINA DE SORTEIO*****/
    public void insereMnum(int x){
        if(existeNumM(x)==0){
            this.Mnums[this.Mnumssize]=x;
            this.Mnumssize++;
        }
    }
/********ARMAZENAR AS ESTRELAS DA PESSOA*****/
    public void insereHnum(int x){
        if(existeNumH(x)==0){
            this.Hnums[this.Hnumssize]=x;
            this.Hnumssize++;
        }
    }
/********ARMAZENAR AS ESTRELAS DA MAQUINA DE SORTEIO*****/
public void insereMest(int x){
   if(existeEstM(x)==0){
       this.Mest[this.Mestsize]=x;
       this.Mestsize++;
    }
}
/********ARMAZENAR AS ESTRELAS DA PESSOA*****/
    public void insereHest(int x){
        if(existeEestH(x)==0){
            this.Hest[this.Hestsize]=x;
            this.Hestsize++;
        }
    }


/**Numeros certos**/
    public void comparaNums(){
        int i,j;
        int N1=getCapNumsM();
        int N2=getCapNumsH();
        System.out.print("Números certos: ");
        for(i=0;i<N1;i++){
            for(j=0;j<N2;j++){
                if(this.Mnums[i]==this.Hnums[j]) System.out.print(this.Hnums[j]);
            }
        }
    }

/**Estrelas certos**/
    public void comparaEsts(){
        int i,j;
        int N1=getCapEstM();
        int N2=getCapEstH();
        System.out.print(" Estrelas certas: ");
        for(i=0;i<N1;i++){
            for(j=0;j<N2;j++){
                if(this.Mest[i]==this.Hest[j]) System.out.print("* "+this.Hest[j]+" ");
            }
        }
	System.out.print("\n");
}
    public String getnumeros(){
        int i;
        String string="";
        int N=this.Mnumcap;
        for(i=0;i<N;i++){
            string=string+(this.Mnums[i]+"  ");
        }
        return string;
    }
    public String getestrelas(){
        int i;
        String string="";
        int N=this.Mestcap;
        for(i=0;i<N;i++){
            string=string+(this.Mest[i]+"   ");
        }
        return string;
    }
}

