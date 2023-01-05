package com.oreilly.chapter11;

import java.util.Comparator;
import java.util.List;

public class Jukebox6 {

    public static void main(String[] args) {
        new Jukebox6().go();
    }

    public void go() {
        List<SongV3> songList = MockSongs.getSongsV3();
        System.out.println(songList);

        songList.sort((s1, s2) -> s1.getTitle().compareTo(s2.getTitle()));
        System.out.println(songList);

        Comparator<SongV3> sortByArtist = (s1, s2) -> s1.getArtist().compareTo(s2.getArtist());
        songList.sort(sortByArtist);
        System.out.println(songList);


        Comparator<SongV3> sortByMultipleFieldsUsingGetMethods = Comparator
//                .comparing(SongV3::getTitle, Comparator.reverseOrder())
                .comparing(SongV3::getTitle)
                .thenComparing(SongV3::getArtist)
                .thenComparing(SongV3::getBpm, ((int1, int2) -> int2 - int1));  // https://www.benchresources.net/java-8-thencomparing-method-for-custom-reverse-sorting/ sorting BPM field in descending order

        songList.sort(sortByMultipleFieldsUsingGetMethods);
        System.out.println(songList);


        Comparator<SongV3> sortByMultipleFieldsUsingLambdas = Comparator
                .comparing((SongV3 s) -> s.getTitle())
                .thenComparing(s -> s.getArtist())
//                .thenComparingInt(s -> s.getBpm());  // when using thenComparingInt the sorting order can only be ascending
                .thenComparing(s -> s.getBpm(), ((int1, int2) -> int2 - int1));  // when using thenComparingInt the sorting order can only be ascending

        songList.sort(sortByMultipleFieldsUsingLambdas);
        System.out.println(songList);

    }

}
