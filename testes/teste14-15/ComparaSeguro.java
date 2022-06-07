import java.util.Comparator;

public class ComparaSeguro implements Comparator<Barco> {
    public int compare(Barco b1,Barco b2){
        if(b1 instanceof BarcoHibrido && b2 instanceof BarcoHibrido){
            return (int) (((BarcoHibrido) b1).seguro() - ((BarcoHibrido) b2).seguro());
        }
        if(b1 instanceof BarcoHibrido && b2 instanceof BarcoCatamaran){
            return (int) (((BarcoHibrido) b1).seguro() - ((BarcoCatamaran) b2).seguro());
        }
        if(b1 instanceof BarcoCatamaran && b2 instanceof BarcoHibrido){
            return (int) (((BarcoCatamaran) b1).seguro() - ((BarcoHibrido) b2).seguro());
        }
        if(b1 instanceof BarcoCatamaran && b2 instanceof BarcoCatamaran){
            return (int) (((BarcoCatamaran) b1).seguro() - ((BarcoCatamaran) b2).seguro());
        }
        return 0;
    }
}
