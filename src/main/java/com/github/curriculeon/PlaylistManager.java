package com.github.curriculeon;


//import com.sun.tools.javac.platform.PlatformUtils;

//import java.util.ArrayList;
import java.util.List;

public class PlaylistManager {
    private Playlist playlist = new Playlist();
    private String[] songs = null;
    public PlaylistManager(String[] songs) {
        playlist = new Playlist(songs);
        this.songs = songs;

    }

    public PlaylistManager(List<String> songs) {
      playlist = new Playlist(songs.toArray(new String[0]));

    }

    public PlaylistManager() {

    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        if(playlist == null){
            throw new IllegalArgumentException();
        }
        this.playlist = playlist;
    }

    private void setPlaylist(String[] toArray) {
        this.playlist = new Playlist(toArray);
    }

    public void addSong(String songToAdd) {

        int songLength = this.playlist.getSongNameArray().length;
        if(songLength == 0){
            this.playlist.setSongNameArray(new String[]{songToAdd});
            System.out.println("inside length 0");
        }else{
            String[]updatedSongs = new String[songLength];
            for(int i=0; i< updatedSongs.length; i++){
                updatedSongs[i] = this.playlist.getSongNameArray()[i];
                System.out.println(this.playlist.getSongNameArray()[i]);
            }
            updatedSongs[updatedSongs.length-1] = songToAdd;
            this.playlist.setSongNameArray(updatedSongs);
        }


    }

    public void removeSong(String songToRemove) {
    }

    public void printAll() {
    }
}
