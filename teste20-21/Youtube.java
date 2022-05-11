import java.util.Map;

public class Youtube {
    public Map<String, Map<String, Video>> videos;


    public Video getVideo(String user, String codVideo)
            throws UserInexistenteException,
            VideoInexistenteException {
        if (!this.videos.containsKey(user))
            throw new UserInexistenteException("User "+user+" Inexistente");
        if (!this.videos.get(user).containsKey(codVideo))
            throw new VideoInexistenteException("Video "+codVideo+" Inexistente");
        return this.videos.get(user).get(codVideo).clone();
    }
}
