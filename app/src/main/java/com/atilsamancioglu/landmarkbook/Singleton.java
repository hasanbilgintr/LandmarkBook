package com.atilsamancioglu.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {
    //Singleton sadece bir adet objeye sahip bir sınıftır
    //intent yüksek verilerde çöküceği için kullandık dinamiktede kontrol az olacağı için iyi bir veri gönderme yönetemidir
    private Landmark selectedLandmark;
    private static Singleton singleton;

    public Singleton() {

    }

    public Landmark getSelectedLandmark() {
        return selectedLandmark;
    }

    public void setChosenLandmark(Landmark selectedLandmark) {
        this.selectedLandmark = selectedLandmark;
    }

    //bu değişken set edildiyse bir dahaki sette edilemicektir buşekilde static olsa dahi kontrlünü sağlamış olucaz
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
