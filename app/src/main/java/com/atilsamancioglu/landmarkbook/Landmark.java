package com.atilsamancioglu.landmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable {
    //implements Serializable listview için kullanıldı recyclerview için önemi yok serileşme demektir

    String name;
    String country;
    int image;

    public Landmark(String name, String country, int image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }
}
