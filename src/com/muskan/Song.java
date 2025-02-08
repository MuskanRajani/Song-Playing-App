package songPlayingApp.src.com.muskan;

public class Song {
    String title;
    double duration;

    public Song(String title, double duration){
        this.title=title;
        this.duration=duration;
    }

    public Song(){

    }
    public double getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
