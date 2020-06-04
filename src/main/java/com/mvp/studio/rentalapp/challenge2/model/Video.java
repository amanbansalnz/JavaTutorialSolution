package com.mvp.studio.rentalapp.challenge2.model;


import java.util.ArrayList;
import java.util.List;

/**
 * This sort of class is called a pojo where it only keeps state and attributes associated with this pojo
 */
public class Video {

    private String movieTitle;
    private boolean checkedOut;
    private double rating;
    private List<Double> ratingHistory = new ArrayList<Double>();

    public Video (String movieTitle){
        this.movieTitle = movieTitle;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        checkedOut= false;
        this.checkedOut = checkedOut;
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
                "| isCheckedOut:" + checkedOut +
                " | rating:" + getRating() + " | \n";
    }
}
