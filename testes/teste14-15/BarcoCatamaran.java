import java.io.Serializable;

public class BarcoCatamaran extends Barco implements Serializable {
    private double area;

    public BarcoCatamaran(BarcoCatamaran b){
        super(b);
        this.area = b.getArea();
    }

    public double seguro(){
        return super.getMilhas()*0.02;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public BarcoCatamaran clone(){
        return new BarcoCatamaran(this);
    }
}
