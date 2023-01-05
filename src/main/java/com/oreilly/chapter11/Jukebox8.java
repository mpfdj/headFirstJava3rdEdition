package com.oreilly.chapter11;

import java.util.*;

public class Jukebox8 {

    public static void main(String[] args) {
        new Jukebox8().go();
    }

    public void go() {
        List<SongV3> songList = MockMoreSongs.getSongsV3();
        System.out.println(songList);

        Comparator<SongV3> sortByTitle = (s1, s2)-> s1.getTitle().compareTo(s2.getTitle());

        songList.sort(sortByTitle);
//        songList.sort((s1, s2)-> s1.getTitle().compareTo(s2.getTitle()));
        System.out.println(songList);

        Set<SongV3> songSet = new HashSet<>(songList);
        System.out.println(songSet);

        Set<SongV3> songSetSorted = new TreeSet<>(sortByTitle);
        songSetSorted.addAll(songList);
        System.out.println(songSetSorted);


    }

}
