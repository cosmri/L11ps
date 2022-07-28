package sg.edu.rp.c346.id21001096.myapplication;

import java.io.Serializable;

public class Movies implements Serializable {
    private int id;
    private String title;
    private String movieGenre;
    private int movieYear;

    public Movies(int id, String title, String movieGenre, int movieYear) {
        this.id = id;
        this.title = title;
        this.movieGenre = movieGenre;
        this.movieYear = movieYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }
}
