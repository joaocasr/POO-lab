import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FBFeedMap {
    private Map<String, List<FBPost>> allPosts;

    public FBFeedMap(FBFeedMap f){
        setAllPosts(f.getAllPosts());
    }

    public void addPost(String user, FBPost post){
        if(this.allPosts.containsKey(user)) this.allPosts.get(user).add(post.clone());
        else {
            List<FBPost> aux= new ArrayList<>();
            aux.add(post.clone());
            this.allPosts.put(user,aux);
        }
    }

    public void removePosts(String user, LocalDateTime di, LocalDateTime df){
      List<FBPost> f=  this.allPosts.get(user).stream()
                             .map(FBPost::clone)
                             .filter(x->x.getData().isBefore(di) && x.getData().isAfter(df))
                             .collect(Collectors.toList());
        this.allPosts.replace(user,f);
    }

    public int postsNumPeriodo(LocalDateTime di, LocalDateTime df){
      return (int) this.allPosts.values()
                     .stream()
                     .flatMap(List::stream)
                     .filter(x->x.getData().isAfter(di) && x.getData().isBefore(df))
                     .count();
    }

    public List<FBPost> timelineGlobal(){
        return this.allPosts.values()
                .stream()
                .flatMap(List::stream)
                .map(FBPost::clone)
                .sorted(new ComparaDatas())
                .collect(Collectors.toList());
    }


    public boolean validaPostsSimultaneos(){
        for(String s: this.allPosts.keySet()){
            List<LocalDateTime> l = this.allPosts.get(s).stream().map(FBPost::getData).collect(Collectors.toList());
            Set<LocalDateTime> aux = new HashSet<>();
            for(LocalDateTime ld : l){
                if(!aux.add(ld)) return false;//set.add -> false, se o elemento que se vai adicionar já se encontra no set
            }
        }
        return true;
    }


    public Map<String, List<FBPost>> getAllPosts(){
        //agregacao
        //return this.allPosts.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        //composicao
        Map<String,List<FBPost>> aux = new HashMap<>();
        for(String s : allPosts.keySet()){
            List<FBPost> l =allPosts.get(s).stream().map(FBPost::clone).collect(Collectors.toList());
            aux.put(s,l);
        }
        return aux;
    }

    public void setAllPosts(Map<String, List<FBPost>> m){
        //agregacao
        //this.allPosts = new Hasmap<>();
        //m.foreach((key,value)->this.allPosts.put(key,value));
        //composicao
        this.allPosts = new HashMap<>();
        for(String s : m.keySet()) {
            List<FBPost> l = allPosts.get(s).stream().map(FBPost::clone).collect(Collectors.toList());
            this.allPosts.put(s, l);
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,List<FBPost>> m : this.allPosts.entrySet()){
            sb.append("User: ").append(m.getKey()).append("\n").append(" Posts: ").append(m.getValue()).append("\n");
        }
        return sb.toString();
    }

    public FBFeedMap clone(){
        return new FBFeedMap(this);
    }
}
