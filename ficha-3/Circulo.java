public class Circulo {
    private double x,y,raio;


    public Circulo(double x,double y , double r){
        this.x=x;
        this.y=y;
        this.raio=r;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setX(double abcissa){
        this.x= abcissa;
    }

    public void setY(double ordenada){
        this.y= ordenada;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public void alteraPonto(double x , double y){
        setX(x);
        setY(y);
    }

    public double calcularArea(){
        double area = Math.pow(getRaio(),2)*Math.PI;
        return area;
    }

    public double calcularPerimetro(){
        double perimetro = 2*getRaio()*Math.PI;
        return perimetro;
    }

    public boolean equals(Circulo circulo){
        if(this==circulo){
            return true;
        }
        if(circulo==null || (this.getClass()!=circulo.getClass())){
            return false;
        }
        return(this.raio==circulo.getRaio() && this.x == circulo.getX() && this.y== circulo.getY());
    }

    public String toString(){
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("X-> ").append(this.x).append("Y-> ").append(this.y).append("Raio-> ").append(this.raio);

        return stringbuilder.toString();
        //return "x: "+this.x +" y: "+this.y+" Raio: "+this.raio;
    }

    public Circulo clone(){
        return new Circulo(this.getX(),this.getY(),this.getRaio());
    }

}
