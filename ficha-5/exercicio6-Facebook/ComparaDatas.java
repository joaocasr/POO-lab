import java.util.Comparator;

public class ComparaDatas implements Comparator<FBPost> {
    public int compare(FBPost f1,FBPost f2){
        int r=0;
        if(f1.getData().isBefore(f2.getData())) r=1;
        if(f1.getData().isAfter(f2.getData())) r=-1;
        return r;
    }
}
