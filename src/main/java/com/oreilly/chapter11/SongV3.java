package com.oreilly.chapter11;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongV3 {
    private String title;
    private String artist;
    private int bpm;

}
