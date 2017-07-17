package com.example.aderelemaryidowu.recyclerviewyupdev;

/**
 * Created by ADERELE MARY IDOWU on 7/13/2017.
 */

public class DataProvider {
    public DataProvider(int mfilmImage, String mfilmName, String mdirectorName){
        filmImage = mfilmImage;
        filmName = mfilmName;
        directorName = mdirectorName;
    }
    public int filmImage;
    public String filmName;
    public String directorName;

    public int getFilmImage() {
        return filmImage;
    }

    public void setFilmImage(int mfilmImage) {
        filmImage = mfilmImage;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String mfilmName) {
        filmName = mfilmName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String mdirectorName) {
        directorName = mdirectorName;
    }



}
