package behaviouralPatterns.iterator.playlist;

import behaviouralPatterns.iterator.Iterator;
import behaviouralPatterns.iterator.SongIterator;

public class SongPlaylist implements Playlist {

    private String[] songs;

    public SongPlaylist(String[] songs) {
        this.songs = songs;
    }

    @Override
    public Iterator<String> iterator() {
        return new SongIterator(songs);
    }
}