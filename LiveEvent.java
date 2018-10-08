import java.util.ArrayList;
import java.util.Collections;

public class LiveEvent {

    private ArrayList<Artist> artistList;

    public LiveEvent() {
        artistList = new ArrayList<>();
    }

    public void addArtist(Artist a) {
        artistList.add(a);
    }

    public ArrayList<Artist> getArtistList() {
        Collections.sort(artistList);
        return artistList;
    }
}
