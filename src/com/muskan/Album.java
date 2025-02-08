package songPlayingApp.src.com.muskan;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String name;
    String artist;
    ArrayList<Song> songs;

    public Album(String name, String artist ) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }
    public Album(){}

    public Song findSong(String title){
        for (Song s: songs){
            if (s.getTitle().equals(title)){
                return s;
            }
        }
        return null;
    }
    public boolean addSong(String title,double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
//            System.out.println(title + " song added Successfully!!");
            return true;
        }
        else {
//            System.out.println("Song with name "+ title + "already exists in list");
            return false;
        }
    }
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> PlayList){
        int index=trackNumber-1;
        if (index>=0 && index<=this.songs.size()){
            PlayList.add(this.songs.get(index));
                return true;

        }
//        System.out.println("this album does not have song with track Number:"+ trackNumber);
        return false;
    }
    public  boolean addToPlaylist(String title , LinkedList<Song> Playlist){
        Song s=findSong(title);
        if (s!=null){
            Playlist.add(s);
            return true;
        }
        else {
//            System.out.println(title+ "there is no such song present in album");
            return false;
        }

    }
}
