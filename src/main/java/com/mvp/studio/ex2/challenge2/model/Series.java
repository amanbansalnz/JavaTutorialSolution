package com.mvp.studio.ex2.challenge2.model;


/**
 * Movie Object keeps information about what movie consists of. (Attributes that describe a movie)
 */
public class Series extends EntertainmentContent {

    private  String review;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return  title + " : has movie rating of " + rating + " review : " + review ;
    }

}
