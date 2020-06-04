package com.mvp.studio.rentalapp.challenge.model;


import java.util.ArrayList;
import java.util.List;

/**
 * This sort of class is called a pojo where it only keeps state and attributes associated with this pojo
 */
public class Video {

    private String movieTitle;
    private boolean isCheckedOut;
    private double rating;
    private List<Double> ratingHistory = new ArrayList<Double>();

    public Video (String movieTitle){
        this.movieTitle = movieTitle;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        ratingHistory.add(rating);

        Double ratingSum = Double.valueOf(0);

        for(Double d : ratingHistory){
            ratingSum+=d; // same as averageRatingSum = averageRatingSum + integer;
        }

        this.rating = (ratingSum/ratingHistory.size());
    }

    @Override
    public String toString() {
        return  "----------------------------------------------------------- \n" +
                "| movieTitle: \"" + movieTitle + "\""+
                "| isCheckedOut:" + isCheckedOut +
                " | rating:" + getRating() + " | \n";
    }
}
