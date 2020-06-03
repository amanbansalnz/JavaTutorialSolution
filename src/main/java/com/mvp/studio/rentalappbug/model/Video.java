package com.mvp.studio.rentalappbug.model;


import java.util.ArrayList;
import java.util.List;

public class Video {

    private String movieTitle;
    private boolean isCheckedOut;
    private int rating;
    private List<Integer> ratingHistory = new ArrayList<Integer>();

    public Video (String movieTitle){
        this.movieTitle = movieTitle;
    }

    public int getAverageRating(){
        int averageRatingSum = 0;

        for(Integer integer : ratingHistory){
            averageRatingSum+=integer; // same as averageRatingSum = averageRatingSum + integer;
        }

        if(averageRatingSum == 0){
            return  0;
        }else{
            return averageRatingSum/ratingHistory.size();
        }
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Integer> getRatingHistory() {
        return ratingHistory;
    }

    public void setRatingHistory(List<Integer> ratingHistory) {
        this.ratingHistory = ratingHistory;
    }

    @Override
    public String toString() {
        return  "----------------------------------------------------------- \n" +
                "| movieTitle: \"" + movieTitle + "\""+
                "| isCheckedOut:" + isCheckedOut +
                " | rating:" + getAverageRating() + " | \n";
    }
}
