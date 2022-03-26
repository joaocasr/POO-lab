import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Fbfeed{
    private List<Fbpost> listaPosts;
    private int capacity;

    public Fbfeed(){
        this.listaPosts= new ArrayList<>();
        this.capacity = 30;
    }

    public Fbfeed(List<Fbpost> fblist, int capacidade){
        this.listaPosts = new ArrayList<>();
        for(Fbpost a : fblist){
            this.listaPosts.add(a.clone());
        }
        //this.setList( fblist);
        this.setCapacity(capacidade);
    }
    public Fbfeed(Fbfeed fb){
        this.setList(fb.getList());
        this.capacity = fb.getCapacity();
    }

    public int nrPosts(String user){
        return (int) this.listaPosts.stream().filter(a1 -> a1.getNome().equals(user)).count();
    }

    public List<Fbpost> postsOf(String user){
        return this.listaPosts.stream().filter(a->a.getNome().equals(user)).collect(Collectors.toList());
    }
    public List<Fbpost> postsOf(String user, LocalDateTime inicio , LocalDateTime fim) {
        return this.listaPosts.stream().filter(a->a.getNome().equals(user)).filter(date->date.getData().isAfter(inicio)).filter(date2->date2.getData().isBefore(fim)).collect(Collectors.toList());
    }

    public List<Fbpost> getList(){
        return this.listaPosts.stream().map(Fbpost::clone).collect(Collectors.toList());
    }

    public Fbpost getPost(int id){
        boolean found =false;
      Iterator<Fbpost> it = this.listaPosts.iterator();
      Fbpost fb = null;
      while(it.hasNext() && !found){
          fb = it.next();
          if(fb.getIdentificador()==id){
              found = true;
          }
      }
        return fb;
    }

    public void setList(List<Fbpost> nposts){
        this.listaPosts = new ArrayList<>();
        Iterator<Fbpost> it = nposts.iterator();
        while(it.hasNext()){
            Fbpost fb = it.next();
            this.listaPosts.add(fb.clone());
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        Fbfeed fb = (Fbfeed) o;
        return (this.listaPosts.equals(fb.getList()) && this.capacity==fb.capacity);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Fbpost a: this.listaPosts){
             sb.append(a.toString()).append("\n");
        }
        sb.append("Capacidade :").append(this.capacity);
        return sb.toString();
    }

    public Fbfeed clone(){
        return new Fbfeed(this);
    }
}
