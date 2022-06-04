import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FBFeed {
    private List<FBPost> allPosts;

    public FBFeed(FBFeed fbf){
        setAllPosts(fbf.getAllPosts());
    }

    public List<FBPost> getAllPosts(){
        return this.allPosts.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    public void setAllPosts(List<FBPost> fp){
        this.allPosts = fp.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    public int nrPosts(String user){
        return (int) this.allPosts.stream().map(FBPost::clone)
                .filter(x->user.equals(x.getUser())).count();
    }

    public List<FBPost> postsOf(String user){
       return this.allPosts.stream().map(FBPost::clone)
               .filter(x->user.equals(x.getUser())).collect(Collectors.toList());
    }

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
       return this.allPosts.stream().map(FBPost::clone)
                    .filter(x->user.equals(x.getUser()))
                    .filter(x->x.getData().isAfter(inicio) && x.getData().isBefore(fim))
                    .collect(Collectors.toList());

    }

    public FBPost getPost(int id){
       return this.allPosts.stream().map(FBPost::clone)
                .filter(x->id==x.getIdentificador()).findFirst().orElse(null);

    }

    public void comment(FBPost post, String comentario){
        this.getPost(post.getIdentificador()).getComentarios().add(comentario);
    }

    public void comment(int postid, String comentario){
        this.getPost(postid).getComentarios().add(comentario);
    }

    public void like(FBPost post){
        FBPost f =this.allPosts.stream().map(FBPost::clone).filter(x->x.equals(post)).findFirst().orElse(null);
        if(this.allPosts.stream().map(FBPost::clone).filter(x->x.equals(post)).count()>0) {
            f.setLikes(f.getLikes()+1);
        }
    }

    public void like(int postid){
        int likes = this.getPost(postid).getLikes();
        this.getPost(postid).setLikes(likes+1);
    }

    public List<Integer> top5Comments(){
        Comparator<FBPost> c = (c1,c2)->{
            int v1 = c1.getComentarios().size();
            int v2 = c2.getComentarios().size();
            return v2-v1;
        };
        return this.allPosts.stream().map(FBPost::clone)
                .sorted(c).map(x->x.getIdentificador()).limit(5).collect(Collectors.toList());
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        this.allPosts.forEach(a->sb.append(a).append("\n"));
        return sb.toString();
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        FBFeed fbf = (FBFeed) o;
        if(this.allPosts.size()!=fbf.getAllPosts().size()) return false;
        boolean equal=true;
        for(int i=0;i<this.allPosts.size();i++){
            if(!this.allPosts.get(i).equals(fbf.getAllPosts().get(i))) equal=false;
        }
        return equal;
    }

    public FBFeed clone(){
        return new FBFeed(this);
    }
    }

