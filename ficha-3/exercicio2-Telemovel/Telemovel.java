import java.util.HashMap;

public class Telemovel {
    private int npics,napps,dimpics,dimapps,dimmsg,stored,dimpicsapps;
    private double x,y;
    private String marca,modelo;
    private String [] apps;
    private HashMap<Integer,String> sms;

    public Telemovel(){
        this.x=79.1;
        this.y=155;
        this.dimapps= 5;
        this.dimpics = 3;
        this.dimmsg = 4;
        this.dimpicsapps = 8;
        this.stored = 8;
        this.npics = 242;
        this.napps = 3;
        this.apps = new String [this.napps];
        this.apps[0] = "Gmail";
        this.apps[1] = "Tinder";
        this.apps[2] = "JMaster";
        this.marca = "Wiko Robby";
        this.modelo = "Wiko Robby Android 6.0 Marshmellow";
        this.sms = new HashMap<Integer,String>();
        this.sms.put(1,"flashgordonbeam: Hello World! :)");
    }

    public double tamMedioApps(){
        return this.dimapps *1.0 /this.napps;
    }

    public String getMsg(Integer x){
        return this.sms.get(x);
    }
    public void recebeMsg(String msg){
        int N = this.sms.size();
        this.sms.put(N+1,msg);
    }
    public void printMsgs(){
        for (Integer key: this.sms.keySet()){
            System.out.println(this.sms.get(key));
        }
    }
    public String maiorMsg(){
        int index=1;
        int max=0;
        for (Integer key: this.sms.keySet()){
            if (max<this.sms.get(key).length()){
                max = this.sms.get(key).length();
                index = key;
            }
        }
        return this.sms.get(index);
    }

    public void removeApp(String nome, double tamanho){
        setStore(getStore()-(int)tamanho);
        int indice=0;
        for(int i =0; i<getNapps()-1;i++) {
            if (this.apps[i].equals(nome)) indice =i;
        }
            for(int index=indice; index<getNapps()-1;index++){
                this.apps[index]=this.apps[index+1];
            }
        this.napps = getNapps()-1;
    }

    public String printApss(){
        StringBuilder stringbuilder = new StringBuilder("Apps: ");
        int i=0;
        while(i<getNapps()){
            stringbuilder.append(getApps(i)).append(" ");
            i++;
        }
        return stringbuilder.toString();
    }

    public int getDimpics() {
        return this.dimpics;
    }

    public void setDimpics(int dimpics) {
        this.dimpics = dimpics;
    }

    public int getDimapps() {
        return this.dimapps;
    }

    public void setDimapps(int dimapps) {
        this.dimapps = dimapps;
    }

    public int getDimmsg() {
        return this.dimmsg;
    }

    public void setDimmsg(int dimmsg) {
        this.dimmsg = dimmsg;
    }

    public int getStore() {
        return this.stored;
    }

    public void setStore(int store) {
        this.stored = store;
    }

    public int getDimpicsapps() {
        return dimpicsapps;
    }

    public void setDimpicsapps(int dimpicsapps) {
        this.dimpicsapps = dimpicsapps;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getApps(int x) {
        return this.apps[x];
    }

    public void setApps(String[] apps) {
        this.apps = apps;
    }

    public int getNpics() {
        return this.npics;
    }

    public void setNpics(int npics) {
        this.npics = npics;
    }

    public int getNapps() {
        return this.napps;
    }

    public void setNapps(int napps) {
        this.napps = napps;
    }

    public boolean existeEspaco(int numeroBytes){
        return (((this.dimpicsapps+this.dimmsg)-this.stored)>numeroBytes);
    }

    public void instalaApp(String nome, int tamanho){
        if(existeEspaco(tamanho)){
            int size = this.apps.length;
            if (size<this.dimapps) this.apps[size]=nome;
        }
    }


    public boolean equals(Telemovel tel){
        if(this==tel){
            return true;
        }
        if(tel==null || (this.getClass()!=tel.getClass())){
            return false;
        }
        return(this.x==tel.getX() && this.y == tel.getY()
                                  && this.marca.equals(tel.getMarca())
                                  && this.modelo.equals(tel.modelo)
        );
    }

    public String toString(){
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Resolução: ").append(this.x).append("x").append(this.y)
                .append("\nCapacidade de fotos- ").append(this.dimpics)
                .append("Gb\nCapacidade de mensagens- ").append(this.dimmsg)
                .append("Gb\nCapacidade de apps- ").append(this.dimapps)
                .append("Gb\nCapacidade de fotos+apps- ").append(this.dimpicsapps)
                .append("Gb\nNº de apps- ").append(this.napps)
                .append("\nNº de fotos guardadas- ").append(this.npics)
                .append("\nEspaço usado - ").append(this.stored)
                .append("Gb\nMarca- ").append(this.marca)
                .append("\nModelo- ").append(this.modelo).append("\nAPPS: ");

        int i=0;
        while (i<getNapps()) {
            stringbuilder.append(getApps(i)).append(" ");
            i++;
        }

        return stringbuilder.toString();
    }

    public Telemovel clone(){
        return new Telemovel();
    }  
}
