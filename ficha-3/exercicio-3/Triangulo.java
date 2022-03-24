import java.util.ArrayList;


public class Triangulo{
    private int x1,x2,x3;
    private int y1,y2,y3;


    public Triangulo(){
        this.x1 = 1;
        this.y1 = 1;
        this.x2 = 4;
        this.y2 = 4;
        this.x3 = 10;
        this.y3 = 10;

    }

    public Triangulo(int a1,int b1, int a2, int b2, int a3, int b3){
        this.x1 = a1;
        this.y1 = b1;
        this.x2 = a2;
        this.y2 = b2;
        this.x3 = a3;
        this.y3 = b3;
    }

    public Triangulo (Triangulo t) {
        this.x1 = t.getX1();
        this.y1 = t.getY1();
        this.x2 = t.getX2();
        this.y2 = t.getY2();
        this.x3 = t.getX3();
        this.y3 = t.getY3();

    }

    public double calculaPerimetroTriangulo(){
        double l1,l2,l3;
        l1 = Math.sqrt(Math.pow((this.x1+this.y1),2)+Math.pow((this.getX2()+this.y2),2));
        l2 = Math.sqrt(Math.pow((this.x2+this.y2),2)+Math.pow((this.getX3()+this.y3),2));
        l3 = Math.sqrt(Math.pow((this.x3+this.y3),2)+Math.pow((this.getX1()+this.y1),2));
        return l1+l2+l3;
    }

    public double calculaAreaTriangulo(){
        double area;
        double l1,l2,l3;
        l1 = Math.sqrt(Math.pow((this.x1+this.y1),2)+Math.pow((this.getX2()+this.y2),2));
        l2 = Math.sqrt(Math.pow((this.x2+this.y2),2)+Math.pow((this.getX3()+this.y3),2));
        l3 = Math.sqrt(Math.pow((this.x3+this.y3),2)+Math.pow((this.getX1()+this.y1),2));
        double p =calculaPerimetroTriangulo()/2;
        area = Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
        return area;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public Triangulo clone(){
        return new Triangulo();
    }

    public boolean equals(Object o){
        if(o==this)
            return true;
        if(o==null || (this.getClass()!=o.getClass()))
            return false;
        Triangulo t = (Triangulo) o;
        return (this.x1==t.getX1() && this.x2==t.getX2() && this.x3==t.getX3()
        && this.y1==t.getY1() && this.y2==t.getY2() && this.y3==t.getY3() );
    }

    public String toString(){
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Ponto 1:(").append(this.x1).append(",").append(this.y1)
                .append(");\nPonto 2:(").append(this.x2).append(",").append(this.y2)
                .append(");\nPonto 3:(").append(this.x3).append(",").append(this.y3).append(");\n");
        return stringbuilder.toString();
    }

}
