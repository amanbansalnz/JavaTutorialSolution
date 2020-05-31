package com.mvp.studio.ex2.challenge2.sevice;

import com.mvp.studio.ex2.challenge2.model.EntertainmentContent;
import com.mvp.studio.ex2.challenge2.model.Movie;
import com.mvp.studio.ex2.challenge2.model.Series;
import com.mvp.studio.ex2.challenge2.util.EntertainmentContentRatingCompare;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * In Real World ReviewingService acts like a Reviewer, It does all the functionality around what a Reviewer does.
 * It is best practice to name classes with name + service which indicates the Actor and type of service/role is does.
 */
public class ReviewingService {

    private Map<String, EntertainmentContent> entertainmentContentHashMap = new HashMap<String, EntertainmentContent>();
    private EntertainmentContentRatingCompare entertainmentContentRatingCompare = new EntertainmentContentRatingCompare();

    public void addMovieRating(String movieTitle, int rating){
        Movie movie = new Movie();
        movie.setTitle(movieTitle);
        movie.setRating(rating);
        entertainmentContentHashMap.put(movieTitle, movie);
    }

    public void addSeriesRating(String movieTitle, String review, int rating){
        Series series = new Series();
        series.setTitle(movieTitle);
        series.setRating(rating);
        series.setReview(review);
        entertainmentContentHashMap.put(movieTitle, series);
    }

    public void removeEntertainmentContentRating(String movieTitle){
        if(entertainmentContentHashMap.containsKey(movieTitle)){
            entertainmentContentHashMap.remove(movieTitle);
        }
    }

    public EntertainmentContent findEntertainmentContentRating(String movieTitle){
        EntertainmentContent entertainmentContent = null;

        if(entertainmentContentHashMap.containsKey(movieTitle)){
            entertainmentContent = entertainmentContentHashMap.get(movieTitle);
        }
        return entertainmentContent;
    }

    public String displayAllEntertainmentContent(){

        StringBuilder builder = new StringBuilder( "List Of Movies That Have Been Rated \n");
        List<EntertainmentContent> entertainmentContents = sortEntertainmentContentByRating();
        for (EntertainmentContent entertainmentContent : entertainmentContents){
            builder.append(entertainmentContent.toString()).append("\n");
        }
        return builder.toString();
    }

    public List<EntertainmentContent> sortEntertainmentContentByRating(){
        Collection<EntertainmentContent> values = entertainmentContentHashMap.values();
        List<EntertainmentContent> entertainmentContents = new ArrayList<EntertainmentContent>(values);
        Collections.sort(entertainmentContents, entertainmentContentRatingCompare);
        return entertainmentContents;
    }

    public Map<String, EntertainmentContent> getEntertainmentContentHashMap() {
        return entertainmentContentHashMap;
    }
}
