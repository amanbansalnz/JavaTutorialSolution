package com.mvp.studio.ex2.challenge2.model;


/**
 * Movie Object keeps information about what movie consists of. (Attributes that describe a movie)
 */
public class Movie extends EntertainmentContent {

    @Override
    public String toString() {
        return  title + " : has movie rating of " + rating ;
    }

}
