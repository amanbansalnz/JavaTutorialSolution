package com.mvp.studio.ex2.challenge.model;


/**
 * Movie Object keeps information about what movie consists of. (Attributes that describe a movie)
 */
public class Movie {

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
