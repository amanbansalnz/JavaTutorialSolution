package com.mvp.studio.rentalapp.model;


public class Video {

    private String movieTitle;
    private int rating;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return  movieTitle + " : has movie rating of " + rating ;
    }


}
