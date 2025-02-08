package songPlayingApp.src.com.muskan;

import java.util.*;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Album1", "Cold Play");
        album.addSong("Yellow",4.5);
        album.addSong("Sunshine",3.0);
        album.addSong("Paradise",2.3);

        albums.add(album);

        album = new Album("Album2","Tailor Swift");
        album.addSong("lover",2.0);
        album.addSong("snow on the beach",4.0);

        albums.add(album);

        LinkedList<Song> PlayList1=new LinkedList<>();

        albums.get(0).addToPlaylist("Yellow",PlayList1);
        albums.get(0).addToPlaylist("Paradise",PlayList1);
        albums.get(1).addToPlaylist("lover",PlayList1);
        albums.get(1).addToPlaylist("snow on the beach",PlayList1);

        play(PlayList1);
    }
    public static void play(LinkedList<Song> playList){
        Scanner sc= new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() ==0){
            System.out.println("This playlist has no songs");
        }
        else {
            System.out.println("Now Playing "+ listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action=sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("playlist complete");
                    quit=true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing "+ listIterator.next().toString());
                    }
                    else {
                        System.out.println("No songs available reached to end of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());
                    }
                    else {
                        System.out.println("This is the first song");
                        forward=false;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    }
                    else{
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        }
                        else {
                            System.out.println("We've reached the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("Available Options are");
        System.out.println("0 to quit\n"+
                "1 to play next song\n"+
                "2 to play previous song\n"+
                "3 to replay the current song\n"+
                "4 list of all songs\n"+
                "5 Print all availabe options\n" );
    }
    public  static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator= playList.iterator();
        System.out.println("-----------------------------------------------------------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            }
        System.out.println("----------------------------------------------------------------------------");
    }
}
