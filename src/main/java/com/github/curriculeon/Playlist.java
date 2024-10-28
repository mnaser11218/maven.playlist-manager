package com.github.curriculeon;
//import com.google.common.primitives.Ints;


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by leon on 1/10/2021.
 */
public class Playlist {
    private String[] songNameArray = new String[]{};
    private int currentIndex = 0;
    public Playlist(String[] songNameArray) {
        this.songNameArray = songNameArray;

    }

    public Playlist(int currentIndex, String[] songNameArray) {
        this.currentIndex= currentIndex;
        this.songNameArray =songNameArray;
    }

    public String[] getSongNameArray() {
        return songNameArray;
    }

    public String getCurrentSelection() {
        return songNameArray[currentIndex];
    }

    public void goToPreviousSong() {
        System.out.println("inside prev song");
        if(this.currentIndex == 0){
            this.currentIndex =this.songNameArray.length-1;
        }else{
            this.currentIndex--;
        }

    }

    public void goToNextSong() {
        System.out.println("inside next song");
        if(this.currentIndex == this.songNameArray.length-1){
            System.out.println("inside next song");

            this.currentIndex=0;
        }else{
            this.currentIndex++;
        }
    }

    public Integer getMinimumNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        int index = Arrays.asList(songNameArray).indexOf(desiredSong);
        int forward = 0;
        int backward = 0;
        this.currentIndex = currentIndex;
        if(this.currentIndex == index){
            return 0;
        }
        while(this.currentIndex != index){
            System.out.println(this.currentIndex);
            goToNextSong();
            System.out.println(this.currentIndex);
            forward++;
        }
        this.currentIndex = currentIndex;
        while(this.currentIndex != index){
            goToPreviousSong();
            backward++;
        }
        return forward < backward ? forward : backward;
    }

    public Integer getNumberOfStepsBetween(Integer currentIndex, String desiredSong, Runnable directionMutator) {
        return null;
    }

    public Integer getForwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return null;
    }

    public Integer getBackwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return null;
    }
}
