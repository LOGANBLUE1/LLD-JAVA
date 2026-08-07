package behaviouralPatterns.iterator;

public class SongIterator implements Iterator<String> {

    private String[] songs;
    private int index;

    public SongIterator(String[] songs) {
        this.songs = songs;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < songs.length;
    }

    @Override
    public String next() {
        return songs[this.index++];
    }
}
