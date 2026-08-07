package behaviouralPatterns.iterator;

import behaviouralPatterns.iterator.playlist.Playlist;
import behaviouralPatterns.iterator.playlist.SongPlaylist;

public class Demo {
    public static void main(String[] args) {

        Playlist playlist =
                new SongPlaylist(new String[]{
                        "Song A",
                        "Song B",
                        "Song C"
                });

        Iterator<String> it = playlist.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}